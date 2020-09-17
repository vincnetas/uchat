package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding01);

    }

    public void showNext(View view) {
        startActivity(new Intent(this, Onboarding02.class));
    }

    @Override
    public void onBackPressed() {
    }
}