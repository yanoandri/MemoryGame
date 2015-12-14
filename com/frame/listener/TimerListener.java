/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import com.frame.component.Panel;
import com.frame.component.Label;
import java.awt.Color;

/**
 *
 * @author YANO
 */
public class TimerListener implements ActionListener {

    private ArrayList<Panel> PanelList;
    private ArrayList<Label> LabelList;
    private Panel Panel1;
    private Panel Panel2;
    private Label Label1;
    private Label Label2;

    public TimerListener() {
        this.PanelList = new ArrayList<Panel>();
        this.LabelList = new ArrayList<Label>();
        this.Panel1 = null;
        this.Panel2 = null;
        this.Label1 = null;
        this.Label2 = null;
    }

    /**
     * @return the PanelList
     */
    public ArrayList<Panel> getPanelList() {
        return PanelList;
    }

    /**
     * @param PanelList the PanelList to set
     */
    public void setPanelList(ArrayList<Panel> PanelList) {
        this.PanelList = PanelList;
    }

    /**
     * @return the LabelList
     */
    public ArrayList<Label> getLabelList() {
        return LabelList;
    }

    /**
     * @param LabelList the LabelList to set
     */
    public void setLabelList(ArrayList<Label> LabelList) {
        this.LabelList = LabelList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.getPanelList().size() > 0 || this.getLabelList().size() > 0) {
            boolean bIsFirstLabelSelected = false;
            for (int i = 0; i < this.getPanelList().size() || i < this.getLabelList().size(); i++) {
                if (bIsFirstLabelSelected) {
                    if (this.getLabelList().get(i).isVisible() && !this.LabelList.get(i).getMatched()) {
                        this.Label1 = this.getLabelList().get(i);
                        this.Panel1 = this.getPanelList().get(i);
                        bIsFirstLabelSelected = true;
                    }
                } else {
                    if (this.getLabelList().get(i).isVisible() && !this.LabelList.get(i).getMatched()) {
                        this.Label2 = this.getLabelList().get(i);
                        this.Panel2 = this.getPanelList().get(i);
                    }
                }
            }
            
            if (this.Label1 != null && this.Label2 != null) {
                if (!this.Label1.getLabelText().equalsIgnoreCase(this.Label2.getLabelText())) {
                    this.Label1.setVisible(false);
                    this.Label2.setVisible(false);
                    this.Panel1.setBackground(Color.GREEN);
                    this.Panel2.setBackground(Color.GREEN);
                    this.getLabelList().clear();
                    this.getPanelList().clear();
                } else {
                    this.Label1.setMatched(true);
                    this.Label2.setMatched(true);
                    this.getLabelList().clear();
                    this.getPanelList().clear();
                }
            }
        }

    }

}
