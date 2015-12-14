/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilities;

import com.frame.listener.PanelListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author YANO
 */
public class SimpanBuka {

    private PanelListener oListenToPanel;
    private ArrayList<Integer> oPanelValueList;
    private ArrayList<Integer> oPanelMatchedList;
    private int iSkor;
    private int iLevel;

    public SimpanBuka() {
        this.oPanelValueList = new ArrayList<Integer>();
        this.oPanelMatchedList = new ArrayList<Integer>();
    }

    public SimpanBuka(PanelListener oPanelListener) {
        this.oPanelValueList = new ArrayList<Integer>();
        this.oPanelMatchedList = new ArrayList<Integer>();
        this.oListenToPanel = oPanelListener;
    }

    /**
     * @return the iSkor
     */
    public int getSkor() {
        return iSkor;
    }

    /**
     * @param iSkor the iSkor to set
     */
    public void setSkor(int iSkor) {
        this.iSkor = iSkor;
    }

    /**
     * @return the iLevel
     */
    public int getLevel() {
        return iLevel;
    }

    /**
     * @param iLevel the iLevel to set
     */
    public void setLevel(int iLevel) {
        this.iLevel = iLevel;
    }

    /**
     * @return the oPanelValueList
     */
    public ArrayList<Integer> getPanelValueList() {
        return oPanelValueList;
    }

    /**
     * @param oPanelValueList the oPanelValueList to set
     */
    public void setPanelValueList(ArrayList<Integer> oPanelValueList) {
        this.oPanelValueList = oPanelValueList;
    }

    /**
     * @return the oPanelMatchedList
     */
    public ArrayList<Integer> getPanelMatchedList() {
        return oPanelMatchedList;
    }

    /**
     * @param oPanelMatchedList the oPanelMatchedList to set
     */
    public void setPanelMatchedList(ArrayList<Integer> oPanelMatchedList) {
        this.oPanelMatchedList = oPanelMatchedList;
    }

    public void simpan() {
        try {
            File oFile = new File("GameConfig.txt");
            if (oFile.exists()) {
                if (oFile.delete()) {
                    writeSaveFile();
                }
            } else {
                writeSaveFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean buka() {
        boolean bIsSaveFileExist = false;
        try{
            File oFile = new File("GameConfig.txt");
            if(oFile.exists()){
                loadSaveFile();
                bIsSaveFileExist = true;
            }else{
                bIsSaveFileExist = false;
            }
        }catch(Exception ex){
            bIsSaveFileExist = false;
        }
        return bIsSaveFileExist;

    }

    public void writeSaveFile() {
        try {
            FileWriter writer = new FileWriter("GameConfig.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            int j = 0;
            while (true) {
                String sTemp = "";
                if (j == 0 || j == 2 || j == 4) {
                    sTemp = ">>>";
                } else {
                    if (j == 1) {
                        sTemp = String.format("Skor : %s", this.oListenToPanel.getLabelSkor().getLabelText());
                    } else if (j == 3) {
                        sTemp = String.format("Level : %s", this.oListenToPanel.getLabelLevel().getLabelText());
                    }
                }
                bufferedWriter.write(sTemp);
                bufferedWriter.newLine();
                if (j == 4) {
                    break;
                } else {
                    j++;
                }
            }
            for (int i = 0; i < oListenToPanel.getSelectedLabelList().size(); i++) {
                bufferedWriter.write(oListenToPanel.getSelectedLabelList().get(i).getLabelText());
                bufferedWriter.write(" ");
                if (this.oListenToPanel.getSelectedLabelList().get(i).getMatched()) {
                    bufferedWriter.write("1");
                } else {
                    bufferedWriter.write("0");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.write("-------------------");
            bufferedWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadSaveFile() {
        try {
            FileReader reader = new FileReader("GameConfig.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            int j = 0;
            boolean bIsRead = false;
            while ((line = bufferedReader.readLine()) != null && !bIsRead) {
                if (j == 0 || j == 2 || j == 4) {
                    j++;
                    continue;
                } else {
                    if (j == 1) {
                        this.iSkor = Integer.parseInt(line.substring(7));
                    } else if (j == 3) {
                        this.iLevel = Integer.parseInt(line.substring(8));
                    } else {
                        if (!line.contains("---")) {
                            this.oPanelValueList.add(Integer.parseInt(line.substring(0, 1)));
                            this.oPanelMatchedList.add(Integer.parseInt(line.substring(2)));
                        } else {
                            bIsRead = true;
                        }
                    }
                }
                j++;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
