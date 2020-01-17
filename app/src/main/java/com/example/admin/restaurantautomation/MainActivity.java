package com.example.admin.restaurantautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void openmenu(View view)
    {
        Intent x = new Intent(this,Menu.class);
        startActivity(x);
    }
    void catagories(View view)
    {
        Intent x = new Intent(this,mainmenu.class);
        startActivity(x);
    }
}
