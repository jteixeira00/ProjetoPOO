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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.GregorianCalendar; 
import java.util.ArrayList;

import javax.swing.*;

        

/**
 *
 * @author dinis
 */
public class CISUC extends JFrame implements Serializable {
    private GregorianCalendar dataAtual;
    ArrayList<Projeto> projeto = new ArrayList<>();
    ArrayList<Pessoa> docente = new ArrayList<>();
    ArrayList<Pessoa> bolseiro = new ArrayList<>();
    
    
    //interface
    JFrame mainFrame;
    JPanel mainPanel;
    JButton criarProjeto, gerirProjeto,listaAtivos, listaIncompletos,listaConcluidos;
    
    
    
    public CISUC(){
        //interface
        //mainFrame = new JFrame();
        super("Cenas");
        setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,3));
        
        criarProjeto = new JButton("Criar Projeto");
        mainPanel.add(criarProjeto);
        
        //criarProjeto.addActionListener(new botaoCriarProjetoListener());
    
        gerirProjeto = new JButton("Gerir Projeto");
        mainPanel.add(gerirProjeto);  
        
        listaAtivos = new JButton("Listar Projetos Ativos");
        mainPanel.add(listaAtivos); 
        
        listaIncompletos = new JButton("Listar Projetos por Concluir");
        mainPanel.add(listaIncompletos);
        
        listaConcluidos = new JButton("Listar Projetos Concluídos");
        mainPanel.add(listaConcluidos);
        setSize(800, 500);
        add(mainPanel);
        setVisible(true);
        
    }
    
    
  
    
    private class botaoCriarProjetoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JFrame frame = new JFrame("Criar Projeto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            
        }
        
        
        
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
   

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                DataI = (line.split("/")[1]).split("-");
                DataF = (line.split("/")[3]).split("-");
                GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                Projeto p = new Projeto(line.split("/")[0],datai,Integer.parseInt(line.split("/")[2]),dataf);
                projeto.add(p);
                
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
                        Pessoa p = new Docente(line.split("/")[1],line.split("/")[2],Integer.parseInt(line.split("/")[3]),line.split("/")[4]);
                        docente.add(p);
                            break;
                        }
                    case "LIC":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Licenciado(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
                            break;
                        }
                    case "MES":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
                            break;
                        }
                    case "DOU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        bolseiro.add(p);
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

public void leFicheiroTarefas(){
    File f = new File("Tarefas.txt");
    String DataI[];
    String DataF[];


    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            Pessoa responsavel = null;
         
            while((line = br.readLine()) != null) {
                switch (line.split("/")[0]) {
                    case "DOCU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[5]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:bolseiro){
                            if((ps.getNome().equals(line.split("/")[6])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Documentacao(line.split("/")[2],datai,Integer.parseInt(line.split("/")[4]),dataf,responsavel);
                        for(Projeto p:projeto){
                            if(p.getNome().equals(t.getNome())==true){
                                p.addTarefa(t);                            
                            }                            
                        }
                        
                            break;
                        }
                    case "DESI":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[5]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:bolseiro){
                            if((ps.getNome().equals(line.split("/")[6])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Documentacao(line.split("/")[2],datai,Integer.parseInt(line.split("/")[4]),dataf,responsavel);
                        for(Projeto p:projeto){
                            if(p.getNome().equals(t.getNome())==true){
                                p.addTarefa(t);                            
                            }                            
                        }
                        
                            break;
                        }                      
                    case "DOU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[5]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        for(Pessoa ps:bolseiro){
                            if((ps.getNome().equals(line.split("/")[6])) == true){
                                responsavel = ps;
                            }
                        }
                        Tarefa t = new Documentacao(line.split("/")[2],datai,Integer.parseInt(line.split("/")[4]),dataf,responsavel);
                        for(Projeto p:projeto){
                            if(p.getNome().equals(t.getNome())==true){
                                p.addTarefa(t);                            
                            }                            
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
}

    
    /*public void leFicheiroProjetos(){
    File f = new File("CISUC.txt");
    File proj = new File("Projetos.obj");

    String DataI[];
    String DataF[];
   

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            try{
            FileOutputStream fos = new FileOutputStream(proj); 
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            while((line = br.readLine()) != null) {
                DataI = (line.split("/")[1]).split("-");
                DataF = (line.split("/")[3]).split("-");
                GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                Projeto p = new Projeto(line.split("/")[0],datai,Integer.parseInt(line.split("/")[2]),dataf);
                oos.writeObject(p);
            }
            oos.close();                   
            } catch (FileNotFoundException ex) { 
                System.out.println("Erro a criar ficheiro de objetos: projetos."); 
            } catch (IOException ex) { 
                System.out.println("Erro a escrever para o ficheiro objeto: projetos.");
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
   }*/
    
/*public void leFicheiroPessoas(){
    File f = new File("Pessoas.txt");
    File proj = new File("Pessoas.obj");
    String DataI[];
    String DataF[];
    int count = 0;

    if(f.exists() && f.isFile()) { 
        try { 
            FileReader fr = new FileReader(f); 
            BufferedReader br = new BufferedReader(fr);
            String line;
            try{
            FileOutputStream fos = new FileOutputStream(proj); 
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            while((line = br.readLine()) != null) {
                switch (line.split("/")[0]) {
                    case "DOC":{
                        Pessoa p = new Docente(line.split("/")[1],line.split("/")[2],Integer.parseInt(line.split("/")[3]),line.split("/")[4]);
                        oos.writeObject(p);
                        count++;
                            break;
                        }
                    case "LIC":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Licenciado(line.split("/")[1],line.split("/")[2],datai,dataf);
                        oos.writeObject(p);
                        count++;
                            break;
                        }
                    case "MES":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        oos.writeObject(p);
                        count++;
                            break;
                        }
                    case "DOU":{
                        DataI = (line.split("/")[3]).split("-");
                        DataF = (line.split("/")[4]).split("-");
                        GregorianCalendar datai = new GregorianCalendar(Integer.parseInt(DataI[2]),Integer.parseInt(DataI[1]),Integer.parseInt(DataI[0]));
                        GregorianCalendar dataf = new GregorianCalendar(Integer.parseInt(DataF[2]),Integer.parseInt(DataF[1]),Integer.parseInt(DataF[0]));
                        Pessoa p = new Mestre(line.split("/")[1],line.split("/")[2],datai,dataf);
                        oos.writeObject(p);
                        count++;
                            break;
                        }
                    default:
                        break;
                }
            }
            oos.writeInt(count);
            oos.close();                   
            } catch (FileNotFoundException ex) { 
                System.out.println("Erro a criar ficheiro de objetos: pessoas."); 
            } catch (IOException ex) { 
                System.out.println("Erro a escrever para o ficheiro objeto: pessoas.");
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
}*/

/*public void leFicheiroObjPessoa(){
    File f = new File("Pessoas.obj");
    int count;
    try { 
        FileInputStream fis = new FileInputStream(f); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        count = ois.readInt();
        System.out.println(count);
        
        Pessoa person = (Pessoa)ois.readObject(); 
        System.out.println(person.getNome());

        ois.close(); 
    } catch (FileNotFoundException ex) { 
        System.out.println("Erro a abrir ficheiro: pessoas."); 
    } catch (IOException ex) { 
        System.out.println("Erro a ler ficheiro:pessoas."); 
    } catch (ClassNotFoundException ex) 
    { System.out.println("Erro a converter objeto: pessoas."); 
    }

}*/
  
    
    
    
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
       
        cisuc.leFicheiroProjetos();
        cisuc.leFicheiroPessoas();
        
        
        
        
              
        
    }
    
}
