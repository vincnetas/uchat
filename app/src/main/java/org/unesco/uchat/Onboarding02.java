package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding02 extends AppCompatActivity {

//    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding02);
//        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
//
//        ExpandableListAdapter a = new SimpleExpandableListAdapter();
//
//        expandableListView.setAdapter();
    }

    public void showNext(View view) {
        startActivity(new Intent(this, Onboarding03.class));
    }

    @Override
    public void onBackPressed() {
    }
}