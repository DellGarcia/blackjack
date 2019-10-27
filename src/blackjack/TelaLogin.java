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

@SuppressWarnings("serial")
public class TelaLogin extends JFrame{

	//Fundo
		private JPanel fundo;
		
		//Etiquetas
		private JLabel lblUsuario;
		private JLabel lblSenha;
		
		//Campos
		protected JTextField txtUsuario;
		protected JPasswordField txtSenha;
		
		//Botoes
		protected JButton btnConfirmar;
		private JButton btnCancelar;
		
		//Fonte
		private Font f;
		
		public TelaLogin() {
			// TODO Auto-generated constructor stub
			setSize(700, 400);
			setTitle("Login");
			setLocationRelativeTo(null);
			setIconImage(new ImageIcon("src/imagens/icone.png").getImage());
			
			f = new Font("Lucida Console", Font.PLAIN, 18);
			
			fundo = new JPanel();
			fundo.setBackground(new Color(79, 79, 79));
			fundo.setLayout(null);
			setContentPane(fundo);
			
			//Label Usuario
			lblUsuario = new JLabel("Digite seu nome de usuario:");
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
			
			//Botao Confirmar
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setSize(200, 50);
			btnConfirmar.setLocation(120 , 280);
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
			btnCancelar.setLocation(getWidth() - btnCancelar.getWidth() - 120 , 280);
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
