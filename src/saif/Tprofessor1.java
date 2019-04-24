package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tprofessor1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTurma;
	private JTextField textFieldAluno;
	private JTextField textFieldprimeiro;
	private JTextField textFieldterceiro;
	private JTextField textFieldsegundo;
	private JTextField atualProfessor;

	public static ArrayList<Usuario> listaDeUsuariosTprofessor1;
	public static ArrayList<turma> turmaGeralTprofessor1;

	private JTextField textFieldindice;

	Tprofessor jan223;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Tprofessor1(ArrayList<Usuario> lista23, ArrayList<turma> turmas23) {
		setTitle("professor");
		listaDeUsuariosTprofessor1 = lista23;
		turmaGeralTprofessor1 = turmas23;
		System.out.println("" + lista23.toString());
		System.out.println("" + turmas23.toString());

		// atributos
		Label Faltas = new Label("Faltas");
		JPanel panel = new JPanel();
		JButton Sair = new JButton("back");

		JPanel Notass = new JPanel();
		JButton Pesquisar = new JButton("Pesquisar");
		Label Aluno = new Label(" Aluno");
		Label alterarNota = new Label("    Alterar Nota");
		JLabel lblTurma = new JLabel("turma");
		JPanel panel_1 = new JPanel();
		JButton Alterar = new JButton("Alterar");
		Alterar.setEnabled(false);
		Label label_2 = new Label("1\u00BA Bim");
		Label label_3 = new Label("2\u00BA Bim");
		textFieldterceiro = new JTextField();
		textFieldterceiro.setEditable(false);
		textFieldprimeiro = new JTextField();
		textFieldprimeiro.setEditable(false);
		textFieldAluno = new JTextField();
		JLabel lblAtualProfe = new JLabel("atual profe");
		textFieldindice = new JTextField();
		atualProfessor = new JTextField();
		textFieldsegundo = new JTextField();
		textFieldsegundo.setEditable(false);
		JButton VerTurmas = new JButton("Ver Turmas");
		Label Turmas = new Label("Turmas");
		JButton VerAlunos = new JButton(" Ver Alunos");
		textFieldTurma = new JTextField();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// sair
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jan223 = new Tprofessor(listaDeUsuariosTprofessor1, turmaGeralTprofessor1);
				jan223.setVisible(true);
				jan223.setResizable(false);
				jan223.enviarPalavra(
						listaDeUsuariosTprofessor1.get(Integer.parseInt(textFieldindice.getText())).getNome(),
						listaDeUsuariosTprofessor1.get(Integer.parseInt(textFieldindice.getText())));
				dispose();
			}
		});

		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 10, 192, 145);
		contentPane.add(panel);
		panel.setLayout(null);

		VerTurmas.setBounds(39, 59, 132, 23);
		panel.add(VerTurmas);

		VerTurmas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		Turmas.setBounds(54, 22, 76, 22);
		panel.add(Turmas);

		Turmas.setBackground(new Color(204, 204, 204));
		Turmas.setFont(new Font("Dialog", Font.BOLD, 17));
		Turmas.setPreferredSize(new Dimension(9, 9));
		Turmas.setMinimumSize(new Dimension(10, 10));

		VerAlunos.setBounds(39, 93, 132, 23);
		panel.add(VerAlunos);
		VerAlunos.setFont(new Font("Tahoma", Font.PLAIN, 11));

		Sair.setBounds(202, 419, 89, 23);
		contentPane.add(Sair);

		Notass.setBackground(new Color(204, 204, 204));
		Notass.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Notass.setBounds(-1, 167, 193, 162);
		contentPane.add(Notass);
		Notass.setLayout(null);

		Pesquisar.setBounds(10, 128, 173, 23);
		Notass.add(Pesquisar);

		// ver turmas, todas-
		VerTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(textFieldindice.getText());
				int ind = i;
				Usuario usuario = listaDeUsuariosTprofessor1.get(ind);

				for (int u = 0; u < turmaGeralTprofessor1.size(); u++) {
					System.out.println("" + turmaGeralTprofessor1.get(u).getTurma().toString());
					System.out.println("" + listaDeUsuariosTprofessor1.get(ind).toString());
					String text = atualProfessor.getText();
					if (turmaGeralTprofessor1.get(u).getTurma().contains(listaDeUsuariosTprofessor1.get(ind))) {
						String turmas = new String("" + turmaGeralTprofessor1.get(u).getTurma());
						JOptionPane.showMessageDialog(null, "" + turmaGeralTprofessor1.get(u).getTurma(), "suas turmas",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		// ver allunos
		VerAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(textFieldindice.getText());
				int ind = i;
				Usuario usuario = listaDeUsuariosTprofessor1.get(ind);

				for (int u = 0; u < turmaGeralTprofessor1.size(); u++) {
					System.out.println("" + turmaGeralTprofessor1.get(u).getTurma().toString());
					System.out.println("" + listaDeUsuariosTprofessor1.get(ind).toString());
					String text = atualProfessor.getText();
					if (turmaGeralTprofessor1.get(u).getTurma().contains(listaDeUsuariosTprofessor1.get(ind))) {
						String turmas = new String("" + turmaGeralTprofessor1.get(u).getTurma());
						JOptionPane.showMessageDialog(null, "" + turmaGeralTprofessor1.get(u).getTurma(), "suas turmas",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// pesquisar
		Pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(textFieldindice.getText());
				int ind = i;
				Usuario usuario = listaDeUsuariosTprofessor1.get(ind);

				for (int u = 0; u < turmaGeralTprofessor1.size(); u++) {
					System.out.println("" + turmaGeralTprofessor1.get(u).getTurma().toString());
					System.out.println("" + listaDeUsuariosTprofessor1.get(ind).toString());
					String text = atualProfessor.getText();
					if (turmaGeralTprofessor1.get(u).getTurma().contains(listaDeUsuariosTprofessor1.get(ind))) {
						String turmas = new String("" + turmaGeralTprofessor1.get(u).getTurma());
						JOptionPane.showMessageDialog(null, "" + turmaGeralTprofessor1.get(u).getTurma(), "suas turmas",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
			}
		});
		textFieldAluno.setBounds(10, 104, 173, 20);
		Notass.add(textFieldAluno);
		textFieldAluno.setColumns(10);

		Aluno.setBounds(10, 78, 86, 22);
		Notass.add(Aluno);
		Aluno.setBackground(new Color(204, 204, 204));
		Aluno.setFont(new Font("Dialog", Font.PLAIN, 11));

		textFieldTurma.setBounds(10, 54, 173, 20);
		Notass.add(textFieldTurma);
		textFieldTurma.setColumns(10);

		alterarNota.setBounds(34, 10, 132, 22);
		Notass.add(alterarNota);
		alterarNota.setBackground(new Color(204, 204, 204));
		alterarNota.setFont(new Font("Dialog", Font.BOLD, 14));

		lblTurma.setBounds(10, 38, 46, 14);
		Notass.add(lblTurma);

		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(0, 340, 192, 145);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textFieldprimeiro.setBounds(10, 11, 86, 20);
		panel_1.add(textFieldprimeiro);
		textFieldprimeiro.setColumns(10);

		textFieldsegundo.setBounds(10, 42, 86, 20);
		panel_1.add(textFieldsegundo);
		textFieldsegundo.setColumns(10);

		Alterar.setBounds(7, 111, 89, 23);
		panel_1.add(Alterar);

		label_2.setBounds(107, 9, 45, 22);
		panel_1.add(label_2);

		label_3.setBounds(105, 42, 62, 22);
		panel_1.add(label_3);

		textFieldterceiro.setBounds(10, 73, 86, 20);
		panel_1.add(textFieldterceiro);
		textFieldterceiro.setColumns(10);

		Faltas.setBounds(107, 70, 62, 22);
		panel_1.add(Faltas);

		atualProfessor.setEditable(false);
		atualProfessor.setBounds(202, 388, 86, 20);
		contentPane.add(atualProfessor);
		atualProfessor.setColumns(10);

		lblAtualProfe.setBounds(201, 370, 90, 14);
		contentPane.add(lblAtualProfe);

		textFieldindice.setEditable(false);
		textFieldindice.setBounds(202, 453, 66, 22);
		contentPane.add(textFieldindice);
		textFieldindice.setColumns(10);
	}

	public void enviarPalavra(String nome, int u) {
		atualProfessor.setText(nome);
		textFieldindice.setText("" + u);
	}
}
