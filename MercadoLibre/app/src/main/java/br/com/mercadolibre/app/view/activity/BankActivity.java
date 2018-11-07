package br.com.mercadolibre.app.view.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.adapter.RecyclerViewAdapter;
import br.com.mercadolibre.app.contract.BankContract;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.presenter.BankPresenter;
import br.com.mercadolibre.app.viewholder.BankViewHolder;

@EActivity(R.layout.activity_bank)
public class BankActivity extends BaseSubscribeActivity implements BankContract.BankView {

    private final int REQUEST_INSTALLMENT = 10;

    @Bean
    BankPresenter presenter;

    @ViewById
    RecyclerView rvCards;

    @Extra
    @InstanceState
    double value;

    @Extra
    @InstanceState
    Payment payment;

    @InstanceState
    ArrayList<Bank> banks = new ArrayList<>();

    private RecyclerViewAdapter<Bank> adapter;

    @AfterViews
    public void init() {
        presenter.setView(this);
        if (banks.isEmpty()) {
            showLoading(getString(R.string.wait));
            presenter.getBanks(payment);
        }
        adapter = new RecyclerViewAdapter<>(BankViewHolder.class, banks);
        rvCards.setAdapter(adapter);
    }

    @Override
    public void onBanks(@NonNull ArrayList<Bank> banks) {
        this.banks.addAll(banks);
        adapter.notifyDataSetChanged();
        hiddenLoading();
    }

    @Override
    public void onError(@NonNull String men) {
        hiddenLoading();
        showDialogMessage(men, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BankActivity.this.finish();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBankSelected(@NonNull Bank bank) {
        InstallmentActivity_.intent(this).value(value).payment(payment).bank(bank).startForResult(REQUEST_INSTALLMENT);
    }

    @OnActivityResult(REQUEST_INSTALLMENT)
    void onResult(int resultCode) {
        if (resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            BankActivity.this.finish();
        }
    }
}
