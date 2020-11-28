package com.example.HumlePorten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private lateinite var analytics: FirebaseAnalytic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BackButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                openActivety2();
            }
        });
    }
             public void openActivety2()
             {
                   Intent intent = new Intent(this, ButtonActivity.class);
                   startActivity(intent);
             }




            }

                                                                                    

