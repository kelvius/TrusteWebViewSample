package com.example.trustewebviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsClient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static String PACKAGE_NAME = "com.android.chrome";
    final static String BASE_URL = "https://www.google.com";
    CustomTabsClient mClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowTWV = findViewById(R.id.btn_show_TWV);

        btnShowTWV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTWVButtonClick();
            }
        });
    }

    public void onTWVButtonClick() {
        Intent intent = new Intent(this, LauncherActivity.class);
        intent.setData(Uri.parse("https://airhorner.com"));
        startActivityForResult(intent, 0);
        overridePendingTransition(R.anim.animation_enter,
                R.anim.animation_leave);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            this.overridePendingTransition(R.anim.animation_back_enter,
                    R.anim.animation_back_leave);
            Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        }
    }
}
