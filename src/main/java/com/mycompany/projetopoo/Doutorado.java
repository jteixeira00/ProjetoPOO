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
public class Doutorado extends Bolseiro{
    
    int custo = 1000;
    
    Doutorado(GregorianCalendar InicioB,GregorianCalendar FimB){
        super(InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return custo;
    }
    
}
