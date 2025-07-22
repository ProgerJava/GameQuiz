package com.example.quiz.ui.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import com.example.quiz.R
import com.example.quiz.databinding.ViewAnswers4Binding
import com.example.quiz.system.ArrayOfMonitorsSet
import java.util.function.BiConsumer

class ViewAnswers4 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseBindingView<ViewAnswers4Binding>(
    context,
    attrs,
    defStyleAttr,
    ViewAnswers4Binding::inflate
) {
    private lateinit var answers: MutableList<String>
    private lateinit var answerViews: List<ViewAnswersText>
    private var colorDefault: Drawable? = null

    override fun applyAttrs(attrs: AttributeSet?): Unit = with(binding) {
        super.applyAttrs(attrs)

        context.theme.obtainStyledAttributes(attrs, R.styleable.ViewAnswers, 0, 0).apply {
            answers = mutableListOf()
            val ans1 = getString(R.styleable.ViewAnswers_answer1)
            if (ans1 != null) answers.add(ans1)

            val ans2 = getString(R.styleable.ViewAnswers_answer2)
            if (ans2 != null) answers.add(ans2)

            val ans3 = getString(R.styleable.ViewAnswers_answer3)
            if (ans3 != null) answers.add(ans3)

            val ans4 = getString(R.styleable.ViewAnswers_answer4)
            if (ans4 != null) answers.add(ans4)

            answerViews = when (answers.size) {
                2 -> listOf(var1, var2)
                3 -> listOf(var1, var2, var3)
                else -> listOf(var1, var2, var3, var4)
            }

            colorDefault = getDrawable(R.styleable.ViewAnswers_buttonsColor)

            setDefaultAllAnswersViews()
            setDefaultMonitor()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun listeners(correctAnswer: Int, onAnswerChecked: BiConsumer<Boolean, ViewAnswersText>): Unit =
        answerViews.forEach {textView ->
            textView.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> true
                    MotionEvent.ACTION_UP -> {
                        checkAnswer(textView, correctAnswer, onAnswerChecked)
                        true
                    }
                    else -> false
                }
            }

        }

    @SuppressLint("NewApi")
    private fun checkAnswer(
        view: ViewAnswersText,
        correctAnswer: Int,
        onAnswerChecked: BiConsumer<Boolean, ViewAnswersText>
    ) {
        if (view.tv.text != context.getString(correctAnswer)) {
            view.setBackToFrame(R.drawable.style_buttons_math_easy_false)
            onAnswerChecked.accept(false, view)
        } else {
            view.setBackToFrame(R.drawable.style_buttons_math_easy_true)
            onAnswerChecked.accept(true, view)
        }
    }

    fun monitorSetText(
        isAnswerTrue: Boolean,
        textNum: ViewAnswersText,
        nextAct: Class<out Activity>,
        onResult: (Boolean) -> Unit
    ) = with(binding) {

        when(isAnswerTrue) {
            true -> monitor.setText(ArrayOfMonitorsSet().arrayOfTrue.random())
            else -> monitor.setText(ArrayOfMonitorsSet().arrayOfFalse.random())
        }

        setDefaultMonitor(true)
        setEnabledFalse()

        handler.postDelayed({
            if (isAnswerTrue) context.startActivity(Intent(context, nextAct))
            else {
                setDefaultAllAnswersViews()
                setDefaultMonitor()
                setEnabledTrue()
            }
            onResult(isAnswerTrue)
        }, 700)
    }

    private fun setEnabledFalse() = answerViews.forEach {it.isEnabled = false }
    private fun setEnabledTrue() = answerViews.forEach { it.isEnabled = true }

    private fun setDefaultMonitor(isVisible: Boolean = false) = with(binding) {
        monitor.visibility = if(isVisible) VISIBLE else GONE
        monitor.background = null
        monitor.background = colorDefault
    }

    private fun setDefaultAllAnswersViews() {
        answers.shuffle()
        answerViews.forEachIndexed {index, view ->
            view.visibility = VISIBLE
            view.tv.text = answers[index]
            view.background = null
            view.setBackToFrame(colorDefault)
        }
    }

    fun monitorSetTextTimer(defColor: Int, addMistakesCount:() -> Unit) = with(binding){
        answerViews.map { it.setBackToFrame(R.drawable.style_buttons_math_easy_false) }

        setEnabledFalse()
        monitor.visibility = VISIBLE
        monitor.setText(R.string.timeOut)
        addMistakesCount()
        handler.postDelayed(object : Runnable {
            override fun run() {
                setDefaultAllAnswersViews()
                monitor.visibility = INVISIBLE
                setEnabledTrue()
            }
        }, 1500)
    }

}