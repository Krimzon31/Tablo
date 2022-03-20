package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer OrdCounter = 0;
    Integer AlsCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnAddOrd(View view) {
        OrdCounter++;
        TextView counterView = findViewById(R.id.txt_counterord);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        counterView.setText(OrdCounter.toString());
    }
    public void onClickBtnAddAls(View view) {
        AlsCounter++;
        TextView counterView = findViewById(R.id.txt_counterals);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        counterView.setText(AlsCounter.toString());
    }
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("OrdCount")) {
            OrdCounter = savedInstanceState.getInt("OrdCount");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("AlsCount")) {
            AlsCounter = savedInstanceState.getInt("AlsCount");
        }
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("OrdCount", OrdCounter);
        outState.putInt("AlsCount", AlsCounter);
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.txt_counterord)).setText(OrdCounter.toString());
        ((TextView) findViewById(R.id.txt_counterals)).setText(AlsCounter.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
    public void onClickBtnObNull(View view) {
        OrdCounter = 0;
        AlsCounter = 0;
        TextView counterOrdView = findViewById(R.id.txt_counterord);
        TextView counterAlsView = findViewById(R.id.txt_counterals);
        counterOrdView.setText(OrdCounter.toString());
        counterAlsView.setText(AlsCounter.toString());
    }

}