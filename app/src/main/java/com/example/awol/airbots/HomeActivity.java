package com.example.awol.airbots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
Button button;
public void init() {
    button = (Button) findViewById(R.id.button4);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent toy = new Intent(HomeActivity.this, SecondActivity.class);

            startActivity(toy);


        }
    });
}
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
   init();

    }
}
