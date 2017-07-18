package com.stephenbain.obliquestrategies.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.stephenbain.obliquestrategies.MyApplication
import com.stephenbain.obliquestrategies.R
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomePresenter.HomeView {

    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).component.inject(this)
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

    override fun setClickListener(clickListener: () -> Unit) {
        touchIntercept.setOnClickListener { clickListener() }
    }

}