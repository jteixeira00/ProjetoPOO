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
public class Documentacao extends Tarefa implements Serializable{
    double esforco = 0.25;
    
    public Documentacao(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD, Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);       
    }
    
    public double getEsforco() {
        return esforco;
    } 
    
}
