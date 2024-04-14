package ProjetoPOO;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;



@SuppressWarnings("unused")
public class App implements Runnable{

    public void run(){
        Faculdade.loadProfessores();
        Faculdade.loadTurmas();
        Faculdade.loadAlunos();
        System.out.println(Faculdade.getTurmas());
        System.out.println(Faculdade.getAlunos());
        System.out.println(Faculdade.getProfessores());
        JFrame frame = new JFrame("Hello World");
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        panel.add(label);
        String fileName = "ProjetoPOO/Data/MIT2.png"; //Adicionando uma imagem de fundo para o menu principal
        File file = new File(fileName);
				try {
					BufferedImage img = ImageIO.read(file);
					Image resizedImage = img.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(resizedImage);
					label.setIcon(icon);
				} catch (IOException e) {
					System.out.println("Erro na imagem: " + fileName);
				}
        frame.add(panel, BorderLayout.CENTER);


        frame.setTitle("MIT - Mangabeira Institute of Technology");
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Novo");
        JMenu editMenu = new JMenu("Editar");
        JMenu viewMenu = new JMenu("Visualizar");
        JMenu addMenu = new JMenu("Adicionar");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(addMenu);

        JMenuItem newAluno = new JMenuItem("Cadastrar Aluno"); //Criando um popup para a menubar Cadastrar Aluno
        newAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Aluno");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labela1 = new JLabel("Nome do Aluno:");
                
                JTextField NomeAluno = new JTextField();
    
                JButton Cadastrar = new JButton("Cadastrar");
                JButton Cancelar = new JButton("Cancelar");
                panel.add(labela1);
                panel.add(NomeAluno);
                panel.add(Cadastrar);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 100);
                frame.setVisible(true);

                Cadastrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String nome = NomeAluno.getText();
                        Aluno aluno = new Aluno(nome);
                        Faculdade.addAluno(aluno);
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Alunos.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getAlunos());
                            System.out.println(aluno);
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                Cancelar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
            }
        });

        JMenuItem newTurma = new JMenuItem("Cadastrar Turma"); //Criando um popup para a menubar Cadastrar Turma
        newTurma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Turma");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labelT1 = new JLabel("Turma:");

                JTextField NomeTurma = new JTextField();

                JButton Cadastrar = new JButton("Cadastrar");
                Cadastrar.addActionListener(new ActionListener() { // Adicionando um evento ao botão Cadastrar que Salva o nome do professor em um arquivo file.txt
                    public void actionPerformed(ActionEvent e) {
                        String nome = NomeTurma.getText();
                        Turmas turma = new Turmas(nome);
                        Faculdade.addTurma(turma);
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Turmas.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getTurmas());
                            System.out.println(turma);
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JButton Cancelar = new JButton("Cancelar");
                Cancelar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                panel.add(labelT1);
                panel.add(NomeTurma);
                panel.add(Cadastrar);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 100);
                frame.setVisible(true);
            }
        });
        JMenuItem newProfessor = new JMenuItem("Cadastrar Professor"); //Criando um popup para a menubar Cadastrar Professor
        newProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Professor");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labelP1 = new JLabel("Nome do Professor:");

                JTextField NomeProfessor = new JTextField();

                JButton Cadastrar = new JButton("Cadastrar");
                Cadastrar.addActionListener(new ActionListener() { // Adicionando um evento ao botão Cadastrar que Salva o nome do professor em um arquivo file.txt
                    public void actionPerformed(ActionEvent e) {
                        String nome = NomeProfessor.getText();
                        Professor professor = new Professor(nome);
                        Faculdade.addProfessor(professor);
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Professores.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getProfessores());
                            System.out.println(professor);
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JButton Cancelar = new JButton("Cancelar");
                Cancelar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                panel.add(labelP1);
                panel.add(NomeProfessor);
                panel.add(Cadastrar);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 100);
                frame.setVisible(true);
            }
        });

        JMenuItem editAluno = new JMenuItem("Editar Aluno");
        JMenuItem editTurma = new JMenuItem("Editar Turma");
        JMenuItem editProfessor = new JMenuItem("Editar Professor");

        JMenuItem consultAlunos = new JMenuItem("Consultar Alunos");
        consultAlunos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Consultar Alunos");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                for(Aluno aluno : Faculdade.getAlunos()){
                    JLabel label = new JLabel(aluno.toString());
                    panel.add(label);
                }
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
        JMenuItem consultTurmas = new JMenuItem("Consultar Turmas");
        consultTurmas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Consultar Turmas");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                for(Turmas turmas : Faculdade.getTurmas()){
                    JLabel label = new JLabel(turmas.toString());
                    panel.add(label);
                }
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
        JMenuItem consultProfessores = new JMenuItem("Consultar Professores"); //Classe anônima para implementar o actionlistener de visualizar os professores
        consultProfessores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Consultar Professores");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                for(Professor professor : Faculdade.getProfessores()){
                    JLabel label = new JLabel(professor.toString());
                    panel.add(label);
                }
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });

        JMenuItem addAlunoT = new JMenuItem("Adicionar Aluno a Turma"); // Adicionando um aluno a uma turma
        addAlunoT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Adicionar Aluno a Turma");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labelA1 = new JLabel("Código do Aluno:");
                JTextField CodigoAluno = new JTextField();
                JLabel labelA2 = new JLabel("Código da Turma:");
                JTextField CodigoTurma = new JTextField();

                JButton Adicionar = new JButton("Adicionar");
                Adicionar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int codigoAluno = Integer.parseInt(CodigoAluno.getText());
                        int codigoTurma = Integer.parseInt(CodigoTurma.getText());
                        Aluno aluno = Faculdade.getAluno(codigoAluno);
                        Turmas turma = Faculdade.getTurma(codigoTurma);
                        turma.adicionarAluno(aluno);
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Turmas.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getTurmas());
                            System.out.println(aluno);
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JButton Cancelar = new JButton("Cancelar");
                Cancelar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });

                JButton ConsultarA = new JButton("Consultar Alunos");
                ConsultarA.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame frame = new JFrame("Consultar Alunos");
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        for(Aluno aluno : Faculdade.getAlunos()){
                            JLabel label = new JLabel(aluno.toString());
                            panel.add(label);
                        }
                        frame.add(panel);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                    }
                });

                JButton ConsultarT = new JButton("Consultar Turmas");
                ConsultarT.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame frame = new JFrame("Consultar Turmas");
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        for(Turmas turmas : Faculdade.getTurmas()){
                            JLabel label = new JLabel(turmas.toString());
                            panel.add(label);
                        }
                        frame.add(panel);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                    }
                });

                panel.add(labelA1);
                panel.add(CodigoAluno);
                panel.add(labelA2);
                panel.add(CodigoTurma);
                panel.add(Adicionar);
                panel.add(Cancelar);
                panel.add(ConsultarA);
                panel.add(ConsultarT);
                frame.add(panel);
                frame.setSize(500, 300);
                frame.setVisible(true);
            }
        });

        JMenuItem addProfessorT = new JMenuItem("Adicionar Professor a Turma");
        JMenuItem addNota = new JMenuItem("Adicionar Nota a aluno");

        
        fileMenu.add(newAluno);
        fileMenu.add(newProfessor);
        fileMenu.add(newTurma);

        editMenu.add(editAluno);
        editMenu.add(editProfessor);
        editMenu.add(editTurma);

        viewMenu.add(consultAlunos);
        viewMenu.add(consultProfessores);
        viewMenu.add(consultTurmas);

        addMenu.add(addAlunoT);
        addMenu.add(addProfessorT);
        addMenu.add(addNota);


        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
