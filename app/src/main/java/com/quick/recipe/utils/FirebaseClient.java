package com.quick.recipe.utils;

import android.content.Context;

import android.util.Log;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.quick.recipe.adapter.MyAdapter;

import com.quick.recipe.model.Cocktail;

import java.util.ArrayList;


/**
 * Created by Admin on 4/29/2017.
 */

public class FirebaseClient {

    Context c;
    String DB_URL;
    RecyclerView recyclerView;

    Firebase firebase;
    ArrayList<Cocktail> cocktails= new ArrayList<>();
    MyAdapter adapter;


    public  FirebaseClient(Context c, String DB_URL, RecyclerView recyclerView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.recyclerView= recyclerView;


        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    public  void savedata (String name, String url)
    {
        Cocktail b= new Cocktail();
        b.setName(name);
        b.setUrl(url);

        firebase.child("Cocktail").push().setValue(b);


    }

    public  void refreshdata()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getupdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getupdates(DataSnapshot dataSnapshot){
        cocktails.clear();
        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Cocktail b= new Cocktail();
            b.setName(ds.getValue(Cocktail.class).getName());
            b.setUrl(ds.getValue(Cocktail.class).getUrl());
            b.setSubName(ds.getValue(Cocktail.class).getSubName());
            b.setDescription(ds.getValue(Cocktail.class).getDescription());
            b.setIngredient1(ds.getValue(Cocktail.class).getIngredient1());
            b.setIngredient2(ds.getValue(Cocktail.class).getIngredient2());
            b.setIngredient3(ds.getValue(Cocktail.class).getIngredient3());
            b.setIngredient4(ds.getValue(Cocktail.class).getIngredient4());
            b.setIngredient5(ds.getValue(Cocktail.class).getIngredient5());
            cocktails.add(b);

        }
        if(cocktails.size()>0)
        {
            adapter=new MyAdapter(c, cocktails);



            recyclerView.setAdapter(adapter);
        }else
        {
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}