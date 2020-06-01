package com.example.test.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mItems = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Item currentItem = mItems.get(position);
        holder.mName.setText(currentItem.getName());
        holder.mPrice.setText(Double.toString(currentItem.getPrice()));
        Picasso.get().load("http://services.hanselandpetal.com" + "/photos/" + currentItem.getPhoto()).into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItem(Item item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView mPrice;
        TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.itemPhoto);
            mPrice = itemView.findViewById(R.id.itemPrice);
            mName = itemView.findViewById(R.id.itemName);

        }
    }
}
