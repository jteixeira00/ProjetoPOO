/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projetopoo;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

        

/**
 *
 * @author dinis
 */
public class CISUC extends JFrame implements Serializable {
    private GregorianCalendar dataAtual = new GregorianCalendar();
    protected ArrayList<Projeto> projeto = new ArrayList<>();
    protected ArrayList<Pessoa> pessoas = new ArrayList<>();
    
       
    
   

    
    public CISUC(){

        
    }
    
    public int AlterarDataAtual(int dia,int mes,int ano){
        if(Checkdata(dia,mes,ano) == 0){
            mes = mes - 1;
            dataAtual.set(GregorianCalendar.YEAR,ano);
            dataAtual.set(GregorianCalendar.MONTH,mes);
            dataAtual.set(GregorianCalendar.DAY_OF_MONTH,dia);
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public int Checkdata(int dia,int mes,int ano){
        if((0<mes && mes<13) && (dia>0 & dia<32) && (ano > 0)){
            if((mes==2 && dia<=29))
                return 0;
            else
                return 1;
        }
        return 1;
    }
    
    public int CheckdataGregorian(GregorianCalendar data){
        int ano,mes,dia;
        ano = data.get(GregorianCalendar.YEAR) + 1;
        mes = data.get(GregorianCalendar.MONTH);
        dia = data.get(GregorianCalendar.DAY_OF_MONTH);
        if((0<mes && mes<13) && (dia>0 & dia<32) && (ano > 0) || (mes == 2 && ano > 0 && dia > 0 && dia < 30 && mes > 0 && mes < 13 )){
            return 0;
        }
        return 1;
    }
    
      
    public int BolseiroInProjetos(Pessoa b){
         for(Projeto proj:projeto){
             for(Pessoa bol: proj.getPessoas()){
                 if(bol.getNome().equals(b.getNome()) == true && bol.getCusto() != 0){
                     return 1;
                 }
             }
         }
         return 0;         
    }
    
    public Projeto ProjetoGetter(String nome){
        Projeto P_Null = new Projeto(null,null,0,null,null);
         for(Projeto p:projeto){
            if(nome.equals(p.getNome()) == true){
                return p;
            }
        }
        return P_Null;              
    }
    
    public Pessoa PessoaGetter(String nome){
         for(Pessoa p:pessoas){
            if(nome.equals(p.getNome()) == true){
                return p;
            }
        }                  
         return null;
        }
    
    public Pessoa EmailGetter(String email){
         for(Pessoa p:pessoas){
            if(email.equals(p.getEmail()) == true){
                return p;
            }
        }                  
         return null;
        }

    
    public ArrayList<String> getNomesProjetos(){
        ArrayList<String> nomes = new ArrayList<>();
        for(Projeto p:projeto){
            nomes.add(p.getNome());
        }
        return nomes;
    }
    
    public ArrayList<String> getNomesProjetosIncompletos(){
        ArrayList<String> nomes = new ArrayList<>();
        for(Projeto p:projeto){
            if(p.isCompleto() == false){
                nomes.add(p.getNome());
            }
        }
        return nomes;
    }
    
 

   
    public void foraPrazo(){
        for(Projeto temp:projeto){
            if(temp.isfPrazo() == true)
                System.out.println(temp.getNome());
        }    
    }
    
    public ArrayList<String> listaNomesConcluidos(){
        ArrayList<String> ret = new ArrayList<>();
        for(Projeto temp:projeto){
            if(temp.isCompleto() == true)
                ret.add(temp.getNome());
        }        
        return ret;
    }
    
    public void listaNaoConcluidos(){
        for(Projeto temp:projeto){
            if(temp.isCompleto() == false)
                System.out.println(temp.getNome());
        }  
    }
        
public int leFicheiroProjetos(){
    File f = new File("CISUC.txt");

    String DataI[];
    String DataF[];
    Pessoa responsavel = null;
   
   

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            Projeto p = new Projeto(null,null,0,null,null,null);
            while((line = br.readLine()) != null) {
                switch (line.split("/")[0]) {
                    case "PROJ":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NO PROJETO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        if(line.split("/")[4].equals("null") == true){
                            p = new Projeto(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),line.split("/")[5],this);
                        }
                        else{
                            GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NO PROJETO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                            p = new Projeto(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,line.split("/")[5],this);
                        }
                        projeto.add(p);

                        break;
                    }
                    case "INV":{
                        for(Pessoa doc:pessoas){
                            if(doc.getNumM()==Integer.parseInt(line.split("/")[1])){
                                p.addPessoa(doc);
                            }
                        }
                        break;
                    }
                    case "DOC":{
                        for(Pessoa doc:pessoas){
                            if(doc.getNumM()==Integer.parseInt(line.split("/")[1])){
                                p.addPessoa(doc);
                            }
                        }                        
                        break;
                    }
                    case "EST":{
                        for(Pessoa b:pessoas){
                            if(b.getEmail().equals(line.split("/")[1])==true){
                                p.addPessoa(b);
                                if(b.getCusto() == 800 || b.getCusto() == 1200){
                                   for(String coor:line.split("/")[2].split("-")){
                                       if(this.EmailGetter(coor) == null){
                                           System.out.println("ERRO NO FICHEIRO: EMAIL DE COORDENADOR NÃO EXISTE");
                                       }else if(this.EmailGetter(coor).getCusto() != 0){
                                           System.out.println("ERRO NO FICHEIRO: EMAIL DE COORDENADOR NÃO PERTENCE A UM DOCENTE");

                                       }else{
                                            b.setCoordenador(this.EmailGetter(coor));
                                       }            
                                        
                                   }
                                    
                                }
                            }
                        }
                        break;
                    }
                    case "DOCU":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        
                        
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NA TAREFA DE DOCUMENTACAO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        if(line.split("/")[4].equals("null") == true){

                            int taxa = Integer.parseInt(line.split("/")[6]);
                            Tarefa t = new Documentacao(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),responsavel,taxa);
                            p.addTarefa(t);
                        }
                        else{
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));                        
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NA TAREFA DE DOCUMENTACAO"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        Tarefa t = new Documentacao(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        }
                        break;
                    }
                    case "DESI":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NA TAREFA DE Design "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        if(line.split("/")[4].equals("null") == true){

