/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.contacts.Contact;
import com.codename1.io.Log;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author User
 */
public class SearchButtonListener implements ActionListener{
    private Form hi;
    public SearchButtonListener(Form hi){
        this.hi = hi;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        configureSearch();
    }   
    private void configureSearch(){
        Image duke = null;
        try {
            duke = Image.createImage("/jonsnow.jpg");
        } catch(IOException err) {
            Log.e(err);
        }
        int fiveMM = Display.getInstance().convertToPixels(5);
        final Image finalDuke = duke.scaledWidth(fiveMM);
        Toolbar.setGlobalToolbar(true);
        Form hi = new Form("Search", BoxLayout.y());
        hi.add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(()-> {
            // this will take a while...
            Contact[] cnts = Display.getInstance().getAllContacts(true, true, true, true, false, false);
            Display.getInstance().callSerially(() -> {
                hi.removeAll();
                for(Contact c : cnts) {
                    MultiButton m = new MultiButton();
                    m.setTextLine1(c.getDisplayName());
                    m.setTextLine2(c.getPrimaryPhoneNumber());
                    Image pic = c.getPhoto();
                    if(pic != null) {
                        m.setIcon(pic.scaled(finalDuke.getWidth(), finalDuke.getHeight()));
                    } else {
                        m.setIcon(finalDuke);
                    }
                    hi.add(m);
                }
                hi.revalidate();
            });
        });

        hi.getToolbar().addSearchCommand(e -> {
            String text = (String)e.getSource();
            if(text == null || text.length() == 0) {
                // clear search
                for(Component cmp : hi.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                hi.getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for(Component cmp : hi.getContentPane()) {
                    MultiButton mb = (MultiButton)cmp;
                    String line1 = mb.getTextLine1();
                    String line2 = mb.getTextLine2();
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1 ||
                            line2 != null && line2.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                hi.getContentPane().animateLayout(150);
            }
        }, 3);
    }
}
