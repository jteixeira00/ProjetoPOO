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
public class Doutorado extends Bolseiro implements Serializable{
    
    /**
     *Construtor Doutorado
     * @param nome Nome Doutorado
     * @param email Email Doutorado
     * @param InicioB Data Inicial de Bolsa Doutorado
     * @param FimB Data Final de Bolsa Doutorado
     */
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
    
    @Override
    public void setCoordenador(Pessoa D){
        System.out.println("Doutorados não tem Coordenadores");             
    }
}
