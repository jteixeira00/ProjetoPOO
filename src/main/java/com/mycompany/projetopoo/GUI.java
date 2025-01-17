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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.NumberFormatter;
import net.miginfocom.swing.MigLayout;

/**
 * @author Dinis Carvalho 2018278118
 * @author João Teixeira 2018278532
 */
public class GUI{
    JFrame mainFrame, frameCreateProject, frameGerirProjeto, frameAdicionarPessoa, redirecionaTarefa, gerirTarefas, frameInfoPessoa, frameListaIncompletos, frameCusto, frameConcluidos, frameCriarTarefa, atualizarTaxa;
    JPanel mainPanel;
    final JButton criarProjeto, gerirProjeto,listaConcluidos;
    private JButton confirm, selecionarPessoas, regressaGerirDasPessoas, fecharCusto, regressaMainDosConcluidos, ver, infoPessoa, confirm2, confirmarTaxa;
    private JButton addPessoa, redirec, listTarefas,eliminaTarefa, atualizaTaxa,calculaCusto, terminaProjeto, regressaMainDaGestao, regressaMainDasTarefas, criaTarefa, guardarFechar;
    private JTextField nome, acronimo, nomeT;
    private JTextField dia, diaT;
    private JTextField mes, mesT ;
    private JTextField ano, anoT;
    private JTextField eta, etaT;
    private JFormattedTextField novaTaxa;
    private JComboBox tipoT;
    private JTextArea infoPessoasText, infoProjetoText, infoTarefaText, infoProjetosAcabadosText;
    private JComboBox listaInvestigadoresPrinc;
    private JComboBox ComboBoxProjetos, responsavelT, ComboBoxTarefas;
    private JList listaPessoas, listaDocentes, listaTarefas, listaProjConcluidos;
    private Projeto currentProjeto;
    Tarefa currentTarefa;
    CISUC cisuc;
    private DefaultComboBoxModel nomesTarefas, nomesProjetos;
    
    
    GUI(CISUC cisuc){
        this.cisuc = cisuc;
        mainFrame = new JFrame("CISUC");
        
        mainFrame.setSize(420, 370);
        
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("align 50% 50%, wrap 1"));
        
        criarProjeto = new JButton("Criar Projeto");
        criarProjeto.setPreferredSize(new Dimension(230, 40));
        criarProjeto.addActionListener(new botaoListener());
        mainPanel.add(criarProjeto);
        
        
        
        gerirProjeto = new JButton("Gerir Projeto");
        gerirProjeto.setPreferredSize(new Dimension(230, 40));
        gerirProjeto.addActionListener(new botaoListener());
        mainPanel.add(gerirProjeto);  
        
       
        
        
        
        listaConcluidos = new JButton("Listar Projetos Concluídos");
        listaConcluidos.setPreferredSize(new Dimension(230, 40));
        listaConcluidos.addActionListener(new botaoListener());
        mainPanel.add(listaConcluidos);
        
        
        guardarFechar = new JButton("Guardar e Fechar");
        guardarFechar.setPreferredSize(new Dimension(230, 40));
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
                frameCreateProject.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
                
