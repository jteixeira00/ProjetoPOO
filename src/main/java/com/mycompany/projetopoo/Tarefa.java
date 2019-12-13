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

public abstract class Tarefa implements Serializable{


    private GregorianCalendar inicioD;
    private GregorianCalendar finalD;
    private int duracaoEstimada;
    private int taxa;
    private String nome;
    private Pessoa responsavel;
    private double esforco;

    

    public Tarefa(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        this.nome=nome;
        this.inicioD = inicioD;
        this.duracaoEstimada = duracaoEstimada;
        this.finalD = finalD;
        this.responsavel = responsavel;
        setCompleto();
    }
    
    public Tarefa(String nome,GregorianCalendar inicioD,int duracaoEstimada,Pessoa responsavel,int taxa){
        this.nome=nome;
        this.inicioD = inicioD;
        this.duracaoEstimada = duracaoEstimada;
        this.responsavel = responsavel;
        this.taxa = taxa;
    }

    public String getNome() {
        return nome;
    }
    
    public void setCompleto(){
        taxa = 100;
    }
    
    public void setDataF(GregorianCalendar data){
        finalD = data;
    }
    
    public void atualizarTaxa(int i){
        taxa = i;
        
    }
    
    public int getTaxa(){
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
    
    public String getTipo(){
        return null;
    }
    //abstract double esforço();
    
}
