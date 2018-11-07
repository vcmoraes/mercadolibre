package br.com.mercadolibre.app.viewholder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.model.Bank;

public class BankViewHolder extends ViewHolderBind<Bank> {

    private ImageView ivImage;
    private TextView tvName;

    public BankViewHolder(RecyclerView parent) {
        super(parent, R.layout.item_list_bank);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void onBindViewHolder(final Bank bank, int position) {
        if (!TextUtils.isEmpty(bank.getImage())) {
            Picasso.with(itemView.getContext()).load(bank.getImage()).into(ivImage);
        }
        tvName.setText(bank.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(bank);
            }
        });
    }
}
