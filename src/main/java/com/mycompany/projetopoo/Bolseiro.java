/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author dinis
 */
abstract class Bolseiro extends Pessoa implements Serializable {
    private GregorianCalendar InicioB;
    private GregorianCalendar FimB;
    private int custo;
    
    public Bolseiro(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email);
        this.InicioB = InicioB; 
        this.FimB = FimB;
    }

    public int getCusto() {
        return custo;
    }
    
    
    
    
    
    
}
