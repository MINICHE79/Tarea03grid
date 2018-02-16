package com.example.inspiron.tarea03grid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class App extends AppCompatActivity {
    private GridView gridView = null;
    private itemAdapter adapter = null;
    private ArrayList<item> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new itemAdapter(this, R.layout.row_grid, fillImages());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                AlertDialog.Builder ImageDialog = new AlertDialog.Builder(App.this);
                ImageView showImage = new ImageView(App.this);
                Bitmap bitmapo = BitmapFactory.decodeResource(getResources(),
                        getResources().getIdentifier("sample_" + position,
                                "drawable",
                                "com.example.inspiron.tarea03grid"));

                showImage.setImageBitmap(bitmapo);
                ImageDialog.setView(showImage);
                ImageDialog.show();
            }
        });
    }

    private ArrayList<item> fillImages() {
        int values = Integer.parseInt(getResources().getString(R.string.howmanyImages));
        lista = new ArrayList<>();
        for (int i = 0; i <= values; i++) {

            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    getResources().getIdentifier("sample_" + i,
                            "drawable",
                            "com.example.inspiron.tarea03grid"));
            lista.add(new item(bitmap, "sample_" + i));
        }
        return lista;
    }
}
