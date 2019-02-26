package com.marcecuevas.mlmoduletest.ui.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.marcecuevas.mlmoduletest.ui.adapter.viewholder.SimpleViewHolder;
import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;

public class PaymentMethodAdapter extends SimpleImageTextAdapter<PaymentMethodDTO,PaymentMethodAdapter.PaymentMethodViewHolder> {

    private Listener listener;

    public PaymentMethodAdapter(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    PaymentMethodViewHolder getViewHolder(View view) {
        return new PaymentMethodViewHolder(context,view);
    }

    class PaymentMethodViewHolder extends SimpleViewHolder<PaymentMethodDTO> implements View.OnClickListener {

        PaymentMethodViewHolder(Context context, View itemView) {
            super(context, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void bind(PaymentMethodDTO item) {
            if(item.getThumbnail() != null){
                Glide.with(context).load(item.getThumbnail()).into(imageView);
            }
            if(item.getName() != null){
                titleTV.setText(item.getName());
            }
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onPaymentMethodSelected(items.get(
                        getLayoutPosition()));
            }
        }
    }

    public interface Listener {
        void onPaymentMethodSelected(PaymentMethodDTO paymentMethod);
    }
}
