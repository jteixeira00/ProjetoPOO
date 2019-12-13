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
public class Licenciado extends Bolseiro implements Serializable{
    
    ArrayList<Pessoa> Coordenadores = new ArrayList<>();

    /**
     *Construtor Licenciado
     * @param nome Nome Licenciado
     * @param email Email Licenciado
     * @param InicioB Data de Incio de Bolsa Licenciado
     * @param FimB Data Final de Bolsa Licenciado
     */
    public Licenciado(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email,InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return 800;
    }
    @Override 
    public String getEstatuto(){
        return "Licenciado";
    }
    

    public void setCoordenador(Pessoa D){
        Coordenadores.add(D);             
    }
        
}