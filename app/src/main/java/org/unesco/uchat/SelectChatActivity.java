package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;
import org.unesco.uchat.view.PersonSelectView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectChatActivity extends AppCompatActivity {

    private LinearLayout personsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chat);
        personsLayout = findViewById(R.id.persons);

        try {
            for (int i = 1; i < 41; i++) {
                final String number = StringUtils.leftPad(Integer.toString(i), 2, '0');

                int id = getResources().getIdentifier("raw/r" + number, null, getPackageName());
                if (id == 0) {
                    continue;
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(id)));

                int iconId = getResources().getIdentifier("drawable/per_" + number, null, getPackageName());
                PersonSelectView psw = new PersonSelectView(this);
                psw.setFace(iconId);
                psw.setName(findName(br));
                psw.setOnClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SelectChatActivity.this, ChatActivity.class);
                        intent.putExtra("number", number);
                        startActivity(intent);
                    }
                });

                personsLayout.addView(psw);
                br.close();
            }
        } catch (IOException e) {

        }
    }

    private String findName(BufferedReader br) throws IOException {
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            if (line.indexOf("n:") != -1) {
                return line.substring(2);
            }
        }

        return result;
    }

    public void showNext(View view) {
        startActivity(new Intent(this, WellcomeActivity.class));
    }

    public void goChat(View view) {
        startActivity(new Intent(this, ChatActivity.class));

    }

    @Override
    public void onBackPressed() {
    }
}