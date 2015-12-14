/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.listener;

import com.frame.component.Frame;
import com.frame.component.Label;
import com.frame.component.Panel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author YANO
 */
public class PanelListener implements MouseListener {

    private ArrayList<Panel> selectedPanelList;
    private ArrayList<Label> selectedLabelList;
    private Panel oSelectedPanel1;
    private Label oSelectedLabel1;
    private Panel oSelectedPanel2;
    private Label oSelectedLabel2;
    private Label oLabelSkor;
    private Label oLabelLevel;
    private Frame oFrame;
    private final int SKOR_MATCHED = 125;

    public PanelListener() {
        this.selectedPanelList = new ArrayList<Panel>();
        this.selectedLabelList = new ArrayList<Label>();
        this.oSelectedPanel1 = null;
        this.oSelectedPanel2 = null;
        this.oSelectedLabel1 = null;
        this.oSelectedLabel2 = null;
        this.oLabelSkor = null;
        this.oLabelLevel = null;
    }

    public PanelListener(ArrayList<Panel> oSelectedPanelList, ArrayList<Label> oSelectedLabelList) {
        this.selectedLabelList = oSelectedLabelList;
        this.selectedPanelList = oSelectedPanelList;
        this.oSelectedPanel1 = null;
        this.oSelectedPanel2 = null;
        this.oSelectedLabel1 = null;
        this.oSelectedLabel2 = null;
        this.oLabelSkor = null;
        this.oLabelLevel = null;
    }

    /**
     * @param oFrame the oFrame to set
     */
    public void setFrame(Frame oFrame) {
        this.oFrame = oFrame;
    }

    /**
     * @return the selectedPanelList
     */
    public ArrayList<Panel> getSelectedPanelList() {
        return selectedPanelList;
    }

    /**
     * @param selectedPanelList the selectedPanelList to set
     */
    public void setSelectedPanelList(ArrayList<Panel> selectedPanelList) {
        this.selectedPanelList = selectedPanelList;
    }

    /**
     * @return the selectedLabelList
     */
    public ArrayList<Label> getSelectedLabelList() {
        return selectedLabelList;
    }

    /**
     * @param selectedLabelList the selectedLabelList to set
     */
    public void setSelectedLabelList(ArrayList<Label> selectedLabelList) {
        this.selectedLabelList = selectedLabelList;
    }

    /**
     * @return the oLabelSkor
     */
    public Label getLabelSkor() {
        return oLabelSkor;
    }

    /**
     * @param oLabelSkor the oLabelSkor to set
     */
    public void setLabelSkor(Label oLabelSkor) {
        this.oLabelSkor = oLabelSkor;
    }

    /**
     * @return the oLabelLevel
     */
    public Label getLabelLevel() {
        return oLabelLevel;
    }

    /**
     * @param oLabelLevel the oLabelLevel to set
     */
    public void setLabelLevel(Label oLabelLevel) {
        this.oLabelLevel = oLabelLevel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (this.oSelectedPanel1 == null) {
                for (int i = 0; i < this.selectedPanelList.size(); i++) {
                    if (this.selectedPanelList.get(i) == e.getSource() && !this.selectedLabelList.get(i).getMatched()) {
                        this.oSelectedPanel1 = this.selectedPanelList.get(i);
                        this.oSelectedLabel1 = this.selectedLabelList.get(i);
                        this.oSelectedPanel1.setBackground(Color.WHITE);
                        this.oSelectedLabel1.setVisible(true);
                    }
                }
            } else if (this.oSelectedPanel1 != null) {
                for (int i = 0; i < this.selectedPanelList.size(); i++) {
                    if (this.selectedPanelList.get(i) == e.getSource() && !this.selectedLabelList.get(i).getMatched()) {
                        this.oSelectedPanel2 = this.selectedPanelList.get(i);
                        this.oSelectedLabel2 = this.selectedLabelList.get(i);
                        this.oSelectedPanel2.setBackground(Color.WHITE);
                        this.oSelectedLabel2.setVisible(true);
                    }
                }
            }
        }
        Timer oTimer = new Timer(250, TimerActionListener());
        oTimer.setRepeats(false);
        oTimer.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public ActionListener TimerActionListener() {
        ActionListener oActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oSelectedPanel1 != null && oSelectedPanel2 != null) {
                    if (!oSelectedLabel1.getLabelText().equalsIgnoreCase(oSelectedLabel2.getLabelText())) {
                        oSelectedLabel1.setVisible(false);
                        oSelectedPanel1.setBackground(Color.GREEN);
                        oSelectedLabel2.setVisible(false);
                        oSelectedPanel2.setBackground(Color.GREEN);
                        releaseTempResource();
                    } else {
                        if (oSelectedPanel1 == oSelectedPanel2) {
                            oSelectedLabel1.setVisible(false);
                            oSelectedPanel1.setBackground(Color.GREEN);
                            oSelectedLabel2.setVisible(false);
                            oSelectedPanel2.setBackground(Color.GREEN);
                            releaseTempResource();
                        } else {
                            oSelectedLabel1.setMatched(true);
                            oSelectedLabel2.setMatched(true);
                            releaseTempResource();
                        }
                    }
                }
                int countValidLabel = countIsVisible();
                oLabelSkor.setText(String.valueOf((countValidLabel / 2) * SKOR_MATCHED));
                oLabelSkor.setLabelText(String.valueOf((countValidLabel / 2) * SKOR_MATCHED));
                if ((countValidLabel / 2) * SKOR_MATCHED == 1000) {
                    releaseTempResource();
                    doLevelUp();
                }
            }
        };
        return oActionListener;
    }

    public void releaseTempResource() {
        this.oSelectedPanel1 = null;
        this.oSelectedPanel2 = null;
        this.oSelectedLabel1 = null;
        this.oSelectedLabel2 = null;
    }

    public int countIsVisible() {
        int i = 0;
        for (int j = 0; j < this.selectedLabelList.size(); j++) {
            if (this.selectedLabelList.get(j).getMatched()) {
                i++;
            }
        }
        return i;
    }

    private void doLevelUp() {
        selectedLabelList.clear();
        selectedPanelList.clear();
        int iGetCurrentLevel = Integer.parseInt(oLabelLevel.getText());
        iGetCurrentLevel++;
        oFrame.dispose();
        oFrame = new Frame();
        oFrame.getLabelLevel().setText(String.valueOf(iGetCurrentLevel));
        oFrame.getLabelLevel().setLabelText(String.valueOf(iGetCurrentLevel));
        oLabelSkor.setText("0");
        oLabelSkor.setLabelText("0");
        JOptionPane.showMessageDialog(oFrame, "you just leveled up to level " + iGetCurrentLevel + "!");
    }

}
