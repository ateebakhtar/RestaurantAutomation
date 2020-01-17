package com.example.admin.restaurantautomation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class menuapater extends RecyclerView.Adapter<menuapater.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> b = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;


    public menuapater(Context mContext, ArrayList<String> mImages, ArrayList<String> mImageNames, ArrayList<String> b) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = (Context) mContext;
        this.b = b;
    }


    @Override
    public menuapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menutemplate, parent, false);
        menuapater.ViewHolder holder = new menuapater.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(menuapater.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext)

                .load(mImages.get(position))
                .into(holder.image);
        holder.imageName.setText(mImageNames.get(position));
        holder.b.setText(b.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "bla bla");

                Intent i = new Intent(mContext, confirmitem.class);
                Bundle x = new Bundle();
                x.putString("Price", b.get(position));
                x.putString("Name", mImageNames.get(position));
                x.putString("url", mImages.get(position));
                i.putExtras(x);

                mContext.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        TextView b;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            b = itemView.findViewById(R.id.textView2);
        }

    }
}