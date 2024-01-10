package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneVisualizzaFarmaci {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaBottoneVisualizzaFarmaci(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.visualizzaFarmaciButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					//per ora vuoto
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche di privacy, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla visualizzazione dei farmaci prescritti ai pazienti");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole visualizzare i farmaci prescritti");
			}
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					
				}
			});
			}
		});
	}
}