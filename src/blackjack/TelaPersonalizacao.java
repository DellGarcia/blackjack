package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaPersonalizacao extends JFrame {

	
	private JPanel tela;
	private JPanel editVerso;
	private JLabel verso[];
	
	public TelaPersonalizacao() {
		// TODO Auto-generated constructor stub
		setTitle("Personalização BlackJack");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(1080, 720);
		setLocationRelativeTo(null);
		setLayout(null);
		setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
		
		verso = new JLabel[12];
		
		//JPanel tela
		tela = new JPanel();
		tela.setBackground(new Color(79,79,79));
		tela.setLayout(null);
		setContentPane(tela);
		
		
		//JLabel
		JLabel msg = new JLabel("Escolha uma aba de personalização");
		msg.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		msg.setForeground(Color.WHITE);
		msg.setSize(320, 50);
		msg.setLocation(getWidth()/2 - msg.getWidth()/2, getHeight() / 2 - msg.getHeight()/2);
		tela.add(msg);
		
		MenuPersonalizacao m = new MenuPersonalizacao();
		setJMenuBar(m);
		
		m.versoCarta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editVerso.setVisible(true);
				tela.setVisible(false);
				setContentPane(editVerso);
			}
		});
		
		editVerso = new JPanel();
		editVerso.setBackground(new Color(79,79,79));
		editVerso.setLayout(null);
		
		//Mais Informacoes
		JLabel infoEditVerso = new JLabel("Escolha um tipo de carta");
		infoEditVerso.setSize(270, 30);
		infoEditVerso.setLocation(getWidth()/2 - infoEditVerso.getWidth()/2, 50);
		infoEditVerso.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		infoEditVerso.setForeground(Color.WHITE);
		editVerso.add(infoEditVerso);
		
		String ordem[] = {
				"verso3.png", "yugioh2.png", "verso2.jpg",
				"verso-naruto.png", "pokemon.jpg", "verso-bleach.jpg",
				"yakusoku-neverland.jpg", "verso-hero.jpg", "verso-kimetsu2.png",
				"verso-fullmetal.jpg", "verso-netero.jpg", "verso-zodiac.jpg"
		};
		int c = 0, x = 50, y = 150;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				verso[c] = new JLabel(new ImageIcon(new ImageIcon("src/baralho01/"+ordem[c]).getImage().getScaledInstance(150, 200, 100)));
				verso[c].setSize(150, 200);
				verso[c].setLocation(x, y);
				editVerso.add(verso[c]);
				int index = c;
				verso[c].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						Carta.tipoVerso = ordem[index];
						Carta.primeira = false;
						InterfaceBlackJack.reset();
					}
				});
				c++;
				x += 160;
			}
			x = 50;
			y += 210;
		}
		
	
	}
	
}
