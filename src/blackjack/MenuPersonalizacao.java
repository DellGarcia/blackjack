package blackjack;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuPersonalizacao extends JMenuBar {
	
	private JMenu menuName;
	public JMenuItem versoCarta;

	
	public MenuPersonalizacao() {
		// TODO Auto-generated constructor stub
		setBackground(new Color(28,28,28));
		setBorder(null);
		
		menuName = new JMenu("Personalização");
		menuName.setFont(new Font("Century Gothic", Font.PLAIN, 22));
//		menuName.setEnabled(false);
		menuName.setContentAreaFilled(true);
		add(menuName);
		
		versoCarta = new JMenuItem("Verso da Carta");
		versoCarta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		versoCarta.setForeground(new Color(199,21,133));
		versoCarta.setBackground(new Color(28,28,28));
		add(versoCarta);
		
	}
	
}
