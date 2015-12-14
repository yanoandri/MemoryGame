package com.frame.component;

import com.utilities.Algoritma;
import com.frame.listener.ButtonListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.frame.listener.PanelListener;
import java.awt.Font;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YANO
 */
public class Frame extends JFrame {

    private Label oLabelSkor;
    private Label oLabelLevel;
    private JButton oButtonBuka;
    private JButton oButtonMulaiBaru;
    private JButton oButtonSimpan;
    private PanelListener oPanelListener;
    private ButtonListener oButtonListener;
    private ArrayList<Panel> ListAllPanel;
    private ArrayList<Label> ListAllLabel;

    public Frame() {
        buildFrameGame(false);
    }

    public Frame(Boolean bIsLoad, ButtonListener oButtonListener, PanelListener oPanelListener) {
        this.oPanelListener = oPanelListener;
        this.oButtonListener = oButtonListener;
        buildFrameGame(bIsLoad);
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

    /**
     * @return the oButtonListener
     */
    public ButtonListener getButtonListener() {
        return oButtonListener;
    }

    /**
     * @param oButtonListener the oButtonListener to set
     */
    public void setButtonListener(ButtonListener oButtonListener) {
        this.oButtonListener = oButtonListener;
    }

    /**
     * @return the oPanelListener
     */
    public PanelListener getPanelListener() {
        return oPanelListener;
    }

    /**
     * @param oPanelListener the oPanelListener to set
     */
    public void setPanelListener(PanelListener oPanelListener) {
        this.oPanelListener = oPanelListener;
    }

    public void buildPanel(boolean bIsLoad) {
        if (bIsLoad) {
            PanelMenu(this.oButtonListener.getSimpanBukaUtilities().getSkor(), this.oButtonListener.getSimpanBukaUtilities().getLevel());
            PanelGame(this.oButtonListener.getSimpanBukaUtilities().getPanelValueList(), this.oButtonListener.getSimpanBukaUtilities().getPanelMatchedList());
        } else {
            PanelMenu();
            PanelGame();
        }

    }

    public void PanelMenu() {
        Panel oPanel1 = new Panel(200, 600, Color.RED);
        JLabel oLabelSkor = new JLabel("Skor: ");
        oLabelSkor.setPreferredSize(new Dimension(150, 50));
        oLabelSkor.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.oLabelSkor = new Label("0", -1);
        this.oLabelSkor.setPreferredSize(new Dimension(150, 50));
        this.oLabelSkor.setFont(new Font("SansSerif", Font.PLAIN, 20));
        JLabel oLabeLevel = new JLabel("Level: ");
        oLabeLevel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        oLabeLevel.setPreferredSize(new Dimension(150, 50));
        this.oLabelLevel = new Label("1", -2);
        this.oLabelLevel.setPreferredSize(new Dimension(150, 50));
        this.oLabelLevel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.oButtonMulaiBaru = new JButton("Mulai Baru");
        this.oButtonSimpan = new JButton("Simpan");
        this.oButtonBuka = new JButton("Buka");
        oPanel1.add(oLabelSkor);
        oPanel1.add(this.oLabelSkor);
        oPanel1.add(oLabeLevel);
        oPanel1.add(this.oLabelLevel);
        oPanel1.add(this.oButtonMulaiBaru);
        this.oButtonMulaiBaru.setPreferredSize(new Dimension(150, 50));
        oPanel1.add(this.oButtonSimpan);
        this.oButtonSimpan.setPreferredSize(new Dimension(150, 50));
        oPanel1.add(this.oButtonBuka);
        this.oButtonBuka.setPreferredSize(new Dimension(150, 50));
        this.getContentPane().add(oPanel1, BorderLayout.WEST);
    }

    public void PanelMenu(int skor, int level) {
        Panel oPanel1 = new Panel(200, 600, Color.RED);
        JLabel oLabelSkor = new JLabel("Skor: ");
        oLabelSkor.setFont(new Font("SansSerif", Font.PLAIN, 20));
        oLabelSkor.setPreferredSize(new Dimension(150, 50));
        this.oLabelSkor = new Label(String.valueOf(skor), -1);
        this.oLabelSkor.setPreferredSize(new Dimension(150, 50));
        this.oLabelSkor.setFont(new Font("SansSerif", Font.PLAIN, 20));
        JLabel oLabeLevel = new JLabel("Level: ");
        oLabeLevel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        oLabeLevel.setPreferredSize(new Dimension(150, 50));
        this.oLabelLevel = new Label(String.valueOf(level), -2);
        this.oLabelLevel.setPreferredSize(new Dimension(150, 50));
        this.oLabelLevel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.oButtonMulaiBaru = new JButton("Mulai Baru");
        this.oButtonSimpan = new JButton("Simpan");
        this.oButtonBuka = new JButton("Buka");
        oPanel1.add(oLabelSkor);
        oPanel1.add(this.oLabelSkor);
        oPanel1.add(oLabeLevel);
        oPanel1.add(this.oLabelLevel);
        oPanel1.add(this.oButtonMulaiBaru);
        this.oButtonMulaiBaru.setPreferredSize(new Dimension(150, 50));
        oPanel1.add(this.oButtonSimpan);
        this.oButtonSimpan.setPreferredSize(new Dimension(150, 50));
        oPanel1.add(this.oButtonBuka);
        this.oButtonBuka.setPreferredSize(new Dimension(150, 50));
        this.getContentPane().add(oPanel1, BorderLayout.WEST);
    }

    public void PanelGame(ArrayList<Integer> oListPanelValue, ArrayList<Integer> oListMatched) {
        ArrayList<Integer> oPanelValue = oListPanelValue;
        ArrayList<Integer> oPanelMatched = oListMatched;
        this.ListAllPanel = new ArrayList<Panel>();
        this.ListAllLabel = new ArrayList<Label>();
        Panel oPanel2 = new Panel(600, 600, Color.BLACK);
        Panel pnlAngka = null;
        for (int i = 0; i < oPanelValue.size(); i++) {
            Label lblAngka = new Label(String.valueOf(oPanelValue.get(i)), i);
            lblAngka.setFont(new Font("SansSerif", Font.PLAIN, 25));
            if (oPanelMatched.get(i) != 0) {
                pnlAngka = new Panel(125, 125, Color.WHITE, i);
                lblAngka.setMatched(true);
                lblAngka.setVisible(true);
            } else {
                pnlAngka = new Panel(125, 125, Color.GREEN, i);
                lblAngka.setVisible(false);
            }
            lblAngka.setForeground(Color.BLUE);
            lblAngka.setPreferredSize(new Dimension(125, 125));
            pnlAngka.addMouseListener(this.oPanelListener);
            pnlAngka.add(lblAngka);
            oPanel2.add(pnlAngka);
            this.ListAllLabel.add(lblAngka);
            this.ListAllPanel.add(pnlAngka);
        }
        oPanelListener.setLabelSkor(this.oLabelSkor);
        oPanelListener.setLabelLevel(this.oLabelLevel);
        this.oPanelListener.setSelectedLabelList(this.ListAllLabel);
        this.oPanelListener.setSelectedPanelList(this.ListAllPanel);
        this.getContentPane().add(oPanel2, BorderLayout.CENTER);
    }

    public void PanelGame() {
        this.ListAllPanel = new ArrayList<Panel>();
        this.ListAllLabel = new ArrayList<Label>();
        Panel oPanel2 = new Panel(600, 600, Color.BLACK);
        Algoritma oAlgoritma = new Algoritma();
        oAlgoritma.isiAngka();
        this.oPanelListener = new PanelListener();
        for (int i = 0; i < oAlgoritma.getListCard().size(); i++) {
            Panel pnlAngka = new Panel(125, 125, Color.GREEN, i);
            Label lblAngka = new Label(String.valueOf(oAlgoritma.getListCard().get(i)), i);
            lblAngka.setFont(new Font("SansSerif", Font.PLAIN, 25));
            lblAngka.setForeground(Color.BLUE);
            lblAngka.setPreferredSize(new Dimension(125, 125));
            lblAngka.setVisible(false);
            pnlAngka.addMouseListener(this.oPanelListener);
            pnlAngka.add(lblAngka);
            oPanel2.add(pnlAngka);
            ListAllPanel.add(pnlAngka);
            ListAllLabel.add(lblAngka);
        }
        this.oPanelListener.setLabelSkor(this.oLabelSkor);
        this.oPanelListener.setLabelLevel(this.oLabelLevel);
        this.oPanelListener.setSelectedLabelList(this.ListAllLabel);
        this.oPanelListener.setSelectedPanelList(this.ListAllPanel);
        this.getContentPane().add(oPanel2, BorderLayout.CENTER);
    }

    public void buildFrameGame(boolean bIsLoad) {
        if (bIsLoad) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setPreferredSize(new Dimension(800, 600));
            this.setResizable(false);
            this.setTitle("Tugas 3 DDP");
            this.setVisible(true);
            buildPanel(true);
            setButtonListener(true);
            this.oPanelListener.setFrame(this);
        } else {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setPreferredSize(new Dimension(800, 600));
            this.setResizable(false);
            this.setTitle("Tugas 3 DDP");
            this.setVisible(true);
            buildPanel(false);
            setButtonListener(false);
            this.oPanelListener.setFrame(this);
        }
    }

    public void setButtonListener(boolean bIsLoad) {
            this.oButtonListener = new ButtonListener(this.oButtonMulaiBaru, this.oButtonSimpan, this.oButtonBuka, this.oPanelListener);
            this.oButtonListener.setFrame(this);
            this.oButtonMulaiBaru.addActionListener(this.oButtonListener);
            this.oButtonSimpan.addActionListener(this.oButtonListener);
            this.oButtonBuka.addActionListener(this.oButtonListener);
            pack();
    }
}
