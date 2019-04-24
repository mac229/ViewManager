package com.maciejkozlowski.viewmanagersample.third

import android.view.ViewGroup
import android.widget.TextView
import com.maciejkozlowski.viewmanager.ViewManager
import com.maciejkozlowski.viewmanager.base.ViewResolver
import com.maciejkozlowski.viewmanager.util.inflate
import com.maciejkozlowski.viewmanagersample.R

/**
 * Created by Maciej Kozłowski on 23/04/2019.
 */
class ThirdViewManager(override val containerViewGroup: ViewGroup, private val contentView: TextView) : ViewManager {

    private val loadingView by lazy { containerViewGroup.inflate(R.layout.loading_view) }
    private val errorView by lazy { containerViewGroup.inflate(R.layout.error_view) }

    override val contentViewResolver = object : ViewResolver {
        override fun getView() = contentView
    }

    override val loadingViewResolver = object : ViewResolver {
        override fun getView() = loadingView
    }

    override val errorViewResolver = object : ViewResolver {
        override fun getView() = errorView
    }

    fun showContent(text: String) {
        showContent()
        contentView.text = text
    }

    init {
        initialize()
    }

    override fun initialize() {
        containerViewGroup.apply {
            addViewToContainer(loadingViewResolver)
            addViewToContainer(errorViewResolver)
        }
    }
}