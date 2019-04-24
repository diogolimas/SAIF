package saif;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class T1 extends JFrame {

	private JPanel contentPane;
	private JTextField textoMatricula;
	public static Usuario adm = new Administrador("administrador", "000", "001");
	
	public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
	public static ArrayList<turma> turmaGeralT1 = new ArrayList<turma>();
	
	

	int exit1 = 0;
	int i = 0;
	int error = 1;
	
	
	T2 windAdm = new T2(listaDeUsuarios, turmaGeralT1);
	T3 janlea3 = new T3(listaDeUsuarios, turmaGeralT1);
	Taluno windAlu = new Taluno(listaDeUsuarios, turmaGeralT1);
	Tprofessor windProfe = new Tprofessor(listaDeUsuarios, turmaGeralT1);
	
	
	esqueciSenha es;
	private JPasswordField textoSenha;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 frame = new T1(listaDeUsuarios, turmaGeralT1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T1(ArrayList<Usuario> lista, ArrayList<turma> turmasg5) {
		listaDeUsuarios = lista;
		setTitle("Login");
		turmaGeralT1=turmasg5;
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 331);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label matrícula = new Label("Matr\u00EDcula:");
		Label senha = new Label("Senha:");
		JButton entrar = new JButton("Entrar");
		entrar.setBackground(new Color(152, 251, 152));
		JButton esqueciSenha = new JButton("Esqueci a Senha");
		esqueciSenha.setBackground(new Color(152, 251, 152));
		esqueciSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		

		matrícula.setForeground(new Color(0, 0, 0));
		matrícula.setBounds(299, 65, 62, 30);
		contentPane.add(matrícula);

		textoMatricula = new JTextField();
		textoMatricula.setBounds(299, 96, 126, 22);
		contentPane.add(textoMatricula);
		textoMatricula.setColumns(10);

		senha.setForeground(new Color(0, 0, 0));
		senha.setBounds(299, 119, 62, 22);
		contentPane.add(senha);
		
		
		// esqueci a senha
		esqueciSenha.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			es = new esqueciSenha(listaDeUsuarios, turmaGeralT1);
			es.setVisible(true);
			dispose();
		}
	});	
		
		
// entrar, botão
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listaDeUsuarios.isEmpty()) {
					listaDeUsuarios.add(adm);
					System.out.println(listaDeUsuarios.toString());
					String pass = new String(textoSenha.getPassword());
					if (textoMatricula.getText().equalsIgnoreCase("000")
							&& (pass.equalsIgnoreCase("001"))) {
						turmaGeralT1 = new ArrayList<turma>();
						turma um = new turma(null, "","");
						turmaGeralT1.add(um);
						JOptionPane.showMessageDialog(null, "você é administrador\n pode editar o sistema", "AVISO",
								JOptionPane.INFORMATION_MESSAGE);
						
						error = -1;
						windAdm.setVisible(true);
						windAdm.setResizable(false);
						windAdm.enviarPalavra(adm.getNome());
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "o primeiro login deve ser do adm", "error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String pass = new String(textoSenha.getPassword());
					if (textoMatricula.getText().isEmpty() || (pass.isEmpty())) {
						exit1 = 1;
						JOptionPane.showMessageDialog(null, "Os campos estão vazios", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						do {

							for (Usuario u : listaDeUsuarios) {
								String pass1 = new String(textoSenha.getPassword());
								if (u.getMatricula().equalsIgnoreCase(textoMatricula.getText())
										&& u.getSenha().equalsIgnoreCase(pass1)) {
									System.out.println("entrou no for each");
									exit1 = 1;
									error = -1;
									JOptionPane.showMessageDialog(null,
											"Logado com sucesso.\nAproveite o SAIF, " + u.getNome() + "!");
									if (u instanceof Administrador) {
										windAdm = new T2(listaDeUsuarios, turmaGeralT1);
										windAdm.setVisible(true);
										windAdm.setResizable(false);
										windAdm.enviarPalavra(u.getNome());
										dispose();
									}
									if (u instanceof Aluno) {
										windAlu = new Taluno(listaDeUsuarios, turmaGeralT1);
										windAlu.setVisible(true);
										windAlu.setResizable(false);
										windAlu.enviarPalavra(u.getNome(), u);
										dispose();
									}
									if (u instanceof Professor) {
										windProfe = new Tprofessor(listaDeUsuarios, turmaGeralT1);
										windProfe.setVisible(true);
										windProfe.setResizable(false);
										windProfe.enviarPalavra(u.getNome(), u);
										dispose();
									}

								}
							}
							System.out.println("saiu do for each");

							exit1 = 1;

						} while (exit1 == 0);

					}
				}
				if (error > 0) {
					JOptionPane.showMessageDialog(null, "Dados não cadastrados", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		entrar.setBounds(300, 174, 125, 23);
		contentPane.add(entrar);

		esqueciSenha.setBounds(299, 210, 126, 23);
		contentPane.add(esqueciSenha);

		JLabel label = new JLabel("");
		label.setBounds(10, 11, 265, 270);
		ImageIcon imagem = new ImageIcon(T1.class.getResource("/imagem/logosaif.png"));
		Image imag = imagem.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imag));
		contentPane.add(label);
		
		textoSenha = new JPasswordField();
		textoSenha.setBounds(299, 143, 126, 20);
		contentPane.add(textoSenha);
	}
}
