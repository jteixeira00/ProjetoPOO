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
public class Licenciado extends Bolseiro implements Serializable{
    private int custo = 800;
    protected ArrayList<Docente> tarefa = new ArrayList<Docente>();
    
    public Licenciado(String nome,String email,GregorianCalendar InicioB,GregorianCalendar FimB){
        super(nome,email,InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return custo;
    }
    
}