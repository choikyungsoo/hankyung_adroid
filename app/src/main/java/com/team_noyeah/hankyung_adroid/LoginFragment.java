package com.team_noyeah.hankyung_adroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private ImageButton close_btn;
    private TextView signUp_btn;
    private Button LoginBTN;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        this.close_btn = view.findViewById(R.id.nbackBTN);
        this.signUp_btn = view.findViewById(R.id.signUpBTN);
        this.LoginBTN = view.findViewById(R.id.LoginBTN);

        this.close_btn.setOnClickListener(this);
        this.signUp_btn.setOnClickListener(this);
        this.LoginBTN.setOnClickListener(this);

//        this.close_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                getActivity().onBackPressed();
//                getActivity().finish();
//            }
//        });
//
//        this.signUp_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_writingMemberInformationFragment);
//            }
//        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nbackBTN:
                getActivity().finish();
                break;
            case R.id.signUpBTN:
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_writingMemberInformationFragment);
                break;
            case R.id.LoginBTN:
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_mainFragment);
                break;
        }
    }
}