package br.com.mercadolibre.app.viewholder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import br.com.mercadolibre.app.R;
import br.com.mercadolibre.app.model.Payment;

public class PaymentViewHolder extends ViewHolderBind<Payment> {

    private ImageView ivImage;
    private TextView tvName;

    public PaymentViewHolder(RecyclerView parent) {
        super(parent, R.layout.item_list_payment);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void onBindViewHolder(final Payment payment, int position) {
        if (!TextUtils.isEmpty(payment.getImage())) {
            Picasso.with(itemView.getContext()).load(payment.getImage()).into(ivImage);
        }
        tvName.setText(payment.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(payment);
            }
        });
    }
}
