package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class T2 extends JFrame {

	private JPanel contentPane;
	private JTextField textAtual;
	Usuario us;
	
	
	public static ArrayList<Usuario> listaDeUsuariosT2;
	public static ArrayList<turma> turmaGeralT2;
	
	
	T3 janelaCad;
	T2cadastrarTurma tjanela;
	int sair21=1;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public T2(ArrayList<Usuario> lista, ArrayList<turma> turmas1) {
		setTitle("Administrador");
		listaDeUsuariosT2 = lista;
		turmaGeralT2=turmas1;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 233);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//atributos
		Label atualUsuario = new Label("Atual Usu\u00E1rio:");
		JButton cadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		JButton turmas = new JButton("Turmas");
		JButton sair = new JButton("Sair");
		textAtual = new JTextField();
		JButton todosUsuarios = new JButton("Todos os Usu\u00E1rios");
		
		
// cadastrar usuário
		cadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaCad = new T3(listaDeUsuariosT2, turmaGeralT2);
				janelaCad.setVisible(true);
				janelaCad.setResizable(false);
				dispose();
			}
		});
	
		
		cadastrarUsuario.setBounds(10, 11, 138, 42);
		contentPane.add(cadastrarUsuario);
		
		turmas.setBounds(182, 60, 203, 42);
		contentPane.add(turmas);
		
		sair.setBounds(262, 160, 58, 23);
		contentPane.add(sair);
		
		textAtual.setBounds(10, 163, 138, 20);
		contentPane.add(textAtual);
		
		textAtual.setColumns(10);
		
		atualUsuario.setBounds(10, 134, 138, 22);
		contentPane.add(atualUsuario);
		
//		bt todos os usuários
		todosUsuarios.setBounds(10, 61, 138, 41);
		contentPane.add(todosUsuarios);
		
		JButton btnCadastrarTurmas = new JButton("Cadastrar/ editar Turmas");
		btnCadastrarTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tjanela = new T2cadastrarTurma(listaDeUsuariosT2, turmaGeralT2);
				tjanela.setVisible(true);
				tjanela.setResizable(false);
				dispose();
			}
		});
		
		// cadastrar turmas
		btnCadastrarTurmas.setBounds(182, 11, 203, 42);
		contentPane.add(btnCadastrarTurmas);
		todosUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "[ Todos os usuários "+listaDeUsuariosT2.toString(), "Todos os usuários", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//sair
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T1 janela1 = new T1(listaDeUsuariosT2, turmaGeralT2);
				janela1.setVisible(true);
				janela1.setResizable(false);
				dispose();
			}
		});
		
		// todas turmas
		turmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(turmaGeralT2==null) {
					JOptionPane.showMessageDialog(null, "Não possui nenhuma turma cadastrada", "error", JOptionPane.ERROR_MESSAGE);
				}else {
				JOptionPane.showMessageDialog(null,turmaGeralT2.toString(), "Todas as turmas", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	public void enviarPalavra(String nome) {
		textAtual.setText(nome);
	}
}