                for(Pessoa temp: cisuc.pessoas){
                    if(temp.getCusto() == 0)
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
                frameGerirProjeto.setSize(420, 370);
                frameGerirProjeto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frameGerirProjeto.setResizable(false);
                JPanel panelGerirProjeto = new JPanel();
                panelGerirProjeto.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                frameGerirProjeto.setResizable(false);
                infoProjetoText = new JTextArea();
                infoProjetoText.setEditable(false);
                
                /*
                nomesTarefas = new DefaultComboBoxModel(currentProjeto.getNomesTarefas().toArray());
                
                ComboBoxTarefas = new JComboBox(nomesTarefas);
                */
                
                nomesProjetos = new DefaultComboBoxModel(cisuc.getNomesProjetosIncompletos().toArray());
                currentProjeto = cisuc.ProjetoGetter(cisuc.getNomesProjetosIncompletos().get(0));
                ComboBoxProjetos = new JComboBox(nomesProjetos);
                ComboBoxProjetos.addActionListener(new botaoListenerEcras2());
                ComboBoxProjetos.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                
                infoProjetoText.setText(cisuc.getInfoProjetos(cisuc.ProjetoGetter((String)ComboBoxProjetos.getSelectedItem())));
                
            }
              });
                        
                infoProjetoText.setText(cisuc.getInfoProjetos(cisuc.ProjetoGetter((String)cisuc.getNomesProjetosIncompletos().get(0))));
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
                panelGerirProjeto.add(infoProjetoText, "span 1 6");
                panelGerirProjeto.add(ComboBoxProjetos);
                panelGerirProjeto.add(addPessoa);
                panelGerirProjeto.add(listTarefas);
                panelGerirProjeto.add(calculaCusto);
                panelGerirProjeto.add(terminaProjeto);
                panelGerirProjeto.add(regressaMainDaGestao, "cell 1 6");
                frameGerirProjeto.add(panelGerirProjeto);
                frameGerirProjeto.setVisible(true);
                mainFrame.setVisible(false);
                
            }
            
            
            
            
            else if(e.getSource() == listaConcluidos){
                frameConcluidos = new JFrame("Projetos Concluídos");
                JPanel panelConcluidos = new JPanel();
                frameConcluidos.setSize(420, 370);
                frameConcluidos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frameConcluidos.setResizable(false);
                regressaMainDosConcluidos = new JButton("Regressar");
                regressaMainDosConcluidos.addActionListener(new botaoListenerEcras());
                panelConcluidos.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                
                infoProjetosAcabadosText = new JTextArea();
                infoProjetosAcabadosText.setEditable(false);
                infoProjetosAcabadosText.setText(cisuc.getInfoProjetos(cisuc.ProjetoGetter(cisuc.listaNomesConcluidos().get(0))));
                JComboBox ComboBoxProjetosAcabados = new JComboBox(cisuc.listaNomesConcluidos().toArray());
                ComboBoxProjetosAcabados.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                
                infoProjetosAcabadosText.setText(cisuc.getInfoProjetos(cisuc.ProjetoGetter((String)ComboBoxProjetosAcabados.getSelectedItem())));
                
            }
            }); 
                
                panelConcluidos.add(infoProjetosAcabadosText, "span 1 6");
                panelConcluidos.add(ComboBoxProjetosAcabados);
                panelConcluidos.add(regressaMainDosConcluidos);
                frameConcluidos.add(panelConcluidos);
                mainFrame.setVisible(false);
                frameConcluidos.setVisible(true);
                
                /*
                infoProjetoText = new JTextArea();
                infoProjetoText.setEditable(false);
                nomesProjetos = new DefaultComboBoxModel(cisuc.getNomesProjetosIncompletos().toArray());
                currentProjeto = cisuc.ProjetoGetter(cisuc.getNomesProjetosIncompletos().get(0));
                ComboBoxProjetos = new JComboBox(nomesProjetos);
                ComboBoxProjetos.addActionListener(new botaoListenerEcras2());
                ComboBoxProjetos.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                
                infoProjetoText.setText(cisuc.getInfoProjetos(cisuc.ProjetoGetter((String)ComboBoxProjetos.getSelectedItem())));
                
            }
              
                */
                
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
                String nomeIPT =(String)listaInvestigadoresPrinc.getSelectedItem().toString();
                Projeto temp = new Projeto(nomeText, dataIT, etaT, acronimoText,cisuc);
                cisuc.addProjeto(temp);
                temp.setIP(cisuc.PessoaGetter(nomeIPT));

 
            }
            else if(e.getSource()==terminaProjeto){
                currentProjeto.TerminarP();
                
                nomesProjetos.removeElement(ComboBoxProjetos.getSelectedItem());
                ComboBoxProjetos.revalidate();
                ComboBoxProjetos.repaint();
                
                /*
                nomeTarefa = (String)ComboBoxTarefas.getSelectedItem();
                System.out.println(nomeTarefa);
                currentProjeto.EliminarTarefa(currentProjeto.tarefaGetter(nomeTarefa));
                nomesTarefas.removeElement(ComboBoxTarefas.getSelectedItem());
                ComboBoxTarefas.revalidate();
                ComboBoxTarefas.repaint();
                */
                
                
                
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
                if(currentProjeto.getNomesTarefas().toArray().length == 0){
                    
                    redirecionaTarefa = new JFrame();
                    JPanel panelRedirec = new JPanel();
                   
                    panelRedirec.setLayout(new MigLayout("align 50% 50%, wrap 1"));
                    redirecionaTarefa.setSize(420,370);
                    redirecionaTarefa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    redirecionaTarefa.setResizable(false);
                    redirec = new JButton("Criar Tarefa");
                    redirec.addActionListener(new botaoListenerEcras2());
                    
                    panelRedirec.add(redirec);
                    redirecionaTarefa.add(panelRedirec);
                    redirecionaTarefa.setVisible(true);
                    
                }
                
                else{
                gerirTarefas = new JFrame("Gerir Tarefas");
                gerirTarefas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                gerirTarefas.setResizable(false);
                gerirTarefas.setSize(420, 370);
                JPanel panelTarefas= new JPanel();
                panelTarefas.setLayout(new MigLayout("align 50% 50%, wrap 2"));                
                
                listaTarefas = new JList(currentProjeto.getNomesTarefas().toArray());
                   
                
                infoTarefaText = new JTextArea();
                infoTarefaText.setEditable(false);
                nomesTarefas = new DefaultComboBoxModel(currentProjeto.getNomesTarefas().toArray());
                
                ComboBoxTarefas = new JComboBox(nomesTarefas);
                infoTarefaText.setText(cisuc.getInfoTarefas(currentProjeto.tarefaGetter((String)currentProjeto.getNomesTarefas().get(0))));
                
               
                
                
                
                ComboBoxTarefas.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                
                infoTarefaText.setText(cisuc.getInfoTarefas(currentProjeto.tarefaGetter((String)ComboBoxTarefas.getSelectedItem())));
                
            }
              });
                
                
                eliminaTarefa = new JButton("Eliminar Tarefa");
                eliminaTarefa.addActionListener(new botaoListenerEcras2());
                
                
                
                atualizaTaxa = new JButton("Atualizar Taxa");
                atualizaTaxa.addActionListener(new botaoListenerEcras2());
                
                criaTarefa = new JButton("Criar Tarefa");
                criaTarefa.addActionListener(new botaoListenerEcras2());
                
                regressaMainDasTarefas = new JButton("Ecrã Principal");
                regressaMainDasTarefas.addActionListener(new botaoListenerEcras2());
                
                
                panelTarefas.add(infoTarefaText, "span 1 6");
                panelTarefas.add(ComboBoxTarefas, "cell 1 0");
                panelTarefas.add(eliminaTarefa, "cell 1 1");
               
                panelTarefas.add(atualizaTaxa, "cell 1 2");
                panelTarefas.add(criaTarefa, "cell 1 3");
                panelTarefas.add(regressaMainDasTarefas, "cell 1 4");
                gerirTarefas.add(panelTarefas);
                frameGerirProjeto.setVisible(false);
                gerirTarefas.setVisible(true);
                }
                
            }
            
            else if(e.getSource() == regressaMainDaGestao){
                
                frameGerirProjeto.setVisible(false);
                mainFrame.setVisible(true);
                
                
            }
            
            else if(e.getSource() == calculaCusto){
                frameCusto = new JFrame("Custo");
                frameCusto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frameCusto.setResizable(false);
                frameCusto.setSize(300, 200);
                fecharCusto = new JButton("Fechar");
                fecharCusto.addActionListener(new botaoListenerEcras2());
                JPanel panelCusto = new JPanel();
                panelCusto.setLayout(new MigLayout("align 50% 50%, wrap 1"));  
                JLabel mensagem = new JLabel("O custo do projeto é:");
                
                String Custo = Integer.toString(currentProjeto.CustoP()); //CALCULAR E INSERIR AQUI
                
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
                
                
                frameAdicionarPessoa.setSize(600,400);
                frameAdicionarPessoa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frameAdicionarPessoa.setResizable(false);
                newPanel2.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                
                regressaGerirDasPessoas = new JButton("Gerir Projeto");
                regressaGerirDasPessoas.addActionListener(new botaoListenerEcras3());
                infoPessoa = new JButton("Informação dos Selecionados");
                infoPessoa.addActionListener(new botaoListenerEcras3());
                
                
                listaPessoas = new JList(cisuc.getNomesPessoas().toArray());
                JScrollPane listScroller = new JScrollPane(listaPessoas);
               
                infoPessoasText = new JTextArea();
                infoPessoasText.setEditable(false);
                infoPessoasText.setText(cisuc.getInfo(cisuc.pessoas.get(0)));
                newPanel2.add(infoPessoasText);
                newPanel2.add(listaPessoas);
                newPanel2.add(selecionarPessoas, "cell 1 2");
                newPanel2.add(regressaGerirDasPessoas, "cell 1 3");
                frameAdicionarPessoa.add(newPanel2);               
                frameAdicionarPessoa.setVisible(true);
                frameGerirProjeto.setVisible(false);
                
                listaPessoas.addMouseListener(new MouseAdapter(){
                            public void mouseClicked(MouseEvent e) {
                                
                                
                                infoPessoasText.setText(cisuc.getInfo(cisuc.pessoas.get(listaPessoas.getSelectedIndex())));
                               
                                
                            }
                        });

            }
            
            
            
            else if(e.getSource() == fecharCusto){
                
                frameCusto.setVisible(false);
                frameGerirProjeto.setVisible(true);
            }
            
            else if(e.getSource() == regressaMainDasTarefas){
                frameGerirProjeto.setVisible(true);
                gerirTarefas.setVisible(false);
                
            }
            
            else if(e.getSource() == ComboBoxProjetos){
                
                
                currentProjeto = cisuc.ProjetoGetter((String)ComboBoxProjetos.getSelectedItem());
            }
            
            else if(e.getSource() == eliminaTarefa){
                
                String nomeTarefa;
                
                nomeTarefa = (String)ComboBoxTarefas.getSelectedItem();
                System.out.println(nomeTarefa);
                currentProjeto.EliminarTarefa(currentProjeto.tarefaGetter(nomeTarefa));
                nomesTarefas.removeElement(ComboBoxTarefas.getSelectedItem());
                ComboBoxTarefas.revalidate();
                ComboBoxTarefas.repaint();
               
            }
            
            
            
            else if((e.getSource() == criaTarefa) || (e.getSource() == redirec)){
                frameCriarTarefa = new JFrame("Criar Tarefa");
                frameCriarTarefa.setSize(420, 370);
                frameCriarTarefa.setResizable(false);
                frameCriarTarefa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                JPanel panelCriarTarefa = new JPanel();
                confirm2 = new JButton("Confirmar");
                
                confirm2.addActionListener(new botaoListenerEcras3());
                panelCriarTarefa.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                JLabel labelNome = new JLabel("Nome:");
                JLabel labelDataInicio = new JLabel("Data Inicio (dia/mes/ano):");
                
                nomeT = new JTextField(10);
                diaT = new JTextField(2);
                mesT = new JTextField(2);
                anoT = new JTextField(4);
                JLabel labelETA = new JLabel("Duração Estimada: (meses)");
                etaT = new JTextField(10);
                
                String[] array = {"Design", "Desenvolvimento", "Documentação"};
                tipoT = new JComboBox(array);
                responsavelT = new JComboBox(currentProjeto.getNomesPessoas().toArray());
                
                
                panelCriarTarefa.add(labelNome);
                panelCriarTarefa.add(nomeT);
                panelCriarTarefa.add(labelDataInicio);
                panelCriarTarefa.add(diaT, "split 3");
                panelCriarTarefa.add(mesT);
                panelCriarTarefa.add(anoT);
                
                panelCriarTarefa.add(labelETA);
                panelCriarTarefa.add(etaT);
                panelCriarTarefa.add(new JLabel("Tipo de Tarefa:"));
                panelCriarTarefa.add(tipoT);
                panelCriarTarefa.add(new JLabel("Responsável: "));
                panelCriarTarefa.add(responsavelT);
                panelCriarTarefa.add(confirm2, "cell 1 5");
                frameCriarTarefa.add(panelCriarTarefa);
                
                frameCriarTarefa.setVisible(true);
                
                
                
                
                
                
                
            }
            
            else if(e.getSource() == atualizaTaxa){
                
                currentTarefa = currentProjeto.tarefaGetter((String)ComboBoxTarefas.getSelectedItem());
                atualizarTaxa = new JFrame("Atualizar Taxa");
                atualizarTaxa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                atualizarTaxa.setSize(300,250);
                atualizarTaxa.setVisible(true);
                
                JPanel panelAtualizarTaxa =  new JPanel();
                panelAtualizarTaxa.setLayout(new MigLayout("align 50% 50%, wrap 2"));
                NumberFormat format = NumberFormat.getInstance();
                NumberFormatter formatter = new NumberFormatter(format);
                formatter.setValueClass(Integer.class);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0);
                formatter.setMaximum(100);
                
                
                novaTaxa = new JFormattedTextField(formatter);
                novaTaxa.setColumns(3);
                confirmarTaxa = new JButton("Confirmar Taxa");
                confirmarTaxa.addActionListener(new botaoListenerEcras3());
                
                panelAtualizarTaxa.add(new JLabel("Taxa atual:"));
                panelAtualizarTaxa.add(new JLabel(Double.toString(currentTarefa.getTaxa())));
                panelAtualizarTaxa.add(new JLabel("Nova taxa:"));
                panelAtualizarTaxa.add(novaTaxa);
                
                panelAtualizarTaxa.add(confirmarTaxa, "cell 1 3");
                
                atualizarTaxa.add(panelAtualizarTaxa);
                atualizarTaxa.setVisible(true);
                
                
                
                
            
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
                  ArrayList<Pessoa> listaPessoa = new ArrayList<>();
                
                for(String bolseiro:listaNomesPessoas){
                   // System.out.println("1");
                    if(cisuc.PessoaGetter(bolseiro).getCusto() != 0)
                        //System.out.println("2");
                        listaPessoa.add(cisuc.PessoaGetter(bolseiro));
                }
                for(String docente:listaNomesPessoas){
                   // System.out.println("3");
                    if(cisuc.PessoaGetter(docente).getCusto() == 0){
                       // System.out.println("4");
                        listaPessoa.add(cisuc.PessoaGetter(docente));
                    }
                }
                
                for(Pessoa bol:listaPessoa){
                    if(bol.getCusto() != 0){
                        System.out.println("6");
                        if(cisuc.BolseiroInProjetos(bol) == 1){
                            System.out.println("7");
                            System.out.println("Bolseiro já tem um Projeto atribuido");
                        }
                        else{
                            System.out.println("8");
                            currentProjeto.addPessoa(bol);
                        }
                    }else{
                        System.out.println("9");
                        if(currentProjeto.addPessoa(bol)==1){
                            System.out.println("10");
                            System.out.println("Docente já existe neste projeto");
                        }          
                    }
                
                
                frameAdicionarPessoa.setVisible(false);
                frameGerirProjeto.setVisible(true);
                
                
                
            }
            }else if(e.getSource() == regressaGerirDasPessoas){
                
                 frameAdicionarPessoa.setVisible(false);
                 frameGerirProjeto.setVisible(true);
                
                
            }
            else if(e.getSource()==confirmarTaxa){
                
                if((Integer)novaTaxa.getValue() == 100){
                    currentTarefa.setCompleto();
                    
                }
                else{
                    currentTarefa.atualizarTaxa((Integer)novaTaxa.getValue());
                }
                atualizarTaxa.setVisible(false);
            }
            
            else if(e.getSource() == confirm2){
                
                String nomeTipo = (String)tipoT.getSelectedItem().toString();
                
                
                int etaA = Integer.parseInt((String)etaT.getText());
                GregorianCalendar dataIT = new GregorianCalendar(Integer.parseInt((String)anoT.getText()), Integer.parseInt((String)diaT.getText()), Integer.parseInt((String)mesT.getText()));
                
                
                if(nomeTipo == "Documentação"){
                    
                    Documentacao taref = new Documentacao((String)nomeT.getText(), dataIT,Integer.parseInt((String)etaT.getText()), cisuc.PessoaGetter((String)responsavelT.getSelectedItem()),0);
                    if((currentProjeto.CriarTarefa(taref, cisuc.PessoaGetter((String)responsavelT.getSelectedItem())) == 1)){
                        System.out.println("Pessoa Sobrecarregada, por favor escolher outra");
                        
                    }
                }
                
                if(nomeTipo == "Desenvolvimento"){
                    
                    Desenvolvimento taref = new Desenvolvimento((String)nomeT.getText(), dataIT,Integer.parseInt((String)etaT.getText()), cisuc.PessoaGetter((String)responsavelT.getSelectedItem()),0);
                    if(currentProjeto.CriarTarefa(taref, cisuc.PessoaGetter((String)responsavelT.getSelectedItem()))==1){
                        System.out.println("Pessoa Sobrecarregada, por favor escolher outra");
                    }
                }
                
                else{
                    
                    
                    Design taref = new Design((String)nomeT.getText(), dataIT,Integer.parseInt((String)etaT.getText()), cisuc.PessoaGetter((String)responsavelT.getSelectedItem()),0);
                    
                    if(currentProjeto.CriarTarefa(taref, cisuc.PessoaGetter((String)responsavelT.getSelectedItem()))==1){
                        System.out.println("Pessoa Sobrecarregada, por favor escolher outra");
                    
                    }
                }
                
                
                mainFrame.setVisible(true);
                frameCriarTarefa.setVisible(false);
                //listaTarefas.setListData(currentProjeto.getNomesTarefas().toArray());
            }
       
        }
 
      }
      

      }