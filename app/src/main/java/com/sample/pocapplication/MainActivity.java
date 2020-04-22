package com.sample.pocapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView Invalid;
    private int counter=3;
    String user="";
    String passwd="";

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

        String encryptuser="9F58976A4FF0DC658140A8665A5635D7";
        String encryptpwd="8D32C2FFFEEE74CEBCBF6327154A2F9A";

        try {
            user = AESUtils.decrypt(encryptuser);
            passwd=AESUtils.decrypt(encryptpwd);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString(),user,passwd);
            }
        });


    }

    private void validate(String userName,String userPassword,String user,String passwd){
        if((userName.equals(user)) && (userPassword.equals(passwd))){
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
