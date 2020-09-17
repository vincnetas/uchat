package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void showOnboarding(View view) {
        startActivity(new Intent(this, Onboarding01.class));
    }

    @Override
    public void onBackPressed() {
    }
}