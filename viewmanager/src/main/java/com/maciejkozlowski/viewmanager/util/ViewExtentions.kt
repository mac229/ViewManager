package com.maciejkozlowski.viewmanager.util

import android.view.View

/**
 * Created by Maciej Kozłowski on 24/04/2019.
 */

fun View.show(show: Boolean) {
    if (show) show() else hide()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}