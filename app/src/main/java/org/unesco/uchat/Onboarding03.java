package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding03);
    }

    public void showNext(View view) {
        startActivity(new Intent(this, EnterNameActivity.class));
    }

    @Override
    public void onBackPressed() {
    }
}