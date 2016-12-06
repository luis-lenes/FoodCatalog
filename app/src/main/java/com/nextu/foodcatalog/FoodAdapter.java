package com.nextu.foodcatalog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Next University.
 */

public class FoodAdapter extends RecyclerView.Adapter {

    private List<FoodItem> items;
    private Context context;

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription;

        ImageView image;

        public FoodViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            image = (ImageView) itemView.findViewById(R.id.img_food);
        }
    }

    public FoodAdapter(Context context, List<FoodItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                return new FoodViewHolder(inflater.inflate(R.layout.japanese_template, parent, false));
            case 1:
                return new FoodViewHolder(inflater.inflate(R.layout.mexican_template, parent, false));
            case 2:
                return new FoodViewHolder(inflater.inflate(R.layout.italian_template, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FoodViewHolder holderItem = (FoodViewHolder) holder;
        FoodItem foodItem = items.get(position);

        holderItem.txtName.setText(foodItem.getName());
        holderItem.txtDescription.setText(foodItem.getDescription());
        holderItem.image.setImageResource(context.getResources().getIdentifier(foodItem.getImage(),
                "sushi", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getFoodType().ordinal();
    }
}
