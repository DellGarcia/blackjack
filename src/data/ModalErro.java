package data;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ModalErro extends JDialog{
	
	public ModalErro(String title, String msg) {
		// TODO Auto-generated constructor stub
		JPanel fundo = new JPanel();
		fundo.setBackground(new Color(79, 79, 79));
		setSize(500, 300);
		setLocationRelativeTo(null);
		setContentPane(fundo);
		setTitle(title);
		
		JLabel lblMensagem = new JLabel();
		lblMensagem.setText(msg);
		lblMensagem.setForeground(Color.WHITE);
		lblMensagem.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		fundo.add(lblMensagem);
	}
	
}
