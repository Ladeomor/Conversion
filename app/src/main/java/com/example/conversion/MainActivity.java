package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        Info = findViewById(R.id.tvInfo);
        Login = findViewById(R.id.btnName);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Praise Odeyemi")) && (userPassword.equals("praisebolu"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        }
        else{
            Info.setText("No of attempts remaining: " + String.valueOf(counter));
            counter--;
            if(counter == 0){
                Login.setEnabled(false);
            }


        }
    }
}