/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import java.util.List;

/**
 *
 * @author Paulo
 */
public abstract class Question {
    private String text;
    private int scores[];
    private boolean answered;
    private List<String> answers;

    public Question(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
    

    public List<String> getAnswers() {
        return answers;
    }

    
    public void answer(String answer){}
    
}
