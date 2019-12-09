/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;

/**
 *
 * @author dinis
 */
public class Documentacao extends Tarefa implements Serializable{
    double esforco = 0.25;
    
    public double getEsforco() {
        return esforco;
    } 
    
}
