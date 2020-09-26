package org.unesco.uchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.unesco.uchat.dto.State;
import org.unesco.uchat.view.AnswerView;
import org.unesco.uchat.view.OptionView;
import org.unesco.uchat.view.QuestionView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private final String name = "Vincentas";
    private LinearLayout chatLayout;
    private ScrollView scrollView;
    private LinearLayout optionsLayout;
    private TextView nameView;
    private TextView tagView;

    private int iconId;
    private String byeText = "Bye";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatLayout = findViewById(R.id.chatLayout);
        scrollView = findViewById(R.id.scrollView);
        optionsLayout = findViewById(R.id.options);
        nameView = findViewById(R.id.nameView);
        tagView = findViewById(R.id.tagView);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

        String number = getIntent().getStringExtra("number");
        int id = getResources().getIdentifier("raw/r" + number, null, getPackageName());
        iconId = getResources().getIdentifier("drawable/per_" + number, null, getPackageName());
        BufferedReader br = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(id)));

        try {
            State state = parseState(br);
            goState(state);
        } catch (IOException e) {

        }
    }

    private void goState(final State s) {
        AnswerView aw = new AnswerView(this);
        aw.setAnswer(s.getSay());
        aw.setIcon(iconId);
        chatLayout.addView(aw, chatLayout.getChildCount());

        optionsLayout.removeAllViews();
        for (final Pair<String, State> pair : s.getQuestions()) {
            OptionView ow = new OptionView(this);
            ow.setOption(pair.getLeft());
            optionsLayout.addView(ow);
            ow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuestionView qw = new QuestionView(ChatActivity.this);
                    qw.setIcon(name);
                    qw.setIcon(App.name);
                    qw.setQuestion(pair.getLeft());
                    chatLayout.addView(qw);

                    goState(pair.getRight());
                }
            });
        }

        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        }, 100);
    }

    private State parseState(BufferedReader br) throws IOException {
        String line;

        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (StringUtils.isBlank(line)) {
                continue;
            }

            if (line.indexOf("b:") != -1) {
                byeText = line.substring(2);
                continue;
            }

            if (line.indexOf("n:") != -1) {
                nameView.setText(line.substring(2));
                continue;
            }

            if (line.indexOf("t:") != -1) {
                tagView.setText(line.substring(2));
                continue;
            }

            if (line.indexOf("q:") != -1) {
                questions.add(line.substring(2));
                continue;
            }

            if (line.indexOf("s:") != -1) {
                answers.add(line.substring(2));
                continue;
            }
        }

        State last = new State();
        last.setSay(answers.get(answers.size() - 1));

        while (!questions.isEmpty()) {
            State state = new State();
            state.setSay(answers.get(answers.size() - 2));
            state.getQuestions().add(Pair.of(questions.get(questions.size() - 1), last));

            last = state;
            answers.remove(answers.size() - 1);
            questions.remove(questions.size() - 1);
        }

        return last;
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ByeActivity.class);

        intent.putExtra("name", nameView.getText());
        intent.putExtra("face", iconId);
        intent.putExtra("bye", byeText);

        startActivity(intent);

    }

    public void askQuestion(View view) {
    }

    @Override
    public void onBackPressed() {
    }
}