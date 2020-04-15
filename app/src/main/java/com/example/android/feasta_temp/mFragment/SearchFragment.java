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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.feasta_temp.HomeAdapter;
import com.example.android.feasta_temp.HomeData;
import com.example.android.feasta_temp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private final String FEASTA_API_URL = "https://feasta.herokuapp.com/api/v1/get-mess/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private ArrayList<HomeData> homeData;
    private RecyclerView recyclerView;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        homeData = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.search_recycler_view);
        jsonRequest();
        return view;
    }

    private void jsonRequest(){
        request = new JsonArrayRequest(FEASTA_API_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for(int i=0;i<response.length();i++)
                {
                    try{
                        jsonObject = response.getJSONObject(i);
                        HomeData data = new HomeData();
                        data.setMessName(jsonObject.getString("mess_name"));
                        data.setMessRating(jsonObject.getString("rating"));
                        data.setMessType(jsonObject.getString("type"));
                        data.setImgMess("https://feasta.herokuapp.com/static/img/mess/test.jpg");
                        homeData.add(data);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupRecyclerView(homeData);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(request);
    }

    public void setupRecyclerView(ArrayList<HomeData> homeData) {

        HomeAdapter adapter = new HomeAdapter(this.getActivity(),homeData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
