package com.kerry.utilslibrary

import android.view.View

fun View.visible() {
    if (visibility != View.VISIBLE) { visibility = View.VISIBLE }
}

fun View.visibleIf(block: () -> Boolean) {
    if (visibility != View.VISIBLE && block()) { View.VISIBLE }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) { visibility = View.INVISIBLE }
}

fun View.invisibleIf(block: () -> Boolean) {
    if (visibility != View.INVISIBLE && block()) { visibility = View.INVISIBLE }
}

fun View.gone() {
    if (visibility != View.GONE) { visibility = View.GONE }
}

fun View.goneIf(block: () -> Boolean) {
    if (visibility != View.GONE && block()) { visibility = View.GONE }
}

inline fun <T : View> T.click(debounceInterval :Long = 700, crossinline block: (T: View) -> Unit) {
    var lastClickTime = 0L
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if ((currentTime - lastClickTime) > debounceInterval) {
            block(it)
            lastClickTime = currentTime
        }
    }
}