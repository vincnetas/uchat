package org.unesco.uchat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PastChatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_chats);
    }

    @Override
    public void onBackPressed() {
    }
}