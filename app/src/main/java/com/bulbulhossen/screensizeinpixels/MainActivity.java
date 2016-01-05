package com.bulbulhossen.screensizeinpixels;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView heightInPixel = (TextView)findViewById(R.id.height_pixel);
        TextView widthInPixel = (TextView)findViewById(R.id.width_pixel);
        TextView inches = (TextView)findViewById(R.id.inches_pixel);

        String[] screenData = getScreenDimension();

        widthInPixel.setText(screenData[0]);
        heightInPixel.setText(screenData[1]);
        inches.setText(screenData[2]);
//
//        return view;
    }

    private String[] getScreenDimension(){
        DisplayMetrics dm = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        double wi = (double)width / (double)dens;
        double hi = (double)height / (double)dens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x+y);

        String[] screenInformation = new String[3];
        screenInformation[0] = String.valueOf(width) + " px";
        screenInformation[1] = String.valueOf(height) + " px" ;
        screenInformation[2] = String.format("%.2f", screenInches) + " inches" ;

        return screenInformation;
    }

}











