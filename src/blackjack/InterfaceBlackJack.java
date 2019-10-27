package blackjack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import data.Jogador;
import data.LoginJogador;

@SuppressWarnings("serial")
public class InterfaceBlackJack extends JFrame{
	
	//JPanel
	private JPanel telaInicial;
	private static JPanel telaPrincipal;
	
	//JMenu
	private JMenuBar menu;
	
	//JButton's
	private JButton btnStartButton;
	private JButton btnQuitGame;
	private JButton btnSobre;
	protected static JButton btnReset;
	protected static JButton btnParo;
	
	//JLabel's
	private JLabel banner;
	protected static JLabel contador;
	protected static JLabel contadorM;
	protected static JButton infoPartida;
	public static JButton nickJogador;
	
	//Cartas do Baralho
	protected static Carta cartas[];
	
	//Baralho
	private static ArrayList<String> baralho;
	
	//Coisas do jogador
	protected static Jogador player;
	protected static int pontuacao; 
	protected static int incY;
	protected static int incX;
	
	//Coisas da Maquina
	protected static int pontuacaoM; 
	protected static int maqY;
	protected static int maqX;
	
	//Validacoes
	protected static boolean paro;
	protected static boolean logado;
	
	//Controle de Som
	private Som s;
	
	static Toolkit tk = Toolkit.getDefaultToolkit();
    static Dimension d = tk.getScreenSize();

	public InterfaceBlackJack() {
		telaInicial = new JPanel();
		telaPrincipal = new JPanel();
		btnReset = new JButton("Jogar Novamente");
		btnParo = new JButton("Parar"); 
		baralho = new ArrayList<String>();
		cartas = new Carta[52];
		contador = new JLabel("Pontuação do Jogador: 0");
		contadorM = new JLabel("Pontuação da Máquina: ?");
		infoPartida = new JButton("");
		nickJogador = new JButton("Jogador");
		s = new Som();
		logado = false;
		paro = false;
		incY = 50;
		incX = 350;
		pontuacao = 0;
		maqY = 50;
		maqX = 350;
		pontuacaoM = 0;
		init();
	}
	
