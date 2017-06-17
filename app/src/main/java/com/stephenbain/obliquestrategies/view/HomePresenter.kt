package com.stephenbain.obliquestrategies.view

class HomePresenter {

    private val nullView = NullHomeView()

    private var view: HomeView = nullView

    fun attach(view: HomeView) {
        this.view = view
    }

    fun detach() {
        view = nullView
    }

    fun present() {
        view.setStrategy("hello world from presenter. lol")
    }

    interface HomeView {
        fun setStrategy(strategy: String)
    }

    private class NullHomeView : HomeView {
        override fun setStrategy(strategy: String) {
            // no-op
        }

    }

}