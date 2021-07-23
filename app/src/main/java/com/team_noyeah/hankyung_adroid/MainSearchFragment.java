package com.team_noyeah.hankyung_adroid;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;


public class MainSearchFragment extends Fragment {

   private SearchView search;

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