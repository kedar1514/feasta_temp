package com.example.android.feasta_temp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private Context c;
    private ArrayList<HomeData> homeData;
    RequestOptions option;

    public HomeAdapter(Context c, ArrayList<HomeData> homeData) {
        this.c = c;
        this.homeData = homeData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.image_shape).error(R.drawable.image_shape);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_view, null);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        homeViewHolder.mMessName.setText(homeData.get(i).getMessName());
        homeViewHolder.mRating.setText(homeData.get(i).getMessRating());
        homeViewHolder.mType.setText(homeData.get(i).getMessType());
        Glide.with(c).load(homeData.get(i).getImgMess()).apply(option).into(homeViewHolder.mMessImage);
    }

    @Override
    public int getItemCount() {
        return homeData.size();
    }

}
