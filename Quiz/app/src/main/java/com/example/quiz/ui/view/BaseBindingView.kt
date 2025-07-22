package com.example.quiz.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding

abstract class BaseBindingView<B : ViewBinding> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B
) : FrameLayout(
    context,
    attrs,
    defStyleAttr
) {

    protected val binding: B = bindingInflater(
        LayoutInflater.from(context),
        this,
        false
    ).also {
        addView(it.root)
    }

    init {
        applyAttrs(attrs)
    }

    protected open fun applyAttrs(attrs: AttributeSet?) {}
}