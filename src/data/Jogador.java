package data;

public class Jogador { 
	private String nickName;
	private String senha;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int cartasCompradas;
	
	//NickName
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	//Senha
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Vitorias
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	//Derrotas
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	//Empates
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	
	//Cartas Compradas
	public int getCartasCompradas() {
		return cartasCompradas;
	}
	public void setCartasCompradas(int cartasCompradas) {
		this.cartasCompradas = cartasCompradas;
	}
	
	
}
