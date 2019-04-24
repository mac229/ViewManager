package com.maciejkozlowski.viewmanagersample.base

import com.maciejkozlowski.viewmanager.ViewManager

/**
 * Created by Maciej Kozłowski on 24/04/2019.
 */

interface BaseViewManager : ViewManager {

    override fun initialize() {
        containerViewGroup.apply {
            addViewToContainer(contentViewResolver)
            addViewToContainer(loadingViewResolver)
            addViewToContainer(errorViewResolver)
        }
    }
}