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
    
    

    public ArrayList<Tarefa> ListarTarefas(){
        for(Tarefa temp: tarefa){
            System.out.println(temp);
        }
        return tarefa;
    }
    
    
    void CriarInformatica(){        
        
    }
    

    public int EliminarTarefa(Tarefa temp){
        if (tarefa.indexOf(temp) == -1){
            return 0;                       
        }
        
        else{
            tarefa.remove(temp);
            return 1;
        }
        
    }
    
    public ArrayList<Tarefa> ListarNaoIniciadas(){
        ArrayList<Tarefa> nIniciadas = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()==0){
                nIniciadas.add(temp);
            }
        }
        return nIniciadas;
       
    }
    
    public ArrayList<Tarefa> ListarFPrazo(GregorianCalendar dataHoje){
        ArrayList<Tarefa> fprazo = new ArrayList<>();
        
        for(Tarefa temp: tarefa){
            if(dataHoje.after(temp.getDataEstimada()) && (temp.getTaxa()!=100)){
                fprazo.add(temp);
            }
            else if(temp.getFinalD().after(temp.getDataEstimada())){
                fprazo.add(temp);
            }
        }
        return fprazo;            
    }
    
    public ArrayList<Tarefa> ListarConcluidas(){
        ArrayList<Tarefa> Concluidas = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()!=100){
                Concluidas.add(temp);
            }
        }
        return Concluidas;
        
    }
    
    public ArrayList<Tarefa> NaoConcluidas(){
        ArrayList<Tarefa> nConcluida = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()!=100){
                nConcluida.add(temp);
            }
        }
        return nConcluida;
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
