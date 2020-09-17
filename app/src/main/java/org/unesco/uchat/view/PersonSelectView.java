package org.unesco.uchat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.unesco.uchat.R;

public class PersonSelectView extends ConstraintLayout {

    private ImageButton faceView;

    private TextView nameView;

    public PersonSelectView(Context context) {
        this(context, null);
    }

    public PersonSelectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PersonSelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.item_persn_select, this);
        faceView = findViewById(R.id.face);
        nameView = findViewById(R.id.name);
    }

    public void setName(String name) {
        nameView.setText(name);
    }

    public void setFace(int resourceId) {
        faceView.setImageDrawable(getContext().getDrawable(resourceId));
    }

    public void setOnClick(OnClickListener listener) {
        faceView.setOnClickListener(listener);
    }


}
