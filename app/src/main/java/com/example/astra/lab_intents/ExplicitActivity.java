package com.example.astra.lab_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        setTitle("ExplicitActivity");
    }
    public void onClickOK(View view){
        Intent intent = new Intent(this, MainActivity.class);
        final EditText explicitText = (EditText) findViewById(R.id.txtExplicit);
        intent.putExtra("text", explicitText.getText().toString());
        startActivity(intent);
    }
    public void onClickCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
