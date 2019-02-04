package com.example.serticivan.mtgcalculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    private ItemClickListener clickListener;
    List<SecondFragmentItems> items = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<SecondFragmentItems> items, ItemClickListener clickListener) {
        this.context = context;
        this.items = items;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.second_fragment_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v, clickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getName());
        holder.tvCounters.setText("1");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addData(List<SecondFragmentItems> data){
        this.items.clear();
        this.items.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewItem(String name, int position){
        if(items.size() >= position){
            SecondFragmentItems newItem = new SecondFragmentItems(name);
            items.add(position,newItem);
            notifyItemInserted(position);
        }
    }

    public void removeItem(int position){
        if(items.size() > position){
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private TextView tvCounters;
        private ImageButton imAddCounters;
        private ImageButton imRemoveCounters;
        private ImageButton imRemoveItem;
        private ItemClickListener itemClickListener;
        public MyViewHolder(View itemView, ItemClickListener clickListener) {
            super(itemView);
            itemClickListener = clickListener;
            tvName = itemView.findViewById(R.id.firstPlayerCounters);
            tvCounters = itemView.findViewById(R.id.tvMonsterCounter);
            imAddCounters= itemView.findViewById(R.id.ibAddCounters);
            imRemoveCounters = itemView.findViewById(R.id.ibremoveCounter);
            imRemoveItem = itemView.findViewById(R.id.ibRemoveItem);
            imRemoveItem.setOnClickListener(this);
            imAddCounters.setOnClickListener(this);
            imRemoveCounters.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int counters;
            switch(view.getId()){
                case(R.id.ibAddCounters):
                    counters = Integer.parseInt(tvCounters.getText().toString());
                    counters++;
                    tvCounters.setText(Integer.toString(counters));
                    break;
                case(R.id.ibremoveCounter):
                    counters = Integer.parseInt(tvCounters.getText().toString());
                    counters--;
                    tvCounters.setText(Integer.toString(counters));
                    break;
                case(R.id.ibRemoveItem):
                    itemClickListener.onItemClick(getAdapterPosition());
            }
        }

        public void setName(String name){
            tvName.setText(name);
        }
    }
}
