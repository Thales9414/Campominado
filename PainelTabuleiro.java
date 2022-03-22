package Campominadojogo;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.adicionarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if (e.isGanhou())
					JOptionPane.showMessageDialog(this, "Parabéns! Você ganhou!");
				else
					JOptionPane.showMessageDialog(this, "Que pena... Você perdeu!");
				
				tabuleiro.reiniciar();
			});
		});
	}
}