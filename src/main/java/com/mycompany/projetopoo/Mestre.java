/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author dinis
 */
public class Mestre extends Bolseiro implements Serializable{
    
    
    ArrayList<Pessoa> Coordenadores = new ArrayList<>();
    /**
     *Construtor Licenciado
     * @param nome
     * @param email
     * @param InicioB
     * @param FimB
     */
    Mestre(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email,InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return 1200;
    }
    @Override 
    public String getEstatuto(){
        return "Mestre";
    }
    
    public void setCoordenador(Pessoa D){
        Coordenadores.add(D);             
    }
        
}
