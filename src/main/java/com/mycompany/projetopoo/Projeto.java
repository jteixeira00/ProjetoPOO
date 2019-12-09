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
public class Projeto extends CISUC{
    String nome;
    String acronimo;
    GregorianCalendar data_inicio;
    GregorianCalendar data_final;
    int duracao;
    ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();
    ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
    Pessoa investigadorP;
    boolean completo;
    boolean fPrazo;
    int custo;
    
    Projeto(String nome,GregorianCalendar data_inicio,int duracao,GregorianCalendar data_final){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_inicio = data_final;
        this.duracao = duracao;
        
    }
    
    
    void ListarTarefas(){
                
    }
    
    void CriarInformatica(){
        
    }
    
    void EliminarTarefa(){
        
    }
    
    void ListarNaoIniciadas(){
       
    }
    
    void ListarFPrazo(){
        
    }
    
    void ListarConcluidas(){
        
    }
    
    void CustoP(){
        
    }
    
    void TerminarP(){
        
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
