package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Tprofessor extends JFrame {

	private JPanel painelGeral;
	private JTextField textoProfessor;
	
	public static ArrayList<Usuario> listaDeUsuariosTprofessor;
	public static ArrayList<turma> turmaGeralTprofessor;
	
	
	
	String nome;
	T1 janela11;
	Tprofessor1 jan12;
	private JTextField textFieldindice;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Tprofessor(ArrayList<Usuario> lista3, ArrayList<turma> turmas56) {
		
		listaDeUsuariosTprofessor = lista3;
		turmaGeralTprofessor=turmas56;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 248);
		painelGeral = new JPanel();
		painelGeral.setBackground(new Color(204, 204, 204));
		painelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelGeral);
		painelGeral.setLayout(null);
		
		JButton turmas = new JButton("Minhas turmas");
		JLabel professor = new JLabel("Atual Professor:");
		JButton botaoback = new JButton("Back");
		textoProfessor = new JTextField();
		textoProfessor.setEditable(false);
		
		turmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jan12 = new Tprofessor1(listaDeUsuariosTprofessor, turmaGeralTprofessor);
				jan12.setVisible(true);
				jan12.setResizable(false);
				jan12.enviarPalavra(listaDeUsuariosTprofessor.get(Integer.parseInt(textFieldindice.getText())).getNome(), Integer.parseInt(textFieldindice.getText()));
				dispose();
			}
		});
		turmas.setBounds(10, 11, 148, 45);
		painelGeral.add(turmas);
		
		
		professor.setBounds(10, 127, 87, 21);
		painelGeral.add(professor);
		
		
		textoProfessor.setBounds(10, 149, 123, 24);
		painelGeral.add(textoProfessor);
		textoProfessor.setColumns(10);
		
		
		botaoback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				janela11 = new T1(listaDeUsuariosTprofessor, turmaGeralTprofessor );
				janela11.setVisible(true);
				janela11.setResizable(false);
				dispose();
			}
		});
		botaoback.setBackground(Color.RED);
		botaoback.setBounds(160, 160, 89, 23);
		painelGeral.add(botaoback);
		
		textFieldindice = new JTextField();
		textFieldindice.setEditable(false);
		textFieldindice.setBounds(10, 178, 45, 20);
		painelGeral.add(textFieldindice);
		textFieldindice.setColumns(10);
	}

	public void enviarPalavra(String nome, Usuario u ) {
		textoProfessor.setText(nome);
		textFieldindice.setText(""+listaDeUsuariosTprofessor.indexOf(u));
		
	}
}