                            int taxa = Integer.parseInt(line.split("/")[6]);

                            Tarefa t = new Design(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),responsavel,taxa);
                            
                            p.addTarefa(t);
                        }
                        else{
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));                        
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NA TAREFA DE DESIGN"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        Tarefa t = new Design(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        }
                        break;
                    }                     
                    case "DESE":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NA TAREFA DE DESENVOLVIMENTO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        if(line.split("/")[4].equals("null") == true){

                            int taxa = Integer.parseInt(line.split("/")[6]);

                            Tarefa t = new Desenvolvimento(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),responsavel,taxa);
                            p.addTarefa(t);
                        }
                        else{
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));                        
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NA TAREFA DE DESENVOLVIMENTO"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        Tarefa t = new Desenvolvimento(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        }
                        break;
                    }
                }
                   
            }
            br.close();
            
        
        }catch (FileNotFoundException ex) { 
            System.out.println("Erro a abrir ficheiro de texto: projetos:"); 
        } catch (IOException ex) { 
            System.out.println("Erro a ler ficheiro de texto: projetos."); 
        } 
    } else { 
        System.out.println("Ficheiro não existe: projetos."); 
    }
    return 0;
   }

public int leFicheiroPessoas(){
    File f = new File("Pessoas.txt");
    String DataI[];
    String DataF[];
    

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                switch (line.split("/")[0]) {
                    case "DOC":{
                        Docente p = new Docente(line.split("/")[1],line.split("/")[2],Integer.parseInt(line.split("/")[3]),line.split("/")[4]);
                        pessoas.add(p);
                            break;
                        }
                    case "LIC":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NO LICENCIADO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NO LICENCIADO"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        Bolseiro p = new Licenciado(line.split("/")[1],line.split("/")[2],datai,dataf);
                        pessoas.add(p);
                            break;
                        }
                    case "MES":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Bolseiro p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        pessoas.add(p);
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NO MESTRE "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NO MESTRE"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                            break;
                        }
                    case "DOU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Bolseiro p = new Doutorado(line.split("/")[1],line.split("/")[2],datai,dataf);
                        pessoas.add(p);
                        if(CheckdataGregorian(datai)==1){
                            System.out.println("DATA INICIAL INVALIDA NO DOUTORADO "+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                        if(CheckdataGregorian(dataf)==1){
                            System.out.println("DATA FINAL INVALIDA NO DOUTORADO"+line.split("/")[1]+": LEITURA DO FICHEIRO");
                            return 1;
                        }
                            break;
                        }
                    default:
                        break;
                }
            }                  
            br.close();
        }catch (FileNotFoundException ex) { 
            System.out.println("Erro a abrir ficheiro de texto: pessoas"); 
        } catch (IOException ex) { 
            System.out.println("Erro a ler ficheiro de texto: pessoas."); 
        } 
    } else { 
        System.out.println("Ficheiro não existe: pessoas."); 
    }
    return 0;
}

