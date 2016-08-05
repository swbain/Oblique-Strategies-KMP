package com.stephenbain.obliquestrategies.view;

import com.stephenbain.obliquestrategies.util.NullObject;

import javax.inject.Inject;

public class HomePresenter {

    private static final HomeView NULL_VIEW = NullObject.create(HomeView.class);

    private HomeView view = NULL_VIEW;

    @Inject
    public HomePresenter() {

    }

    public void attach(HomeView view) {
        this.view = view;
    }

    public void detach() {
        view = NULL_VIEW;
    }

    public void present() {

    }

    interface HomeView {

    }
}
