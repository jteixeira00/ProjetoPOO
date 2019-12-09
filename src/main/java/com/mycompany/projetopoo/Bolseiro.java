/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.util.GregorianCalendar;

/**
 *
 * @author dinis
 */
public class Bolseiro {
    GregorianCalendar InicioB;
    GregorianCalendar FimB;
    int custo;
    
    Bolseiro(GregorianCalendar InicioB,GregorianCalendar FimB){
        this.InicioB = InicioB; 
        this.FimB = FimB;
    }

    public int getCusto() {
        return custo;
    }
    
    
    
    
    
    
}
