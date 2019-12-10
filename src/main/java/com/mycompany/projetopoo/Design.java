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
public class Design extends Tarefa{
    private double esforço = 0.5;
    
    public Design(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);        
    }
    
    public double getEsforço(){
        return esforço;
    }
    
    /*public double esforço(){
    return 0.5;*/
}
    

