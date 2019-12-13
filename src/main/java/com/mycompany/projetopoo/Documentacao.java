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
    
    /**
     * Construtor Documentação
     * @param nome Nome Documentação
     * @param inicioD Data Inicial Documentação
     * @param duracaoEstimada Duração Documentação
     * @param finalD Data Final Documentação
     * @param responsavel Pessoa Responsavel Documentação
     */
    public Documentacao(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD, Pessoa responsavel){
        super(nome,inicioD,duracaoEstimada,finalD,responsavel);       
    }

    /**
     *Construtor caso não seja dada a data final, tem de ser introduzida a taxa
     * @param nome Nome Documentação
     * @param inicioD Data Inicial Documentação
     * @param duracaoEstimada Duração Documentação
     * @param responsavel Pessoa Responsavel Documentação
     * @param taxa Taxa Documentação
     */
    public Documentacao(String nome,GregorianCalendar inicioD,int duracaoEstimada,Pessoa responsavel,int taxa){
        super(nome,inicioD,duracaoEstimada,responsavel,taxa);       
    }
    
    @Override
    public double getEsforco() {
        return 0.25;
    } 
    
    @Override
    public String getTipo(){
        return "Documentação";
    }
    
}
