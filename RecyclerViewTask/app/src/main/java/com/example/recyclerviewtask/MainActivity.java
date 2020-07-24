package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.recycler);

        int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,
                R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwich,
                R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,
        R.drawable.oreo,R.drawable.pie,R.drawable.q,R.drawable.r};

        String names[] = {"alpha","Beta","Cupcake","Donut","Eclair","froyo",
                "Gingerbread","Honeycomb","Icecreamsandwitch","Jellybean","kitkat","lollopop","marshmallow","nougat",
        "oreo","pie","q","r"};
        String VersionNumbers[] = { "0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};

        String releasedates[]= {"12","13","14","15","16","17","18","19","20","1","2","3","4","5","6","7","8","9"};

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this,images, names,VersionNumbers,releasedates);
        rv.setAdapter(adapter);


    }
}