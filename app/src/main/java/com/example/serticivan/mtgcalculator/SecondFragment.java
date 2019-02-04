package com.example.serticivan.mtgcalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment implements View.OnClickListener, ItemClickListener {
    View v;
    private RecyclerView recyclerView;
    private List<SecondFragmentItems> items = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    private EditText editText;
    private Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second,container,false);
        recyclerView = v.findViewById(R.id.firstPlayerRecyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),items,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        editText = v.findViewById(R.id.teInputCreatures);
        submit = v.findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        recyclerViewAdapter.addNewItem(editText.getText().toString(), recyclerViewAdapter.getItemCount());

    }

    @Override
    public void onItemClick(int position) {
        recyclerViewAdapter.removeItem(position);
    }
}
