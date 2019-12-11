/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class GUI{
    JFrame mainFrame;
    JPanel mainPanel;
    JButton criarProjeto, gerirProjeto,listaAtivos, listaIncompletos,listaConcluidos;
    CISUC cisuc;
    
    
    
    GUI(CISUC cisuc){
        this.cisuc = cisuc;
        mainFrame = new JFrame("Cenas");
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,3));
        
        
        criarProjeto = new JButton("Criar Projeto");
        criarProjeto.addActionListener(new botaoListener());
        mainPanel.add(criarProjeto);
        
        
    
        gerirProjeto = new JButton("Gerir Projeto");
        gerirProjeto.addActionListener(new botaoListener());
        mainPanel.add(gerirProjeto);  
        
        listaAtivos = new JButton("Listar Projetos Ativos");
        listaAtivos.addActionListener(new botaoListener());
        mainPanel.add(listaAtivos); 
        
        listaIncompletos = new JButton("Listar Projetos por Concluir");
        listaIncompletos.addActionListener(new botaoListener());
        mainPanel.add(listaIncompletos);
        
        listaConcluidos = new JButton("Listar Projetos Concluídos");
        listaConcluidos.addActionListener(new botaoListener());
        mainPanel.add(listaConcluidos);
        mainFrame.setSize(800, 500);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    
    }
      private class botaoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel newPanel = new JPanel();
            if (e.getSource() == criarProjeto){ 
                JFrame newFrame = new JFrame();
                
                newPanel.setLayout(new GridLayout(10,2));
                JLabel labelNome = new JLabel("Nome:");
                JTextField nome = new JTextField(10);
                JLabel labelAcronimo = new JLabel("Acronimo:");
                JTextField acronimo = new JTextField(10);
                JLabel labelDataInicio = new JLabel("Data Inicio (dia/mes/ano):");
                
                JTextField dia = new JTextField(10);
                JTextField mes = new JTextField(10);
                JTextField ano = new JTextField(10);
                JLabel labelETA = new JLabel("Duração Estimada: (meses)");
                JTextField eta = new JTextField(10);
                
                JLabel labelIP = new JLabel("Investigador Principal:");               
                ArrayList<String> lista;
                lista = new ArrayList();
                
                for(Projeto temp: cisuc.projeto){
                    lista.add(temp.getInvestigadorP().getNome());
                }    
                JComboBox listaInvestigadores = new JComboBox(lista.toArray());  
                
                newPanel.add(labelNome);
                newPanel.add(nome);
                newPanel.add(labelAcronimo);
                newPanel.add(acronimo);
                newPanel.add(labelDataInicio);
                newPanel.add(dia);
                newPanel.add(mes);
                newPanel.add(ano);
                newPanel.add(labelETA);
                newPanel.add(eta);
                newPanel.add(labelIP);
                newPanel.add(listaInvestigadores);
                newFrame.add(newPanel);
                newFrame.setSize(800, 500);
                newFrame.add(newPanel);
                newFrame.setVisible(true);
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
               
              
            }
            else if(e.getSource() == gerirProjeto){
                
            }
            
            else if(e.getSource() == listaAtivos){
                
            }
            else if(e.getSource() == listaIncompletos){
                
            }
            
            else if(e.getSource() == listaConcluidos){
                
            }
        }
        
    }
}
