package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    Retrofit retrofit;
    ProgressDialog pd;
    EditText et_username;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        tv=findViewById(R.id.result);
        et_username= findViewById(R.id.username);
    }

    public void getResponse(View view) {
        pd.show();
        String input = et_username.getText().toString();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        GithubService service = retrofit.create(GithubService.class);
        Call<List<Pojo>> response = service.getRespos(input);
        response.enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                List<Pojo> list = response.body();
                StringBuilder builder = new StringBuilder();
                for(int i=0;i<list.size();i++)
                {
                    builder.append(list.get(i).getName()+"\n"+list.get(i)
                            .getFullName()+"\n\n");
                }
  