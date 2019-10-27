package blackjack;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ModalInformativo extends JFrame {

	private JPanel fundo;
	private JLabel mensagemPrincipal;
	private JLabel del, gui;
	private JLabel nomeDel, nomeGui;
	
	
	public ModalInformativo() {
		setTitle("Jogo BlackJack");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
		
		fundo = new JPanel();
		fundo.setBackground(new Color(79,79,79));
		fundo.setLayout(null);
		setContentPane(fundo);
		
		//Mensagem Principal
		mensagemPrincipal = new JLabel("Desenvolvido pelo alunos do 2° ETIM:");
		mensagemPrincipal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mensagemPrincipal.setSize(290, 50);
		mensagemPrincipal.setLocation(getWidth() / 2 - mensagemPrincipal.getWidth()/2, 20);
		mensagemPrincipal.setVisible(true);
		mensagemPrincipal.setForeground(Color.WHITE);
		fundo.add(mensagemPrincipal);
		
		del = new JLabel(new ImageIcon(new ImageIcon("src/imagens/fotoCircular01.png").getImage().getScaledInstance(200, 200, 100)));
		del.setSize(200, 200);
		del.setLocation(50, 100);
		fundo.add(del);
		
		gui = new JLabel(new ImageIcon(new ImageIcon("src/imagens/fotoCircular02.png").getImage().getScaledInstance(200, 200, 100)));
		gui.setSize(200, 200);
		gui.setLocation(getWidth() - gui.getWidth() - 50, 100);
		fundo.add(gui);
		
		nomeDel = new JLabel("Lucas Del Puerto Garcia");
		nomeDel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nomeDel.setForeground(Color.WHITE);
		nomeDel.setSize(290, 50);
		nomeDel.setLocation(50, 300);
		nomeDel.setVisible(true);
		fundo.add(nomeDel);
		
		nomeGui = new JLabel("Guilherme F. de Azevedo");
		nomeGui.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nomeGui.setForeground(Color.WHITE);
		nomeGui.setSize(290, 50);
		nomeGui.setLocation(getWidth() - nomeGui.getWidth() + 50, 300);
		nomeGui.setVisible(true);
		fundo.add(nomeGui);
		
	}
	
}
