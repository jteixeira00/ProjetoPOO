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
public class Projeto extends CISUC implements Serializable{
    private String nome;
    private String acronimo;
    private GregorianCalendar data_inicio;
    private GregorianCalendar data_final;
    private int duracao;
    protected ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();
    protected ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
    private Pessoa investigadorP;
    private boolean completo;
    private boolean fPrazo;
    private int custo;
    
    public Projeto(String nome,GregorianCalendar data_inicio,int duracao,GregorianCalendar data_final){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_inicio = data_final;
        this.duracao = duracao;
        
    }
    
    
    public void ListarTarefas(){
                
    }
    
    public void CriarInformatica(){
        
    }
    
    public void EliminarTarefa(){
        
    }
    
    public void ListarNaoIniciadas(){
       
    }
    
    public void ListarFPrazo(){
        
    }
    
    public void ListarConcluidas(){
        
    }
    
    public void CustoP(){
        
    }
    
    public void TerminarP(){
        
    }

    public String getNome() {
        return nome;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public GregorianCalendar getData_inicio() {
        return data_inicio;
    }

    public GregorianCalendar getData_final() {
        return data_final;
    }

    public int getDuracao() {
        return duracao;
    }

    public ArrayList<Tarefa> getTarefa() {
        return tarefa;
    }

    public ArrayList<Pessoa> getPessoa() {
        return pessoa;
    }

    public Pessoa getInvestigadorP() {
        return investigadorP;
    }

    public boolean isCompleto() {
        return completo;
    }

    public boolean isfPrazo() {
        return fPrazo;
    }
    
    public int getCusto() {
        return custo;
    }
    
        
    
    
    
    
    
    
    
    
    
    
    
}
