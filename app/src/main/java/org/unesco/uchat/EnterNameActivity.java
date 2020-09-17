package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnterNameActivity extends AppCompatActivity {

    private EditText editTextTextPersonName;

    private TextView iconText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        iconText = findViewById(R.id.iconText);
        editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    iconText.setText(s.subSequence(0, 1).toString().toUpperCase());
                    App.name = s.toString();
                } else {
                    iconText.setText("?");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void showNext(View view) {
        startActivity(new Intent(this, WellcomeActivity.class));

    }

    @Override
    public void onBackPressed() {
    }
}