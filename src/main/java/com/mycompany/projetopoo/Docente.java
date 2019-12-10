/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

/**
 *
 * @author dinis
 */
public class Docente extends Pessoa{
    private int numM;
    private String area;
    public Docente(String nome,String email,int numM,String area){
        super(nome,email);
        this.numM = numM;
        this.area = area;
    }
    
    
   
}

