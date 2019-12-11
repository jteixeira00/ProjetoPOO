/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author User
 */
public class GUI{
    JFrame mainFrame, frameCreateProject, frameGerirProjeto;
    JPanel mainPanel;
    final JButton criarProjeto, gerirProjeto,listaAtivos, listaIncompletos,listaConcluidos;
    JButton confirm;
    JButton addPessoa, listTarefas,eliminaTarefa, atribuiTarefa, atualizaTaxa,calculaCusto, terminaProjeto;
    JTextField nome, acronimo;
    JTextField dia;
    JTextField mes ;
    JTextField ano;
    JTextField eta;
    JComboBox listaInvestigadoresPrinc; 
           
    CISUC cisuc;
    
    
    
    GUI(CISUC cisuc){
        this.cisuc = cisuc;
        mainFrame = new JFrame("Cenas");
        mainFrame.setSize(800, 500);
        
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,3));
        
        
        criarProjeto = new JButton("Criar Projeto");
        criarProjeto.addActionListener(new botaoListener());
        mainPanel.add(criarProjeto);
        
        
    
        gerirProjeto = new JButton("Gerir Projeto");
        gerirProjeto.addActionListener(new botaoListenerEcras());
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
        
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    
    }
      private class botaoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel newPanel = new JPanel();
            
            if (e.getSource() == criarProjeto){ 
                frameCreateProject = new JFrame();
                frameCreateProject.setSize(100, 300);
                frameCreateProject.setResizable(false);
                
                confirm = new JButton("Confirmar");
                confirm.addActionListener(new botaoListenerEcras());
                newPanel.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                JLabel labelNome = new JLabel("Nome:");
                nome = new JTextField(10);
                JLabel labelAcronimo = new JLabel("Acronimo:");
                acronimo = new JTextField(10);
                JLabel labelDataInicio = new JLabel("Data Inicio (dia/mes/ano):");
                dia = new JTextField(2);
                mes = new JTextField(2);
                ano = new JTextField(4);
                JLabel labelETA = new JLabel("Duração Estimada: (meses)");
                eta = new JTextField(10); 
                JLabel labelIP = new JLabel("Investigador Principal:");  
                ArrayList<String> lista;
                lista = new ArrayList();
 
                
                for(Docente temp: cisuc.docente){
                    lista.add(temp.getNome());
                }
                 
                
                listaInvestigadoresPrinc = new JComboBox(lista.toArray());  
                newPanel.add(labelNome);
                newPanel.add(nome);
                newPanel.add(labelAcronimo);
                newPanel.add(acronimo);
                newPanel.add(labelDataInicio);
                newPanel.add(dia, "split 3");
                newPanel.add(mes);
                newPanel.add(ano);
                newPanel.add(labelETA);
                newPanel.add(eta);                
                newPanel.add(labelIP);
                newPanel.add(listaInvestigadoresPrinc);
                frameCreateProject.add(newPanel);               
                frameCreateProject.setSize(800, 500);
                frameCreateProject.add(newPanel);
                newPanel.add(confirm, "cell 1 6");
                mainFrame.setVisible(false);
                frameCreateProject.setVisible(true);
                
                frameCreateProject.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                
               
              
            }
            else if(e.getSource() == gerirProjeto){
                //JButton addPessoa, listTarefas,eliminaTarefa, atribuiTarefa, atualizaTaxa,calculaCusto, terminaProjeto;
                frameGerirProjeto = new JFrame("Gerir Projeto");
                frameGerirProjeto.setResizable(false);
                
                addPessoa = new JButton("Associar Pessoa");
                addPessoa.addActionListener(new botaoListenerEcras());
                
                listTarefas = new JButton("Listar Tarefas");
                listTarefas.addActionListener(new botaoListenerEcras());
                
                calculaCusto = new JButton("Calcular Custo");
                calculaCusto.addActionListener(new botaoListenerEcras());
                
                terminaProjeto = new JButton("Concluir Projeto");
                terminaProjeto.addActionListener(new botaoListenerEcras());
                
                
                
                
                
                
                
            }
            
            else if(e.getSource() == listaAtivos){
                
            }
            else if(e.getSource() == listaIncompletos){
                
            }
            
            else if(e.getSource() == listaConcluidos){
                
            }
            
            
        }
        
    }
      private class botaoListenerEcras implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == confirm){
                mainFrame.setVisible(true);
                frameCreateProject.setVisible(false);
                
                String nomeText =  (String)nome.getText();
                String acronimoText = (String)acronimo.getText();
                int diaT = Integer.parseInt((String)dia.getText());
                int mesT = Integer.parseInt((String)mes.getText());  
                int anoT = Integer.parseInt((String)ano.getText());
                int etaT = Integer.parseInt((String)eta.getText());
                GregorianCalendar dataIT = new GregorianCalendar(anoT, diaT, mesT);
                Projeto temp = new Projeto(nomeText,dataIT, etaT,acronimoText);
                cisuc.projeto.add(temp);
                
                String nomeIPT =(String)listaInvestigadoresPrinc.getSelectedItem().toString();
 
            }
            
            else if(e.getSource() == listTarefas){
                
                eliminaTarefa = new JButton("Eliminar Tarefa");
                eliminaTarefa.addActionListener(new botaoListenerEcras2());
                
                atribuiTarefa = new JButton("Atribuir Tarefa");
                atribuiTarefa.addActionListener(new botaoListenerEcras2());
                
                atualizaTaxa = new JButton("Atualizar Taxa");
                atualizaTaxa.addActionListener(new botaoListenerEcras2());
                
                
            }
            
        }
            
     }
      private class botaoListenerEcras2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            
        } 
        
     }
      
}
