/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;


/**
 * 
 * @author dinis
 */
public class Projeto implements Serializable{
    private String nome;
    private String acronimo;
    private GregorianCalendar data_inicio;
    private GregorianCalendar data_final;
    private int duracao;

    /**
     *ArrayList de tarefas
     */
    protected ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();

    /**
     *ArrayList de pessoas
     */
    protected ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();   
    private Pessoa investigadorP;
    private boolean completo = false;
    private boolean fPrazo = false;
    private int custo;
    CISUC cisuc;
  
    /**
     *Construtor do Projeto
     * @param nome
     * @param data_inicio
     * @param duracao
     * @param data_final
     * @param acronimo
     * @param cisuc
     */
    public Projeto(String nome,GregorianCalendar data_inicio,int duracao,GregorianCalendar data_final,String acronimo,CISUC cisuc){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.duracao = duracao;
        this.acronimo = acronimo;
        this.data_final = data_final;
        this.investigadorP = null;
        this.completo = true;
        this.setCompleto();
        this.cisuc = cisuc;
       
    }

    /**
     * Construtor do Projeto caso não seja indicada a data final
     * @param nome
     * @param data_inicio
     * @param duracao
     * @param acronimo
     * @param cisuc
     */
    public Projeto(String nome,GregorianCalendar data_inicio,int duracao,String acronimo,CISUC cisuc){
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.duracao = duracao;
        this.acronimo = acronimo;
        this.investigadorP = null;
        this.cisuc = cisuc;

    }

    /**
     * Devolve a tarefa com o mesmo nome
     * @param nome
     * @return Tarefa
     */
    public Tarefa tarefaGetter(String nome){
        for(Tarefa temp: tarefa){
            if(temp.getNome() == nome){
                return temp;
            }
        }        
        return null;
    }
    
    /**
     * Devolve Array List de strings com os nomes das tarefas não incializadas
     * @return Array List de strings
     */
    public ArrayList<String> NomesTarefasInicializadas(){
        ArrayList<String> nomes = null;
        for(Tarefa t:tarefa){
            if(t.getTaxa() == 0){
                nomes.add(t.getNome());
            }
        }
        return nomes;
    }
    
    /**
     * Elimina a tarefa da arraylist do projeto e da arraylist da pessoa correspondente
     * @param t
     */
    public void EliminarTarefa(Tarefa t){
        for(Pessoa p:pessoa){
            for(Tarefa tar:p.listarTarefas()){
            if(t.getNome().equals(tar.getNome())==true){
                p.listarTarefas().remove(tar);
            }                
            }
        }
        for(Tarefa tar:tarefa){
            if(t.getNome().equals(tar.getNome())==true){
                tarefa.remove(tar);
            }
        }                
    }
    
    /**
     * Devolve Array List de strings com os nomes das tarefas completas
     * @return Array List de strings
     */
    public ArrayList<String> NomesTarefasCompletas(){
        ArrayList<String> nomes = null;
        for(Tarefa t:tarefa){
            if(t.getTaxa() == 100){
                nomes.add(t.getNome());
            }
        }
        return nomes;
    }
    
    /**
     * Coloca a tarefa como completa na arraylist do projeto e na arraylist da pessoa correspondente
     * @param t
     */
    public void setTarefaCompleta(Tarefa t){
        t.setCompleto();
        t.setDataF(cisuc.getDataAtual());
        for(Pessoa p:pessoa){
            for(Tarefa tar:p.listarTarefas()){
            if(t.getNome().equals(tar.getNome())==true){
                tar.setCompleto();
                
            }                
            }
        }
    }
    
    /**
     * Coloca a dataFinal do projeto como a data atual (caso não tenha a data final) e coloca completo a true
     */
    public void setProjetoCompleto(){
        if(completo != true){
            data_final = cisuc.getDataAtual();
            completo = true;
        }
    }
   

    public void addTarefa(Tarefa t){
        tarefa.add(t);
    }
    

    public void addDocente(Docente d){
        pessoa.add(d);       
    }
        
 
    public void addBolseiro(Bolseiro b){
        pessoa.add(b);       
    }
    
