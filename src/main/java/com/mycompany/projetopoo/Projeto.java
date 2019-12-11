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
    protected ArrayList<Docente> docente = new ArrayList<Docente>();
    protected ArrayList<Bolseiro> bolseiro = new ArrayList<Bolseiro>();    
    private Pessoa investigadorP;
    private boolean completo = false;
    private boolean fPrazo = false;
    private int custo;
    
    //FALTA ACRONIMO
    
    public Projeto(String nome,GregorianCalendar data_inicio,int duracao,GregorianCalendar data_final,String acronimo){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.duracao = duracao;
        this.acronimo = acronimo;
        this.data_final = data_final;
        this.investigadorP = null;
       
    }
    public Projeto(String nome,GregorianCalendar data_inicio,int duracao,String acronimo){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.duracao = duracao;
        this.acronimo = acronimo;
        this.investigadorP = null;        
    }
   
    
    public void addTarefa(Tarefa t){
        tarefa.add(t);
    }
    
    public void addDocente(Docente d){
        docente.add(d);       
    }
    
    public void addBolseiro(Bolseiro b){
        bolseiro.add(b);       
    }
    
    public int setIP(Docente d){
        if(investigadorP == null){
            this.investigadorP = d;
            return 1;
        }
        return 0;               
    }
    

    public ArrayList<Tarefa> ListarTarefas(){
        for(Tarefa temp: tarefa){
            System.out.println(temp);
        }
        return tarefa;
    }
    
    public int addPessoa(Pessoa p){
        int check =0;
        for(Projeto proj: projeto){
            for(Pessoa pess: proj.getPessoas()){
                if(pess.getNome().equals(p.getNome())){
                    check =1;
                }
            }
        }
        if(check==1){
            return 1;
        }
        else{
            pessoa.add(p);
            return 0;
        }
     
    }
    


    /*public int CriarTarefa(String nome,GregorianCalendar inicioD,int duracaoEstimada,GregorianCalendar finalD,Pessoa responsavel,int tipo){
       double carga =0;
        if(tipo == 1){
            //Desenvolvimento
            
            carga = 1;
            
        }
        if(tipo == 2){
            
            carga = 0.25;
        }
        else{
            
            carga = 0.5;
        }
        
        
        
        if((responsavel.getCarga() + carga) > 1 ){
            return 0; //sobracarregado
        }
        if(tipo == 1){
            //Desenvolvimento
            Desenvolvimento taref;
        }
        if(tipo == 2){
            Documentacao taref;
            
        }
        else{
            Design taref = new Design(inicioD,duracaoEstimada,responsavel);
            
        }
        
        
        return 1;
    }*/

    

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
    
    public ArrayList<Tarefa> ListarFPrazo(){
        ArrayList<Tarefa> fprazo = new ArrayList<>();
        GregorianCalendar dataHoje = new GregorianCalendar();
        
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
    

    public int CustoP(){
        int custoMensal =0;
        int custoFinal;
        for (Pessoa temp: pessoa){
            custoMensal += temp.getCusto();
        }
        custoFinal = custoMensal * this.duracao;
        return custoFinal;
    }
    
    void TerminarP(){
        GregorianCalendar dataHoje = new GregorianCalendar();
        this.data_final = dataHoje;
        this.completo = true;     

        
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

    public ArrayList<Tarefa> getTarefas() {
        return tarefa;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoa;
    }

    public Pessoa getInvestigadorP() {
        return investigadorP;
    }

    public boolean isCompleto() {
        return completo;
    }

    public GregorianCalendar getDataEstimada(){
        GregorianCalendar data;
        data = (GregorianCalendar)data_inicio.clone();
        
        
        data.add((GregorianCalendar.MONTH), duracao);
        return data;
        
        
    }
    public boolean isfPrazo() {
        
        GregorianCalendar dataHoje = new GregorianCalendar();
        
        
            if(dataHoje.after(this.getDataEstimada()) && (this.isCompleto()==false)){
                fPrazo = true;
                return fPrazo;
                
                
            }
            else if(this.getData_final().after(this.getDataEstimada())){
                fPrazo = true;
            }
        
        
        
        fPrazo=true;
        return fPrazo;
    }
    
    public int getCusto() {
        return custo;
    }
    
    
    
    
    
}
