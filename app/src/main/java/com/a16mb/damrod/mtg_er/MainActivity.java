package com.a16mb.damrod.mtg_er;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.top_bg_image)
    ImageView topBgImage;

    @InjectView(R.id.top_button_minus)
    Button topButtonMinus;

    @InjectView(R.id.top_button_plus)
    Button topButtonPlus;

    @InjectView(R.id.top_life_total)
    TextView topLifeTotal;

    @InjectView(R.id.bottom_bg_image)
    ImageView bottomBgImage;

    @InjectView(R.id.bottom_button_minus)
    Button bottomButtonMinus;

    @InjectView(R.id.bottom_button_plus)
    Button bottomButtonPlus;

    @InjectView(R.id.bottom_life_total)
    TextView bottomLifeTotal;

    @InjectView(R.id.restert_button)
            Button buttonRestart;

    int startingHP = 20;
    int topHP = startingHP, bottomHP = startingHP;

    @Override
    protected void onStop() {
        super.onStop();
        saveDataToSharedPref();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setRandomBG();
        readDataFromSharedPref();
        topLifeTotal.setText(Integer.toString(topHP));
        bottomLifeTotal.setText(Integer.toString(bottomHP));

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topHP = startingHP;
                bottomHP = startingHP;
                topLifeTotal.setText(Integer.toString(topHP));
                bottomLifeTotal.setText(Integer.toString(bottomHP));
                setRandomBG();
            }
        });

        topButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topHP--;
                topLifeTotal.setText(Integer.toString(topHP));
            }
        });

        topButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topHP++;
                topLifeTotal.setText(Integer.toString(topHP));
            }
        });

        bottomButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomHP--;
                bottomLifeTotal.setText(Integer.toString(bottomHP));
            }
        });

        bottomButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomHP++;
                bottomLifeTotal.setText(Integer.toString(bottomHP));
            }
        });

    }

void saveDataToSharedPref()
{
    SharedPreferences prefs = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putInt("topHP", topHP);
    editor.putInt("bottomHP", bottomHP);
    editor.putInt("startingHP",startingHP);
    editor.apply();
}

void readDataFromSharedPref()
{
    SharedPreferences prefs = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
    startingHP = prefs.getInt("startingHP", 20);
    topHP = prefs.getInt("topHP", startingHP);
    bottomHP = prefs.getInt("bottomHP", startingHP);
}

    void setRandomBG()
    {
        int[] imgID = {
                R.drawable.land0,
                R.drawable.land1,
                R.drawable.land2,
                R.drawable.land3,
                R.drawable.land4
        };
        Random rnd = new Random();
        int top = rnd.nextInt(5);
        int bottom = top-1;
        if(bottom <0)
        {
            bottom = top+1;
        }
        topBgImage.setBackgroundResource(imgID[top]);
        bottomBgImage.setBackgroundResource(imgID[bottom]);

    }


}
