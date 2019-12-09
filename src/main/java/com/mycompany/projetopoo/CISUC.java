/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projetopoo;
import java.awt.GridLayout;
import java.util.GregorianCalendar; 
import java.util.ArrayList;
import javax.swing.*;
        

/**
 *
 * @author dinis
 */
public class CISUC {
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
    
    public void ListaNaoConcluidos(){
        for(Projeto temp:projeto){
            if(temp.completo == false)
                System.out.println(temp.nome);
        }  
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
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
