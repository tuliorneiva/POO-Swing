package ProjetoPOO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("unused")
public class App implements Runnable{

    public void run(){
        JFrame frame = new JFrame("Hello World");
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("MIT - Mangabeira Institute of Technology");
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Novo");
        JMenu editMenu = new JMenu("Editar");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JMenuItem newAluno = new JMenuItem("Cadastrar Aluno"); //Criando um popup para a menubar Cadastrar Aluno
        newAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Aluno");
                JPanel panel = new JPanel();
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });

        JMenuItem newTurma = new JMenuItem("Cadastrar Turma"); //Criando um popup para a menubar Cadastrar Turma
        newTurma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Turma");
                JPanel panel = new JPanel();
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
        JMenuItem newProfessor = new JMenuItem("Cadastrar Professor"); //Criando um popup para a menubar Cadastrar Professor
        newProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cadastrar Professor");
                JPanel panel = new JPanel();
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });

        JMenuItem editAluno = new JMenuItem("Editar Aluno");
        JMenuItem editTurma = new JMenuItem("Editar Turma");
        JMenuItem editProfessor = new JMenuItem("Editar Professor");

        
        fileMenu.add(newAluno);
        fileMenu.add(newProfessor);
        fileMenu.add(newTurma);

        editMenu.add(editAluno);
        editMenu.add(editProfessor);
        editMenu.add(editTurma);

        frame.setSize(900, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
