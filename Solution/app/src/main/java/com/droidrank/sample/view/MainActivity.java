package com.droidrank.sample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.droidrank.sample.ActivityUtil;
import com.droidrank.sample.R;
import com.droidrank.sample.controller.MagicBoxController;
import com.droidrank.sample.data.BoxData;
import com.droidrank.sample.viewInterface.InputInterface;

public class MainActivity extends AppCompatActivity implements InputInterface {

    EditText numberOfColumnsView;
    Button button ;
    MagicBoxController magicBoxController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfColumnsView = (EditText) findViewById(R.id.size_of_box);
        button = (Button)findViewById(R.id.bt_create);
        magicBoxController = new MagicBoxController(this, new BoxData());

    }

    public void generateMagicBox(View view){

        magicBoxController.onButtonClicked();
    }

    @Override
    public void showInputError(int resId) {
        numberOfColumnsView.setError(getString(resId));
    }

    @Override
    public String getNumberInput() {
        return numberOfColumnsView.getText().toString();

    }

    @Override
    public void startActivity() {
        int value = Integer.parseInt(getNumberInput());
        new ActivityUtil(this).startMagicBoxActivity(value);
    }
}
