package br.com.mercadolibre.app.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.core.modelResponse.BankResponse;

@EBean(scope = EBean.Scope.Singleton)
public class BankMapper {

    public Bank responseToBank(BankResponse response) {
        Bank bank = new Bank();
        bank.setId(response.getId());
        bank.setName(response.getName());
        bank.setImage(response.getThumbnail());
        return bank;
    }

    public ArrayList<Bank> responseToBank(@NonNull ArrayList<BankResponse> response) {
        ArrayList<Bank> banks = new ArrayList<>();
        for (BankResponse bankResponse : response) {
            banks.add(responseToBank(bankResponse));
        }
        return banks;
    }
}
