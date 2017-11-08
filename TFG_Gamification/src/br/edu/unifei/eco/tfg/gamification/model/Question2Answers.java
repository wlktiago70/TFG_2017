/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class Question2Answers implements Question {
    private final String text;
    private int scores[];
    private boolean answered;
    private List<String> answers;
    private List<int[]> points;
    
    
    public Question2Answers(String text, String answerA, int[] pointsA, String answerB, int[] pointsB) {
        this.text = text;
        this.answered = false;
        
        this.answers = new ArrayList<>();
        this.points = new ArrayList<>();
        
        this.answers.add(answerA);
        this.points.add(pointsA);
        this.answers.add(answerB);
        this.points.add(pointsB);
        
    }

    
    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public int[] getScores() {
        return this.scores;
    }

    @Override
    public boolean isAnswered() {
        return this.answered;
    }

    @Override
    public List<String> getAnswers() {
        return this.answers;
    }
    
    @Override
    public void answer(String answer) {
        this.scores = points.get(this.answers.indexOf(answer));
        this.answered = true;
    }

    
    
    
}
