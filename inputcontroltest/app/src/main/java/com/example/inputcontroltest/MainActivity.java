package com.example.inputcontroltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<string> extends AppCompatActivity {
 EditText  et_name, et_mobile,et_email,et_password;
 TextView tv;
 CheckBox ch_java,ch_android,ch_python;
 RadioButton r_male,r_female;
 String gender;
 Spinner sp_district,sp_madal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_mobile=findViewById(R.id.mobile);
        et_email =findViewById(R.id.email);
        et_password=findViewById(R.id.textpassword);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        ch_java = findViewById(R.id.java);
        ch_android = findViewById(R.id.android);
        ch_python = findViewById(R.id.python);
        sp_district=findViewById(R.id.district);
        sp_madal=findViewById(R.id.mandal);
        tv = findViewById(R.id.result);

        ArrayAdapter<CharSequence> districtAdapter = ArrayAdapter.createFromResource(this,R.array.districts,
                android.R.layout.simple_spinner_item);
        sp_district.setAdapter(districtAdapter);
        
        sp_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:
                        Toast.makeText(MainActivity.this,"please select district",Toast.LENGTH_SHORT).show();
                    case 1:
                        ArrayAdapter<CharSequence> pra_madala= ArrayAdapter.createFromResource(MainActivity.this,R.array.prakasm_madals,
                                android.R.layout.simple_spinner_item);
                        sp_madal.setAdapter(pra_madala);
                        break;
                    case  2:
                        ArrayAdapter<CharSequence> gun_madala= ArrayAdapter.createFromResource(MainActivity.this,R.array.guntur_madala,
                                android.R.layout.simple_spinner_item);
                        sp_madal.setAdapter(gun_madala);
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
        StringBuilder builder = new StringBuilder();
        if(ch_java.isChecked()){
            builder.append(ch_java.getText().toString()+",");
        }
        if(ch_android.isChecked()){
            builder.append(ch_android.getText().toString()+",");
        }
        if(ch_python.isChecked()){
            builder.append(ch_python.getText().toString());
        }

        String  selecltedDistrict = sp_district.getSelectedItem().toString();
        String selecltMandal = sp_madal.getSelectedItem().toString();
        tv.setText(name+"\n"+mobile+"\n"+email+"\n"+textpassword+"\n"
                +gender+"\n"+builder+"\n"+selecltedDistrict+"\n"+selecltMandal);

    }
}