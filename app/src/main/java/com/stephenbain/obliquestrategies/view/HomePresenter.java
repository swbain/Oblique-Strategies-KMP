package com.stephenbain.obliquestrategies.view;

import com.stephenbain.obliquestrategies.model.Strategy;
import com.stephenbain.obliquestrategies.model.StrategyDao;
import com.stephenbain.obliquestrategies.util.NullObject;

import javax.inject.Inject;
import java.util.UUID;

public class HomePresenter {

    private static final HomeView NULL_VIEW = NullObject.create(HomeView.class);

    private final StrategyDao strategyDao;

    private HomeView view = NULL_VIEW;

    @Inject
    public HomePresenter(StrategyDao strategyDao) {
        this.strategyDao = strategyDao;
    }

    public void attach(HomeView view) {
        this.view = view;
    }

    public void detach() {
        view = NULL_VIEW;
    }

    public void present() {
        view.setClickListener(new ClickListener() {
            @Override
            public void onClicked() {
                loadStrategy();
            }
        });

        loadStrategy();
    }

    private void loadStrategy() {
        strategyDao.requestStrategy(new StrategyDao.Callback() {
            @Override
            public void onSuccess(Strategy strategy) {
                view.showStrategy(strategy.getStrategy());
            }

            @Override
            public void onError() {
                view.showError();
            }
        });
    }

    interface HomeView {
        void setClickListener(ClickListener clickListener);
        void showStrategy(String strategy);
        void showError();
    }

    interface ClickListener {
        void onClicked();
    }
}
