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
public interface Question {
    
    
    public String getText();
    
    public int[] getScores();


    public boolean isAnswered();

    public List<String> getAnswers();
    
    public void answer(String answer);
    
}
