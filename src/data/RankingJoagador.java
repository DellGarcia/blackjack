package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RankingJoagador {

	private ArrayList<Jogador> jogadores;
	
	public RankingJoagador() {
		// TODO Auto-generated constructor stub
	
		jogadores = new ArrayList<Jogador>();
		lerTodosOsJogadores();
		ordenarJogadores();
	}
	
	public void lerTodosOsJogadores() {
		try {
			BufferedReader bf  = new BufferedReader(new FileReader("src/data/data.in"));
			while(bf.ready()) {
				String linha[] = bf.readLine().trim().split(" ");
				Jogador jogador = new Jogador();
				jogador.setNickName(linha[0]);
				jogador.setSenha(linha[1]);
				jogador.setVitorias(Integer.parseInt(linha[2]));
				jogador.setDerrotas(Integer.parseInt(linha[3]));
				jogador.setEmpates(Integer.parseInt(linha[4]));
				jogador.setCartasCompradas(Integer.parseInt(linha[5]));
				jogadores.add(jogador);
			}
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na leitura");
			e.printStackTrace();
		}
	}
	
	public void ordenarJogadores() {
		for(int i = 0; i < jogadores.size(); i++) {
			for(int j = i + 1; j < jogadores.size(); j++) {
				if(jogadores.get(j).getVitorias() > jogadores.get(i).getVitorias()) {
					Jogador p = jogadores.get(i);
					jogadores.set(i, jogadores.get(j));
					jogadores.set(j, p);
				}else if(jogadores.get(j).getVitorias() == jogadores.get(i).getVitorias()) {
					if(jogadores.get(j).getEmpates() > jogadores.get(i).getEmpates()) {
						Jogador p = jogadores.get(i);
						jogadores.set(i, jogadores.get(j));
						jogadores.set(j, p);
					}else if(jogadores.get(j).getEmpates() == jogadores.get(i).getEmpates()) {
						if(jogadores.get(j).getDerrotas() < jogadores.get(i).getDerrotas()) {
							Jogador p = jogadores.get(i);
							jogadores.set(i, jogadores.get(j));
							jogadores.set(j, p);
						}else if(jogadores.get(j).getDerrotas() == jogadores.get(i).getDerrotas()) {
							if(jogadores.get(j).getCartasCompradas() < jogadores.get(i).getCartasCompradas()) {
								Jogador p = jogadores.get(i);
								jogadores.set(i, jogadores.get(j));
								jogadores.set(j, p);
							}
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Jogador> getJogadores() {
		return this.jogadores;
	}
}
