package com.example.quiz.ui.activity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.Const
import com.example.quiz.Const.MUSIC_MODE
import com.example.quiz.R
import com.example.quiz.system.MyService

abstract class BaseActivity: AppCompatActivity() {

    private var backPressedTime: Long = 0
    private var flagMusic = false
    lateinit var animationTimer: Animation


    val sp: SharedPreferences by lazy {application.getSharedPreferences(Const.BASE_SP, MODE_PRIVATE)}
    val editor: SharedPreferences.Editor by lazy {sp.edit()}

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        flagMusic = false
        //Установка нулевой анимации:
        overridePendingTransition(0, 0)
        animationTimer = AnimationUtils.loadAnimation(this, R.anim.anim_timer)

    }

    override fun onResume() {
        super.onResume()
        /**//////////////////////////////////////// */
        if (sp.getInt(MUSIC_MODE, 1) != 0)
            startService(Intent(this, MyService::class.java))

    }

    override fun onStop() {
        super.onStop()
        if (flagMusic == false) {
            stopService(Intent(this, MyService::class.java))
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(this, "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    fun setFlagMusic(flag: Boolean = true) {
        flagMusic = flag
    }

    fun incrementCompletedLevelCount(key: String, currentLevel: Int) {
        var level = sp.getInt(key, 1)
        if(currentLevel == level) {
            Log.d("incrementCompleted", "$currentLevel----$level");
            level += 1
            editor.putInt(key, level).commit()
        }
        setFlagMusic(true)
    }

    fun incrementError(key: String) {
        var level = sp.getInt(key + "incorrect", 0)
        level += 1
        editor.putInt(key + "incorrect", level).commit()
    }


    fun getAllErrorForLevel(key: String): String {
        return sp.getInt(key + "incorrect", 0).toString()
    }

    fun timerScheduler(onTick: (Int) -> Unit) {
        var i = 16
        val timer = object : CountDownTimer(16000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                i--
                onTick(i)
            }

            override fun onFinish() {
                cancel()
            }
        }.start()

    }

    fun startLevel(nextAct: Class<out Activity?>?) {
        val intent = Intent(this, nextAct)
        startActivity(intent)
        setFlagMusic(true)
    }

    fun setLevelsGrid(key: String, levels: Array<Int>, back: Int) {
        val level = sp.getInt(key, 1)
        for (i in 0..< level) {
            if (i != levels.size) {
                val textView = findViewById<TextView>(levels[i])
                textView.background = getDrawable(back)
                textView.text = (i + 1).toString()
            }
        }
    }

    fun resetLevels(key: String, levels: Array<Int>, back: Int) {
        val level = sp.getInt(key, 1)

        editor.putInt(key, 1).commit()
        editor.putInt(key + "incorrect", 0).commit()
        editor.commit()

        for (i in 1..< level) {
            if (i != levels.size) {
                val textView = findViewById<TextView?>(levels[i])
                textView.background = getDrawable(back)
                textView.text = "X"
            }
        }
    }

}