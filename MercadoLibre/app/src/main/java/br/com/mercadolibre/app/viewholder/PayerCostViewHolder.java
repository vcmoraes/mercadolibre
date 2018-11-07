package br.com.mercadolibre.app.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.model.PayerCost;

public class PayerCostViewHolder extends ViewHolderBind<PayerCost> {

    private TextView tvName;

    public PayerCostViewHolder(RecyclerView parent) {
        super(parent, R.layout.item_list_payercost);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void onBindViewHolder(final PayerCost payerCost, int position) {
        tvName.setText(payerCost.getRecommendedMessage());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(payerCost);
            }
        });
    }
}