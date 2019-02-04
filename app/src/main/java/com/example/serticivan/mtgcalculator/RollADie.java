package com.example.serticivan.mtgcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RollADie extends AppCompatActivity implements View.OnClickListener {
    private TextView firstPlayerRoll;
    private TextView secondPlayerRoll;
    private Button exit;
    private Button roll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_adie);
        firstPlayerRoll = findViewById(R.id.firstPlayerRoll);
        secondPlayerRoll = findViewById(R.id.secondPlayerRoll);
        exit = findViewById(R.id.exit);
        roll = findViewById(R.id.btnRoll);
        exit.setOnClickListener(this);
        roll.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Random random = new Random();
        switch (view.getId()){
            case R.id.btnRoll:
                firstPlayerRoll.setText(Integer.toString(random.nextInt(20-1)+1));
                secondPlayerRoll.setText(Integer.toString(random.nextInt(20-1)+1));
                break;
            case R.id.exit:
                finish();
                break;
        }
    }
}
