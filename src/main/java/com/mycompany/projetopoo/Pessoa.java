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
    String nome;
    String email;
    int custo;
    ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();
    
    void addTarefa(Tarefa t){
        
    }   
    
    void Pessoa(String nome,String email){
        
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getCusto() {
        return custo;
    }
    
    
    
    
    
    
}
