/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * @author Dinis Carvalho 2018278118
 * @author João Teixeira 2018278532
 */
public abstract class Bolseiro extends Pessoa implements Serializable {
    private GregorianCalendar InicioB;
    private GregorianCalendar FimB;
    private int custo;
    
    /**
     * Construtor Bolseiro
     * @param nome Nome Bolseiro
     * @param email Email Bolseiro
     * @param InicioB Data de Inicio Bolseiro
     * @param FimB Data Final Bolseiro
     */
    
    Bolseiro(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email);
        this.InicioB = InicioB; 
        this.FimB = FimB;    
    }

    @Override
    public int getCusto(){
        return custo;
    }
    
    @Override 
    public String getEstatuto(){
        return "Bolseiro";
    }
       
    public GregorianCalendar getInicio(){
        return InicioB;
    }
    public GregorianCalendar getFim(){
        return FimB;
    }
    public abstract void setCoordenador(Pessoa D); 
}
