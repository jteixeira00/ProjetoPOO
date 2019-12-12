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
public class Doutorado extends Bolseiro implements Serializable{
    
    
    
    public Doutorado(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email,InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return 1000;
    }
    @Override 
    public String getEstatuto(){
        return "Doutorado";
    }
    
}
