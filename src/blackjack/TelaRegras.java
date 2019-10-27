package blackjack;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TelaRegras extends JFrame {

	private JPanel fundo;
	private JTextArea mensagemPrincipal;
	
	public TelaRegras() {
		// TODO Auto-generated constructor stub
		setTitle("Regras do Jogo");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
		
		fundo = new JPanel();
		fundo.setBackground(new Color(79,79,79));
		setContentPane(fundo);
		
		//Mensagem Principal
		mensagemPrincipal = new JTextArea();
		mensagemPrincipal.setEditable(false);
		mensagemPrincipal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mensagemPrincipal.setBackground(new Color(79,79,79));
		mensagemPrincipal.setForeground(Color.WHITE);
		mensagemPrincipal.setSize(525, 400);
		mensagemPrincipal.setEditable(false);
		mensagemPrincipal.setFocusable(false);
		mensagemPrincipal.setLocation(this.getX() - mensagemPrincipal.getWidth()/2, 20);
		mensagemPrincipal.setText("O jogo blackjack ou 21, é um jogo de cartas, utilizando um baralho \ncomum 52(sem coringas), onde ganha quem adquirir a pontuacao \nmais proxima de 21.\n"
								+ "O jogador tem a opção de comprar um carta por turno ou parar \ncaso não queira ultrapassar o 21, já que isso resulta em derrota!\n"
								+ "\nA pontuacao segue a seguinte lista:\n"
								+ "AS - 1 ponto\n"
								+ "2  - 2 pontos\n"
								+ "3  - 3 pontos\n"
								+ "4  - 4 pontos\n"
								+ "5  - 5 pontos\n"
								+ "6  - 6 pontos\n"
								+ "7  - 7 pontos\n"
								+ "8  - 8 pontos\n"
								+ "9  - 9 pontos\n"
								+ "10 - 10 pontos\n"
								+ "J  - 10 pontos\n"
								+ "Q  - 10 pontos\n"
								+ "K  - 10 potnos\n");
								
		fundo.add(mensagemPrincipal);
	}
	
}
