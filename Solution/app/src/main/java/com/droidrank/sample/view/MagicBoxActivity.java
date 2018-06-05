package com.droidrank.sample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.droidrank.sample.R;
import com.droidrank.sample.controller.MagicBoxController;
import com.droidrank.sample.data.BoxData;

public class MagicBoxActivity extends AppCompatActivity {

    MagicBoxController magicBoxController;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_box);
        Intent intent = getIntent();
        int  numberOfColumns = intent.getIntExtra("number_of_columns",1);
        magicBoxController = new MagicBoxController(new BoxData());
        String[] numbers = magicBoxController.getData(numberOfColumns);
        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setNumColumns(numberOfColumns);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);
    }
}
