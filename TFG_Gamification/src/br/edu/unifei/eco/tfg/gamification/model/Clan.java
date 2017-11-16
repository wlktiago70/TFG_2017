/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */

@DatabaseTable(tableName = "clans")
public class Clan extends Group {
    @DatabaseField(foreign = true)
    private List<Player> members = new ArrayList<Player>();
    
    
    public Clan(String name, String description) {
        super(name, description);
    }

    public void addMember(Player player){
        members.add(player);
    }
}
