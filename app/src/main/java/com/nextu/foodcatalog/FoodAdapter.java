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

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription;

        ImageView image;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            image = (ImageView) itemView.findViewById(R.id.primary_img);
        }
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription, txtIngredients;

        ImageView image;

        public NormalViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            txtIngredients = (TextView) itemView.findViewById(R.id.txt_ingr);
            image = (ImageView) itemView.findViewById(R.id.primary_img);
        }
    }

    public static class LargeViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription, txtIngredients;

        ImageView primaryImage, secondImage;

        public LargeViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            txtIngredients = (TextView) itemView.findViewById(R.id.txt_ingr);
            primaryImage = (ImageView) itemView.findViewById(R.id.primary_img);
            primaryImage = (ImageView) itemView.findViewById(R.id.second_img);
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
                return new SimpleViewHolder(inflater.inflate(R.layout.simple_template, parent, false));
            case 1:
                return new NormalViewHolder(inflater.inflate(R.layout.normal_template, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FoodItem foodItem = items.get(position);

        switch (getItemViewType(position)){
            case 0:
                SimpleViewHolder simpleHolder = (SimpleViewHolder) holder;

                simpleHolder.txtName.setText(foodItem.getName());
                simpleHolder.txtDescription.setText(foodItem.getDescription());
                simpleHolder.image.setImageResource(context.getResources().getIdentifier(foodItem
                        .getPrimaryImage(), "drawable", context.getPackageName()));
                break;
            case 1:
                NormalViewHolder normalHolder = (NormalViewHolder) holder;

                normalHolder.txtName.setText(foodItem.getName());
                normalHolder.txtDescription.setText(foodItem.getDescription());
                normalHolder.txtIngredients.setText(foodItem.getIngredients());
                normalHolder.image.setImageResource(context.getResources().getIdentifier(foodItem
                        .getPrimaryImage(), "drawable", context.getPackageName()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}
