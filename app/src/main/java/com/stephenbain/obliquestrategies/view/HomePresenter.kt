package com.stephenbain.obliquestrategies.view

class HomePresenter {

    private var view: HomeView? = null

    fun attach(view: HomeView) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun present() {
        view?.setStrategy("hello world from presenter. lol")
    }

    interface HomeView {
        fun setStrategy(strategy: String)
        fun setClickListener(clickListener: ClickListener)
    }

    interface ClickListener {
        fun onClicked()
    }

}