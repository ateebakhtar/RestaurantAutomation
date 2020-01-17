package com.example.admin.restaurantautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.function.ToIntFunction;

public class confirmitem extends AppCompatActivity {
    int total;
    int count = 1;

    TextView s1;
    TextView s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmitem);
        de.hdodenhof.circleimageview.CircleImageView image = findViewById(R.id.image);
        Bundle x = getIntent().getExtras();

        s1 = findViewById(R.id.textView3);
        s2 = findViewById(R.id.textView5);

        String t1 = x.getString("Name");
        String t2 = x.getString("Price");
        String t3 = x.getString("url");

        Glide.with(this)

                .load(t3)
                .into(image);


        total =  Integer.parseInt(t1);
        s1.setText(t2);
        s2.setText(t1);
    }
    public void add(View view)
    {
        count++;
        int sum = total * count;
        s2.setText(" "+sum);
    }


    public void subract(View view) {
        if(count > 1)
        {
            count--;
        }
        else
        {
            Toast.makeText(this, "Cant be lower", Toast.LENGTH_SHORT).show();
        }
        int sum = total * count;
        s2.setText(" "+sum);
    }
}
