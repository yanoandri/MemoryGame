/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.listener;

import com.frame.component.Frame;
import com.utilities.SimpanBuka;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author YANO
 */
public class ButtonListener implements ActionListener {

    private JButton oButtonMulaiBaru;
    private JButton oButtonSimpan;
    private JButton oButtonBuka;
    private Frame oFrame;
    private SimpanBuka oSimpanBukaUtilities;

    public ButtonListener() {
        this.oSimpanBukaUtilities = new SimpanBuka();
    }

    public ButtonListener(JButton oButtonMulaiBaru, JButton oButtonSimpan, JButton oButtonBuka, PanelListener oPanelListener) {
        this.oButtonMulaiBaru = oButtonMulaiBaru;
        this.oButtonSimpan = oButtonSimpan;
        this.oButtonBuka = oButtonBuka;
        this.oSimpanBukaUtilities = new SimpanBuka(oPanelListener);
    }

    /**
     * @return the oSimpanBukaUtilities
     */
    public SimpanBuka getSimpanBukaUtilities() {
        return oSimpanBukaUtilities;
    }

    /**
     * @param oSimpanBukaUtilities the oSimpanBukaUtilities to set
     */
    public void setSimpanBukaUtilities(SimpanBuka oSimpanBukaUtilities) {
        this.oSimpanBukaUtilities = oSimpanBukaUtilities;
    }

    /**
     * @return the oFrame
     */
    public Frame getFrame() {
        return oFrame;
    }

    /**
     * @param oFrame the oFrame to set public void setFrame(Frame oFrame) {
     */
    public void setFrame(Frame oFrame) {
        this.oFrame = oFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.oButtonMulaiBaru) {
            this.oFrame.dispose();
            this.oFrame = new Frame();
        } else if (e.getSource() == this.oButtonSimpan) {
            this.oSimpanBukaUtilities.simpan();
            JOptionPane.showMessageDialog(this.oFrame, "Your game has been saved!");
        } else if (e.getSource() == this.oButtonBuka) {
            this.oFrame.dispose();
            if (this.oSimpanBukaUtilities.buka()) {
                this.oFrame = new Frame(true, this, new PanelListener());
                JOptionPane.showMessageDialog(this.oFrame, "Your game has been loaded from previous session!");
            } else {
                this.oFrame.setVisible(true);
                JOptionPane.showMessageDialog(this.oFrame, "There is no save file from previous session, please make a save file first!");
            }

        }
    }
}
