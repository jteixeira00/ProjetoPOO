/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projetopoo;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar; 
import java.util.ArrayList;

        

/**
 *
 * @author dinis
 */
public class CISUC implements Serializable{
    private GregorianCalendar dataAtual;
    ArrayList<Projeto> projeto = new ArrayList<Projeto>();
    ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
    
    
    void CISUC(){
        
    }
    
    public void addProjeto(Projeto p,GregorianCalendar dataAtual){
        projeto.add(p);
        this.dataAtual = dataAtual;   
    }
    
    public void addPessoa(Pessoa p){
        pessoa.add(p);
    }
    public void foraPrazo(){
        for(Projeto temp:projeto){
            if(temp.fPrazo == true)
                System.out.println(temp.nome);
        }    
    }
    
    public void listaConcluidos(){
        for(Projeto temp:projeto){
            if(temp.completo == true)
                System.out.println(temp.nome);
        }        
        
    }
    
    /*public void ListaNaoConcluidos(){
        for(Projeto temp:projeto){
            if(temp.completo == false)
                System.out.println(temp.nome);
        }
    }
        
    public void escreverFicheiroProjeto(){
     File f = new File("CISUC.txt");
     StringBuilder data = 
     GregorianCalendar dataAtual = new GregorianCalendar(2018,01,01);
     String ano = Integer.toString(dataAtual.get(GregorianCalendar.YEAR)); 
     String mes = Integer.toString(dataAtual.get(GregorianCalendar.MONTH)); 
     String dia = Integer.toString(dataAtual.get(GregorianCalendar.DAY_OF_MONTH));
        
      
    
     try { 
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        
        fmt.setCalendar(dataAtual);
        String data = fmt.format(dataAtual.getTime());
        System.out.println(data);

        
        bw.write(data); bw.newLine();
        bw.close(); 
        } catch (IOException ex) { 
            System.out.println("Erro a escrever no ficheiro."); 
        }
    }*/
    
    public void leFicheiroProjetos(){
    File f = new File("CISUC.txt");
    File proj = new File("Projetos.obj");

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
                //Projeto p = new Projeto(line.split("/")[0],datai,Integer.parseInt(line.split("/")[2]),dataf);
                Projeto p = new Projeto("A",datai,5,dataf);
                try { 
                    FileOutputStream fos = new FileOutputStream(proj); 
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(p);
                    oos.close();
                    
                } catch (FileNotFoundException ex) { 
                    System.out.println("Erro a criar ficheiro."); 
                } catch (IOException ex) { 
                    System.out.println("Erro a escrever para o ficheiro objeto."); 
                }
                

            }
            br.close(); 
        } catch (FileNotFoundException ex) { 
            System.out.println("Erro a abrir ficheiro de texto."); 
        } catch (IOException ex) { 
            System.out.println("Erro a ler ficheiro de texto."); 
        } 
    } else { 
        System.out.println("Ficheiro não existe."); 
    }
   }
  
    
    
    
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        cisuc.leFicheiroProjetos();
        
        /*GregorianCalendar dataAtual = new GregorianCalendar(2018,01,01);
        GregorianCalendar dataInicio = new GregorianCalendar(2018,03,02);
        GregorianCalendar dataFinal = new GregorianCalendar(2018,12,05);
        Projeto p = new Projeto("ProjetoPOO",dataInicio,5,dataFinal);
        cisuc.addProjeto(p, dataAtual);
        JFrame frame = new JFrame();
        frame.setTitle("CISUC");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel(p.nome);
        JTextField text1 = new JTextField(10);
        JLabel label2 = new JLabel(String.valueOf((p.data_inicio).month)); 
        JTextField text2 = new JTextField(10); 
        JLabel label3 = new JLabel("Valor 3");
        JTextField text3 = new JTextField(10);
        JButton button = new JButton("Calcular");
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(4, 2)); 
        panel.add(label1); panel.add(text1);
        panel.add(label2); panel.add(text2); 
        panel.add(label3); panel.add(text3);
        panel.add(button);
        frame.add(panel); 
        frame.setVisible(true);*/
        
        
    }
    
}
