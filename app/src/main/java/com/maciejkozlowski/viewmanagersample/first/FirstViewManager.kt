package com.maciejkozlowski.viewmanagersample.first

import android.view.ViewGroup
import com.maciejkozlowski.viewmanager.base.ViewResolver
import com.maciejkozlowski.viewmanager.util.inflate
import com.maciejkozlowski.viewmanagersample.R
import com.maciejkozlowski.viewmanagersample.base.BaseViewManager
import kotlinx.android.synthetic.main.content_view.view.*

/**
 * Created by Maciej Kozłowski on 23/04/2019.
 */
class FirstViewManager(override val containerViewGroup: ViewGroup) : BaseViewManager {

    private val contentView by lazy { containerViewGroup.inflate(R.layout.content_view) }
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
        contentView.contentTextView.text = text
    }

    init {
        initialize()
    }
}