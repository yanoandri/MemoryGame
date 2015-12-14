package com.frame.component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
/**
 *
 * @author YANO
 */
public class Panel extends JPanel {
    private int PanelId;
        
    public Panel(){
    }
    
    public Panel(int x, int y, Color color){
        setBackground(color);
        setPreferredSize(new Dimension(x, y));
    }
    
    public Panel(int x, int y, Color color, int PanelId){
        setBackground(color);
        setPreferredSize(new Dimension(x, y));
        this.PanelId = PanelId;
    }
    
    /**
     * @return the PanelId
     */
    public int getPanelId() {
        return PanelId;
    }

    /**
     * @param PanelId the PanelId to set
     */
    public void setPanelId(int PanelId) {
        this.PanelId = PanelId;
    }
}
