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
                        if (nome.equals("")) { // Tratamento de erros
                            JOptionPane.showMessageDialog(frame, "Nome do aluno não pode ser vazio.");
                            return;
                        }
                        else if (nome.length() > 50) {
                            JOptionPane.showMessageDialog(frame, "Nome do aluno não pode ter mais de 50 caracteres.");
                            return;
                        }
                        else if (nome.length() < 3) {
                            JOptionPane.showMessageDialog(frame, "Nome do aluno não pode ter menos de 3 caracteres.");
                            return;
                        }

                        else if (nome.equals(" ")) {
                            JOptionPane.showMessageDialog(frame, "Nome do aluno não pode ser vazio.");
                            return;
                        }
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
                            JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!");
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
                        if (nome.equals("")) { // Tratamento de erros
                            JOptionPane.showMessageDialog(frame, "Nome da turma não pode ser vazio.");
                            return;
                        }
                        else if (nome.length() > 50) {
                            JOptionPane.showMessageDialog(frame, "Nome da turma não pode ter mais de 50 caracteres.");
                            return;
                        }
                        else if (nome.length() < 2) {
                            JOptionPane.showMessageDialog(frame, "Nome da turma não pode ter menos de 2 caracteres.");
                            return;
                        }

                        else if (nome.equals(" ")) {
                            JOptionPane.showMessageDialog(frame, "Nome da turma não pode ser vazio.");
                            return;
                        }
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
                            JOptionPane.showMessageDialog(frame, "Turma cadastrada com sucesso!");
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
                        if (nome.equals("")) { // Tratamento de erros
                            JOptionPane.showMessageDialog(frame, "Nome do professor não pode ser vazio.");
                            return;
                        }
                        else if (nome.length() > 50) {
                            JOptionPane.showMessageDialog(frame, "Nome do professor não pode ter mais de 50 caracteres.");
                            return;
                        }
                        else if (nome.length() < 3) {
                            JOptionPane.showMessageDialog(frame, "Nome do professor não pode ter menos de 3 caracteres.");
                            return;
                        }

                        else if (nome.equals(" ")) {
                            JOptionPane.showMessageDialog(frame, "Nome do professor não pode ser vazio.");
                            return;
                        }
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
                            JOptionPane.showMessageDialog(frame, "Professor cadastrado com sucesso!");
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


        //BOTÕES DE EDIÇÃO
        JMenuItem editAluno = new JMenuItem("Editar Aluno");
        JMenuItem editTurma = new JMenuItem("Editar Turma");
        JMenuItem editProfessor = new JMenuItem("Editar Professor");

        JMenuItem consultAlunos = new JMenuItem("Consultar Alunos");
        consultAlunos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Consultar Alunos");
                JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                        imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                        g.drawImage(imageIcon.getImage(), 0, 0, null);
                    
                    }
                };
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
                JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                        imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                        g.drawImage(imageIcon.getImage(), 0, 0, null);
                    
                    }
                };
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                for (Turmas turmas : Faculdade.getTurmas()) {
                    String nomeTurma = turmas.getNomeTurma();
                    Integer codigoTurma = turmas.getCodigoTurmas();
                    ArrayList<Integer> listaDeAlunos = Faculdade.getTurma(codigoTurma).getAlunos();
                    String professor = turmas.getProfessor() != null ? turmas.getProfessor().getNome() : "Nenhum professor atribuído";
                    String stringFinal = String.format("<html>%s - Código: %d <br> Professor: %s <br> Lista de Alunos: <br>", nomeTurma, codigoTurma, professor);
                    
                    
                    for (Integer codigo : listaDeAlunos) {
                        Aluno aluno = Faculdade.getAluno(codigo);
                        stringFinal += String.format("&nbsp;&nbsp;&nbsp;&nbsp;%s - Código: %d<br>", aluno.getNome(), aluno.getCodigoAluno());
                    }

                    /*
                    //erro:
                    for (Integer codigo : listaDeAlunos) {
                        Aluno aluno = Faculdade.getAluno(codigo);
                        NotasMaterias notas = turmas.getNotas(codigo);
                        stringFinal += String.format("&nbsp;&nbsp;&nbsp;&nbsp;%s - Código: %d<br>", aluno.getNome(), aluno.getCodigoAluno());
                    }
                    */
                    
                    stringFinal += "<br></html>";
                    
                    JLabel label = new JLabel(stringFinal);
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
                JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                        imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                        g.drawImage(imageIcon.getImage(), 0, 0, null);
                    
                    }
                };
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
                if (Faculdade.getAlunos().isEmpty() || Faculdade.getTurmas().isEmpty()) { //Tratamento de erro para caso não haja alunos ou turmas cadastrados
                    JOptionPane.showMessageDialog(frame, "Não há alunos ou turmas cadastrados. Por favor, antes faça o cadastro.");
                    return;
                }
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
                        if (Faculdade.getAluno(codigoAluno) == null) { //Tratamento de erro caso o aluno não exista
                            JOptionPane.showMessageDialog(frame, "Aluno não encontrado.");
                            return;
                        }
                        int codigoTurma = Integer.parseInt(CodigoTurma.getText());
                        if (Faculdade.getTurma(codigoTurma) == null) { //Tratamento de erro caso a turma não exista
                            JOptionPane.showMessageDialog(frame, "Turma não encontrada.");
                            return;
                        }
                        

                        Turmas turma = Faculdade.getTurma(codigoTurma);
                        if (turma.hasAluno(codigoAluno)) { //Tratamento de erro caso o aluno já esteja na turma
                            JOptionPane.showMessageDialog(frame, "Aluno já está matriculado na turma.");
                            return;
                        }

                        
                        turma.adicionarAluno(codigoAluno);
                        turma.addNota(codigoAluno, Float.parseFloat("0"));
                    
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Turmas.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getTurmas());
                            System.out.println(Faculdade.getAluno(codigoAluno));
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                            JOptionPane.showMessageDialog(frame, "Aluno adicionado a turma com sucesso!");
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
                        JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                                imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                                g.drawImage(imageIcon.getImage(), 0, 0, null);
                            
                            }
                        };
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
                        JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                                imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                                g.drawImage(imageIcon.getImage(), 0, 0, null);
                            
                            }
                        };
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        for (Turmas turmas : Faculdade.getTurmas()) {
                            String nomeTurma = turmas.getNomeTurma();
                            Integer codigoTurma = turmas.getCodigoTurmas();
                            ArrayList<Integer> listaDeAlunos = turmas.getAlunos();
                            String professor = turmas.getProfessor() != null ? turmas.getProfessor().getNome() : "Nenhum professor atribuído";
                            String stringFinal = String.format("<html>%s - Código: %d <br> Professor: %s <br> Lista de Alunos: <br>", nomeTurma, codigoTurma, professor);
                                                        
                            for (Integer codigo : listaDeAlunos) {
                                Aluno aluno = Faculdade.getAluno(codigo);
                                stringFinal += String.format("&nbsp;&nbsp;&nbsp;&nbsp;%s - Código: %d<br>", aluno.getNome(), aluno.getCodigoAluno());
                            }
                            
                            stringFinal += "<br></html>";
                            
                            JLabel label = new JLabel(stringFinal);
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

        JMenuItem addProfessorT = new JMenuItem("Adicionar Professor a Turma"); // Botao para adicionar um professor a uma turma
        addProfessorT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (Faculdade.getProfessores().isEmpty() || Faculdade.getTurmas().isEmpty()) { //Tratamento de erro caso não haja professores ou turmas cadastrados
                    JOptionPane.showMessageDialog(frame, "Não há professores ou turmas cadastrados. Por favor, antes faça o cadastro.");
                    return;
                }
                JFrame frame = new JFrame("Adicionar Professor a Turma");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,2,5,5));

                JLabel labelP1 = new JLabel("Código do Professor:");
                JTextField CodigoProfessor = new JTextField();
                JLabel labelP2 = new JLabel("Código da Turma:");
                JTextField CodigoTurma = new JTextField();

                JButton Adicionar = new JButton("Adicionar");
                Adicionar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int codigoProfessor = Integer.parseInt(CodigoProfessor.getText());
                        if (Faculdade.getProfessor(codigoProfessor) == null) { //Tratamento de erro caso o professor não exista
                            JOptionPane.showMessageDialog(frame, "Professor não encontrado.");
                            return;
                        }
                        int codigoTurma = Integer.parseInt(CodigoTurma.getText());
                        if (Faculdade.getTurma(codigoTurma) == null) { //Tratamento de erro caso a turma não exista
                            JOptionPane.showMessageDialog(frame, "Turma não encontrada.");
                            return;
                        }
                        Professor professor = Faculdade.getProfessor(codigoProfessor);
                        Turmas turma = Faculdade.getTurma(codigoTurma);
                        if (turma.getCodigoProfessor() != 0) { //Tratamento de erro caso a turma já tenha um professor
                            JOptionPane.showMessageDialog(frame, "Turma já possui um professor. Caso deseje mudar o professor, vá a aba Editar.");
                            return;
                        }
                        turma.setCodigoProfessor(codigoProfessor);
                        try {
                            // Criar um FileOutputStream para escrever dados em um arquivo
                            FileOutputStream fileOutputStream = new FileOutputStream("Turmas.txt");
        
                            // Criar um DataOutputStream usando o FileOutputStream
                            ObjectOutputStream objeto = new ObjectOutputStream(fileOutputStream);
                            
                            // Escrever dados no arquivo usando métodos do DataOutputStream
                            objeto.writeObject(Faculdade.getTurmas());
                            System.out.println(professor);
                            // Fechar o DataOutputStream
                            objeto.close();
                            
                            System.out.println("Dados foram escritos no arquivo com sucesso.");
                            JOptionPane.showMessageDialog(frame, "Professor adicionado a turma com sucesso!");
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

                JButton ConsultarP = new JButton("Consultar Professores");
                ConsultarP.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame frame = new JFrame("Consultar Professores");
                        JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                                imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                                g.drawImage(imageIcon.getImage(), 0, 0, null);
                            
                            }
                        };
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

                JButton ConsultarT = new JButton("Consultar Turmas");
                ConsultarT.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JFrame frame = new JFrame("Consultar Turmas");
                        JPanel panel = new JPanel(){         //Setando um background pro panel da visualizaçao
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                ImageIcon imageIcon = new ImageIcon("ProjetoPOO/Data/MIT2Tran.png");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // Scale it to the new size
                                imageIcon = new ImageIcon(newimg);  // Transform it back into an ImageIcon
                                g.drawImage(imageIcon.getImage(), 0, 0, null);
                            
                            }
                        };
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        for (Turmas turmas : Faculdade.getTurmas()) {
                            String nomeTurma = turmas.getNomeTurma();
                            Integer codigoTurma = turmas.getCodigoTurmas();
                            ArrayList<Integer> listaDeAlunos = turmas.getAlunos();
                            String professor = turmas.getProfessor() != null ? turmas.getProfessor().getNome() : "Nenhum professor atribuído";
                            String stringFinal = String.format("<html>%s - Código: %d <br> Professor: %s <br> Lista de Alunos: <br>", nomeTurma, codigoTurma, professor);
                                                        
                            for (Integer codigo : listaDeAlunos) {
                                Aluno aluno = Faculdade.getAluno(codigo);
                                stringFinal += String.format("&nbsp;&nbsp;&nbsp;&nbsp;%s - Código: %d<br>", aluno.getNome(), aluno.getCodigoAluno());
                            }
                            
                            stringFinal += "<br></html>";
                            JLabel label = new JLabel(stringFinal);
                            panel.add(label);
                        }    
                        frame.add(panel);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                    }
                });
            
                panel.add(labelP1);
                panel.add(CodigoProfessor);
                panel.add(labelP2);
                panel.add(CodigoTurma);
                panel.add(Adicionar);
                panel.add(Cancelar);
                panel.add(ConsultarP);
                panel.add(ConsultarT);
                frame.add(panel);
                frame.setSize(500, 300);
                frame.setVisible(true);
            }
        });

        JMenuItem addNota = new JMenuItem("Adicionar Nota a aluno");

        addNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode abrir uma caixa de diálogo para solicitar o nome do aluno e a nota
                JFrame frame = new JFrame("Adicionar Nota a Aluno");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel labelP1 = new JLabel("Código do Aluno:");
                JTextField CodigoAluno = new JTextField();
                JLabel labelP2 = new JLabel("Código da Turma:");
                JTextField CodigoTurma = new JTextField();
                JLabel labelP3 = new JLabel("Nota:");
                JTextField Nota = new JTextField();

                JButton AdicionarNota = new JButton("Adicionar Nota");
                AdicionarNota.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int codaluno = Integer.parseInt(CodigoAluno.getText());
                        int codturma = Integer.parseInt(CodigoTurma.getText());
                        float nota = Float.parseFloat(Nota.getText());

                        if (Faculdade.getAluno(codaluno) != null) {
                            try {
                                Turmas turmas = Faculdade.getTurma(codturma); // pega de algum canto
                                turmas.addNota(codaluno, nota);
                                NotasMaterias notasmaterias = new NotasMaterias(); // Criando um novo arraylist de notas
                                JOptionPane.showMessageDialog(null, "A nota foi adicionada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "A nota deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
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
                panel.add(CodigoAluno);
                panel.add(labelP2);
                panel.add(CodigoTurma);
                panel.add(labelP3);
                panel.add(Nota);
                panel.add(AdicionarNota);
                panel.add(Cancelar);
                frame.add(panel);
                frame.setSize(500, 300);
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

        addMenu.add(addAlunoT);
        addMenu.add(addProfessorT);
        addMenu.add(addNota);


        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
