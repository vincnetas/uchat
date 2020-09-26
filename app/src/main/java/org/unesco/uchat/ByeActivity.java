package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ByeActivity extends AppCompatActivity {

    private TextView nameView;

    private TextView byeView;

    private ImageView faceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);

        nameView = findViewById(R.id.name);
        byeView = findViewById(R.id.bye);
        faceView = findViewById(R.id.face);

        nameView.setText(getIntent().getStringExtra("name"));
        byeView.setText(getIntent().getStringExtra("bye"));
        faceView.setImageDrawable(getDrawable(getIntent().getIntExtra("face", 0)));
    }

    public void goBackClick(View view) {
        startActivity(new Intent(this, SelectChatActivity.class));
    }

    @Override
    public void onBackPressed() {
    }
}