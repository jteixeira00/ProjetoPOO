/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author dinis
 */
public class Licenciado extends Bolseiro{
    int custo = 800;
    ArrayList<Docente> tarefa = new ArrayList<Docente>();
    
    Licenciado(GregorianCalendar InicioB,GregorianCalendar FimB){
        super(InicioB,FimB);
    }
            
    @Override
    public int getCusto() {
        return custo;
    }
    
}