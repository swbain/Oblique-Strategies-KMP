package com.stephenbain.obliquestrategies.view

import java.util.*
import javax.inject.Inject

class HomePresenter @Inject constructor() {

    private var view: HomeView? = null

    fun attach(view: HomeView) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun present() {
        view?.setStrategy("hello world from presenter. lol")
        view?.setClickListener {
            view?.setStrategy(UUID.randomUUID().toString())
        }
    }

    interface HomeView {
        fun setStrategy(strategy: String)
        fun setClickListener(clickListener: () -> Unit)
    }

}