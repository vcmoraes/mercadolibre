package br.com.mercadolibre.app.view.watcher;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import br.com.mercadolibre.util.Util;

public class ValueTextWatcher implements TextWatcher {

    private final EditText editText;
    private final int maxValue;
    private String current = "";

    public ValueTextWatcher(@NonNull EditText editText, int maxValue) {
        this.editText = editText;
        this.maxValue = maxValue;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!s.toString().equalsIgnoreCase(current)) {
            editText.removeTextChangedListener(this);

            String cleanString = s.toString().replaceAll("[,.]", "");
            String cleanStringParsed = current.replaceAll("[,.]", "");

            double parsed = cleanString.isEmpty() ? 0.0 : Double.parseDouble(cleanString);
            String formatted = "";
            if (parsed / 100 > maxValue) {
                parsed = java.lang.Double.parseDouble(cleanStringParsed);
            }
            if (parsed > 0) {
                formatted = Util.toCurrencyValue(parsed / 100).replaceAll("[R$]", "");
            }

            current = formatted;
            editText.setText(formatted);
            editText.setSelection(formatted.length());

            editText.addTextChangedListener(this);
        }
    }
}
