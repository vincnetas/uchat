package org.unesco.uchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.SimpleExpandableListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Onboarding02 extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding02);

        scrollView = findViewById(R.id.scroll_view);
        expandableListView = new ExpandableListView(this);


        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("ROOT_NAME", "Lietuvos vietovės");
            }});
            add(new HashMap<String, String>() {{
                put("ROOT_NAME", "Lietuvos tradicijos");
            }});
            add(new HashMap<String, String>() {{
                put("ROOT_NAME", "Lietuvos dokumentai");
            }});
        }};

        List<List<Map<String, String>>> listOfChildGroups = new ArrayList<List<Map<String, String>>>();

        List<Map<String, String>> childGroupForFirstGroupRow = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Žuvintas");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Vilniaus istorinis centras");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Kuršių nerija");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Struvės geodezinis lankas");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Kernavės archeologinė vietovė");
            }});
        }};
        listOfChildGroups.add(childGroupForFirstGroupRow);

        List<Map<String, String>> childGroupForSecondGroupRow = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Kryždirbystė ir jos simbolika Lietuvoje");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Trijų Baltijos valstybių Dainų ir šokių švenčių tradicija\n");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Sutartinės – daugiabalsės lietuvių dainos ");
            }});
        }};
        listOfChildGroups.add(childGroupForSecondGroupRow);

        List<Map<String, String>> childGroupForThirdGroupRow = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Baltijos kelias");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Liublino unija");
            }});
            add(new HashMap<String, String>() {{
                put("CHILD_NAME", "Radvilų archyvai, biblioteka");
            }});
        }};
        listOfChildGroups.add(childGroupForThirdGroupRow);

        SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(
                this,

                groupData,
                R.layout.layout_gruop_active,
                R.layout.layout_gruop,
                new String[]{"ROOT_NAME"},
                new int[]{android.R.id.text1},

                listOfChildGroups,
                R.layout.layout_gruop_item,
                new String[]{"CHILD_NAME"},
                new int[]{android.R.id.text1}

        );


        expandableListView.setAdapter(sela);
        expandableListView.setChildDivider(getResources().getDrawable(android.R.color.transparent));

        scrollView.addView(expandableListView);
    }

    public void showNext(View view) {
        startActivity(new Intent(this, Onboarding03.class));
    }

    @Override
    public void onBackPressed() {
    }
}