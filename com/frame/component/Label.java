/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frame.component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author YANO
 */
public class Label extends JLabel {
    private int iLblId;
    private boolean bIsMatched;
    private String sText;
    
    public Label(){
        this.iLblId = -1;
        this.bIsMatched = false;
    }
    
    public Label(String angka,int iLblId){
        setText(angka);
        setHorizontalAlignment(SwingConstants.CENTER);
        this.iLblId = iLblId;
        this.bIsMatched = false;
        this.sText = angka;
    }
    
    public Label(int iLblId){
        this.iLblId = iLblId;
    }

    /**
     * @return the iLblId
     */
    public int getLblId() {
        return iLblId;
    }

    /**
     * @param iLblId the iLblId to set
     */
    public void setLblId(int iLblId) {
        this.iLblId = iLblId;
    }

    /**
     * @return the bIsMatched
     */
    public boolean getMatched() {
        return bIsMatched;
    }

    /**
     * @param bIsMatched the bIsMatched to set
     */
    public void setMatched(boolean bIsMatched) {
        this.bIsMatched = bIsMatched;
    }

    /**
     * @return the sText
     */
    public String getLabelText() {
        return sText;
    }

    /**
     * @param sText the sText to set
     */
    public void setLabelText(String sText) {
        this.sText = sText;
        setText(sText);
    }
    
}
