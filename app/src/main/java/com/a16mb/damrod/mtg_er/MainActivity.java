package com.a16mb.damrod.mtg_er;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ImageView topBgImage;
    @BindView(R.id.top_button_minus)
    Button topButtonMinus;

    @BindView(R.id.top_button_plus)
    Button topButtonPlus;

    @BindView(R.id.top_life_total)
    TextView topLifeTotal;

    ImageView bottomBgImage;

    @BindView(R.id.bottom_button_minus)
    Button bottomButtonMinus;

    @BindView(R.id.bottom_button_plus)
    Button bottomButtonPlus;

    @BindView(R.id.bottom_life_total)
    TextView bottomLifeTotal;

    int startingHP = 25;
    int topHP = startingHP, bottomHP = startingHP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setRandomBG();


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
        topBgImage  = (ImageView) findViewById(R.id.top_bg_image);
        topBgImage.setBackgroundResource(imgID[top]);

        bottomBgImage  = (ImageView) findViewById(R.id.bottom_bg_image);
        bottomBgImage.setBackgroundResource(imgID[bottom]);

    }


}
