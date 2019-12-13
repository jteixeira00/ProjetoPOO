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

public abstract class Tarefa implements Serializable{


    private GregorianCalendar inicioD;
    private GregorianCalendar finalD;
    private int duracaoEstimada;
    private int taxa;
    private String nome;
    private Pessoa responsavel;
    private double esforco;

    /**
     *Construtor Tarefa
     * @param nome Nome Tarefa
     * @param inicioD Data Inicial Tarefa
     * @param duracaoEstimada Duracao Tarefa
     * @param finalD Data Final Tarefa
     * @param responsavel Pessoa Responsavel Tarefa
     */
    public Tarefa(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        this.nome=nome;
        this.inicioD = inicioD;
        this.duracaoEstimada = duracaoEstimada;
        this.finalD = finalD;
        this.responsavel = responsavel;
        setCompleto();
    }
    
    /**
     *Construtor Tarefa sem data final, tem de ser introduzida a taxa
     * @param nome Nome Tarefa
     * @param inicioD Data Inicial Tarefa
     * @param duracaoEstimada Duracao Tarefa
     * @param responsavel Pessoa Responsavel Tarefa
     * @param taxa Taxa Tarefa
     */
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
    
    /**
     * coloca a taxa como completa (100)
     */
    public void setCompleto(){
        taxa = 100;
    }
    
    /**
     * Coloca a data final como a data atual
     * @param data Data GregorianCalendar
     */
    public void setDataF(GregorianCalendar data){
        finalD = data;
    }
    
    /**
     *Atualiza a taxa para um valor i
     * @param i Taxa Integer
     */
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

    /**
     *Devolve uma data final estimada 
     * @return GregorianCalendar data 
     */
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
    

    
}
