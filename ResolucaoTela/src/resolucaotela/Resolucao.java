/**
 * 
 */
package resolucaotela;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Resolucao {
	public static void main(String[] args) {
	 Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	 int alt = (int) tela.getHeight();
	 int larg = (int)tela.getWidth();
	 System.out.println("Sua resolução é de "+larg+" x "+alt);
	}

}
