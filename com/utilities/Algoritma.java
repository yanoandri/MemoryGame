package com.utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author YANO
 */
public class Algoritma {

    private ArrayList<Integer> listCard;
    private Random intRandomize;

    public Algoritma() {
        this.listCard = new ArrayList<Integer>();
        intRandomize = new Random();
    }

    /**
     * @return the listCard
     */
    public ArrayList<Integer> getListCard() {
        return listCard;
    }

    /**
     * @param listCard the listCard to set
     */
    public void setListCard(ArrayList<Integer> listCard) {
        this.listCard = listCard;
    }

    public ArrayList<Integer> isiAngka() {
        boolean isPair = false, isFill = false;
        int iALreadyIn = 0;
        while (!isFill) {
            int Temp1 = this.intRandomize.nextInt(8);
            int Temp2 = this.intRandomize.nextInt(8);
            if (Temp1 == Temp2) {
                isPair = true;
                while (isPair) {
                    for (int a : this.listCard) {
                        if (Temp1 == a || Temp2 == a) {
                            iALreadyIn++;
                        }
                    }                    
                    if (iALreadyIn > 0) {
                        iALreadyIn = 0;
                    } else  {
                        this.listCard.add(Temp1);
                        this.listCard.add(Temp2);
                    }
                    isPair = false;
                }                
            }
            
            if (this.listCard.size() == 16) {
                isFill = true;
            }
        }
        Collections.shuffle(this.listCard);
        return this.listCard;
    }

}
