package com.example.five_practice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btnCamera, btnBrowser, btnCall, btnMap, btnClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnCall = findViewById(R.id.btnCall);
        btnMap = findViewById(R.id.btnMap);
        btnClock = findViewById(R.id.btnClock);

        btnCamera.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if (v.getId() == R.id.btnCamera) {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Нет камеры", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.btnBrowser) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnCall) {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnMap) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.753215,37.620394?z=15"));
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnClock) {
            intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Часы не найдены", Toast.LENGTH_SHORT).show();
            }
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}