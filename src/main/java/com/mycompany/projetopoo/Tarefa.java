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
public class Tarefa implements Serializable{
    GregorianCalendar inicioD;
    GregorianCalendar finalD;
    int duracao;
    Pessoa responsavel;
    double esforco;
    
    
    void Tarefa(GregorianCalendar inicioD,GregorianCalendar finalD,int duracao,Pessoa responsavel){
    
    }
    
    void atualizarTaxa(int i){
        
    }

    public GregorianCalendar getInicioD() {
        return inicioD;
    }

    public GregorianCalendar getFinalD() {
        return finalD;
    }

    public int getDuracao() {
        return duracao;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public double getEsforco() {
        return esforco;
    }
    
    
    
    
    
}
