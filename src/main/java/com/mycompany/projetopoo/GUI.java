/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopoo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author User
 */
public class GUI{
    JFrame mainFrame, frameCreateProject, frameGerirProjeto, frameAdicionarPessoa, gerirTarefas, frameInfoPessoa, frameListaIncompletos, frameCusto, frameConcluidos;
    JPanel mainPanel;
    final JButton criarProjeto, gerirProjeto,listaConcluidos;
    JButton confirm, selecionarPessoas, regressaGerirDasPessoas, fecharCusto, regressaMainDosConcluidos, ver, infoPessoa;
    JButton addPessoa, listTarefas,eliminaTarefa, atribuiTarefa, atualizaTaxa,calculaCusto, terminaProjeto, regressaMainDaGestao, regressaMainDasTarefas, criaTarefa, guardarFechar;
    JTextField nome, acronimo;
    JTextField dia;
    JTextField mes ;
    JTextField ano;
    JTextField eta;
    
    JTextArea infoPessoasText;
    JComboBox listaInvestigadoresPrinc;
    JComboBox ComboBoxProjetos;
    JList listaPessoas, listaDocentes, listaTarefas, listaProjConcluidos;
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
        
       
        
        
        
        listaConcluidos = new JButton("Listar Projetos Concluídos");
        listaConcluidos.addActionListener(new botaoListener());
        mainPanel.add(listaConcluidos);
        
        
        guardarFechar = new JButton("Guardar e Fechar");
        guardarFechar.addActionListener(new botaoListener());
        mainPanel.add(guardarFechar);
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
                JTextField text = new JTextField();
                
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
                newPanel.add(text);
                frameCreateProject.add(newPanel);               
                
                frameCreateProject.add(newPanel);
                newPanel.add(confirm, "cell 1 6");
                mainFrame.setVisible(false);
                frameCreateProject.setVisible(true);
                
