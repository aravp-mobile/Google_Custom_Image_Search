package com.arvind.ooug.taskgci.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.arvind.ooug.taskgci.R;
import com.arvind.ooug.taskgci.models.ImageResult;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivImage = (ImageView)findViewById(R.id.ivResult);

        ImageResult imageResult = (ImageResult)getIntent().getSerializableExtra("result");
        String url = imageResult.getFullurl();
        Picasso.with(this).load(url).into(ivImage);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_image_display, menu);
        return true;
    }
}
