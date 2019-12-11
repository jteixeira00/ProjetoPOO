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
    private GregorianCalendar dataAtual;
    ArrayList<Projeto> projeto = new ArrayList<>();
    ArrayList<Docente> docente = new ArrayList<>();
    ArrayList<Bolseiro> bolseiro = new ArrayList<>();
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    
   

    
    public CISUC(){

        
    }
    
    

   
    public void foraPrazo(){
        for(Projeto temp:projeto){
            if(temp.isfPrazo() == true)
                System.out.println(temp.getNome());
        }    
    }
    
    public void listaConcluidos(){
        for(Projeto temp:projeto){
            if(temp.isCompleto() == true)
                System.out.println(temp.getNome());
        }        
        
    }
    
    public void listaNaoConcluidos(){
        for(Projeto temp:projeto){
            if(temp.isCompleto() == false)
                System.out.println(temp.getNome());
        }  
    }
        
public void leFicheiroProjetos(){
    File f = new File("CISUC.txt");

    String DataI[];
    String DataF[];
    int count = 0;
    Pessoa responsavel = null;
   
   

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            Projeto p = new Projeto(null,null,0,null,null);
            while((line = br.readLine()) != null) {
                switch (line.split("/")[0]) {
                    case "PROJ":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        if(dataf.get(GregorianCalendar.YEAR)==0000 && dataf.get(GregorianCalendar.MONTH)==00 && dataf.get(GregorianCalendar.DAY_OF_MONTH)==00){
                            p = new Projeto(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),line.split("/")[5]);
                        }
                        else{
                            p = new Projeto(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,line.split("/")[5]);
                        }
                        projeto.add(p);

                        break;
                    }
                    case "INV":{
                        for(Docente doc:docente){
                            if(doc.getNumM()==Integer.parseInt(line.split("/")[1])){
                                p.setIP(doc);
                            }
                        }
                        break;
                    }
                    case "DOC":{
                        for(Docente doc:docente){
                            if(doc.getNumM()==Integer.parseInt(line.split("/")[1])){
                                p.addDocente(doc);
                            }
                        }                        
                        break;
                    }
                    case "EST":{
                        for(Bolseiro b:bolseiro){
                            if(b.getEmail().equals(line.split("/")[1])==true){
                                p.addBolseiro(b);
                            }
                        }
                        break;
                    }
                    case "DOCU":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Documentacao(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        break;
                    }
                    case "DESI":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Design(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        break;
                    }                     
                    case "DESE":{
                        DataI = (line.split("/")[2]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:pessoas){
                            if((ps.getEmail().equals(line.split("/")[5])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Desenvolvimento(line.split("/")[1],datai,Integer.parseInt(line.split("/")[3]),dataf,responsavel);
                        p.addTarefa(t);
                        break;
                    }
                    default:
                        break;
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
   }

public void leFicheiroPessoas(){
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
                        docente.add(p);
                        pessoas.add(p);
                            break;
                        }
                    case "LIC":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Bolseiro p = new Licenciado(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
                        pessoas.add(p);
                            break;
                        }
                    case "MES":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Bolseiro p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
                        pessoas.add(p);
                            break;
                        }
                    case "DOU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Bolseiro p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
                        pessoas.add(p);
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
}

public ArrayList<Projeto> getListaProjeto(){
    
    return projeto;
}


public ArrayList<String> getNomesPessoas(){
    ArrayList<String> list = new ArrayList<String>();
    
    for(Pessoa temp: pessoas){
        list.add(temp.getNome());
        
    }
    
    
    return list;
}
    
    


  
public boolean ObjectCheck() throws IOException{
    File f = new File("Pessoas.obj");

    try { 
        FileInputStream fis = new FileInputStream(f); 
    } catch (FileNotFoundException ex) { 
        return false; 
    }
    return true;
    
}
    

public int leObjectFilesBolseiros(){
    try {
            FileInputStream fis = new FileInputStream("Bolseiros.obj");
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

public int leObjectFilesDocentes(){
    try {
            FileInputStream fis = new FileInputStream("Docentes.obj");
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
        for(Bolseiro b:bolseiro){
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
        for(Docente d:docente){
            oos.writeObject(d);
        }
        oos.close(); 
    } catch (FileNotFoundException ex) { 
        System.out.println("Erro a criar ficheiro."); 
    } catch (IOException ex) { 
        System.out.println("Erro a escrever para o ficheiro."); 
    } 
    
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        
        try {
            GUI gui = new GUI(cisuc);
           if(cisuc.ObjectCheck() == false){
                cisuc.leFicheiroPessoas();
                cisuc.leFicheiroProjetos();  
            }
           else{
               cisuc.leObjectFilesDocentes();
               cisuc.leObjectFilesBolseiros();
               cisuc.leObjectFilesProjetos();
            }
        } catch (IOException ex) {
            System.out.println("IOException caught; Main");
        }
        cisuc.SaveObjectFilesBolseiros();
        cisuc.SaveObjectFilesBolseiros();
        cisuc.SaveObjectFilesProjetos();
        
    }
    
}
