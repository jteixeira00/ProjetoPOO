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

    private GregorianCalendar inicioD;
    private GregorianCalendar finalD;
    private int duracaoEstimada;
    private double taxa;
    private String nome;
    private Pessoa responsavel;
    private double esforco;

    
    
    
    
    public Tarefa(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        this.nome=nome;
        this.inicioD = inicioD;
        this.duracaoEstimada = duracaoEstimada;
        this.finalD = finalD;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }
    
    public void atualizarTaxa(int i){
        
    }
    
    public double getTaxa(){
        return taxa;
    }

    public GregorianCalendar getInicioD() {
        return inicioD;
    }

    public GregorianCalendar getFinalD() {
        return finalD;
    }
    
    public int getDuracaoEstimada(){
        return duracaoEstimada;
    }

    public GregorianCalendar getDataEstimada(){
        GregorianCalendar data;
        data = (GregorianCalendar)inicioD.clone();
        
        
        data.add((GregorianCalendar.MONTH), duracaoEstimada);
        return data;
    }
    

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public double getEsforco() {
        return esforco;
    }
    
    
    
    
    
}
