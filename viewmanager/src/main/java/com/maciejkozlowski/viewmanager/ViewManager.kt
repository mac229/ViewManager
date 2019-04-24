package com.maciejkozlowski.viewmanager

import android.view.ViewGroup
import com.maciejkozlowski.viewmanager.base.ViewResolver
import com.maciejkozlowski.viewmanager.util.show

/**
 * Created by Maciej Kozłowski on 23/04/2019.
 */
interface ViewManager {

    val containerViewGroup: ViewGroup

    val contentViewResolver: ViewResolver
    val loadingViewResolver: ViewResolver
    val errorViewResolver: ViewResolver

    fun initialize()

    fun ViewGroup.addViewToContainer(viewResolver: ViewResolver) {
        containerViewGroup.addView(viewResolver.getView())
    }

    fun showContent() {
        setVisibility(showContent = SHOW)
    }

    fun showLoading() {
        setVisibility(showLoading = SHOW)
    }

    fun showError() {
        setVisibility(showError = SHOW)
    }

    private fun setVisibility(showContent: Boolean = HIDE, showLoading: Boolean = HIDE, showError: Boolean = HIDE) {
        contentViewResolver.getView().show(showContent)
        loadingViewResolver.getView().show(showLoading)
        errorViewResolver.getView().show(showError)
    }

    companion object {
        private const val SHOW = true
        private const val HIDE = false
    }
}