package br.com.mercadolibre.app.view.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
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
import br.com.mercadolibre.app.contract.PaymentContract;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.presenter.PaymentPresent;
import br.com.mercadolibre.app.viewholder.PaymentViewHolder;

@EActivity(R.layout.activity_payment)
public class PaymentActivity extends BaseSubscribeActivity implements PaymentContract.PaymentView {

    private final int REQUEST_BANK = 10;

    @Bean
    PaymentPresent presenter;

    @ViewById
    RecyclerView rvCards;

    @Extra
    double value;

    @InstanceState
    ArrayList<Payment> payments = new ArrayList<>();

    private RecyclerViewAdapter<Payment> adapter;

    @AfterViews
    public void init() {
        presenter.setView(this);
        if (payments.isEmpty()) {
            showLoading(getString(R.string.wait));
            presenter.getPayments();
        }
        adapter = new RecyclerViewAdapter<>(PaymentViewHolder.class, payments);
        rvCards.setAdapter(adapter);
    }

    @Click(R.id.btn_continue)
    void onBtnContinue() {
        BankActivity_.intent(this).start();
    }

    @Override
    public void onPayments(@NonNull ArrayList<Payment> payments) {
        this.payments.addAll(payments);
        adapter.notifyDataSetChanged();
        hiddenLoading();
    }

    @Override
    public void onError(@NonNull String men) {
        hiddenLoading();
        showDialogMessage(men, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PaymentActivity.this.finish();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPaymentSelected(@NonNull Payment payment) {
        BankActivity_.intent(this).value(value).payment(payment).startForResult(REQUEST_BANK);
    }

    @OnActivityResult(REQUEST_BANK)
    void onResult(int resultCode) {
        if (resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            PaymentActivity.this.finish();
        }
    }
}
