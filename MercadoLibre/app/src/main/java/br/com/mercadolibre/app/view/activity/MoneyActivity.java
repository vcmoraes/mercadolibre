package br.com.mercadolibre.app.view.activity;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.view.watcher.ValueTextWatcher;
import br.com.mercadolibre.util.Util;

@EActivity(R.layout.activity_money)
public class MoneyActivity extends BaseActivity {

    private final int REQUEST_PAYMENT = 10;

    @ViewById
    TextInputLayout inputLayoutValue;

    @ViewById
    Button btnContinue;

    @AfterViews
    public void init() {
        if (inputLayoutValue.getEditText() != null) {
            inputLayoutValue.getEditText().addTextChangedListener(new ValueTextWatcher(inputLayoutValue.getEditText(), Integer.MAX_VALUE));
            inputLayoutValue.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    btnContinue.setVisibility(s.toString().trim().isEmpty() ? View.GONE : View.VISIBLE);
                }
            });
        }
    }

    @Click(R.id.btn_continue)
    void onBtnContinue() {
        if (inputLayoutValue.getEditText() != null) {
            PaymentActivity_.intent(this).value(Util.textToValue(inputLayoutValue.getEditText().getText().toString())).startForResult(REQUEST_PAYMENT);
        }
    }

    @OnActivityResult(REQUEST_PAYMENT)
    void onResult(int resultCode) {
        if (resultCode == RESULT_OK && inputLayoutValue.getEditText() != null) {
            inputLayoutValue.getEditText().setText("");
        }
    }
}
