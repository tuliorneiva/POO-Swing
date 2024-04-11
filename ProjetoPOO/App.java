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
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        JMenuItem newAluno = new JMenuItem("Cadastrar Aluno"); //Criando um popup para a menubar Cadastrar Aluno
        newAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Aluno");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labela1 = new JLabel("Nome do Aluno:");
                JLabel labela2 = new JLabel("Turma:");

                JTextField NomeAluno = new JTextField();
                JTextField TurmaAluno = new JTextField();

                JButton Cadastrar = new JButton("Cadastrar");
                JButton Cancelar = new JButton("Cancelar");
                panel.add(labela1);
                panel.add(NomeAluno);
                panel.add(labela2);
                panel.add(TurmaAluno);
                panel.add(Cadastrar);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 250);
                frame.setVisible(true);
            }
        });

        JMenuItem newTurma = new JMenuItem("Cadastrar Turma"); //Criando um popup para a menubar Cadastrar Turma
        newTurma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Turma");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labelT1 = new JLabel("Turma:");
                JLabel labelT2 = new JLabel("Professor:");

                JTextField NomeTurma = new JTextField();
                JTextField TurmaProfessor = new JTextField();

                JButton Cadastrar = new JButton("Cadastrar");
                Cadastrar.addActionListener(new ActionListener() { // Adicionando um evento ao botão Cadastrar que Salva o nome do professor em um arquivo file.txt
                    public void actionPerformed(ActionEvent e) {
                        String nome = NomeTurma.getText();
                        String professor = TurmaProfessor.getText();
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            dataOutputStream.writeUTF(nome);
                            dataOutputStream.writeUTF(professor);
                            System.out.println(nome);
                            // Fechar o DataOutputStream
                            dataOutputStream.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JButton Cancelar = new JButton("Cancelar");
                panel.add(labelT1);
                panel.add(NomeTurma);
                panel.add(labelT2);
                panel.add(TurmaProfessor);
                panel.add(Cadastrar);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 250);
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
                            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        
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
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JMenuItem consultTurmas = new JMenuItem("Consultar Turmas");
        JMenuItem consultProfessores = new JMenuItem("Consultar Professores");
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

        
        fileMenu.add(newAluno);
        fileMenu.add(newProfessor);
        fileMenu.add(newTurma);

        editMenu.add(editAluno);
        editMenu.add(editProfessor);
        editMenu.add(editTurma);

        viewMenu.add(consultAlunos);
        viewMenu.add(consultProfessores);
        viewMenu.add(consultTurmas);

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