public ArrayList<Projeto> getListaProjeto(){
    
    return projeto;
}


public ArrayList<String> getNomesPessoas(){
    ArrayList<String> list = new ArrayList<>();
    
    for(Pessoa temp: pessoas){
        list.add(temp.getNome());
        
    }
    
    
    return list;
}
    
    


  
public boolean ObjectCheck() throws IOException{
    File bol = new File("Bolseiros.OBJ");
    File doc = new File("Docentes.OBJ");
    File proj = new File("Projetos.OBJ");
    
    if(bol.exists() && doc.exists() && proj.exists()){
        return true;
        
    }
    
    return false;
}

public String getInfo(Pessoa p){
    String info;
    if(p.getCusto() != 0){
        info = String.format("Nome: %s\nEstatuto: %s\nEmail: %s\nInicio da Bolsa: %d-%d-%d\nFim da Bolsa: %d-%d-%d\nCusto: %d",p.getNome(),p.getEstatuto(),p.getEmail(),p.getInicio().get(GregorianCalendar.DAY_OF_MONTH),p.getInicio().get(GregorianCalendar.MONTH)+1,p.getInicio().get(GregorianCalendar.YEAR),p.getFim().get(GregorianCalendar.DAY_OF_MONTH),p.getFim().get(GregorianCalendar.MONTH)+1,p.getFim().get(GregorianCalendar.YEAR),p.getCusto());
    }
    else{
        info = String.format("Nome: %s\nEstatuto: %s\nEmail: %s\nNúmero Mecanográfico: %d\nÁrea de investigação: %s",p.getNome(),p.getEstatuto(),p.getEmail(),p.getNumM(),p.getArea());
    }    
    return info;
}

public String getInfoProjetos(Projeto p){
    String info;
    if(p.getCompleto() == true){
        info = String.format("Nome: %s\nAcrónimo: %s\nData de Inicio: %d-%d-%d\nDuração: %d\nData Final: %d-%d-%d\nPessoas:",p.getNome(),p.getAcronimo(),p.getData_inicio().get(GregorianCalendar.DAY_OF_MONTH),p.getData_inicio().get(GregorianCalendar.MONTH)+1,p.getData_inicio().get(GregorianCalendar.YEAR),p.getData_final().get(GregorianCalendar.DAY_OF_MONTH),p.getData_final().get(GregorianCalendar.MONTH)+1,p.getData_final().get(GregorianCalendar.YEAR),p.getDuracao());
    }
    else{
        info = String.format("Nome: %s\nAcrónimo: %s\nData de Inicio: %d-%d-%d\nDuração: %d\n",p.getNome(),p.getAcronimo(),p.getData_inicio().get(GregorianCalendar.DAY_OF_MONTH),p.getData_inicio().get(GregorianCalendar.MONTH)+1,p.getData_inicio().get(GregorianCalendar.YEAR),p.getDuracao());
    }
    for(Pessoa ps:p.getPessoas()){
        info = info + "\n" + ps.getNome();
    }
    return info;
}

public String getInfoTarefas(Tarefa p){
    String info;
    if(p.getTaxa() == 1){
        info = String.format("Nome: %s\nTipo: %s\nData de Inicio: %d-%d-%d\nTaxa: 100\nEsforço: %f\nData Final: %d-%d-%d\nResponsavel: %s\n",p.getNome(),p.getTipo(),p.getInicioD().get(GregorianCalendar.DAY_OF_MONTH),p.getInicioD().get(GregorianCalendar.MONTH)+1,p.getInicioD().get(GregorianCalendar.YEAR),p.getEsforco(),p.getFinalD().get(GregorianCalendar.DAY_OF_MONTH),p.getFinalD().get(GregorianCalendar.MONTH)+1,p.getFinalD().get(GregorianCalendar.YEAR),p.getResponsavel().getNome());
    }
    else{
        info = String.format("Nome: %s\nTipo: %s\nData de Inicio: %d-%d-%d\nTaxa: %d\nEsforço: %f\nResponsavel: %s\n",p.getNome(),p.getTipo(),p.getInicioD().get(GregorianCalendar.DAY_OF_MONTH),p.getInicioD().get(GregorianCalendar.MONTH)+1,p.getInicioD().get(GregorianCalendar.YEAR),p.getTaxa(),p.getEsforco(),p.getResponsavel().getNome());
    }    
    return info;
}
    

