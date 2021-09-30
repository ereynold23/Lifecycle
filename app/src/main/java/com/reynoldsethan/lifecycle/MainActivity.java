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
    TextView currentRun;
    TextView onCreate;
    TextView onStart;
    TextView onResume;
    TextView onPause;
    TextView onStop;
    TextView onRestart;
    TextView onDestroy;
    TextView lifetime;
    TextView onCreate2;
    TextView onStart2;
    TextView onResume2;
    TextView onPause2;
    TextView onStop2;
    TextView onRestart2;
    TextView onDestroy2;
    ConstraintLayout main_layout;
    int countonCreate =0;
    int countonStart=0;
    int countonResume=0;
    int countonPause=0;
    int countonStop=0;
    int countonRestart=0;
    int countonDestroy=0;
    int countonCreate2 =0;
    int countonStart2=0;
    int countonResume2=0;
    int countonPause2=0;
    int countonStop2=0;
    int countonRestart2=0;
    int countonDestroy2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        main_layout = findViewById(R.id.main_layout);

        onCreate = findViewById(R.id.onCreate);
        onStart = findViewById(R.id.onStart);
        onResume = findViewById(R.id.onResume);
        onPause = findViewById(R.id.onPause);
        onStop = findViewById(R.id.onStop);
        onRestart = findViewById(R.id.onRestart);
        onDestroy = findViewById(R.id.onDestroy);

        onCreate2 = findViewById(R.id.onCreate2);
        onStart2 = findViewById(R.id.onStart2);
        onResume2 = findViewById(R.id.onResume2);
        onPause2 = findViewById(R.id.onPause2);
        onStop2 = findViewById(R.id.onStop2);
        onRestart2 = findViewById(R.id.onRestart2);
        onDestroy2 = findViewById(R.id.onDestroy2);



        setInitialValues();
        countonCreate++;
        countonCreate2++;
        storeValues();
    }

    private void setInitialValues() {
        countonCreate=sharedPreferences.getInt("donCreate",0);
        countonStart=sharedPreferences.getInt("donStart",0);
        countonResume=sharedPreferences.getInt("donResume",0);
        countonPause=sharedPreferences.getInt("donPause",0);
        countonStop=sharedPreferences.getInt("donStop",0);
        countonRestart=sharedPreferences.getInt("donRestart",0);
        countonDestroy=sharedPreferences.getInt("donDestroy",0);

    }
    private void storeValues() {
        editor.putInt("donCreate",countonCreate);
        editor.putInt("donStart",countonStart);
        editor.putInt("donResume",countonResume);
        editor.putInt("donPause",countonPause);
        editor.putInt("donStop",countonStop);
        editor.putInt("donRestart",countonRestart);
        editor.putInt("donDestroy",countonDestroy);

        editor.apply();
        onStart.setText("onStart: " + countonStart);
        onStart2.setText("onStart: " + countonStart2);
        onCreate.setText("onCreate: " + countonCreate);
        onCreate2.setText("onCreate: " + countonCreate2);
        onResume.setText("onResume: " + countonResume);
        onResume2.setText("onResume: " + countonResume2);
        onPause.setText("onPause: " + countonPause);
        onPause2.setText("onPause: " + countonPause2);
        onStop.setText("onStop: " + countonStop);
        onStop2.setText("onStop: " + countonStop2);
        onRestart.setText("onRestart: " + countonRestart);
        onRestart2.setText("onRestart: " + countonRestart2);
        onDestroy.setText("onDestroy: " + countonDestroy);
        onDestroy2.setText("onDestroy: " + countonDestroy2);
    }
    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        countonStart2++;

        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        countonResume2++;

        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        countonPause2++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        countonStop2++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        countonRestart2++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        countonDestroy2++;

        storeValues();
    }

    @Override
    public void onClick(View view) {

    }
}
