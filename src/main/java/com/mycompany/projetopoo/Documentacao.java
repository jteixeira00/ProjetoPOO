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
    Documentacao(GregorianCalendar inicioD,int duracaoEstimada,Pessoa responsavel){
        super(inicioD, duracaoEstimada,responsavel);
    }
    @Override
    
    public double getEsforco() {
        return esforco;
    } 
    
}
