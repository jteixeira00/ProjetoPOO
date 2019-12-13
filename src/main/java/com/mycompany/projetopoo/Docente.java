/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

/**
 * @author Dinis Carvalho 2018278118
 * @author João Teixeira 2018278532
 */
public class Docente extends Pessoa{
    private int numM;
    private String area;

    /**
     *Construtor Docente
     * @param nome Nome Docente
     * @param email Email Docente
     * @param numM Número Mecanográfico Docente
     * @param area Área de Investigação Docente
     */
    public Docente(String nome,String email,int numM,String area){
        super(nome,email);
        this.numM = numM;
        this.area = area;
    }

    @Override
    public int getNumM() {
        return numM;
    }

    public String getArea() {
        return area;
    }
    
    @Override 
    public String getEstatuto(){
        return "Docente";
    }
    
    @Override
    public void setCoordenador(Pessoa D){
        System.out.println("Docentes não tem Coordenadores");             
    }
    
    
    
    

}

