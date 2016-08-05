package com.stephenbain.obliquestrategies.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.stephenbain.obliquestrategies.MyApplication;
import com.stephenbain.obliquestrategies.R;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomeView {

    @Inject HomePresenter presenter;

    @BindView(R.id.touchIntercept) View touchIntercept;
    @BindView(R.id.strategy) TextView strategy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getComponent().inject(this);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter.attach(this);
        presenter.present();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }

    @Override
    public void setClickListener(final HomePresenter.ClickListener clickListener) {
        touchIntercept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClicked();
            }
        });
    }

    @Override
    public void showStrategy(String strategy) {
        this.strategy.setText(strategy);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
}