    /**
     *Se tiver investigador principal não o adiciona
     * @param d
     * @return 1 se tiver investigador principal
     */
    public int setIP(Docente d){
        if(investigadorP == null){
            this.investigadorP = d;
            System.out.println("Já tem um ivestigador principal");
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
    
    /**
     * Cria uma array list de strings com os nomes dos projetos em fora de brazo 
     * @return ArrayList de Strings
     */
    public ArrayList<String> ForaPrazo(){
        ArrayList<String> nomes = null;
        for(Tarefa t:tarefa){
            if(t.getTaxa() != 100){
                if((t.getInicioD().get(GregorianCalendar.MONTH) + 1 + (t.getInicioD().get(GregorianCalendar.YEAR)*12)  + t.getDuracaoEstimada() < cisuc.getDataAtual().get(GregorianCalendar.MONTH) + 1 + (cisuc.getDataAtual().get(GregorianCalendar.YEAR)*12)))
                    nomes.add(t.getNome());
                }
            else{
                if((t.getInicioD().get(GregorianCalendar.MONTH) + 1 + (t.getInicioD().get(GregorianCalendar.YEAR)*12)  + t.getDuracaoEstimada() < t.getFinalD().get(GregorianCalendar.MONTH) + (t.getFinalD().get(GregorianCalendar.YEAR)*12))){
                   nomes.add(t.getNome()); 
                }
            }
           
        
        }
        
        return nomes;
    }
    
    /**
     * 
     * @param p
     * @return
     */
    public int addPessoa(Pessoa p){
        if(p.getCusto() != 0){
            for(Projeto proj: cisuc.getProjeto()){
                for(Pessoa pess: proj.getPessoas()){
                    if(pess.getNome().equals(p.getNome())){
                        return 1;
                    }
                }
            }
            pessoa.add(p);
        }else{
            for(Pessoa pess:pessoa){
                    if(pess.getNome().equals(p.getNome())){
                        return 1;
                    }
                    else{
                        pessoa.add(p);
                    }
            }
        }       
        return 0;
     }
     
    /**
     *
     * @param T
     * @param p
     * @return
     */
    public int CriarTarefa(Tarefa T,Pessoa p){
        double carga = T.getEsforco();
        for(Tarefa t:p.listarTarefas()){
           carga += t.getEsforco();
           if(carga > 1){
               return 1;
           }
        }
        p.listarTarefas().add(T);
        this.tarefa.add(T);
        return 0;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getNomesPessoas(){
        ArrayList<String> nomes = new ArrayList<>();
        for(Pessoa b:pessoa){
            nomes.add(b.getNome());
        }
        return nomes;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getNomesTarefas(){
        ArrayList<String> nomes = new ArrayList<>();
        for(Tarefa b:tarefa){
            nomes.add(b.getNome());
        }
        return nomes;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tarefa> ListarNaoIniciadas(){
        ArrayList<Tarefa> nIniciadas = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()==0){
                nIniciadas.add(temp);
            }
        }
        return nIniciadas;
       
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Tarefa> ListarFPrazo(){
        ArrayList<Tarefa> fprazo = new ArrayList<>();
        GregorianCalendar dataHoje = cisuc.getDataAtual();
        
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
    
    /**
     *
     */
    public void setCompleto(){
        completo = true;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Tarefa> ListarConcluidas(){
        ArrayList<Tarefa> Concluidas = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()!=100){
                Concluidas.add(temp);
            }
        }
        return Concluidas;
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Tarefa> NaoConcluidas(){
        ArrayList<Tarefa> nConcluida = new ArrayList<>();
        for(Tarefa temp: tarefa){
            if(temp.getTaxa()!=100){
                nConcluida.add(temp);
            }
        }
        return nConcluida;
    }
    
    /**
     *
     * @return
     */
    public int CustoP(){
        int custoMensal =0;
        int custoFinal;
        for (Pessoa b: pessoa){   
            if(b.getCusto()!=0)
                custoMensal += b.getCusto();
        }
        if((data_inicio.get(GregorianCalendar.MONTH) + (data_inicio.get(GregorianCalendar.YEAR)*12)  + duracao <= cisuc.getDataAtual().get(GregorianCalendar.MONTH) + 1 + (cisuc.getDataAtual().get(GregorianCalendar.YEAR)*12))){
            custoFinal = custoMensal * (((cisuc.getDataAtual().get(GregorianCalendar.YEAR) - data_inicio.get(GregorianCalendar.YEAR))*12)+cisuc.getDataAtual().get(GregorianCalendar.MONTH) + 1 - data_inicio.get(GregorianCalendar.MONTH) + 1);
            
        }else{
            custoFinal = custoMensal * this.duracao;
        }
        return custoFinal;
    }
    
    void TerminarP(){
        GregorianCalendar dataHoje = new GregorianCalendar();
        this.data_final = dataHoje;
        this.completo = true;     

        
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getData_inicio() {
        return data_inicio;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getData_final() {
        return data_final;
    }

    /**
     *
     * @return
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefa;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pessoa> getPessoas() {
        return pessoa;
    }
    
    /**
     *
     * @return
     */
    public Pessoa getInvestigadorP() {
        return investigadorP;
    }

    /**
     *
     * @return
     */
    public boolean isCompleto() {
        return completo;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getDataEstimada(){
        GregorianCalendar data;
        data = (GregorianCalendar)data_inicio.clone();
        
        
        data.add((GregorianCalendar.MONTH), duracao);
        return data;
        
        
    }

    /**
     *
     * @return
     */
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
    
    /**
     *
     * @return
     */
    public int getCusto() {
        custo = this.CustoP();
        return custo;
    }
    
    /**
     *
     * @return
     */
    public boolean getCompleto(){
        return completo;
    }  
    
    
}
