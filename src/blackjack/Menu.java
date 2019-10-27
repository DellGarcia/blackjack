package blackjack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	private JMenu menu;
	private JMenuItem sair;
	private JMenuItem ranking;
	private JMenuItem comoJogar;
	private JMenuItem sobre;
	private JMenuItem personalizar;
	
	public Menu() {
		// TODO Auto-generated constructor stub
		setBackground(new Color(28,28,28));
		setBorder(null);

		menu = new JMenu("Blackjack");
		menu.setForeground(new Color(199,21,133));
		menu.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		menu.setContentAreaFilled(true);	
		add(menu);
		
		//Regras do Jogo
		comoJogar = new JMenuItem("Regras");
		comoJogar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		comoJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		comoJogar.setBackground(new Color(28,28,28));
//		comoJogar.setForeground(new Color(199,21,133));
		comoJogar.setBorder(null);
		menu.add(comoJogar);
		
		//Ranking dos jogadores
		ranking = new JMenuItem("Ranking");
		ranking.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		ranking.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		comoJogar.setBackground(new Color(28,28,28));
//		comoJogar.setForeground(new Color(199,21,133));
		ranking.setBorder(null);
		menu.add(ranking);
		
		//Menu de pesonalizacao
		personalizar = new JMenuItem("Personalizar");
		personalizar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		personalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		personalizar.setBorder(null);
		menu.add(personalizar);
		
		//Sobre
		sobre = new JMenuItem("Sobre");
		sobre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sobre.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sobre.setBorder(null);
		menu.add(sobre);
		
		//Sair
		sair = new JMenuItem("Sair");
		sair.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		sair.setBackground(new Color(28,28,28));
//		sair.setForeground(new Color(199,21,133));
		sair.setBorder(null);
		menu.add(sair);
	
		
		//Acao do como jogar
		comoJogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaRegras().setVisible(true);
			}
		});
		
		//Acao do Ranking
		ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaRanking().setVisible(true);
			}
		});
		
		//Acao do sobre
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModalInformativo().setVisible(true);
			}
		});
		
		//Acao do personalizar
		personalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaPersonalizacao().setVisible(true);
			}
		});
		
		//Acao do sair
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	
}
