package org.unesco.uchat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.unesco.uchat.R;

public class QuestionView extends ConstraintLayout {

    private TextView textView;

    private TextView nameView;

    public QuestionView(Context context) {
        this(context, null);
    }

    public QuestionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QuestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.item_question, this);

        textView = findViewById(R.id.questionText);
        nameView = findViewById(R.id.playerIcon);
    }

    public void setQuestion(String question) {
        textView.setText(question);
    }

    public void setIcon(String letter) {
        nameView.setText("" + letter.charAt(0));
    }

}
