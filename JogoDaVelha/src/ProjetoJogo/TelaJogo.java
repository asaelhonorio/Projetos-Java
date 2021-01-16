/**
 * 
 */
package ProjetoJogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.tools.sjavac.server.SysInfo;

public class TelaJogo  extends JFrame{
	
	ImageIcon bola = new ImageIcon(getClass().getResource("circulo.png"));
	ImageIcon x = new ImageIcon(getClass().getResource("x.png"));
	
	JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
	
	Bloco blocos[] = new Bloco[9];
	
	final int JOGADOR_1 = 1;
	final int JOGADOR_2 = 2;
	
	int jogadorVez = JOGADOR_1;
	
	JLabel lInfo = new JLabel("Jogador "+JOGADOR_1);
	
	public TelaJogo() {
		configurarJanela();
		configurarTela();
	}
	public void configurarTela() {
		add(BorderLayout.CENTER,pTela);
		add(BorderLayout.NORTH,lInfo);
		pTela.setBackground(Color.BLACK);
		lInfo.setFont(new Font("Arial", Font.BOLD,30));
		lInfo.setForeground(new Color(50,200,50));
		lInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0;i<9;i++){
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			pTela.add(bloco);
		}
	}
	public void mudarVez() {
		if(jogadorVez == 1) {
			jogadorVez=2;
			lInfo.setText("Jogador 2");
			lInfo.setForeground(Color.RED);
		}else {
			jogadorVez=1;
			lInfo.setText("Jogador 1");
			lInfo.setForeground(new Color(20, 200, 50));
		}
	}
	public boolean win(int jog) {
		if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog) {
			return true;
		}
		if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog) {
			return true;
		}
		if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog) {
			return true;
		}
		if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog) {
			return true;
		}
		if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[2].quem==jog && blocos[4].quem==jog && blocos[6].quem==jog) {
			return true;
		}
		return false;
	}
	
	public void  configurarJanela() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaJogo();
		
	}
	public class Bloco extends JButton{
		int quem = 0;
		public Bloco() {
			setBackground(Color.WHITE);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (quem==0) {
						 if(jogadorVez == JOGADOR_1) {
							 setIcon(bola);
							 quem = JOGADOR_1;
						 }else {
							 setIcon(x);
							 quem = JOGADOR_2;    
						 }
						 if(win(quem)) {
							 JOptionPane.showMessageDialog(null, "Jogador "+quem+" Venceu!");
							 System.exit(0);
						 }
						 mudarVez();

					}
				
				}
			});
			
		}
	}
}