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
    JFrame mainFrame, frameCreateProject, frameGerirProjeto, frameAdicionarPessoa, gerirTarefas, frameListaIncompletos;
    JPanel mainPanel;
    final JButton criarProjeto, gerirProjeto, listaIncompletos,listaConcluidos;
    JButton confirm, selecionarPessoas;
    JButton addPessoa, listTarefas,eliminaTarefa, atribuiTarefa, atualizaTaxa,calculaCusto, terminaProjeto, regressaMainDaGestao, regressaMainDasTarefas;
    JTextField nome, acronimo;
    JTextField dia;
    JTextField mes ;
    JTextField ano;
    JTextField eta;
    JComboBox listaInvestigadoresPrinc;
    JComboBox ComboBoxProjetos;
    JList listaPessoas, listaDocentes, listaTarefas;
    Projeto currentProjeto;
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
                
                
                frameGerirProjeto = new JFrame("Gerir Projeto");
                frameGerirProjeto.setSize(600,800);
                frameGerirProjeto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                JPanel panelGerirProjeto = new JPanel();
                panelGerirProjeto.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                frameGerirProjeto.setResizable(false);
                
                ComboBoxProjetos = new JComboBox(cisuc.getNomesProjetosIncompletos().toArray());
                ComboBoxProjetos.addActionListener(new botaoListenerEcras2());
                System.out.println("AAAAA\n");
                 ArrayList<String> nomes = cisuc.getNomesProjetosIncompletos();
                 System.out.println(nomes.get(0));
                
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
                panelGerirProjeto.add(ComboBoxProjetos);
                panelGerirProjeto.add(addPessoa);
                panelGerirProjeto.add(listTarefas);
                panelGerirProjeto.add(calculaCusto);
                panelGerirProjeto.add(terminaProjeto);
                panelGerirProjeto.add(regressaMainDaGestao, "cell 0 6");
                frameGerirProjeto.add(panelGerirProjeto);
                frameGerirProjeto.setVisible(true);
                mainFrame.setVisible(false);
                
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
                Projeto temp = new Projeto(nomeText, dataIT, etaT, acronimoText,cisuc);
                cisuc.projeto.add(temp);
                
                String nomeIPT =(String)listaInvestigadoresPrinc.getSelectedItem().toString();
 
            }
            
            else if(e.getSource() == listTarefas){
                gerirTarefas = new JFrame("Gerir Tarefas");
                gerirTarefas.setSize(600,800);
                JPanel panelTarefas= new JPanel();
                panelTarefas.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                
                gerirTarefas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                listaTarefas = new JList(currentProjeto.getNomesTarefas().toArray());
                JScrollPane listScroller = new JScrollPane(listaTarefas);
                
                eliminaTarefa = new JButton("Eliminar Tarefa");
                eliminaTarefa.addActionListener(new botaoListenerEcras2());
                
                atribuiTarefa = new JButton("Atribuir Tarefa");
                atribuiTarefa.addActionListener(new botaoListenerEcras2());
                
                atualizaTaxa = new JButton("Atualizar Taxa");
                atualizaTaxa.addActionListener(new botaoListenerEcras2());
                
                regressaMainDasTarefas = new JButton("Ecrã Principal");
                regressaMainDasTarefas.addActionListener(new botaoListenerEcras2());
                
                panelTarefas.add(listaTarefas, "span 1 6");
                panelTarefas.add(eliminaTarefa, "cell 1 0");
                panelTarefas.add(atribuiTarefa, "cell 1 1");
                panelTarefas.add(atualizaTaxa, "cell 1 2");
                gerirTarefas.add(panelTarefas);
                frameGerirProjeto.setVisible(false);
                gerirTarefas.setVisible(true);
                
            }
            
            else if(e.getSource() == regressaMainDaGestao){
                
                frameGerirProjeto.setVisible(false);
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
                selecionarPessoas.addActionListener(new botaoListenerEcras2());
                frameAdicionarPessoa = new JFrame("Adicionar Pessoas");
                frameAdicionarPessoa.setSize(600,800);
                newPanel2.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                
                listaPessoas = new JList(cisuc.getNomesBolseiros().toArray());
                JScrollPane listScroller = new JScrollPane(listaPessoas);
                
                listaDocentes = new JList(cisuc.getNomesDocentes().toArray());
                JScrollPane listScroller2 = new JScrollPane(listaDocentes);
                newPanel2.add(new Label("Bolseiros"));
                newPanel2.add(new Label("Docentes"));
                newPanel2.add(listScroller);
                newPanel2.add(listScroller2);
                newPanel2.add(selecionarPessoas, "cell 1 1");
                frameAdicionarPessoa.add(newPanel2);               
                frameAdicionarPessoa.setVisible(true);
                frameGerirProjeto.setVisible(false);
                
       
                
            }
            
            else if(e.getSource() == ComboBoxProjetos){
                currentProjeto = cisuc.ProjetoGetter((String)ComboBoxProjetos.getSelectedItem());
            }
            
            
        } 
        
     }
 
      
      private class botaoListenerEcras3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == selecionarPessoas){
                
                
                List<String> lista = listaPessoas.getSelectedValuesList();
                List<String> listaDoc = listaDocentes.getSelectedValuesList();
                
                
                ArrayList<String> listaNomesPessoas = new ArrayList<>(lista.size());
                ArrayList<String> listaNomesDocentes = new ArrayList<>(listaDoc.size());
                listaNomesPessoas.addAll(lista);
                
                //CODIGO PARA ADICIONAR A PESSOA(definir listaBolseiro,definir listaDocentes e defnir projeto)
                
                ArrayList<Bolseiro> listaBolseiro = new ArrayList<>();
                ArrayList<Docente> listaDocentes = new ArrayList<>();
                ArrayList<Bolseiro> BolseirosRejeitados = new ArrayList<>();
                
                for(String bolseiro:listaNomesPessoas){
                    listaBolseiro.add(cisuc.BolseiroGetter(bolseiro));
                }
                for(String docente:listaNomesDocentes){
                    listaDocentes.add(cisuc.DocenteGetter(docente));
                }
                
                for(Bolseiro bol:listaBolseiro){
                    if(cisuc.BolseiroInProjetos(bol) == 1){
                        BolseirosRejeitados.add(bol);
                        /*Bolseiros Rejeitados mostar*/
                    }
                    else{
                        currentProjeto.addBolseiro(bol);
                    }
                 for(Docente dol:listaDocentes){
                     currentProjeto.addDocente(dol);
                 }
                    
                }
                
                
                frameAdicionarPessoa.setVisible(false);
                frameGerirProjeto.setVisible(true);
                
                
                
            }
            
            
        }
            
            
        }
      
}
