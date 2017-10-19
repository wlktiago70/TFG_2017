/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

/**
 *
 * @author Paulo
 */
public class PlayerPerformance {
    private int completedSQ;        //numero de SQ completas
    private int totalSQ;            //numero total de SQ que participou
    private int totalSQcreated;     //numero total de SQ criada
   
    
    public int getCompletedSQ() {
        return completedSQ;
    }

    public void addCompletedSQ() {
        this.completedSQ++; 
    }

    public int getTotalSQ() {
        return totalSQ;
    }

    public void addTotalSQ() {
        this.totalSQ++;
    }

    public int getTotalSQcreated() {
        return totalSQcreated;
    }

    public void addTotalSQcreated() {
        this.totalSQcreated++;
    }
    
    
    
    
    
    
    
}
    