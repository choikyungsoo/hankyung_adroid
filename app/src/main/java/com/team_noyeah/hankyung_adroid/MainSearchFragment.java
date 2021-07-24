package com.team_noyeah.hankyung_adroid;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;


public class MainSearchFragment extends Fragment {

   private SearchView search;
    private ArrayList<MainSearchRecycleritem> list = new ArrayList<MainSearchRecycleritem>();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.R_recentsearch) ;
        MainSearchAdapterRecycleritem recyclerItemAdapter = new MainSearchAdapterRecycleritem(this.list);
        recyclerView.setAdapter(recyclerItemAdapter) ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        addRecyclerItem("  미술관");
        addRecyclerItem("  전시회");
        addRecyclerItem("  박람회");
        recyclerItemAdapter.notifyDataSetChanged();

    }

    private void addRecyclerItem(String recent){
        MainSearchRecycleritem recyclerItem = new MainSearchRecycleritem();
        recyclerItem.setRecentSearch(recent);
        list.add(recyclerItem);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main_search, container, false);
        this.search = view.findViewById(R.id.search);
//        this.search.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));
        return view;
    }
}