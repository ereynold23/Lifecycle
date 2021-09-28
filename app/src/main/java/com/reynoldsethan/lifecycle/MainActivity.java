package com.reynoldsethan.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ShareCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView top_left;
    TextView top_right;
    TextView bot_left;
    TextView bot_right;
    TextView center;
    SeekBar font_changer;
    ConstraintLayout main_layout;
    int countonCreate =0;
    int countonStart=0;
    int countonResume=0;
    int countonPause=0;
    int countonStop=0;
    int countonRestart=0;
    int countonDestroy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        top_left = findViewById(R.id.top_left_button);
        top_right = findViewById(R.id.top_right_button);
        bot_left = findViewById(R.id.bot_left_button);
        bot_right = findViewById(R.id.bot_right_button);
        font_changer = findViewById(R.id.font_changer);
        center = findViewById(R.id.center_number);
        top_left.setOnClickListener(this);
        top_right.setOnClickListener(this);
        bot_right.setOnClickListener(this);
        bot_left.setOnClickListener(this);
        center.setOnClickListener(this);
        main_layout = findViewById(R.id.main_layout);
        setInitialValues();
        main_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                top_left.setText("0");
                top_right.setText("0");
                bot_left.setText("0");
                bot_right.setText("0");
                font_changer.setProgress(50);
                center.setText("0");
                SharedPreferences wipe = getSharedPreferences("AppSave", MODE_PRIVATE);
                SharedPreferences.Editor remove = wipe.edit();
                remove.clear();
                remove.apply();
                return false;
            }
        });
    }

    private void setInitialValues() {
        countonCreate=sharedPreferences.getInt("onCreate",0);
        countonStart=sharedPreferences.getInt("onStart",0);
        countonResume=sharedPreferences.getInt("onResume",0);
        countonPause=sharedPreferences.getInt("onPause",0);
        countonStop=sharedPreferences.getInt("onStop",0);
        countonRestart=sharedPreferences.getInt("onRestart",0);
        countonDestroy=sharedPreferences.getInt("onDestroy",0);
    }
    private void storeValues() {
        editor.putInt("onCreate",countonCreate);
        editor.putInt("onStart",countonStart);
        editor.putInt("onResume",countonResume);
        editor.putInt("onPause",countonPause);
        editor.putInt("onStop",countonStop);
        editor.putInt("onRestart",countonRestart);
        editor.putInt("onDestroy",countonDestroy);
        editor.apply();
    }
    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonStop++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        storeValues();
    }

    @Override
    public void onClick(View view) {

    }
}
