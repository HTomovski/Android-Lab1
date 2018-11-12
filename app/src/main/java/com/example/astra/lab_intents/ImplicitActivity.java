package com.example.astra.lab_intents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.widget.TextView;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        setTitle("ImplicitActivity");

        final Intent filter = new Intent();
        filter.setAction("android.intent.action.MAIN");
        filter.addCategory("android.intent.category.LAUNCHER");

        PackageManager packageManager = this.getPackageManager();
        List<ResolveInfo> classes = packageManager.queryIntentActivities(filter, PackageManager.MATCH_DEFAULT_ONLY);
        TextView textView = findViewById(R.id.txtImplicit);
        if(classes != null && classes.size() != 0)
        {
            for(ResolveInfo resInfo : classes)
            {
                textView.append(resInfo.activityInfo.name + "\n");
            }
        }
    }
}
