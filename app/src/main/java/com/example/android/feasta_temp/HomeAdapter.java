package com.example.android.feasta_temp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    private Context c;
    private ArrayList<HomeData> homeData;
    private ArrayList<HomeData> homeDataFull;
    RequestOptions option;

    public HomeAdapter(Context c, ArrayList<HomeData> homeData) {
        this.c = c;
        this.homeData = homeData;
        homeDataFull = new ArrayList<>(homeData);
        option = new RequestOptions().centerCrop().placeholder(R.drawable.image_shape).error(R.drawable.image_shape);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final int position = i;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_view, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MessProfile.class);
                intent.putExtra("mess_name", homeData.get(position).getMessName());
                intent.putExtra("mess_image", homeData.get(position).getImgMess());
                v.getContext().startActivity(intent);
            }
        });
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        homeViewHolder.mMessName.setText(homeData.get(i).getMessName());
        homeViewHolder.mRating.setText(homeData.get(i).getMessRating());
        homeViewHolder.mType.setText(homeData.get(i).getMessType());
        Glide.with(c).load(homeData.get(i).getImgMess()).into(homeViewHolder.mMessImage);
    }//.apply(option)

    @Override
    public int getItemCount() {
        return homeData.size();
    }

   /*@Override
    public Filter getFilter() {
        return dataFilter;
    }

    private Filter dataFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<HomeData> filteredList= new ArrayList<>();

            if(constraint==null || constraint.length() ==0){
                filteredList.addAll(homeDataFull);
            }
            else
            {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(HomeData data : homeDataFull){
                    if(data.getMessName().toLowerCase().contains(filterPattern)){
                        filteredList.add(data);
                    }
                }
            }
            FilterResults  results = new FilterResults();
            results.values =filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            homeData.clear();
            homeData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };*/
}
