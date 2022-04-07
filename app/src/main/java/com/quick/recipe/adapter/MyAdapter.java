package com.quick.recipe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.quick.recipe.R;

import com.quick.recipe.activities.DetailActivity;
import com.quick.recipe.adapter.holder.MyHolder;
import com.quick.recipe.model.Cocktail;
import com.quick.recipe.utils.PicassoClient;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    ArrayList<Cocktail> cocktail;

    public MyAdapter (Context context, ArrayList<Cocktail> cocktails){
        this.context= context;
        this.cocktail=cocktails;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_layout,parent,false);
        MyHolder holder= new MyHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Cocktail cocktaillist = cocktail.get(position);

        holder.nameTxt.setText(cocktaillist.getName());
        holder.subTxt.setText(cocktaillist.getSubName());
        holder.subTxt.setText(cocktaillist.getSubName());
        PicassoClient.downloadimg(context, cocktaillist.getUrl(),holder.img);


        holder.card_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", cocktaillist.getName());
                intent.putExtra("url",  cocktaillist.getUrl());
                intent.putExtra("subname",  cocktaillist.getSubName());
                intent.putExtra("description",  cocktaillist.getDescription());
                intent.putExtra("ingredient1",  cocktaillist.getIngredient1());
                intent.putExtra("ingredient2",  cocktaillist.getIngredient2());
                intent.putExtra("ingredient3",  cocktaillist.getIngredient3());
                intent.putExtra("ingredient4",  cocktaillist.getIngredient4());
                intent.putExtra("ingredient5",  cocktaillist.getIngredient5());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return cocktail.size();
    }

    public void removeTopItem() {
        cocktail.remove(0);
        notifyDataSetChanged();
    }
}