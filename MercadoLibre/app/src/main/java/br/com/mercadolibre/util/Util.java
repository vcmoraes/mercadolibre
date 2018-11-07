package br.com.mercadolibre.util;

import android.support.annotation.NonNull;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    public static String toCurrencyValue(double value) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(value).replace("R$", "R$ ");
    }

    public static double textToValue(@NonNull String value) {
        String cleanString = value.replaceAll("[,.]", "");
        double parsed = cleanString.isEmpty() ? 0.0 : Double.parseDouble(cleanString);
        return parsed / 100;
    }
}
