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
public class MainQuest extends Quest {
    
    private int chapter;        //capitulo da mainquest 
    
    public MainQuest(int chapter, String name, String description, List<Goal> goals, List<Reward> rewards) {
      
        super(name, description, goals, rewards);
        this.chapter = chapter;
      
    }

    public int getChapter() {
        return chapter;
    }
    
    
    
}
