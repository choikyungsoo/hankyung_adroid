package com.team_noyeah.hankyung_adroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;


public class home extends Fragment implements View.OnClickListener{

    private Button NicknameFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NicknameFragment = (Button) view.findViewById(R.id.nickname);

        NicknameFragment.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Navigation.findNavController(v).navigate(R.id.verifyFragment);
    }
}