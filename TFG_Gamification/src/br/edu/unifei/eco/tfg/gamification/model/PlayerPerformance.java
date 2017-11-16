/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Paulo
 */
@DatabaseTable(tableName = "playerPerformance")
public class PlayerPerformance {
    @DatabaseField()
    private int completedSQ;        //numero de SQ completas
    @DatabaseField()
    private int totalSQ;            //numero total de SQ que participou
    @DatabaseField()
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
    