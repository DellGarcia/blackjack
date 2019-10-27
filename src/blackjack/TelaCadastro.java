package blackjack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.CadastrarJogador;
import data.ModalErro;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame{
	
	//Fundo
	private JPanel fundo;
	
	//Etiquetas
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblConfirmaSenha;
	
	//Campos
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmaSenha;
	
	//Botoes
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	//Fonte
	private Font f;
	
	public TelaCadastro() {
		// TODO Auto-generated constructor stub
		setSize(800, 500);
		setTitle("Cadastro");
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
		
		f = new Font("Lucida Console", Font.PLAIN, 18);
		
		fundo = new JPanel();
		fundo.setBackground(new Color(79, 79, 79));
		fundo.setLayout(null);
		setContentPane(fundo);
		
		//Label Usuario
		lblUsuario = new JLabel("Digite um nome de usuario:");
		lblUsuario.setSize(300, 40);
		lblUsuario.setFont(f);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setLocation(getWidth()/2 - lblUsuario.getWidth()/2, 60);
		fundo.add(lblUsuario);
		
		//Campo Usuario
		txtUsuario = new JTextField();
		txtUsuario.setSize(300, 40);
		txtUsuario.setFont(f);
		txtUsuario.setLocation(getWidth()/2 - txtUsuario.getWidth()/2, 100);
		fundo.add(txtUsuario);
		
		//Label Senha
		lblSenha = new JLabel("Digite uma senha:");
		lblSenha.setSize(300, 40);
		lblSenha.setFont(f);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setLocation(getWidth()/2 - lblSenha.getWidth()/2, 140);
		fundo.add(lblSenha);
		
		//Campo Senha
		txtSenha = new JPasswordField();
		txtSenha.setSize(300, 40);
		txtSenha.setFont(f);
		txtSenha.setLocation(getWidth()/2 - txtSenha.getWidth()/2, 180);
		fundo.add(txtSenha);
		
		//Label Confirmar Senha
		lblConfirmaSenha = new JLabel("Confirme a senha:");
		lblConfirmaSenha.setSize(300, 40);
		lblConfirmaSenha.setFont(f);
		lblConfirmaSenha.setForeground(Color.WHITE);
		lblConfirmaSenha.setLocation(getWidth()/2 - lblConfirmaSenha.getWidth()/2, 220);
		fundo.add(lblConfirmaSenha);
		
		//Campo Confirmar Senha
		txtConfirmaSenha = new JPasswordField();
		txtConfirmaSenha.setSize(300, 40);
		txtConfirmaSenha.setFont(f);
		txtConfirmaSenha.setLocation(getWidth()/2 - txtConfirmaSenha.getWidth()/2, 260);
		fundo.add(txtConfirmaSenha);
		
		//Botao Confirmar
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setSize(200, 50);
		btnConfirmar.setLocation(150 , 350);
		btnConfirmar.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnConfirmar.setBackground(new Color(28,28,28));
		btnConfirmar.setForeground(new Color(199,21,133));
		btnConfirmar.setOpaque(true);
		btnConfirmar.setSelected(false);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fundo.add(btnConfirmar);
		
		//Botao Cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(200, 50);
		btnCancelar.setLocation(getWidth() - btnCancelar.getWidth() - 150 , 350);
		btnCancelar.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		btnCancelar.setBackground(new Color(28,28,28));
		btnCancelar.setForeground(new Color(199,21,133));
		btnCancelar.setOpaque(true);
		btnCancelar.setSelected(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fundo.add(btnCancelar);
		
		//Acao do Botao Cadastrar
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				char s[] = txtSenha.getPassword(), s2[] = txtConfirmaSenha.getPassword();
				String str = "", str2 = "";
				for(int i = 0; i < s.length; i++) {
					str += s[i];	
				}
				for(int i = 0; i < s2.length; i++) {
					str2 += s2[i];
				}
				if(str.equals(str2)) {
					CadastrarJogador cj = new CadastrarJogador(txtUsuario.getText(), str);
 					if(cj.isValido()) {
 						setVisible(false);
 						new TelaLogin().setVisible(true);
 					}
				}else {
					new ModalErro("Erro na Senha", "Senhas Divergentes").setVisible(true);
				}
			}
		});
		
		//Acao do Botao Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
	}
	
	
}
