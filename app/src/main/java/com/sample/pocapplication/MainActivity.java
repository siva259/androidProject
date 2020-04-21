package com.sample.pocapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView Invalid;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText) findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);
        Invalid=(TextView)findViewById(R.id.tvInvalid);

        Info.setText("No of attempts remaining: 3");
        Invalid.setVisibility(View.INVISIBLE);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
        
        AppCenter.start(getApplication(), "03d2977e-0a16-4557-af34-edb684b1c488",
                  Analytics.class, Crashes.class);


    }

    private void validate(String userName,String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("admin123"))){
            //Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            //Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            Invalid.setVisibility(View.INVISIBLE);
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Invalid.setVisibility(View.VISIBLE);
            Invalid.setText("Incorrect Name or Password");
            Invalid.setTextColor(Color.RED);
            Info.setText("No of attempts remaining:" + String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