	public void init() {
		
	    setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
	    
	    s.playSound("Serenity.wav");
	    
		//Configuracoes do JFrame
		setTitle("Blackjack");
		setSize(1080, 720);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Configuracoes do JPanel de fundo(tela)
		telaInicial.setLayout(null);
		telaInicial.setVisible(true);
		setContentPane(telaInicial);
		
		//Botao de Inicio
		btnStartButton = new JButton("Start Game");
		btnStartButton.setSize(200, 50);
		btnStartButton.setLocation(d.width - 300, d.height - 300);
		btnStartButton.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnStartButton.setBackground(new Color(199,21,133));
		btnStartButton.setForeground(Color.WHITE);
		btnStartButton.setSelected(false);
		btnStartButton.setContentAreaFilled(false);
		btnStartButton.setOpaque(true);
		btnStartButton.setFocusPainted(false);
		btnStartButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		telaInicial.add(btnStartButton);
		
		//Botao Sobre
		btnSobre = new JButton("Game Info");
		btnSobre.setSize(200, 50);
		btnSobre.setLocation(d.width - 300, d.height - 240);
		btnSobre.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnSobre.setBackground(new Color(199,21,133));
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setSelected(false);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setOpaque(true);
		btnSobre.setFocusPainted(false);
		btnSobre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnSobre.setCursor(new Cursor(Cursor.HAND_CURSOR));
		telaInicial.add(btnSobre);
		
		//Botao de Sair
		btnQuitGame = new JButton("Quit Game");
		btnQuitGame.setSize(200, 50);
		btnQuitGame.setLocation(d.width - 300, d.height - 180);
		btnQuitGame.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnQuitGame.setBackground(new Color(199,21,133));
		btnQuitGame.setForeground(Color.WHITE);
		btnQuitGame.setSelected(false);
		btnQuitGame.setContentAreaFilled(false);
		btnQuitGame.setOpaque(true);
		btnQuitGame.setFocusPainted(false);
		btnQuitGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnQuitGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		telaInicial.add(btnQuitGame);
		
		
		//Imagem de Fundo
		banner = new JLabel(new ImageIcon(new ImageIcon("src/imagens/banner.jpg").getImage().getScaledInstance(d.width, d.height, 100)));
		banner.setSize(d.getSize());
		banner.setVisible(true);
		telaInicial.add(banner);
		
		//Acao botao de inicio
		btnStartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frameUser = new JFrame();
				frameUser.setTitle("Modo de Entrada");
				frameUser.setDefaultCloseOperation(HIDE_ON_CLOSE);
				frameUser.setSize(600, 400);
				frameUser.setLocationRelativeTo(null);
				frameUser.setVisible(true);
				frameUser.setResizable(false);
				frameUser.setLayout(null);
				frameUser.setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
				
				JPanel fundo = new JPanel();
				fundo.setBackground(new Color(79,79,79));
				fundo.setLayout(null);
				frameUser.setContentPane(fundo);
				
				//botao logar como jogador
				JButton btnLogin = new JButton("Login");
				btnLogin.setSize(150, 50);
				btnLogin.setLocation(20, frameUser.getHeight() - (btnLogin.getHeight()+60));
				btnLogin.setFont(new Font("Lucida Console", Font.PLAIN, 25));
				btnLogin.setBackground(new Color(28,28,28));
				btnLogin.setForeground(new Color(199,21,133));
				btnLogin.setOpaque(true);
				btnLogin.setSelected(false);
				btnLogin.setContentAreaFilled(false);
				btnLogin.setOpaque(true);
				btnLogin.setFocusPainted(false);
				btnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
				fundo.add(btnLogin);
				
				//botao cadastrar jogador
				JButton btnCadastro = new JButton("Cadastro");
				btnCadastro.setSize(150, 50);
				btnCadastro.setLocation(frameUser.getWidth()/2 - btnCadastro.getWidth()/2, frameUser.getHeight() - (btnCadastro.getHeight()+60));
				btnCadastro.setFont(new Font("Lucida Console", Font.PLAIN, 25));
//				btnCadastro.setBackground(new Color(199,21,133));
//				btnCadastro.setForeground(Color.WHITE);
				btnCadastro.setBackground(new Color(28,28,28));
				btnCadastro.setForeground(new Color(199,21,133));
				btnCadastro.setOpaque(true);
				btnCadastro.setSelected(false);
				btnCadastro.setContentAreaFilled(false);
				btnCadastro.setOpaque(true);
				btnCadastro.setFocusPainted(false);
				btnCadastro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				btnCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
				fundo.add(btnCadastro);
				
				//Botao jogar como convidado
				JButton btnConvidado = new JButton("Convidado");
				btnConvidado.setSize(150, 50);
				btnConvidado.setLocation(frameUser.getWidth() - btnConvidado.getWidth() - 30, frameUser.getHeight() - (btnConvidado.getHeight()+60));
				btnConvidado.setFont(new Font("Lucida Console", Font.PLAIN, 25));
				btnConvidado.setBackground(new Color(28,28,28));
				btnConvidado.setForeground(new Color(199,21,133));
				btnConvidado.setOpaque(true);
				btnConvidado.setSelected(false);
				btnConvidado.setContentAreaFilled(false);
				btnConvidado.setOpaque(true);
				btnConvidado.setFocusPainted(false);
				btnConvidado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				btnConvidado.setCursor(new Cursor(Cursor.HAND_CURSOR));
				fundo.add(btnConvidado);
				
				//Bannerzin
				JLabel bannerzin = new JLabel(new ImageIcon(new ImageIcon("src/imagens/bannerzin.png").getImage().getScaledInstance(400, 200, 100)));
				bannerzin.setSize(400, 200);
				bannerzin.setLocation(frameUser.getWidth()/2 - bannerzin.getWidth()/2, 20);
				fundo.add(bannerzin);
				
				//JLabel instrucao
				JLabel instrucao = new JLabel("Selecione uma opção de entrada:");
				instrucao.setSize(375, 40);
				instrucao.setLocation(frameUser.getWidth()/2 - instrucao.getWidth()/2, 220);
				instrucao.setFont(new Font("Lucida Console", Font.PLAIN, 20));
				instrucao.setForeground(Color.WHITE);
				fundo.add(instrucao);
				
				//Acao Botao Login
				btnLogin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameUser.setVisible(false);
						TelaLogin tl = new TelaLogin();
						tl.setVisible(true);
						tl.btnConfirmar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								char s[] = tl.txtSenha.getPassword();
								String str = "";
								for(int i = 0; i < s.length; i++) {
									str += s[i];	
								}
								try {
									LoginJogador lj = new LoginJogador(tl.txtUsuario.getText(), str);
									if(lj.isLoginEfeutado()) {
										tl.setVisible(false);
										logado = true;
										player = new Jogador();
										player.setNickName(lj.getUsuario());
										player.setSenha(lj.getSenha());
										player.setVitorias(lj.getVitorias());
										player.setDerrotas(lj.getDerrotas());
										player.setEmpates(lj.getEmpates());
										player.setCartasCompradas(lj.getCartasCompradas());
										telaInicial.setVisible(false);
										menu = new Menu();
										setJMenuBar(menu);
										colocarCartas();
										setContentPane(telaPrincipal);
										menu.setVisible(true);
									}
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
					}
				});
				
				//Acao Botao Cadastro
				btnCadastro.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameUser.setVisible(false);
						new TelaCadastro().setVisible(true);						
					}
				});
				
				//Acao Botao Convidado
				btnConvidado.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameUser.setVisible(false);
						nickJogador.setText("Convidado");
						telaInicial.setVisible(false);
						//Menu do Jogo
						menu = new Menu();
						setJMenuBar(menu);
						colocarCartas();
						setContentPane(telaPrincipal);
						menu.setVisible(true);
					}
				});
			}
		});
		
		//Acao do Botao Sobre
		btnSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModalInformativo().setVisible(true);
			}
		});
		
		//Acao do Botao Quit
		btnQuitGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		//Tela Principal
		telaPrincipal.setBackground(new Color(54,54,54));
		telaPrincipal.setLayout(null);
		
		//Contador
		contador.setSize(300, 30);
		contador.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contador.setLocation( (d.width / 2 - contador.getWidth() / 2) + 400, 100);
		contador.setForeground(Color.WHITE);
		contador.setVisible(true);
		telaPrincipal.add(contador);
		
		contadorM.setSize(300, 30);
		contadorM.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contadorM.setLocation( (d.width / 2 - contadorM.getWidth() / 2) - 400 , 100);
		contadorM.setForeground(Color.WHITE);
		contadorM.setVisible(true);
		telaPrincipal.add(contadorM);
		
		//Status
		infoPartida.setSize(310, 30);
		infoPartida.setBackground(new Color(54,54,54));
		infoPartida.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		infoPartida.setLocation(d.width / 2 - infoPartida.getWidth() / 2, 170);
		infoPartida.setForeground(Color.WHITE);
		infoPartida.setVisible(true);
		infoPartida.setOpaque(true);
		infoPartida.setSelected(false);
		infoPartida.setContentAreaFilled(false);
		infoPartida.setOpaque(true);
		infoPartida.setFocusPainted(false);
		infoPartida.setBorder(null);
		telaPrincipal.add(infoPartida);
		
		//NickJogador
		nickJogador.setSize(500, 30);
		nickJogador.setBackground(new Color(54,54,54));
		nickJogador.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		nickJogador.setLocation(d.width / 2 - nickJogador.getWidth() / 2, 60);
		nickJogador.setForeground(Color.WHITE);
		nickJogador.setVisible(true);
		nickJogador.setOpaque(true);
		nickJogador.setSelected(false);
		nickJogador.setContentAreaFilled(false);
		nickJogador.setOpaque(true);
		nickJogador.setFocusPainted(false);
		nickJogador.setBorder(null);
		telaPrincipal.add(nickJogador);
		
		//Botao Reset
		btnReset.setSize(300, 50);
		btnReset.setLocation(d.width / 2 - btnReset.getWidth() / 2, d.height - 200);
		btnReset.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnReset.setBackground(new Color(28,28,28));
		btnReset.setForeground(new Color(199,21,133));
		btnReset.setOpaque(true);
		btnReset.setSelected(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setOpaque(true);
		btnReset.setFocusPainted(false);
		btnReset.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReset.setVisible(false);
		telaPrincipal.add(btnReset);
		
		//Botao Paro
		btnParo.setSize(300, 50);
		btnParo.setLocation(d.width / 2 - btnReset.getWidth() / 2, d.height - 200);
		btnParo.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnParo.setBackground(new Color(28,28,28));
		btnParo.setForeground(new Color(199,21,133));
		btnParo.setOpaque(true);
		btnParo.setSelected(false);
		btnParo.setContentAreaFilled(false);
		btnParo.setOpaque(true);
		btnParo.setFocusPainted(false);
		btnParo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnParo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnParo.setVisible(false);
		telaPrincipal.add(btnParo);
		
		//Acao do Botao Reset
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				s.stopSound("Serenity.wav");
				reset();
			}
		});
	
		//Acao Botao Paro
		btnParo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pontuacao > pontuacaoM) {
					infoPartida.setText("O Jogador Ganhou o Jogo");
					if(InterfaceBlackJack.logado) {
						InterfaceBlackJack.player.setVitorias(InterfaceBlackJack.player.getVitorias() + 1);
					}
					InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
					infoPartida.setVisible(true);
				}else if(pontuacao == pontuacaoM){
					infoPartida.setText("Incrivel, temos um empate!");
					if(InterfaceBlackJack.logado) {
						InterfaceBlackJack.player.setEmpates(InterfaceBlackJack.player.getEmpates() + 1);
					}
					InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
					infoPartida.setVisible(true);
				}else {
					infoPartida.setText("A Máquina Ganhou o Jogo");
					if(InterfaceBlackJack.logado) {
						InterfaceBlackJack.player.setDerrotas(InterfaceBlackJack.player.getDerrotas() + 1);
					}
					InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
					infoPartida.setVisible(true);
				}
				mostrarCartasMaquina();
				btnParo.setVisible(false);
				btnReset.setVisible(true);
				paro = true;
			}
		});
		
	}
	
	public static void reset() {
		btnReset.setVisible(false);
		btnParo.setVisible(false);
		for(int i = 0; i < 52; i++) {
			cartas[i].setVisible(false);
			cartas[i] = null;
		}
		pontuacao = 0;
		pontuacaoM = 0;
		infoPartida.setText("");
		infoPartida.setVisible(false);
		contador.setText("Pontuação do Jogador: 0");
		contadorM.setText("Pontuação da Máquina: ?");
		baralho.clear();
		baralho = new ArrayList<String>();
		cartas = new Carta[52];
		incY = 50;
		incX = 350;
		maqY = 50;
		maqX = 350;
		paro = false;
		colocarCartas();
	}
	
	public static void sortearCartas() {
		String naipe[] = {"copas", "espadas", "ouro", "paus"};
		for(int i = 0; i < 4; i++) {
			String nomeCartas[] = {
					naipe[i] + "-01.png", naipe[i] + "-02.png", naipe[i] + "-03.png", naipe[i] + "-04.png",
					naipe[i] + "-05.png", naipe[i] + "-06.png", naipe[i] + "-07.png", naipe[i] + "-08.png", 
					naipe[i] + "-09.png", naipe[i] + "-10.png", naipe[i] + "-dama.png", naipe[i] + "-valete.png",
					naipe[i] + "-rei.png",
			};
			for(int j = 0; j < nomeCartas.length; j++) {
				baralho.add(nomeCartas[j]);
			}
		}
	}
	
	public static void colocarCartas() {
		sortearCartas();
		Collections.shuffle(baralho);
		int x = d.width / 2 - 210 / 2, y = d.height / 2 - 300 / 2;
		for(int i = 0; i < 52; i++) {
			
			cartas[i] = new Carta(baralho.get(i), 200, 300);
			cartas[i].setSize(200, 300);
			cartas[i].setLocation(x, y);
			cartas[i].setVisible(true);
			cartas[i].setBorder(null);
			telaPrincipal.add(cartas[i]);
			if(i % 3 == 0) {
				x++;
				y++;
				
			}
		}
	}
	
	public static void mostrarCartasMaquina() {
		for(int i = 0; i < 52; i++) {
			if(!cartas[i].virado) {
				cartas[i].setIcon(new ImageIcon(cartas[i].frente.getImage().getScaledInstance(Carta.width, Carta.heiht, 100)));
			}
		}
		if(logado) {
			try {
				atualizarRankingJogador();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void atualizarRankingJogador() throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("src/data/data.in"));
		
		String str = "";
		while(bf.ready()) {
			String linha[] = bf.readLine().trim().split(" ");
			if(!player.getNickName().equals(linha[0])) {
				for(int i = 0; i < 6; i++) {
					if(i != 6 - 1) {
						str += linha[i] + " ";
					}else {
						str += linha[i] + "\n";
					}
				}
			}else {
				str += player.getNickName() + " ";
				str += player.getSenha() + " ";
				str += player.getVitorias() + " ";
				str += player.getDerrotas() + " ";
				str += player.getEmpates() + " ";
				str += player.getCartasCompradas() + "\n";
			}
		}
		bf.close();
		FileWriter fw = new FileWriter("src/data/data.in");
		fw.append(str);
		fw.close();
	}
	
}
