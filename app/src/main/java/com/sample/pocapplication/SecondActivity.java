package com.sample.pocapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnPPT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView=(TextView)findViewById(R.id.textView);
        textView.setTextColor(Color.BLUE);
        btnPPT=(Button)findViewById(R.id.btnPPT);

        btnPPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateNew();
            }
        });
    }

    public void validateNew(){
        Intent in=new Intent(this,ThirdActivity.class);
        startActivity(in);
    }

}
