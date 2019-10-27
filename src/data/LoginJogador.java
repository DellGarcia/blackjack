package data;

import java.io.BufferedReader;
import java.io.FileReader;

import blackjack.InterfaceBlackJack;

public class LoginJogador {
	
	private BufferedReader bf;
	private String senhaCorreta;
	private boolean loginEfetuado;
	private String usuario, senha;
	private int vitorias, derrotas, empates, cartasCompradas;
	
	public LoginJogador(String user, String pass) throws Exception {
		// TODO Auto-generated constructor stub
		try {
			bf = new BufferedReader(new FileReader("src/data/data.in"));
		}catch(Exception e) {
			System.out.println("Problemas no arquivo");
			e.printStackTrace();
		}
		
		loginEfetuado = false;
		
		if(verificaUsuarioExiste(user)) {
			if(pass.equals(senhaCorreta)) {
				InterfaceBlackJack.nickJogador.setText(user);
				loginEfetuado = true;
				usuario = user;
				senha = pass;
			}else {
				new ModalErro("Erro na Senha", "Senha Incorreta").setVisible(true);
			}
		}else {
			new ModalErro("Erro no Usuario", "Usuario não cadastrado").setVisible(true);
			System.out.println("Usuario não cadastrado");
		}
	}
	
	public boolean verificaUsuarioExiste(String user) throws Exception{
		while(bf.ready()) {
			String linha[] = bf.readLine().trim().split(" ");
			if(linha[0].equals(user)) {
				senhaCorreta = linha[1];
				vitorias = Integer.parseInt(linha[2]);
				derrotas = Integer.parseInt(linha[3]);
				empates = Integer.parseInt(linha[4]);
				cartasCompradas = Integer.parseInt(linha[5]);
				return true;
			}
		}
		return false;
	}
	
	public boolean isLoginEfeutado() {
		return loginEfetuado;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getCartasCompradas() {
		return cartasCompradas;
	}

	public void setCartasCompradas(int cartasCompradas) {
		this.cartasCompradas = cartasCompradas;
	}
	
	
}
