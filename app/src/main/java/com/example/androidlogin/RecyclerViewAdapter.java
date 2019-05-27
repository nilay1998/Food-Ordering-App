package com.example.androidlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mMenuItems=new ArrayList<>();
    private ArrayList<Integer> mItemPrice=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mMenuItems, ArrayList<Integer> mItemPrice, Context mContext) {
        this.mMenuItems = mMenuItems;
        this.mItemPrice = mItemPrice;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.menuItem.setText(mMenuItems.get(i));
        viewHolder.itemPrice.setText(mItemPrice.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return mMenuItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView menuItem;
        TextView itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuItem=itemView.findViewById(R.id.menuitem);
            itemPrice=itemView.findViewById(R.id.itemPrice);
        }
    }
}
