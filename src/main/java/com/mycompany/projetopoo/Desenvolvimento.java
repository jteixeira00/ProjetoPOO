/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.util.GregorianCalendar;

/**
 * @author Dinis Carvalho 2018278118
 * @author João Teixeira 2018278532
 */
public class Desenvolvimento extends Tarefa{
    
    /**
     * Construtor Desenvolvimento
     * @param nome Nome Desenvolvimento
     * @param inicioD Data Inicial Desenvolvimento
     * @param duracaoEstimada Duração Desenvolvimento
     * @param finalD Data Final Desenvolvimento
     * @param responsavel Pessoa Responsavel Desenvolvimento
     */
    public Desenvolvimento(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD, Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);   
        
    }

    /**
     * Construtor Desenvolvimento caso não seja dada a data final, tem de ser introduzida a taxa
     * @param nome Nome Desenvolvimento
     * @param inicioD Data Inicial Desenvolvimento
     * @param duracaoEstimada Duração Desenvolvimento
     * @param responsavel Pessoa Responsavel Desenvolvimento
     * @param taxa Taxa Desenvolvimento
     */
    public Desenvolvimento(String nome,GregorianCalendar inicioD,int duracaoEstimada,Pessoa responsavel,int taxa){
        super(nome,inicioD,duracaoEstimada,responsavel,taxa);     
    }
    
    @Override
    public double getEsforco() {
        return 1;
    }
    
    @Override
    public String getTipo(){
        return "Desenvolvimento";
    }
    
}
