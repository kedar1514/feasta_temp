package com.example.android.feasta_temp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeViewHolder extends RecyclerView.ViewHolder{
    TextView mMessName;
    TextView mRating;
    ImageView mMessImage;
    TextView mType;
    ImageView mStar;


    public HomeViewHolder(View itemView){

        super(itemView);

        mMessName = (TextView)itemView.findViewById(R.id.mess_name);
        mRating = (TextView)itemView.findViewById(R.id.rating);
        mMessImage = (ImageView)itemView.findViewById(R.id.mess_image);
        mStar = (ImageView) itemView.findViewById(R.id.rating_image);
        mType = (TextView)itemView.findViewById(R.id.type);
    }


}