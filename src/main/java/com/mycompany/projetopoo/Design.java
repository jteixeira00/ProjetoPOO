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

    /**
     *
     * @param nome
     * @param inicioD
     * @param duracaoEstimada
     * @param finalD
     * @param responsavel
     */
    public Design(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);        
    }

    /**
     * Construtor caso não seja dada a data final, tem de ser introduzida a taxa
     * @param nome
     * @param inicioD
     * @param duracaoEstimada
     * @param responsavel
     * @param taxa
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
    

