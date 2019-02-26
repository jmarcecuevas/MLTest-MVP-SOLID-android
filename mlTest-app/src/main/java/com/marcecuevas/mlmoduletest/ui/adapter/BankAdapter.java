package com.marcecuevas.mlmoduletest.ui.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.marcecuevas.mlmoduletest.ui.adapter.viewholder.SimpleViewHolder;
import com.marcecuevas.mltest_core.model.dto.BankDTO;

public class BankAdapter extends SimpleImageTextAdapter<BankDTO,BankAdapter.BankViewHolder> {

    private Listener listener;

    public BankAdapter(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    BankViewHolder getViewHolder(View view) {
        return new BankViewHolder(context,view);
    }

    class BankViewHolder extends SimpleViewHolder<BankDTO> implements View.OnClickListener {

        public BankViewHolder(Context context, View itemView) {
            super(context, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void bind(BankDTO item) {
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
                listener.onBankSelected(items.get(getLayoutPosition()));
            }
        }
    }

    public interface Listener {
        void onBankSelected(BankDTO bank);
    }
}
