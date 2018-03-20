package com.stephenbain.obliquestrategies.view

import com.stephenbain.obliquestrategies.data.StrategyService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(private val strategyService: StrategyService) {

    private var view: HomeView? = null

    fun attach(view: HomeView) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun present() {
        refreshStrategy()
        view?.setClickListener(::refreshStrategy)
    }

    private fun refreshStrategy() {
        strategyService.requestStrategy()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ cardResponse -> view?.setStrategy(cardResponse.strategy) })
    }

    interface HomeView {
        fun setStrategy(strategy: String)
        fun setClickListener(clickListener: () -> Unit)
    }

}