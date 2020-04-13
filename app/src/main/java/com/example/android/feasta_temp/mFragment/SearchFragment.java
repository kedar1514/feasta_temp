package com.example.android.feasta_temp.mFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.feasta_temp.HomeAdapter;
import com.example.android.feasta_temp.HomeData;
import com.example.android.feasta_temp.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    /*public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }*/

public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        HomeAdapter adapter = new HomeAdapter(this.getActivity(),getMylist());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<HomeData> getMylist(){
        ArrayList<HomeData> hd = new ArrayList<>();

        HomeData m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.5");
        m.setMessType("Veg");
        m.setMessName("Rohini Mess");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.3");
        m.setMessType("Veg");
        m.setMessName("Food Court Mess");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.9");
        m.setMessType("Veg");
        m.setMessName("Dhurvankur Mess");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.1");
        m.setMessType("Veg");
        m.setMessName("Foog Mess");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.2");
        m.setMessType("Veg");
        m.setMessName("Candrbhaga Mess");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("3.9");
        m.setMessName("Surbhi Mess");
        m.setMessType("Veg");
        hd.add(m);

        m = new HomeData();
        //m.setImgMess(R.drawable.mess_temp);
        m.setImgRating(R.drawable.star);
        m.setMessRating("4.4");
        m.setMessName("Italian Mess");
        m.setMessType("Veg");
        hd.add(m);

        return hd;
    }
}

/*package com.example.android.feasta_temp.mFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.feasta_temp.R;

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, null);
    }
}*/