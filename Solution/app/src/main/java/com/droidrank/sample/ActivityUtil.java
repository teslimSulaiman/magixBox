package com.droidrank.sample;

import android.content.Context;
import android.content.Intent;

import com.droidrank.sample.view.MagicBoxActivity;

/**
 * Created by USER on 5/28/2018.
 */

public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMagicBoxActivity(int numberOfBox) {
        Intent intent = new Intent(context, MagicBoxActivity.class);
        intent.putExtra("number_of_columns", numberOfBox);
        context.startActivity(intent);
    }

}