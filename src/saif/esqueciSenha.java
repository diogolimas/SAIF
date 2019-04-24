package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.LineNumberInputStream;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class esqueciSenha extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	// ARRAYS
	public static ArrayList<Usuario> listaDeUsuariosEsqueci;
	public static ArrayList<turma> turmaGeralTesqueci;
	int z=0;
	T1 t1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public esqueciSenha(ArrayList<Usuario> uss22, ArrayList<turma> turma2) {
		listaDeUsuariosEsqueci = uss22;
		turmaGeralTesqueci = turma2;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(25, 42, 46, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(25, 61, 100, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblMatrcula = new JLabel("matr\u00EDcula");
		lblMatrcula.setBounds(25, 89, 75, 20);
		contentPane.add(lblMatrcula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(25, 111, 100, 20);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		JLabel lblNovaSenha = new JLabel("nova senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNovaSenha.setBounds(25, 176, 89, 14);
		contentPane.add(lblNovaSenha);

		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(25, 199, 112, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setEditable(false);
		passwordField_1.setBounds(25, 244, 112, 20);
		contentPane.add(passwordField_1);

		JLabel lblRepitaANova = new JLabel("repita a nova senha");
		lblRepitaANova.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepitaANova.setBounds(25, 225, 151, 14);
		contentPane.add(lblRepitaANova);

		JLabel lblEsqueciASenha = new JLabel("Esqueci a Senha");
		lblEsqueciASenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEsqueciASenha.setBounds(24, 9, 130, 22);
		contentPane.add(lblEsqueciASenha);

		JButton cadastrarNewSenha = new JButton("cadastrar nova senha");
		
		cadastrarNewSenha.setEnabled(false);
		cadastrarNewSenha.setBounds(25, 278, 151, 23);
		contentPane.add(cadastrarNewSenha);

		JButton btnBack = new JButton("back");

		btnBack.setBounds(175, 39, 75, 23);
		contentPane.add(btnBack);

		JButton verificar = new JButton("verificar");

		verificar.setBounds(25, 138, 100, 23);
		contentPane.add(verificar);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1 = new T1(listaDeUsuariosEsqueci, turmaGeralTesqueci);
				t1.setVisible(true);
				dispose();

			}
		});

		verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int met = 0;
				for (int jau = 0; jau < listaDeUsuariosEsqueci.size(); jau++) {

					if (listaDeUsuariosEsqueci.get(jau).getNome().equalsIgnoreCase(textFieldNome.getText())
							&& (listaDeUsuariosEsqueci.get(jau).getMatricula()
									.equalsIgnoreCase(textFieldMatricula.getText()))) {
							passwordField.setEditable(true);
							passwordField_1.setEditable(true);
							cadastrarNewSenha.setEnabled(true);
							z=jau;
						met = -1;
						System.out.println(""+listaDeUsuariosEsqueci.get(jau).toString());
						
					}
				}
				
				if(met>=0) {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cadastrarNewSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passnew = new String(passwordField.getPassword());
				System.out.println(""+passnew);
				System.out.println(""+listaDeUsuariosEsqueci.get(z).toString());
				listaDeUsuariosEsqueci.get(z).setSenha(passnew);
			}
		});

	}
}
