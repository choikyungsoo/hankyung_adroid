package com.team_noyeah.hankyung_adroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class NickNameFragment extends Fragment {

    private EditText nickinput;
    private TextView textsize;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nick_name, container, false);

        nickinput = view.findViewById(R.id.nickinput);
        textsize = view.findViewById(R.id.textsize);

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
}