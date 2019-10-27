package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CadastrarJogador {

	private BufferedReader bf;
	private FileWriter fw;
	private String str;
	private boolean valido; 
	
	public CadastrarJogador(String nickName, String senha) {
		valido = true;
		try {
			str = "";
			bf = new BufferedReader(new FileReader("src/data/data.in"));
			if(verificaNickDisponivel(nickName)) {
				fw = new FileWriter("src/data/data.in");
				fw.append(str);
				fw.append(nickName + " " + senha + " " + 0 + " " + 0 + " " + 0 + " " + 0 + "\n");
				fw.close();
			}else {
				new ModalErro("Erro no Usuario", "Usuario ja cadastrado!").setVisible(true);
				valido = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("arquivo não encontrado");
		}
	}
	
	public boolean verificaNickDisponivel(String nick) throws Exception{
		boolean valido = true;
		while(bf.ready()) {
			String linha[] = bf.readLine().trim().split(" ");
			for(int i = 0; i < linha.length; i++) {
				if(i != linha.length-1) {
					str += linha[i] + " ";
				}else {
					str += linha[i] + "\n";
				}
			}
			if(nick.equals(linha[0])) valido = false;
		}
		return valido;
	}
	
	public boolean isValido() {
		return this.valido;
	}
}
