package org.unesco.uchat.dto;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class State {

    private String say;

    private List<Pair<String, State>> questions = new ArrayList<>();


    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public List<Pair<String, State>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Pair<String, State>> questions) {
        this.questions = questions;
    }
}
