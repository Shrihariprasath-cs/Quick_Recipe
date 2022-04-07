package com.quick.recipe.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.recipe.R;

public class MyHolder  extends RecyclerView.ViewHolder {

    public TextView nameTxt,subTxt;
    public ImageView img;
    public CardView card_select;
    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        subTxt= (TextView) itemView.findViewById(R.id.subTxt);
        img=(ImageView) itemView.findViewById(R.id.cocktailImage);
        card_select=(CardView) itemView.findViewById(R.id.card_select);


    }
}
