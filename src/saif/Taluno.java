package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Taluno extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAtual;
	
	public static ArrayList<Usuario> listaDeUsuariosTaluno;
	public static ArrayList<turma> turmaGeralTaluno;
	int meet;
	
	T1 janela1;
	private JTextField textFieldindice;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Taluno(ArrayList<Usuario> lista2, ArrayList<turma> turma22 ) {
		setTitle("aluno1");
		listaDeUsuariosTaluno = lista2;
		turmaGeralTaluno=turma22;
		
		
		
		JButton btnNewButton = new JButton("Turmas Virtuais");
		
		Label label = new Label("Atualizar Usuario");
		JButton Sair = new JButton("back");
		textFieldAtual = new JTextField();
		textFieldAtual.setEditable(false);
		JButton Boletim = new JButton("Boletim");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 187, 263);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		label.setBounds(20, 104, 106, 20);
		contentPane.add(label);
		

// minhas turmas		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 meet = 0;
				int i = Integer.parseInt(textFieldindice.getText());
				int ind = i;
				Usuario usuario = listaDeUsuariosTaluno.get(ind);

				for (int u = 0; u < turmaGeralTaluno.size(); u++) {
					System.out.println("" + turmaGeralTaluno.get(u).getTurma().toString());
					System.out.println("" + listaDeUsuariosTaluno.get(ind).toString());
					String text = textFieldAtual.getText();
					if (turmaGeralTaluno.get(u).getTurma().contains(listaDeUsuariosTaluno.get(ind))) {
						String turmas = new String("" + turmaGeralTaluno.get(u).getTurma());
						JOptionPane.showMessageDialog(null, "" + turmaGeralTaluno.get(u).getTurma(), "suas turmas",
								JOptionPane.INFORMATION_MESSAGE);
						meet=-1;
					}
				}
				if(meet>=0) {
					JOptionPane.showMessageDialog(null, "Você não possui nenhuma turma", "error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela1= new T1(listaDeUsuariosTaluno, turmaGeralTaluno);
				janela1.setVisible(true);
				janela1.setResizable(false);
				dispose();
			}
		});
		Sair.setBounds(87, 190, 74, 23);
		contentPane.add(Sair);
		
		
		textFieldAtual.setBounds(20, 130, 126, 20);
		contentPane.add(textFieldAtual);
		textFieldAtual.setColumns(10);
		
		
		btnNewButton.setBounds(20, 33, 126, 23);
		contentPane.add(btnNewButton);
		
		
		Boletim.setBounds(20, 75, 126, 23);
		contentPane.add(Boletim);
		
		textFieldindice = new JTextField();
		textFieldindice.setBounds(20, 161, 65, 20);
		contentPane.add(textFieldindice);
		textFieldindice.setColumns(10);
	}

	public void enviarPalavra(String nome, Usuario u) {
		textFieldAtual.setText(nome);
		textFieldindice.setText(""+listaDeUsuariosTaluno.indexOf(u));
		
	}
}
