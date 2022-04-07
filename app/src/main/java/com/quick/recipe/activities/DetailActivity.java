package com.quick.recipe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.quick.recipe.R;
import com.quick.recipe.utils.PicassoClient;
import com.skyhope.showmoretextview.ShowMoreTextView;

public class DetailActivity extends AppCompatActivity {
TextView nameTxt,ingred_1,ingred_2,ingred_3,ingred_4,ingred_5;
ShowMoreTextView txtdescription;
ImageView cokctailimage,back_arrow;
String strName,strSubName,description,strIngredient1,strIngredient2,strIngredient3,strIngredient4,strIngredient5,strImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);

        strName =  getIntent().getStringExtra("name");
        strImage =  getIntent().getStringExtra("url");
        strSubName =  getIntent().getStringExtra("subname");
        description =  getIntent().getStringExtra("description");
        strIngredient1 =  getIntent().getStringExtra("ingredient1");
        strIngredient2 =  getIntent().getStringExtra("ingredient2");
        strIngredient3 =  getIntent().getStringExtra("ingredient3");
        strIngredient4 =  getIntent().getStringExtra("ingredient4");
        strIngredient5 =  getIntent().getStringExtra("ingredient5");


        back_arrow=(ImageView)findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


        nameTxt=(TextView)findViewById(R.id.nameTxt);
        nameTxt.setText(strName);

        txtdescription=(ShowMoreTextView)findViewById(R.id.description);
        txtdescription.setText(description);


        txtdescription.setShowingLine(4);
        txtdescription.addShowMoreText("Readmore");
        txtdescription.addShowLessText("Less");
        txtdescription.setShowMoreColor(Color.parseColor("#ff6900")); // or other color
        txtdescription.setShowLessTextColor(Color.parseColor("#ff6900"));

        ingred_1=(TextView)findViewById(R.id.ingred_1);
        ingred_1.setText(strIngredient1);

        ingred_2=(TextView)findViewById(R.id.ingred_2);
        ingred_2.setText(strIngredient2);

        ingred_3=(TextView)findViewById(R.id.ingred_3);
        ingred_3.setText(strIngredient3);

        ingred_4=(TextView)findViewById(R.id.ingred_4);
        ingred_4.setText(strIngredient4);

        ingred_5=(TextView)findViewById(R.id.ingred_5);
        ingred_5.setText(strIngredient5);


        cokctailimage=(ImageView)findViewById(R.id.cocktailImage);


        PicassoClient.downloadimg(getApplicationContext(), strImage,cokctailimage);




    }
}