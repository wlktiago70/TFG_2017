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
public class Party extends Group {
    
    private Player creator;                                     //criador da equipe
    private SideQuest sideQuest;                               //SQ que a equipe esta participando
    private List<Player> members = new ArrayList<Player>();
    
}
