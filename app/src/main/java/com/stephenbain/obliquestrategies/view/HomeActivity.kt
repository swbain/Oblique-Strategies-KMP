package com.stephenbain.obliquestrategies.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.stephenbain.obliquestrategies.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomePresenter.HomeView {

    private val presenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter.attach(this)
        presenter.present()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun setStrategy(strategy: String) {
        this.strategy.text = strategy
    }

}