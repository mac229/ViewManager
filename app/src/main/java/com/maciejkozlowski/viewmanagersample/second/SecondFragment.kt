package com.maciejkozlowski.viewmanagersample.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maciejkozlowski.viewmanagersample.R
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_second.*
import java.util.concurrent.TimeUnit

class SecondFragment : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    private val viewManager by lazy { SecondViewManager(frameLayout) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
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
        fun newInstance() = SecondFragment()
    }
}
