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
public class Question2Answers extends Question {
    private List<String> answers;
    private List<int[]> points;
    
    
    public Question2Answers(String answerA, int[] pointsA, String answerB, int[] pointsB) {
        this.answers = new ArrayList<>();
        this.points = new ArrayList<>();
        
        this.answers.add(answerA);
        this.points.add(pointsA);
        this.answers.add(answerB);
        this.points.add(pointsB);
        
    }

    @Override
    public void answer(String answer) {
        setScores(points.get(this.answers.indexOf(answer)));
        setAnswered(true);
    }
    
    
    
}
