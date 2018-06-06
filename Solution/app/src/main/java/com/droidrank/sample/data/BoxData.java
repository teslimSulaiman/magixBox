package com.droidrank.sample.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 5/28/2018.
 */

public class BoxData {

    public String[] getBoxData(int n){

        int[][] magicSquare = new int[n][n];
        String [] result = new String[n*n];

        int i = n/2;
        int j = n-1;

        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n)
            {
                j = n-2;
                i = 0;
            }
            else
            {
                if (j == n)
                    j = 0;

                if (i < 0)
                    i=n-1;
            }

            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else{
                magicSquare[i][j] = num++;
                result[i * n + j] = num -1 +"";
            }

            j++; i--;
        }

        return result;
    }


    public boolean isFieldEmpty(String numberOfColumns) {
        return numberOfColumns.isEmpty();
    }

    public boolean isOdd(int number){

        return number > 0 && number % 2 != 0;
    }
}
