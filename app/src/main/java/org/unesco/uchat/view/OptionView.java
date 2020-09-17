package org.unesco.uchat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.unesco.uchat.R;

public class OptionView extends ConstraintLayout {

    private TextView textView;


    public OptionView(Context context) {
        this(context, null);
    }

    public OptionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.item_option, this);

        textView = findViewById(R.id.option_text);
    }

    public void setOption(String option) {
        textView.setText(option);
    }
}
