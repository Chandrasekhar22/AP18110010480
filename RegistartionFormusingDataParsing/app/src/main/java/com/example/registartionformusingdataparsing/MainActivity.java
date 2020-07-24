package com.example.registartionformusingdataparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button send_button;
    EditText et_name, et_mobile,et_email,et_password,et_rollnum;
    RadioButton r_male,r_female,r_cse,r_ece,r_mech,r_civil;
    String gender,Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_mobile=findViewById(R.id.phone);
        et_email =findViewById(R.id.email);
        et_password=findViewById(R.id.textpassword);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        r_cse = findViewById(R.id.cse);
        r_ece = findViewById(R.id.ece);
        r_mech = findViewById(R.id.mech);
        r_civil = findViewById(R.id.civil);



    }

    public void Submit(View view) {
        String name = et_name.getText().toString();
        String mobile =et_mobile.getText().toString();
        String email = et_email.getText().toString();
        String textpassword =et_password.getText().toString();
        if(r_male.isChecked()){
            gender = r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender = r_female.getText().toString();

        }
        if(r_cse.isChecked()){
            Group = r_cse.getText().toString();
        }
        if(r_ece.isChecked()){
            Group = r_ece.getText().toString();

        }
        if(r_mech.isChecked()){
            Group = r_mech.getText().toString();
        }
        if(r_civil.isChecked()){
            Group = r_civil.getText().toString();

        }

        Intent intent = new Intent(MainActivity.this, secondactivity.class);
        intent.putExtra("message_key", "Name:"+name+"\n"
                +"mobile no:"+mobile+"\n"+"Email:"+email+"\n"+"Password:"+textpassword+"\n"+"Gender:"+gender+"\n"+"Group"+Group);


        startActivity(intent);


    }
}