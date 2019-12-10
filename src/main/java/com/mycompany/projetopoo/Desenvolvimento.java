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
public class Desenvolvimento extends Tarefa{
    

    public Desenvolvimento(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD, Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);   
        
    }
    
    @Override
    public double getEsforco() {
        return 1;
    } 
    
}
