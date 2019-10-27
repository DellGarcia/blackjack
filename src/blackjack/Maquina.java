package blackjack;

import java.util.Random;

public class Maquina {
	
	private Som somCarta;
	
	public Maquina() {
		somCarta = new Som();
	} 
	
	public boolean jogoOuNao() {
		int porcentagemEstourar = InterfaceBlackJack.pontuacaoM;
		Random r = new Random();
		if(porcentagemEstourar < 10) {
			return true;
		}else if(porcentagemEstourar < 12) {
			porcentagemEstourar =  r.nextInt(10) + 1;
			if(porcentagemEstourar < 2) {
				return false;
			}else {
				return true;
			}
		}else if(porcentagemEstourar < 14) {
			porcentagemEstourar =  r.nextInt(12) + 1;	
			if(porcentagemEstourar < 4) {
				return false;
			}else {
				return true;
			}
		}else if(porcentagemEstourar < 16) {
			porcentagemEstourar =  r.nextInt(14) + 1;
			if(porcentagemEstourar < 6) {
				return false;
			}else {
				return true;
			}
		}else if(porcentagemEstourar < 18) {
			porcentagemEstourar =  r.nextInt(16) + 1;
			if(porcentagemEstourar < 8) {
				return false;
			}else {
				return true;
			}
		} else if(porcentagemEstourar < 20) {
			porcentagemEstourar =  r.nextInt(18) + 1;
			if(porcentagemEstourar < 10) {
				return false;
			}else {
				return true;
			}
		}
		return false;
		
	}
	
	public void pegarUmaCarta() {
		boolean valido = jogoOuNao();
		for(int i = 0; i < 52; i++) {
			if(InterfaceBlackJack.cartas[i].virado && valido) {
				somCarta.playSound("comprar2Carta.wav");
				InterfaceBlackJack.cartas[i].setLocation(InterfaceBlackJack.cartas[i].getX() - InterfaceBlackJack.maqX, InterfaceBlackJack.cartas[i].getY() - InterfaceBlackJack.maqY);
				InterfaceBlackJack.pontuacaoM += InterfaceBlackJack.cartas[i].valor;
				InterfaceBlackJack.maqX += 30;
				InterfaceBlackJack.maqY -= 30;
				InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: ?");
				InterfaceBlackJack.cartas[i].virado = false;
				if(InterfaceBlackJack.pontuacaoM == 21) {
					InterfaceBlackJack.infoPartida.setText("BlackJack, a Máquina Ganhou");
					if(InterfaceBlackJack.logado) {
						InterfaceBlackJack.player.setDerrotas(InterfaceBlackJack.player.getDerrotas() + 1);
					}
					InterfaceBlackJack.mostrarCartasMaquina();
					InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
					InterfaceBlackJack.infoPartida.setVisible(true);
				}else if(InterfaceBlackJack.pontuacaoM > 21) {
					InterfaceBlackJack.infoPartida.setText("Estourou, O Jogador Ganhou");
					if(InterfaceBlackJack.logado) {
						InterfaceBlackJack.player.setVitorias(InterfaceBlackJack.player.getVitorias() + 1);
					}
					InterfaceBlackJack.mostrarCartasMaquina();
					InterfaceBlackJack.contadorM.setText("Pontuação da Máquina: " + InterfaceBlackJack.pontuacaoM);
					InterfaceBlackJack.infoPartida.setVisible(true);
				}
				if(InterfaceBlackJack.pontuacaoM >= 21) {
					InterfaceBlackJack.paro = true;
					InterfaceBlackJack.btnParo.setVisible(false);
					InterfaceBlackJack.btnReset.setVisible(true);
				}
				break;
			}
		
		}
	}
	
}
