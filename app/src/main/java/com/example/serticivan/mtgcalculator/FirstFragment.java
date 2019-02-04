package com.example.serticivan.mtgcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class FirstFragment extends Fragment implements View.OnClickListener{

    private Button btnRollADie;
    private ImageButton ibFirstPlayerPlus;
    private ImageButton ibFirstPlayerMinus;
    private ImageButton ibSecondPlayerPlus;
    private ImageButton ibSecondPlayerMinus;
    private TextView firstPlayerLife;
    private TextView secondPlayerLife;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstPlayerLife = view.findViewById(R.id.tvFirstPlayerLife);
        secondPlayerLife = view.findViewById(R.id.tvSecondPlayerLife);

        btnRollADie = view.findViewById(R.id.btnRollADie);
        btnRollADie.setOnClickListener(this);
        ibFirstPlayerPlus = view.findViewById(R.id.ibFirstPlus);
        ibFirstPlayerPlus.setOnClickListener(this);
        ibFirstPlayerMinus = view.findViewById(R.id.ibFirstMinus);
        ibFirstPlayerMinus.setOnClickListener(this);
        ibSecondPlayerPlus = view.findViewById(R.id.ibSecondPlus);
        ibSecondPlayerPlus.setOnClickListener(this);
        ibSecondPlayerMinus = view.findViewById(R.id.ibSecondMinus);
        ibSecondPlayerMinus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int number;
        switch (view.getId()){
            case R.id.ibFirstPlus:
                number = Integer.parseInt(firstPlayerLife.getText().toString());
                number++;
                firstPlayerLife.setText(Integer.toString(number));
                break;
            case R.id.ibFirstMinus:
                number = Integer.parseInt(firstPlayerLife.getText().toString());
                number--;
                firstPlayerLife.setText(Integer.toString(number));
                break;
            case R.id.ibSecondPlus:
                number = Integer.parseInt(secondPlayerLife.getText().toString());
                number++;
                secondPlayerLife.setText(Integer.toString(number));
                break;
            case R.id.ibSecondMinus:
                number = Integer.parseInt(secondPlayerLife.getText().toString());
                number--;
                secondPlayerLife.setText(Integer.toString(number));
                break;
            case R.id.btnRollADie:
                Intent intent = new Intent(getActivity(),RollADie.class);
                startActivity(intent);
                break;

        }
    }
}
