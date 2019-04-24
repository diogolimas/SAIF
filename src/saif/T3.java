package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;

public class T3 extends JFrame {

	private JPanel contentPane;
	private JTextField nomeText;
	private JTextField matriculaText;
	
	
	
	ArrayList<Usuario> listaDeUsuariosT3;
	private JTextField senhaText;
	
	
	
	public static ArrayList<turma> turmaGeralT3;

	T1 janela1;
	T2 janela2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public T3(ArrayList<Usuario> lista1, ArrayList<turma> turmas5) {
		setTitle("cadastramento");
		listaDeUsuariosT3 = lista1;
		turmaGeralT3=turmas5;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// atributos
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelMatricula = new JLabel("Matr\u00EDcula:");
		nomeText = new JTextField();
		matriculaText = new JTextField();
		JRadioButton rdbtnProfessor = new JRadioButton("professor");
		buttonGroup.add(rdbtnProfessor);
		rdbtnProfessor.setBackground(new Color(204, 204, 204));
		JRadioButton rdbtnAluno = new JRadioButton("aluno");
		buttonGroup.add(rdbtnAluno);
		rdbtnAluno.setBackground(new Color(204, 204, 204));
		JLabel lblSenha = new JLabel("senha");
		senhaText = new JTextField();
		JButton btCadastrar = new JButton("cadastrar");
		JButton exit = new JButton("X");
		JButton btnBack = new JButton("back");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela2 = new T2(listaDeUsuariosT3, turmaGeralT3);
				janela2.setVisible(true);
				janela2.setResizable(false);
				dispose();
			}
		});

		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnProfessor.isSelected()) {
					Usuario profe = new Professor(nomeText.getText(), matriculaText.getText(), senhaText.getText());
					listaDeUsuariosT3.add(profe);
					JOptionPane.showMessageDialog(null, "Professor cadastrado", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					nomeText.setText("");
					matriculaText.setText("");
					senhaText.setText("");

				}
				if (rdbtnAluno.isSelected()) {
					Usuario aluno = new Aluno(nomeText.getText(), matriculaText.getText(), senhaText.getText(), 0, 0);
					listaDeUsuariosT3.add(aluno);
					JOptionPane.showMessageDialog(null, "aluno cadastrado", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					nomeText.setText("");
					matriculaText.setText("");
					senhaText.setText("");

				}
				if (rdbtnAluno.isSelected() == false && rdbtnProfessor.isSelected()==false) {
					JOptionPane.showMessageDialog(null, "selecione, ao menos, um tipo de cadastramneto", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				System.out.println(listaDeUsuariosT3.toString());
			}
		});

		nomeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nomeText.setBounds(10, 91, 96, 20);
		contentPane.add(nomeText);
		nomeText.setColumns(10);

		labelNome.setBounds(10, 66, 47, 14);
		contentPane.add(labelNome);

		labelMatricula.setBounds(10, 122, 118, 14);
		contentPane.add(labelMatricula);

		matriculaText.setBounds(10, 138, 96, 20);
		contentPane.add(matriculaText);
		matriculaText.setColumns(10);

		rdbtnProfessor.setBounds(10, 7, 109, 23);
		contentPane.add(rdbtnProfessor);

		rdbtnAluno.setBounds(10, 36, 109, 23);
		contentPane.add(rdbtnAluno);

		lblSenha.setBounds(11, 169, 46, 14);
		contentPane.add(lblSenha);

		senhaText.setBounds(10, 185, 96, 20);
		contentPane.add(senhaText);
		senhaText.setColumns(10);

		btCadastrar.setBounds(10, 233, 96, 23);
		contentPane.add(btCadastrar);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela1 = new T1(listaDeUsuariosT3, turmaGeralT3);
				janela1.setVisible(true);
				janela1.setResizable(false);
				dispose();
			}
		});
		exit.setBackground(new Color(255, 0, 0));
		exit.setBounds(159, 7, 47, 23);
		contentPane.add(exit);

		btnBack.setBounds(147, 36, 67, 23);
		contentPane.add(btnBack);
	}


}
