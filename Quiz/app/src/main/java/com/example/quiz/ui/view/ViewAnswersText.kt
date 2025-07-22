package com.example.quiz.ui.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import com.example.quiz.databinding.ViewAnswerTextBinding

class ViewAnswersText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseBindingView<ViewAnswerTextBinding>(
    context,
    attrs,
    defStyleAttr,
    ViewAnswerTextBinding::inflate
) {


    val frame get() = binding.frame
    val tv get() = binding.text

    fun setBackToFrame(drawable: Drawable?) {
        binding.frame.background = drawable
    }

    fun setBackToFrame(id: Int) {
        binding.frame.background = context.getDrawable(id)
    }



}