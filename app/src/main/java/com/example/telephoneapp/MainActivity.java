package com.example.telephoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_number;
    ImageButton bt_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        bt_call = findViewById(R.id.bt_call);

        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = et_number.getText().toString();
                if(phone.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),
                            "Please enter phone number",
                                  Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s = "tel: "+ phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });
    }
}