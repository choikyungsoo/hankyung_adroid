package com.team_noyeah.hankyung_adroid;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class WritingMemberInformationFragment extends Fragment {

    private InputMethodManager inputMethodManager;

    private EditText id_text;
    private EditText pw_text;
    private InputFilter filter;
    private EditText pw_check_text;
    private EditText birthYear_text;
    private EditText birthMonth_text;
    private EditText birthDay_text;
    private RadioGroup gender_radiogroup;
    private Button gotoVerifyingYourself_btn;
    private ImageButton gotologinFragment_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_writing_member_information, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        this.inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        this.id_text = view.findViewById(R.id.IDBlank);
        this.pw_text = view.findViewById(R.id.PWBlank);
        this.pw_check_text = view.findViewById(R.id.PWCheckBlank);
        this.birthYear_text = view.findViewById(R.id.birthYear);
        this.birthMonth_text = view.findViewById(R.id.birthMonth);
        this.birthDay_text = view.findViewById(R.id.birthDay);
        this.gender_radiogroup = view.findViewById(R.id.genderRadioGroup);
        this.gotoVerifyingYourself_btn = view.findViewById(R.id.gotoVerifyingYourselfBTN);
        this.gotologinFragment_btn = view.findViewById(R.id.backArrow);


        this.gotoVerifyingYourself_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
//                    id_text.
                }
                else if(pw_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(pw_text.getText().toString().length()<8){
                    Toast.makeText(getContext(),"비밀번호를 8자 이상 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!Pattern.matches("^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+$", pw_text.getText().toString())){
                    Toast.makeText(getContext(),"비밀번호는 영문/숫자/특수문자(공백 제외)만 허용하며, 2개 이상 조합해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(pw_check_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"비밀번호 확인을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(birthYear_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(birthMonth_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(birthMonth_text.getText().toString())>12){
                    Toast.makeText(getContext(),"생년월일을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    birthMonth_text.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
                else if(birthDay_text.getText().toString().equals("")){
                    Toast.makeText(getContext(),"생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(((Integer.parseInt(birthMonth_text.getText().toString()) == 1
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 3
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 5
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 7
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 8
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 10
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 12) && Integer.parseInt(birthDay_text.getText().toString()) > 31)
                        || ((Integer.parseInt(birthMonth_text.getText().toString()) == 4
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 6
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 9
                        || Integer.parseInt(birthMonth_text.getText().toString()) == 11) && Integer.parseInt(birthDay_text.getText().toString()) > 30)
                        || ((Integer.parseInt(birthMonth_text.getText().toString()) == 2) && Integer.parseInt(birthDay_text.getText().toString()) > 29)){
                    Toast.makeText(getContext(),"생년월일을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    birthDay_text.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
                else if(gender_radiogroup.getCheckedRadioButtonId()==-1){
//                    Log.v("submit", Integer.toString(gender_radiogroup.getCheckedRadioButtonId()));
                    Toast.makeText(getContext(), "성별을 선택해주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    Navigation.findNavController(view).navigate(R.id.action_writingMemberInformationFragment_to_verifyFragment);
                }
            }
        });

        this.gotologinFragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.loginFragment);
            }
        });
    }
}