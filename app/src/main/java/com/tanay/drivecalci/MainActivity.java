package com.tanay.drivecalci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView input_give= (TextView) findViewById(R.id.input);

        input_give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent input_intent= new Intent(MainActivity.this, InputActivity.class);
                startActivity(input_intent);

            }
        });
    }
}