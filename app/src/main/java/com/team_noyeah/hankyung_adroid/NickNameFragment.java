package com.team_noyeah.hankyung_adroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class NickNameFragment extends Fragment implements View.OnClickListener {

    private EditText nickinput;
    private TextView textsize;
    private ImageButton nback;
    private Button completeSignUp_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nick_name, container, false);

        this.nickinput = view.findViewById(R.id.nickinput);
        this.textsize = view.findViewById(R.id.textsize);
        this.nback = view.findViewById(R.id.nbackBTN);
        this.completeSignUp_btn = view.findViewById(R.id.completeSignUp_btn);

        this.nback.setOnClickListener(this);
        this.completeSignUp_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        nickinput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = nickinput.getText().toString();
                textsize.setText(String.valueOf(input.length())+" / 10");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nbackBTN:
                Navigation.findNavController(v).navigate(R.id.verifyFragment);
                break;
            case R.id.completeSignUp_btn:
                Navigation.findNavController(v).navigate(R.id.action_nickNameFragment_to_loginFragment);
                break;
        }
    }
}