package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T2cadastrarTurma extends JFrame {

	private JPanel contentPane;
	private JTextField textNomedaTurma;
	private JTextField textNome;
	private JTextField textMatricula;
	private JTextField textSenha;

	T2 janela2;
	// arraylist
	ArrayList<Usuario> listaDeUsuariosTcadastrarTurma;
	ArrayList<turma> TurmasGeral;
	ArrayList<Usuario> pessoasDaTurma = new ArrayList<Usuario>();

	private JTextField textFieldPeriodo;
	int exit2 = 0;
	int exit3 = 0;
	int exit4 = 0;
	int exit5 = 0;
	int exit6 = 0;
	int entrar = 0;
	turma turma;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public T2cadastrarTurma(ArrayList<Usuario> lista45, ArrayList<turma> turma45  ) {
		setTitle("cadastrar/editar turma");
		listaDeUsuariosTcadastrarTurma = lista45;
		TurmasGeral=turma45;
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		// atributos
		JButton btnRemoverAluno = new JButton("remover aluno");

		JLabel lblNomeDaTurma = new JLabel("Nome da turma");
		JLabel lblAlunosEProfessores = new JLabel("adicionar alunos e professores \u00E0 turma");
		JButton btnIntegrantes = new JButton("integrantes  da turma");

		btnIntegrantes.setEnabled(false);
		JLabel lblNome = new JLabel("nome:");
		textNome = new JTextField();
		textNome.setEnabled(false);
		textFieldPeriodo = new JTextField();
		JLabel lblMatricula = new JLabel("matricula:");
		JLabel lblSenha = new JLabel("senha:");
		textMatricula = new JTextField();
		textMatricula.setEnabled(false);
		textSenha = new JTextField();
		textSenha.setEnabled(false);
		JButton btnAdicionarAluno = new JButton("Adicionar Aluno ");
		btnAdicionarAluno.setEnabled(false);
		JButton btnNack = new JButton("back");
		JButton btnFinalizarTurma = new JButton("finalizar turma");

		btnFinalizarTurma.setEnabled(false);
		JLabel lblCliqueAqui = new JLabel("clique aqui:");
		JPanel panel = new JPanel();
		JButton btnAqui = new JButton("aqui");
		textNomedaTurma = new JTextField();
		JLabel lblTodosOsUsurios = new JLabel("todos os usu\u00E1rios");
		JLabel lblDoSistema = new JLabel("do sistema;");
		JButton btncadastrarTurma = new JButton("Cadastrar turma");
		JButton editarTurma = new JButton("editar turma");
		JButton buttonRemover = new JButton("Remover turma");
		// atributos end
		// cadastrarTurma
		btncadastrarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo para o cadastro de turma está/estão vazio", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
						turma = new turma(pessoasDaTurma, "", "");
						turma.setDisciplina(textNomedaTurma.getText());
						turma.setPeriodo(textFieldPeriodo.getText());
						TurmasGeral.add(turma);
						System.out.println("" + TurmasGeral.toString());
						textNomedaTurma.setText("");
						textFieldPeriodo.setText("");
						
					
//					}

				}
				
			}
		});

		
		
		// integrantes da turma
		btnIntegrantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int errou10 = 0;

				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()
						|| textNome.getText().isEmpty() || textMatricula.getText().isEmpty()
						|| textSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo para o cadastro de turma/aluno está/estão vazio",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					do {

						for (turma pp : TurmasGeral) {
							if (pp.getDisciplina().equalsIgnoreCase(textNomedaTurma.getText())
									&& pp.getPeriodo().equalsIgnoreCase(textFieldPeriodo.getText())) {
								System.out.println("entrou no for each");
								exit3 = 1;
								errou10 = -1;
								JOptionPane.showMessageDialog(null, ""+pp.getTurma().toString(), "information", JOptionPane.INFORMATION_MESSAGE);
								pp.getTurma();

							}
						}
						System.out.println("saiu do for each");

						exit2 = 1;

					} while (exit2 == 0);
					if (errou10 >= 0) {
						JOptionPane.showMessageDialog(null, "A turma não está cadastrada", "error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		// todos os usuários
		btnAqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "[ Todos os usuários " + listaDeUsuariosTcadastrarTurma.toString(),
						"Todos os usuários", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		lblNomeDaTurma.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		lblNomeDaTurma.setBounds(10, 11, 103, 14);
		contentPane.add(lblNomeDaTurma);

		textNomedaTurma.setBounds(10, 32, 135, 20);
		contentPane.add(textNomedaTurma);
		textNomedaTurma.setColumns(10);

		// finalizar turma
		btnFinalizarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomedaTurma.setText("");
				textFieldPeriodo.setText("");

			}
		});

		// remover aluno
		btnRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int errou7 = 0;
				int errou8 = 0;
				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()
						|| textNome.getText().isEmpty() || textMatricula.getText().isEmpty()
						|| textSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo para o cadastro de turma/aluno está/estão vazio",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					do {

						for (turma pp : TurmasGeral) {
							if (pp.getDisciplina().equalsIgnoreCase(textNomedaTurma.getText())
									&& pp.getPeriodo().equalsIgnoreCase(textFieldPeriodo.getText())) {
								System.out.println("entrou no for each");
								exit3 = 1;
								errou7 = -1;

								do {
									for (Usuario ui : listaDeUsuariosTcadastrarTurma) {
										if (ui.getNome().equalsIgnoreCase(textNome.getText())
												&& ui.getMatricula().equalsIgnoreCase(textMatricula.getText())
												&& ui.getSenha().equalsIgnoreCase(textSenha.getText())) {
											errou8 = -1;
											System.out.println("o objeto está no array");
											pessoasDaTurma.remove(ui);
											exit3 = 1;
											pp.setTurma1(pessoasDaTurma);
											System.out.println("" + TurmasGeral.toString());
										}
										exit3 = 1;

									}
								} while (exit3 == 0);
								if (errou8 >= 0) {
									JOptionPane.showMessageDialog(null, "O aluno não está cadastrado", "error",
											JOptionPane.ERROR_MESSAGE);
								}

							}
						}
						System.out.println("saiu do for each");

						exit2 = 1;

					} while (exit2 == 0);
					if (errou8 >= 0) {
						JOptionPane.showMessageDialog(null, "A turma não está cadastrada", "error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		});

		// adicionar um aluno
		btnAdicionarAluno.addActionListener(new ActionListener() {
			int errou5 = 0;
			int errou6 = 0;

			public void actionPerformed(ActionEvent arg0) {
				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()
						|| textNome.getText().isEmpty() || textMatricula.getText().isEmpty()
						|| textSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo para o cadastro de turma/aluno está/estão vazio",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					do {

						for (turma t : TurmasGeral) {
							if (t.getDisciplina().equalsIgnoreCase(textNomedaTurma.getText())
									&& t.getPeriodo().equalsIgnoreCase(textFieldPeriodo.getText())) {
								System.out.println("entrou no for each");
								exit3 = 1;
								errou6 = -1;

								do {
									for (Usuario i : listaDeUsuariosTcadastrarTurma) {
										if (i.getNome().equalsIgnoreCase(textNome.getText())
												&& i.getMatricula().equalsIgnoreCase(textMatricula.getText())
												&& i.getSenha().equalsIgnoreCase(textSenha.getText())) {
											errou5 = -1;
											System.out.println("o objeto está no array");
											pessoasDaTurma.add(i);
											exit3 = 1;
											t.setTurma1(pessoasDaTurma);
											System.out.println("" + TurmasGeral.toString());
										}
										exit3 = 1;

									}
								} while (exit3 == 0);
								if (errou5 >= 0) {
									JOptionPane.showMessageDialog(null, "O aluno não está cadastrado", "error",
											JOptionPane.ERROR_MESSAGE);
								}
								if (errou6 >= 0) {
									JOptionPane.showMessageDialog(null, "A turma não está cadastrada", "error",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						System.out.println("saiu do for each");

						exit2 = 1;

					} while (exit2 == 0);

				}

			}
		});

		// editarTurma
		editarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int errado = 0;
				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo para o cadastro de turma/aluno está/estão vazio",
							"error", JOptionPane.ERROR_MESSAGE);
				} else {

					do {
						for (turma t : TurmasGeral) {
							if (t.getDisciplina().equalsIgnoreCase(textNomedaTurma.getText())) {
								if (t.getPeriodo().equalsIgnoreCase(textFieldPeriodo.getText())) {
									t.setDisciplina(textNomedaTurma.getText());
									t.setPeriodo(textFieldPeriodo.getText());

									System.out.println("entrou no for each");
									System.out.println("" + TurmasGeral.toString());

									errado = -1;
									textNome.setEnabled(true);
									textMatricula.setEnabled(true);
									textSenha.setEnabled(true);
									btnAdicionarAluno.setEnabled(true);
									btnRemoverAluno.setEnabled(true);
									btnIntegrantes.setEnabled(true);
									btnFinalizarTurma.setEnabled(true);
									exit4 = 1;
									System.out.println("valor do exit " + exit4);

								}
							}

							exit4 = 1;

						}
						System.out.println("saiu no for each");
						System.out.println("valor do exit " + exit4);

					} while (exit4 == 0);
					if (errado >= 0) {
						JOptionPane.showMessageDialog(null, "turma não cadastrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		editarTurma.setBounds(156, 59, 140, 23);
		contentPane.add(editarTurma);

		lblAlunosEProfessores.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblAlunosEProfessores.setBounds(10, 77, 318, 41);
		contentPane.add(lblAlunosEProfessores);

		btnIntegrantes.setFont(new Font("Yu Gothic", Font.PLAIN, 10));
		btnIntegrantes.setBounds(10, 334, 151, 34);
		contentPane.add(btnIntegrantes);

		lblNome.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		lblNome.setBounds(10, 114, 46, 14);
		contentPane.add(lblNome);

		textNome.setBounds(10, 135, 121, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		lblMatricula.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		lblMatricula.setBounds(12, 156, 76, 14);
		contentPane.add(lblMatricula);

		textMatricula.setBounds(9, 176, 121, 20);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);

		lblSenha.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		lblSenha.setBounds(10, 200, 69, 14);
		contentPane.add(lblSenha);

		textSenha.setBounds(10, 221, 119, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);

		btnAdicionarAluno.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnAdicionarAluno.setBounds(10, 252, 151, 34);
		contentPane.add(btnAdicionarAluno);

		btnFinalizarTurma.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		btnFinalizarTurma.setBounds(10, 372, 151, 34);
		contentPane.add(btnFinalizarTurma);

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(212, 149, 109, 79);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAqui.setBounds(28, 52, 58, 23);
		panel.add(btnAqui);
		btnAqui.setBackground(new Color(255, 255, 153));

		lblTodosOsUsurios.setBounds(6, 0, 110, 34);
		panel.add(lblTodosOsUsurios);
		lblTodosOsUsurios.setToolTipText("");

		lblDoSistema.setBounds(25, 23, 72, 14);
		panel.add(lblDoSistema);

		lblCliqueAqui.setBounds(22, 36, 69, 14);
		panel.add(lblCliqueAqui);

		btnNack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela2 = new T2(listaDeUsuariosTcadastrarTurma, TurmasGeral);
				janela2.setVisible(true);
				janela2.setResizable(false);
				dispose();

			}
		});
		btnNack.setBackground(new Color(204, 0, 0));
		btnNack.setBounds(349, 378, 89, 23);
		contentPane.add(btnNack);
		// teste


		// remover turma
		buttonRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int met = 0;
				if (textNomedaTurma.getText().isEmpty() || textFieldPeriodo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "error", "O campo para o cadastro de turma está/estão vazio",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int jau = 0; jau < TurmasGeral.size(); jau++) {

						if (TurmasGeral.get(jau).getDisciplina().equalsIgnoreCase(textNomedaTurma.getText())) {
							System.out.println("entrou nome correto");
							if (TurmasGeral.get(jau).getPeriodo().equalsIgnoreCase(textFieldPeriodo.getText())) {
								TurmasGeral.remove(jau);
								met = -1;
								System.out.println("entrou no laço");
							}
						}
					}

					System.out.println("" + TurmasGeral.toString());

					if (met >= 0) {
						JOptionPane.showMessageDialog(null, "Turma não encontrada", "error", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Turma removida com sucesso", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});
		btncadastrarTurma.setBounds(10, 59, 136, 23);
		contentPane.add(btncadastrarTurma);

		textFieldPeriodo.setBounds(156, 31, 140, 20);
		contentPane.add(textFieldPeriodo);
		textFieldPeriodo.setColumns(10);

		buttonRemover.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		buttonRemover.setBounds(306, 59, 135, 23);
		contentPane.add(buttonRemover);

		btnRemoverAluno.setEnabled(false);
		btnRemoverAluno.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnRemoverAluno.setBounds(10, 289, 151, 34);
		contentPane.add(btnRemoverAluno);

		JLabel lblPerodo = new JLabel("per\u00EDodo");
		lblPerodo.setBounds(156, 11, 76, 14);
		contentPane.add(lblPerodo);

	}
}
