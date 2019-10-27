package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import data.Jogador;
import data.RankingJoagador;

@SuppressWarnings("serial")
public class TelaRanking extends JFrame{

	private JTable tabela;
	private JPanel fundo;
	private JScrollPane telaRolagem;
	private RankingJoagador rank;
	private ArrayList<Jogador> players;
	
	public TelaRanking() {
		// TODO Auto-generated constructor stub
		setTitle("Ranking dos Jogadores");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(900, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
		
		fundo = new JPanel();
		fundo.setBackground(new Color(79,79,79));
		fundo.setLayout(new GridLayout(1, 1));
		setContentPane(fundo);
		
		rank = new RankingJoagador();
		players = rank.getJogadores();
		String ordemTabela[][] = new String[players.size()][6];
		for(int i = 0; i < players.size(); i++) {
			ordemTabela[i][0] = ""+(i+1);
			ordemTabela[i][1] = players.get(i).getNickName();
			ordemTabela[i][2] = ""+players.get(i).getVitorias();
			ordemTabela[i][3] = ""+players.get(i).getDerrotas();
			ordemTabela[i][4] = ""+players.get(i).getEmpates();
			ordemTabela[i][5] = ""+players.get(i).getCartasCompradas();
		}
		
		String cabecalho[] = {"Nº", "NickName", "Vitórias", "Derrotas", "Empates", "Cartas Compradas"};
		
		tabela = new JTable(ordemTabela, cabecalho);
		tabela.setEnabled(false);
		tabela.setBackground(new Color(105,105,105));
		tabela.setForeground(Color.WHITE);
		tabela.setDragEnabled(false);
		tabela.setBorder(null);
//		tabela.setRowSelectionAllowed(false);
		tabela.setCellSelectionEnabled(false);
		tabela.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tabela.setRowHeight(60);
		
		telaRolagem = new JScrollPane(tabela);
		telaRolagem.setIgnoreRepaint(true);
		telaRolagem.setBorder(null);
		JScrollBar sb = new JScrollBar();
		sb.setFocusable(false);
		sb.setBackground(Color.LIGHT_GRAY);
		sb.setForeground(Color.DARK_GRAY);
		telaRolagem.setVerticalScrollBar(sb);
		telaRolagem.setSize(getWidth(), getHeight());
		telaRolagem.setBackground(new Color(79, 79, 79));
		fundo.add(telaRolagem);
	}
	
}
