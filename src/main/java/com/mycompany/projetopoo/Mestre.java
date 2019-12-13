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
 * @author Dinis Carvalho 2018278118
 * @author João Teixeira 2018278532
 */
public class Mestre extends Bolseiro implements Serializable{
    
    
    ArrayList<Pessoa> Coordenadores = new ArrayList<>();
    /**
     *Construtor Mestre
     * @param nome Nome Mestre
     * @param email Email Mestre
     * @param InicioB Data Inicio Bolsa Mestre
     * @param FimB Data Final Bolsa Mestre
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
