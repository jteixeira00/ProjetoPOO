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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author User
 */
public class GUI{
    JFrame mainFrame, frameCreateProject, frameEscolherProjeto, frameGerirProjeto, frameAdicionarPessoa;
    JPanel mainPanel, panelTarefas;
    final JButton criarProjeto, gerirProjeto,listaAtivos, listaIncompletos,listaConcluidos;
    JButton confirm, selecionarPessoas,regressaMainDaEscolhaProjeto, regressaMainDaGestao;
    JButton addPessoa, listTarefas,eliminaTarefa, atribuiTarefa, atualizaTaxa,calculaCusto, terminaProjeto, regressaMainDaGesta, gerirProjetoNEXT, escolherProjeto;
    JTextField nome, acronimo;
    JTextField dia;
    JTextField mes ;
    JTextField ano;
    JTextField eta;
    JComboBox listaInvestigadoresPrinc;
    Projeto currentProjeto;
    
    JList listaPessoas, listaProjetos;
           
    CISUC cisuc;
    
    
    
    GUI(CISUC cisuc){
        
        this.cisuc = cisuc;
        mainFrame = new JFrame("Cenas");
        
        mainFrame.setSize(800, 600);
        
        
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
        
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    
    }
      private class botaoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel newPanel = new JPanel();
            
            if (e.getSource() == criarProjeto){ 
                frameCreateProject = new JFrame();   
                frameCreateProject.setSize(400,300);
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
                
                frameCreateProject.add(newPanel);
                newPanel.add(confirm, "cell 1 6");
                mainFrame.setVisible(false);
                frameCreateProject.setVisible(true);
                
                frameCreateProject.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                
               
              
            }
            else if(e.getSource() == gerirProjeto){
                
                regressaMainDaEscolhaProjeto= new JButton("Ecrã Principal");
                regressaMainDaEscolhaProjeto.addActionListener(new botaoListenerEcras());
                
                frameEscolherProjeto = new JFrame("Escolher Projeto");        
                frameEscolherProjeto.setSize(600,800);
                frameEscolherProjeto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                escolherProjeto = new JButton("Escolher");
                
                
                escolherProjeto.addActionListener(new botaoListenerEcras());
                
                JPanel panel = new JPanel(new MigLayout("align 50% 50%, wrap 1"));
                listaProjetos = new JList(cisuc.getNomesProjetos().toArray());
                JScrollPane listScrollerProjetos = new JScrollPane(listaProjetos);
                
                panel.add(listScrollerProjetos, "span 2 4");
                panel.add(escolherProjeto);
                
                frameEscolherProjeto.add(panel);
                
                frameEscolherProjeto.setVisible(true);
                mainFrame.setVisible(false);
                
                
                
                
                
                
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
                Projeto temp = new Projeto(nomeText, dataIT, etaT, acronimoText);
                cisuc.projeto.add(temp);
                
                String nomeIPT =(String)listaInvestigadoresPrinc.getSelectedItem().toString();
 
            }
            
            else if(e.getSource() == escolherProjeto){
                
                
                String Projeto = (String)listaProjetos.getSelectedValue();
                
                
                
                
                
                
                
                
                
            }
            
            else if(e.getSource() == listTarefas){
                
                panelTarefas = new JPanel();
                
                eliminaTarefa = new JButton("Eliminar Tarefa");
                eliminaTarefa.addActionListener(new botaoListenerEcras2());
                
                atribuiTarefa = new JButton("Atribuir Tarefa");
                atribuiTarefa.addActionListener(new botaoListenerEcras2());
                
                atualizaTaxa = new JButton("Atualizar Taxa");
                atualizaTaxa.addActionListener(new botaoListenerEcras2());
                
                
                
                
                
            }
            
            else if(e.getSource() == regressaMainDaGestao){
            
                frameGerirProjeto.setVisible(false);
                mainFrame.setVisible(true);
                
                
            }
            else if(e.getSource() == regressaMainDaEscolhaProjeto){
                
                
                
                
                frameEscolherProjeto.setVisible(false);
                mainFrame.setVisible(true);
                
                
            }
            
        }
            
     }
      private class botaoListenerEcras2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel newPanel2 = new JPanel();
            if(e.getSource() == addPessoa ){
                selecionarPessoas = new JButton("Selecionar Pessoas");
                selecionarPessoas.addActionListener(new botaoListenerEcras3());
                frameAdicionarPessoa = new JFrame("Adicionar Pessoas");
                frameAdicionarPessoa.setSize(600,800);
                newPanel2.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                
                listaPessoas = new JList(cisuc.getNomesPessoas().toArray());
                JScrollPane listScroller = new JScrollPane(listaPessoas);
                
                newPanel2.add(listScroller);
                newPanel2.add(selecionarPessoas);
                frameAdicionarPessoa.add(newPanel2);               
                frameAdicionarPessoa.setVisible(true);
                frameGerirProjeto.setVisible(false);
                
       
                
            }
            
            
            if(e.getSource() == gerirProjetoNEXT){
                
                frameGerirProjeto = new JFrame("Gerir Projeto");
                frameGerirProjeto.setSize(600,800);
                frameGerirProjeto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                JPanel panelGerirProjeto = new JPanel();
                panelGerirProjeto.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                frameGerirProjeto.setResizable(false);
                
                addPessoa = new JButton("Associar Pessoa");
                addPessoa.addActionListener(new botaoListenerEcras2());
                
                listTarefas = new JButton("Listar Tarefas");
                listTarefas.addActionListener(new botaoListenerEcras());
                
                calculaCusto = new JButton("Calcular Custo");
                calculaCusto.addActionListener(new botaoListenerEcras());
                
                terminaProjeto = new JButton("Concluir Projeto");
                terminaProjeto.addActionListener(new botaoListenerEcras());
                
                regressaMainDaGestao = new JButton("Ecrã Principal");
                regressaMainDaGestao.addActionListener(new botaoListenerEcras());
                
                panelGerirProjeto.add(addPessoa);
                panelGerirProjeto.add(listTarefas);
                panelGerirProjeto.add(calculaCusto);
                panelGerirProjeto.add(terminaProjeto);
                panelGerirProjeto.add(regressaMainDaGestao, "cell 0 6");
                frameGerirProjeto.add(panelGerirProjeto);
                frameGerirProjeto.setVisible(true);
                mainFrame.setVisible(false);
                
                
                
                
                
            }
            
        } 
        
     }
      private class botaoListenerEcras3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == selecionarPessoas){
                List<String> lista = listaPessoas.getSelectedValuesList();
                ArrayList<String> listaNomesPessoas = new ArrayList<>(lista.size());
                listaNomesPessoas.addAll(lista);
                
                //CODIGO PARA ADICIONAR A PESSOA
                
                frameAdicionarPessoa.setVisible(false);
                frameGerirProjeto.setVisible(true);
                
                
                
            }
            
            
        }
            
            
        }
      
}
