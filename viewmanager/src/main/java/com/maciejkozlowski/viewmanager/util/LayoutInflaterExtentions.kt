package com.maciejkozlowski.viewmanager.util

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by Maciej Kozłowski on 24/04/2019.
 */

fun LayoutInflater.inflate(@LayoutRes layoutRes: Int, parent: View? = null, attachToRoot: Boolean = false): View {
    return inflate(layoutRes, parent, attachToRoot)

}