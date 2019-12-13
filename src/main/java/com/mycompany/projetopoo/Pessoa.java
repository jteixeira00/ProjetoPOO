/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author dinis
 */
public abstract class Pessoa implements Serializable{
    private String nome;
    private String email;
    private int custo;

    /**
     *Array List tarefa
     */
    protected ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();
    
       
     /**
     *Construtor Pessoa
     * @param nome nome Pessoa
     * @param email email Pessoa
     */
    Pessoa(String nome,String email){
        this.nome = nome;
        this.email = email;
        
    }

    /**
     * Adiciona tarefa à lista de tarefas
     * @param t tarefa
     */
    public void addTarefa(Tarefa t){
       tarefa.add(t);
       
    }
    

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    /**
     *Devolve lista de tarefas do projeto
     * @return ArrayList de tarefas do projeto
     */
    public ArrayList<Tarefa> listarTarefas(){
        return tarefa;
    }
     
    
    
    /**
     *Devolve a carga total do projeto
     * @return carga 
     */
    public double getCarga(){
        double carga = 0;
        for(Tarefa temp: tarefa){
            carga+= temp.getEsforco();
        }
        return carga;
    }


    public int getCusto() {
        return 0;
    }


    public int getNumM() {
        return 0;
    }
    

    public String getEstatuto(){
        return null;
    }
    

    public GregorianCalendar getInicio(){
        return null;
    }


    public GregorianCalendar getFim(){
        return null;
    }
    

    public String getArea(){
        return null;
    }
    

    public abstract void setCoordenador(Pessoa D);          
    
}
