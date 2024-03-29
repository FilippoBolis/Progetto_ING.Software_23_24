package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import gestore_db.InserimentoJooq;
import gui.InserisciPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiPaziente {

	private InserisciPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella TabellaProntoSoccorso;

	/** Classe che prende i dati digitati nel relativo frame e li inserisce nel database
	 * @param v1 riferimento al frame per l'inserimento pazienti
	 * @param v2 riferimento al frame principale
	 * @param m riferimento al modello
	 */
	public ConfermaAggiungiPaziente(InserisciPazienteFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		TabellaProntoSoccorso = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Pronto Soccorso");
		start();
	}

	/**Una volta premuto il pulsante "conferma" nel frame di inserimento, prende i dati scritti e li utilizza
	 * per eseguire un insert nella tabella degente del database.
	 * Inoltre permete la chiusura della finestra, premendo la X oppure confermando l'inserimento.
	 * Alla chiusura della finestra il frame principale viene riabilitato e aggiornato con il nuovo dato.
	 */
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!frame.codiceTextField.getText().isBlank() && !frame.nomeTextField.getText().isBlank() && !frame.cognomeTextField.getText().isBlank()) {
					String codice = frame.codiceTextField.getText();
					String nome = frame.nomeTextField.getText();
					String cognome = frame.cognomeTextField.getText();
					String sesso;
					if (frame.sessoComboBox.getSelectedItem().equals("maschio")) {
						sesso = "M";
					}
					else {
						sesso = "F";
					}
					String urgenza = (String) frame.urgenzaComboBox.getSelectedItem();
					if (InserimentoJooq.getIstanza().degente(codice,nome,cognome,sesso,LocalDate.now(),LocalTime.now().withNano(0),urgenza) == 1) {
						modello.modelloGestorePaziente.deselezionaPaziente();
						frameDeiPazienti.updateStringaPaziente();
						TabellaProntoSoccorso.update();
						frameDeiPazienti.updateViewTabella();
					}
					else {
						new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema durante l'agginta del paziente, se il problema persiste chiamare un tecnico");
					}
					frameDeiPazienti.sfondoFrame.setEnabled(true);
					frame.sfondoFrame.dispose();
				}
				else {
					new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
					
				}
			}
		});
		
		frame.sfondoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameDeiPazienti.sfondoFrame.setEnabled(true);
                frame.sfondoFrame.dispose();
            }
        });
	}
}
