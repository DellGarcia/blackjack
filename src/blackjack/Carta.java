package blackjack;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Carta extends JLabel implements MouseListener{
	
	protected ImageIcon frente;
	protected ImageIcon verso;
	protected boolean virado;
	protected static String tipoVerso;
	protected int valor;
	protected static int width;
	protected static int heiht;
	protected static boolean primeira = true;
	private Maquina maquina;
	private Som somCarta;
	
	public Carta(String str, int x, int y) {
		// TODO Auto-generated constructor stub
		width = x;
		heiht = y;
		if(primeira) {
			tipoVerso = "verso3.png";
		}
		frente = new ImageIcon(new ImageIcon("src/baralho01/" + str).getImage().getScaledInstance(x, y, 100));
		verso = new ImageIcon("src/baralho01/"+tipoVerso);
		virado = true;
		somCarta = new Som();
		maquina = new Maquina();
		setIcon(new ImageIcon(verso.getImage().getScaledInstance(x, y, 100)));
		setValor(str);
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(InterfaceBlackJack.pontuacao > 0 & InterfaceBlackJack.pontuacao < 21) {
			InterfaceBlackJack.btnParo.setVisible(true);
		}
		if(InterfaceBlackJack.pontuacao < 21 && virado & InterfaceBlackJack.paro != true) {
			somCarta.playSound("comprar1Carta.wav");
			if(InterfaceBlackJack.logado) {
				InterfaceBlackJack.player.setCartasCompradas(InterfaceBlackJack.player.getCartasCompradas() + 1);
			}
			this.setIcon(new ImageIcon(frente.getImage().getScaledInstance(width, heiht, 100)));
			setLocation(getX() + InterfaceBlackJack.incX, getY() + InterfaceBlackJack.incY);
			InterfaceBlackJack.pontuacao += this.valor;
			InterfaceBlackJack.incX += 30;
			InterfaceBlackJack.incY -= 30;
			InterfaceBlackJack.contador.setText("Pontuação do Jogador: " + InterfaceBlackJack.pontuacao);
			if(InterfaceBlackJack.pontuacao >= 21) {
				InterfaceBlackJack.btnReset.setVisible(true);
			}
			if(InterfaceBlackJack.pontuacao == 21) {
				InterfaceBlackJack.infoPartida.setText("BlackJack, o Jogador Ganhou!");
				InterfaceBlackJack.contadorM.setText("Pontuação da Maquina: " + InterfaceBlackJack.pontuacaoM);
				if(InterfaceBlackJack.logado) {
					InterfaceBlackJack.player.setVitorias(InterfaceBlackJack.player.getVitorias() + 1);
				}
				InterfaceBlackJack.mostrarCartasMaquina();
				InterfaceBlackJack.infoPartida.setVisible(true);
			}else if(InterfaceBlackJack.pontuacao > 21) {
				InterfaceBlackJack.infoPartida.setText("Estourou, a Máquina Ganhou!");
				if(InterfaceBlackJack.logado) {
					InterfaceBlackJack.player.setDerrotas(InterfaceBlackJack.player.getDerrotas() + 1);
				}
				InterfaceBlackJack.mostrarCartasMaquina();
				InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
				InterfaceBlackJack.infoPartida.setVisible(true);
			}else {
				virado = false;
				maquina.pegarUmaCarta();
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setValor(String str) {
		if(str.contains("01")) {
			this.valor = 1;
		}else if(str.contains("02")){
			this.valor = 2;
		}
		else if(str.contains("03")){
			this.valor = 3;
		}
		else if(str.contains("04")){
			this.valor = 4;
		}
		else if(str.contains("05")){
			this.valor = 5;
		}
		else if(str.contains("06")){
			this.valor = 6;
		}
		else if(str.contains("07")){
			this.valor = 7;
		}
		else if(str.contains("08")){
			this.valor = 8;
		}
		else if(str.contains("09")){
			this.valor = 9;
		}
		else if(str.contains("10")){
			this.valor = 10;
		}
		else if(str.contains("valete")){
			this.valor = 10;
		}
		else if(str.contains("dama")){
			this.valor = 10;
		}
		else if(str.contains("rei")){
			this.valor = 10;
		}
		
		
	}
 	
}
