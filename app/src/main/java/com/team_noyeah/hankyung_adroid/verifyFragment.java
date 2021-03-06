
package com.team_noyeah.hankyung_adroid;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class verifyFragment extends Fragment implements View.OnClickListener {

    //안드로이드 widget
    private EditText phoneinput;

    private TextView timer;
    private TextView warning;

    private Button verify;
    private Button next;
    private ImageButton back;

    private CheckBox agreeA;
    private CheckBox agree1;
    private CheckBox agree2;
    private CheckBox agree3;

    //레이아웃
    private ConstraintLayout verifycode;

    //값
    private String startTime;

    //서버(파이어베이스)
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify, container, false);
        this.auth = FirebaseAuth.getInstance();

        this.phoneinput = view.findViewById(R.id.phoneinput);
        this.verify = view.findViewById(R.id.verifybtn);
        this.back = view.findViewById(R.id.backBTN);
        this.next = view.findViewById(R.id.nextBTN);
        this.agreeA = view.findViewById(R.id.agreeAll);
        this.agree1 = view.findViewById(R.id.agree1);
        this.agree2 = view.findViewById(R.id.agree2);
        this.agree3 = view.findViewById(R.id.agree3);

        this.timer = view.findViewById(R.id.timer);
        this.warning = view.findViewById(R.id.warningText);
        this.verifycode = view.findViewById(R.id.inputverifycode);

        this.startTime = "000235";

        this.verify.setOnClickListener(this);
        this.back.setOnClickListener(this);
        this.next.setOnClickListener(this);
        this.agreeA.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.verifybtn:
//                verifyphonemethod();
                this.verifycode.setVisibility(v.VISIBLE);
                countDown(this.startTime);
                break;
            case R.id.backBTN:
                Navigation.findNavController(v).navigate(R.id.writingMemberInformationFragment);
                break;
            case R.id.agreeAll:
                CheckOtherCheckBox();
                break;
            case R.id.nextBTN:
                moveToNicknameFragment(v);
        }

    }

    private void moveToNicknameFragment(View v) {
        NickNameFragment fragment = new NickNameFragment();
        if(!(agree1.isChecked()) || !(agree2.isChecked())){
            if(!(agree1.isChecked()) && !(agree2.isChecked())){
                this.warning.setText("필수 약관 모두 체크해주세요");
            } else if(!(agree1.isChecked())){
                this.warning.setText("이용약관 동의에 체크하지 않았습니다.");
            } else if(!(agree2.isChecked())){
                this.warning.setText("개인정보수집 동의에 체크하지 않았습니다.");
            }
        } else{
            Navigation.findNavController(v).navigate(R.id.action_verifyFragment_to_nickNameFragment);
        }

    }

    private void CheckOtherCheckBox() {
        if(this.agreeA.isChecked()) {
            this.agree1.setChecked(true);
            this.agree2.setChecked(true);
            this.agree3.setChecked(true);
        } else{
            this.agree1.setChecked(false);
            this.agree2.setChecked(false);
            this.agree3.setChecked(false);
        }
    }

    private void countDown(String startTime) {
        long conversionTime = 0;

        // 1000 단위가 1초
        // 60000 단위가 1분
        // 60000 * 3600 = 1시간

        String getHour = startTime.substring(0, 2);
        String getMin = startTime.substring(2, 4);
        String getSecond = startTime.substring(4, 6);

        // "00"이 아니고, 첫번째 자리가 0 이면 제거
        if (getHour.substring(0, 1) == "0") {
            getHour = getHour.substring(1, 2);
        }

        if (getMin.substring(0, 1) == "0") {
            getMin = getMin.substring(1, 2);
        }

        if (getSecond.substring(0, 1) == "0") {
            getSecond = getSecond.substring(1, 2);
        }

        // 변환시간
        conversionTime = Long.valueOf(getHour) * 1000 * 3600 + Long.valueOf(getMin) * 60 * 1000 + Long.valueOf(getSecond) * 1000;

        // 첫번쨰 인자 : 원하는 시간 (예를들어 30초면 30 x 1000(주기))
        // 두번쨰 인자 : 주기( 1000 = 1초)
        new CountDownTimer(conversionTime, 1000) {

            // 특정 시간마다 뷰 변경
            public void onTick(long millisUntilFinished) {

                // 시간단위
                String hour = String.valueOf(millisUntilFinished / (60 * 60 * 1000));

                // 분단위
                long getMin = millisUntilFinished - (millisUntilFinished / (60 * 60 * 1000)) ;
                String min = String.valueOf(getMin / (60 * 1000)); // 몫

                // 초단위
                String second = String.valueOf((getMin % (60 * 1000)) / 1000); // 나머지

                // 밀리세컨드 단위
                String millis = String.valueOf((getMin % (60 * 1000)) % 1000); // 몫

                // 시간이 한자리면 0을 붙인다
                if (hour.length() == 1) {
                    hour = "0" + hour;
                }

                // 분이 한자리면 0을 붙인다
                if (min.length() == 1) {
                    min = "0" + min;
                }

                // 초가 한자리면 0을 붙인다
                if (second.length() == 1) {
                    second = "0" + second;
                }

                timer.setText(min + ":" + second);
            }

            // 제한시간 종료시
            public void onFinish() {
                timer.setText("다시 인증해주세요");
            }
        }.start();
    }

    private void verifyphonemethod() {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(String.valueOf(phoneinput))
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(getActivity())
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(String verificationId,
                                           PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        // Save the verification id somewhere
                        // ...

                        // The corresponding whitelisted code above should be used to complete sign-in.
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        // Sign in with the credential
                        // ...
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        // ...
                    }
                })
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}
