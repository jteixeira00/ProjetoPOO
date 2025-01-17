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
public class Design extends Tarefa{

    /**
     * Construtor Design
     * @param nome Nome Design
     * @param inicioD Data Inicial Design
     * @param duracaoEstimada Duração Design
     * @param finalD Data Final Design
     * @param responsavel Pessoa Responsavel Design
     */
    public Design(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);        
    }

    /**
     * Construtor Design, caso não seja dada a data final, tem de ser introduzida a taxa
     * @param nome Nome Design
     * @param inicioD Data Inicial Design
     * @param duracaoEstimada Duração Design
     * @param responsavel Pessoa Responsavel Design
     * @param taxa Taxa Design
     */
    public Design(String nome,GregorianCalendar inicioD,int duracaoEstimada,Pessoa responsavel,int taxa){
        super(nome,inicioD,duracaoEstimada,responsavel,taxa);       
    }
    @Override
    public double getEsforco() {
        return 0.5;
    } 

    @Override
    public String getTipo(){
        return "Design";
    }
}
    

