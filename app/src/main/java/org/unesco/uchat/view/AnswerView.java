package org.unesco.uchat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.unesco.uchat.R;

public class AnswerView extends ConstraintLayout {

    private TextView textView;

    private ImageView icon;

    public AnswerView(Context context) {
        this(context, null);
    }

    public AnswerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnswerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.item_answer, this);

        textView = findViewById(R.id.answerText);
        icon = findViewById(R.id.characterIcon);
    }

    public void setAnswer(String answer) {
        textView.setText(answer);
    }

    public void setIcon(int resourceId) {
        icon.setImageDrawable(getContext().getDrawable(resourceId));
    }

}
