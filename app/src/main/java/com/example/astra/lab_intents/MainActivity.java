package com.example.astra.lab_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity");

        Bundle ExplicitData = getIntent().getExtras();
        if (ExplicitData != null){
            String ExplicitMessage = ExplicitData.getString("text");
            final TextView tv = findViewById(R.id.txtExplicitResult);
            tv.setText(ExplicitMessage);
        }
    }
    public void onClickExplicit(View view){
        Intent intent = new Intent(this, ExplicitActivity.class);

        startActivity(intent);
    }
    public void onClickImplicit(View view){
        Intent intent = new Intent("mk.ukim.finki.mpip.IMPLICIT_ACTION");
        startActivity(intent);
    }
    public void onClickSend(View view){
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title");
        intent.putExtra(Intent.EXTRA_TEXT, "Content sent from MainActivity");
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void onClickSelectImage(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(intent);
    }
}
