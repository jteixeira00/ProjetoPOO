/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dinis
 */
public class Pessoa implements Serializable{
    private String nome;
    private String email;
    private int custo;
    protected ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();
    
    public void addTarefa(Tarefa t){
        
    }   
    
    public Pessoa(String nome,String email){
        this.nome = nome;
        this.email = email;
        
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public ArrayList<Tarefa> listarTarefas(){
        return tarefa;
    }
    void adicionarTarefa(Tarefa temp){
        tarefa.add(temp);
    }
    
    public int removerTarefa(Tarefa temp){
        
        if (tarefa.indexOf(temp) == -1){
            return 0;                       
        }

        else{
            tarefa.remove(temp);
            return 1;
        }
    }
    
    public double getCarga(){
        double carga = 0;
        for(Tarefa temp: tarefa){
            carga+= temp.getEsforco();
        }
        return carga;
    }

    public int getCusto() {
        return custo;
    }

   
    
    
    
    
    
    
}
