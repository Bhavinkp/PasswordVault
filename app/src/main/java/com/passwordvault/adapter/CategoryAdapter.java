package com.passwordvault.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.passwordvault.R;
import com.passwordvault.activity.SelectCategory;
import com.passwordvault.pojo.TypeOfCategory;

import java.util.List;

/**
 * Created by bpanchal on 26-Aug-16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>  {


    private List<TypeOfCategory> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView ;
        TextView titleTextView;
        TextView nameTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView)itemView.findViewById(R.id.categoryImageView);
            this.titleTextView = (TextView)itemView.findViewById(R.id.categoryTitle);
            this.nameTextView = (TextView)itemView.findViewById(R.id.categoryName);

        }
    }

    public CategoryAdapter(List<TypeOfCategory> data) {
        this.dataSet = data;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(SelectCategory.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {

        ImageView imageView = holder.imageView;
        TextView titleTextView = holder.titleTextView;
        TextView nameTextView = holder.nameTextView;
        // Set City Title
        // cityName = dataSet.get(position).getCityName();
        titleTextView.setText(dataSet.get(position).getTitle());
        nameTextView.setText(dataSet.get(position).getCategoryName());
        imageView.setImageResource(dataSet.get(position).getImageId());
        imageView.setTag(dataSet.get(position).getImageId());
        //imageView.setTag(1,dataSet.get(position).getBackgroundColorId());
        imageView.setBackgroundColor(dataSet.get(position).getBackgroundColorId());

}

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
