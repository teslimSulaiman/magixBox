package com.droidrank.sample.controller;

import com.droidrank.sample.R;
import com.droidrank.sample.data.BoxData;
import com.droidrank.sample.viewInterface.InputInterface;

/**
 * Created by USER on 5/28/2018.
 */

public class MagicBoxController {

    private InputInterface inputInterface;
    private BoxData boxData;
    public MagicBoxController(InputInterface inputInterface, BoxData boxData) {
        this.inputInterface = inputInterface;
        this.boxData = boxData;
    }


    public MagicBoxController( BoxData boxData) {
        this.boxData = boxData;
    }

    public String[] getData(int numberOfColumn){
        return boxData.getBoxData(numberOfColumn);
    }

    public void onButtonClicked() {

        String   numberOfColumns = inputInterface.getNumberInput();
        if (boxData.isFieldEmpty(numberOfColumns)){
            inputInterface.showInputError(R.string.error_empty);
            return;
        }
        if(android.text.TextUtils.isDigitsOnly(numberOfColumns) && boxData.isOdd(Integer.parseInt(numberOfColumns))){
            inputInterface.startActivity();
        }else if(android.text.TextUtils.isDigitsOnly(numberOfColumns)){
           inputInterface.showInputError(R.string.only_odd);
        }else{
            inputInterface.showInputError(R.string.error_input);
        }
    }


}
