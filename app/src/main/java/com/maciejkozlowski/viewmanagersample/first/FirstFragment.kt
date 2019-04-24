package com.maciejkozlowski.viewmanagersample.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FirstFragment : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    private val viewManager by lazy { FirstViewManager(FrameLayout(context!!)) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return viewManager.containerViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        load()
    }

    private fun load() {
        val disposable = Single
            .just("Hello world")
            .delay(3, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { viewManager.showLoading() }
            .subscribe(
                { viewManager.showContent(it) },
                { viewManager.showError() }
            )

        compositeDisposable.addAll(disposable)
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.dispose()
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}
