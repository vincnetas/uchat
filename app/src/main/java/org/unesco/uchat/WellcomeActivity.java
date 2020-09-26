package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WellcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
    }

    public void showNext(View view) {
        startActivity(new Intent(this, SelectChatActivity.class));
    }

    public void showHeritageSites(View view) {
        startActivity(new Intent(this, HeritageSitesActivity.class));
    }


    @Override
    public void onBackPressed() {
    }
}