public int leObjectFilesBolseiros(){
    try {
            FileInputStream fis = new FileInputStream("Bolseiros.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){ 
                try{
                    pessoas.add((Bolseiro)ois.readObject());   
                }catch (ClassNotFoundException ex) {
                    System.out.println("Erro a converter objeto");
                }catch (EOFException ex){
                    ois.close();
                    return 0;
                }
            }
    }catch (FileNotFoundException ex) {
        System.out.println("Erro a abrir ficheiro.");
    }catch (IOException ex) {
        System.out.println("Erro a ler ficheiro.");          
    }
    return 1;
}

public int leObjectFilesDocentes(){
    try {
            FileInputStream fis = new FileInputStream("Docentes.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){ 
                try{

                    pessoas.add((Docente)ois.readObject());   


                }catch (ClassNotFoundException ex) {
                    System.out.println("Erro a converter objeto");
                }catch (EOFException ex){
                    ois.close();
                    return 0;
                }
            }
    }catch (FileNotFoundException ex) {
        System.out.println("Erro a abrir ficheiro.");
    }catch (IOException ex) {
        System.out.println("Erro a ler ficheiro.");          
    }
    return 1;
}
    

public int leObjectFilesProjetos(){
    try {
            FileInputStream fis = new FileInputStream("Projetos.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){ 
                try{
                    projeto.add((Projeto)ois.readObject());   

                }catch (ClassNotFoundException ex) {
                    System.out.println("Erro a converter objeto");
                }catch (EOFException ex){
                    ois.close();
                    return 0;
                }
            }
    }catch (FileNotFoundException ex) {
        System.out.println("Erro a abrir ficheiro.");
    }catch (IOException ex) {
        System.out.println("Erro a ler ficheiro.");          
    }
    return 1;
}

public void SaveObjectFilesProjetos(){
    File f = new File("Projetos.obj");
    try { 
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Projeto p:projeto){
            oos.writeObject(p);
        }
        oos.close(); 
    } catch (FileNotFoundException ex) { 
        System.out.println("Erro a criar ficheiro."); 
    } catch (IOException ex) { 
        System.out.println("Erro a escrever para o ficheiro."); 
    }    
}

public void SaveObjectFilesBolseiros(){
    File f = new File("Bolseiros.obj");
    try { 
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Pessoa b:pessoas){
            if (b.getCusto() != 0)
                oos.writeObject(b);
        }
        oos.close(); 
    } catch (FileNotFoundException ex) { 
        System.out.println("Erro a criar ficheiro."); 
    } catch (IOException ex) { 
        System.out.println("Erro a escrever para o ficheiro."); 
    } 
    
}

public void SaveObjectFilesDocentes(){
    File f = new File("Docentes.obj");
    try { 
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Pessoa d:pessoas){
            if (d.getCusto() == 0)
                oos.writeObject(d);
        }
        oos.close(); 
    } catch (FileNotFoundException ex) { 
        System.out.println("Erro a criar ficheiro."); 
    } catch (IOException ex) { 
        System.out.println("Erro a escrever para o ficheiro."); 
    }     
}

    public GregorianCalendar getDataAtual() {
        return dataAtual;
    }
    
    

    public ArrayList<Projeto> getProjeto() {
        return projeto;
    }

//    public ArrayList<Docente> getDocente() {
//        return docente;
//    }

//    public ArrayList<Bolseiro> getBolseiro() {
//        return bolseiro;
//    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    public static void Exit(CISUC cisuc){
        cisuc.SaveObjectFilesBolseiros();
        cisuc.SaveObjectFilesDocentes();
        cisuc.SaveObjectFilesProjetos();
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        int ErroFichPessoas = 0;
        int ErroFichProjetos = 0;
        
        try {
            
           if(cisuc.ObjectCheck() == false){
                
                ErroFichPessoas = cisuc.leFicheiroPessoas();
                ErroFichProjetos = cisuc.leFicheiroProjetos();  
            }
           else{
               cisuc.leObjectFilesDocentes();
               cisuc.leObjectFilesBolseiros();
               cisuc.leObjectFilesProjetos();
            }
        } catch (IOException ex) {
            System.out.println("IOException caught: Main");
        }
        

        for(Projeto p:cisuc.projeto){
            System.out.println("Projeto "+p.getNome());
            System.out.println("++++++++++++++++++");
            for(Pessoa pessoa:p.getPessoas()){
                System.out.println(cisuc.getInfo(pessoa));
                System.out.println("-------------------");
            }
        }
        
        
        GUI gui = new GUI(cisuc);

        
        //if(ErroFichPessoas == 0 && ErroFichProjetos == 0)
            //Exit(cisuc);
        
    }
    
}
