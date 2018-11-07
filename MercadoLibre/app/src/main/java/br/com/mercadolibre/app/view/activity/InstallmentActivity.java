package br.com.mercadolibre.app.view.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.adapter.RecyclerViewAdapter;
import br.com.mercadolibre.app.contract.InstallmentContract;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Installment;
import br.com.mercadolibre.app.model.PayerCost;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.presenter.InstallmentPresenter;
import br.com.mercadolibre.app.viewholder.PayerCostViewHolder;

@EActivity(R.layout.activity_installment)
public class InstallmentActivity extends BaseSubscribeActivity implements InstallmentContract.InstallmentView {

    @Bean
    InstallmentPresenter presenter;

    @ViewById
    RecyclerView rvCards;

    @Extra
    @InstanceState
    double value;

    @Extra
    @InstanceState
    Payment payment;

    @Extra
    @InstanceState
    Bank bank;

    @InstanceState
    ArrayList<PayerCost> payerCosts = new ArrayList<>();

    private RecyclerViewAdapter<PayerCost> adapter;

    @AfterViews
    public void init() {
        presenter.setView(this);
        if (payerCosts.isEmpty()) {
            showLoading(getString(R.string.wait));
            presenter.getInstallments(value, payment, bank);
        }
        adapter = new RecyclerViewAdapter<>(PayerCostViewHolder.class, payerCosts);
        rvCards.setAdapter(adapter);
    }

    @Override
    public void onInstallments(@NonNull ArrayList<Installment> installments) {
        if (!installments.isEmpty()) {
            this.payerCosts.addAll(installments.get(0).getCosts());
            adapter.notifyDataSetChanged();
        }
        hiddenLoading();
    }

    @Override
    public void onError(@NonNull String men) {
        hiddenLoading();
        showDialogMessage(men, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                InstallmentActivity.this.finish();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPayerCostSelected(@NonNull PayerCost payerCost) {
        setResult(RESULT_OK);
        InstallmentActivity.this.finish();
    }
}