                frameCreateProject.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                
               
              
            }
            
            else if(e.getSource() == guardarFechar){
                
                cisuc.SaveObjectFilesBolseiros();
                cisuc.SaveObjectFilesDocentes();
                cisuc.SaveObjectFilesProjetos();
                System.exit(0);
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
            
            
            
            
            else if(e.getSource() == listaConcluidos){
                frameConcluidos = new JFrame("Projetos Concluídos");
                JPanel panelConcluidos = new JPanel();
                frameConcluidos.setSize(600,800);
                frameConcluidos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                regressaMainDosConcluidos = new JButton("Regressar");
                regressaMainDosConcluidos.addActionListener(new botaoListenerEcras());
                ver = new JButton("Ver +");
                ver.addActionListener(new botaoListenerEcras());
                
                panelConcluidos.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                
                listaProjConcluidos = new JList(cisuc.listaNomesConcluidos().toArray());
                   
                JScrollPane listScrollerConcluidos = new JScrollPane(listaProjConcluidos);
                
                
                panelConcluidos.add(listScrollerConcluidos);
                panelConcluidos.add(ver, "split 2");
                panelConcluidos.add(regressaMainDosConcluidos);
                frameConcluidos.add(panelConcluidos);
                mainFrame.setVisible(false);
                frameConcluidos.setVisible(true);
                
                
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
            else if(e.getSource()==terminaProjeto){
                currentProjeto.TerminarP();
                ComboBoxProjetos.removeAllItems();
                for(String nome: cisuc.getNomesProjetosIncompletos()){
                    ComboBoxProjetos.addItem(nome);
                }
                
                
                
            }
            else if(e.getSource()==ver){
                JFrame frameVerC = new JFrame("Informações projeto concluído");
                JPanel panelVerC = new JPanel();
                panelVerC.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                String nomeProjeto = new String((String)listaProjConcluidos.getSelectedValue());
                Projeto tempProj = cisuc.ProjetoGetter(nomeProjeto);
                JLabel nome = new JLabel("Nome:");
                JLabel nomeP = new JLabel(tempProj.getNome());
                JLabel acr = new JLabel("Acrónimo:");
                JLabel acrP = new JLabel(tempProj.getAcronimo());
                JLabel dataI = new JLabel("Data Início:") ;
                
                
                
                //completar
            }
            
            else if(e.getSource()==regressaMainDosConcluidos){
                
                mainFrame.setVisible(true);
                frameConcluidos.setVisible(false);
            }
            
            else if(e.getSource() == listTarefas){
                
                gerirTarefas = new JFrame("Gerir Tarefas");
                gerirTarefas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gerirTarefas.setSize(600,800);
                JPanel panelTarefas= new JPanel();
                panelTarefas.setLayout(new MigLayout("align 50% 50%, wrap 2"));                
                
                listaTarefas = new JList(currentProjeto.getNomesTarefas().toArray());
                   
                JScrollPane listScroller = new JScrollPane(listaTarefas);
                
                eliminaTarefa = new JButton("Eliminar Tarefa");
                eliminaTarefa.addActionListener(new botaoListenerEcras2());
                
                atribuiTarefa = new JButton("Atribuir Tarefa");
                atribuiTarefa.addActionListener(new botaoListenerEcras2());
                
                atualizaTaxa = new JButton("Atualizar Taxa");
                atualizaTaxa.addActionListener(new botaoListenerEcras2());
                
                criaTarefa = new JButton("Criar Tarefa");
                criaTarefa.addActionListener(new botaoListenerEcras2());
                
                regressaMainDasTarefas = new JButton("Ecrã Principal");
                regressaMainDasTarefas.addActionListener(new botaoListenerEcras2());
                
                
                
                panelTarefas.add(listScroller, "span 0 6");
                panelTarefas.add(eliminaTarefa, "cell 1 0");
                panelTarefas.add(atribuiTarefa, "cell 1 1");
                panelTarefas.add(atualizaTaxa, "cell 1 2");
                panelTarefas.add(criaTarefa, "cell 1 3");
                panelTarefas.add(regressaMainDasTarefas, "cell 1 5");
                gerirTarefas.add(panelTarefas);
                frameGerirProjeto.setVisible(false);
                gerirTarefas.setVisible(true);
                
            }
            
            else if(e.getSource() == regressaMainDaGestao){
                
                frameGerirProjeto.setVisible(false);
                mainFrame.setVisible(true);
                
                
            }
            
            else if(e.getSource() == calculaCusto){
                frameCusto = new JFrame("Custo");
                frameCusto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frameCusto.setResizable(false);
                frameCusto.setSize(300, 200);
                fecharCusto = new JButton("Fechar");
                fecharCusto.addActionListener(new botaoListenerEcras2());
                JPanel panelCusto = new JPanel();
                panelCusto.setLayout(new MigLayout("align 50% 50%, wrap 1"));  
                JLabel mensagem = new JLabel("O custo do projeto é:");
                
                String Custo = new String("Batata"); //CALCULAR E INSERIR AQUI
                
                JLabel custoL = new JLabel(Custo);
                panelCusto.add(mensagem);
                panelCusto.add(custoL);
                panelCusto.add(fecharCusto);
                frameCusto.add(panelCusto);
                frameCusto.setVisible(true);
                frameGerirProjeto.setVisible(false);
                
                 
                
            
            
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
                
                frameAdicionarPessoa.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e) {
                        infoPessoasText.setText("");
                        infoPessoasText.setText(;cisuc.getInfo(cisuc.PessoaGetter(listaPessoas.getSelectedValue())));
                    }
                
                });
                frameAdicionarPessoa.setSize(600,400);
                newPanel2.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                
                regressaGerirDasPessoas = new JButton("Gerir Projeto");
                regressaGerirDasPessoas.addActionListener(new botaoListenerEcras3());
                
                infoPessoa = new JButton("Informação dos Selecionados");
                infoPessoa.addActionListener(new botaoListenerEcras3());
                
                
                listaPessoas = new JList(cisuc.getNomesPessoas().toArray());
                JScrollPane listScroller = new JScrollPane(listaPessoas);
                
                newPanel2.add(listScroller);
                
                newPanel2.add(selecionarPessoas, "cell 1 2");
                newPanel2.add(regressaGerirDasPessoas, "cell 1 3");
                frameAdicionarPessoa.add(newPanel2);               
                frameAdicionarPessoa.setVisible(true);
                frameGerirProjeto.setVisible(false);
                
       
                
            }
            
            else if(e.getSource() == fecharCusto){
                
                frameCusto.setVisible(false);
                frameGerirProjeto.setVisible(true);
            }
            
            else if(e.getSource() == ComboBoxProjetos){
                
                
                currentProjeto = cisuc.ProjetoGetter((String)ComboBoxProjetos.getSelectedItem());
            }
            
            else if(e.getSource() == eliminaTarefa){
                
                
            }
            
            else if(e.getSource() == atribuiTarefa){
                
                
            }
            
            else if(e.getSource() == criaTarefa){
                
                
            }
            
            else if(e.getSource() == atualizaTaxa){
                
                
            }
            
            else if(e.getSource() == regressaMainDaGestao){
                
                
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
            else if(e.getSource() == regressaGerirDasPessoas){
                
                 frameAdicionarPessoa.setVisible(false);
                 frameGerirProjeto.setVisible(true);
                
                
            }
            
            
            
        }
            
            
        }
      
}
