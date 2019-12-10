/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class GUI extends JFrame {
    JFrame mainFrame;
    JPanel mainPanel;
    JButton criarProjeto, gerirProjeto,listaAtivos, listaIncompletos,listaConcluidos;
    
    
    
    GUI(){
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
}
