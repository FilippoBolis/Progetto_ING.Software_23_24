package logiche_frame_sezioni_ospedaliere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record10;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.PazientiFrame;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaDellaPosizionePazienteTabella extends LogicaFrame{

	private String filtro;
	
	/**Classe che tiene conto dei dati del paziente presenti nel database,
	 * permettendone la visualizzazione a schermo in base alla sezione selezionata del programma.
	 * Nel caso in cui la sezione attiva sia "in reparto", permette di visualizzare anche i dati relativi al letto assegnato a ogni degente
	 * @param p riferimento agli elementi grafici
	 * @param m riferimento al modello generale
	 * @param filtro corrisponde alla sezione attiva correntemente nel programma, 
	 * definisce quali degenti devono essere mostrati a schermo in un determinato momento
	 */
	public LogicaDellaPosizionePazienteTabella(PazientiFrame p, ModelloGestoreLogicaGenerale m, String filtro) {
		super(p,m);
		this.filtro=filtro;
	}
	
	/**Ogni qualvolta venga selezionata una nuova sezione o effettuata una modifica ai dati dei pazienti
	 * viene ricaricata la lista di degenti nella sezione attiva, utilizzando i dati aggiornati presenti nel database.
	 */
	public void update() {
		if(!frameDeiPazienti.updating) {
			try {
				List<String> nomi = new ArrayList<>();
				List<String> codice = new ArrayList<>();
	            List<String> cognomi = new ArrayList<>();
	            List<String> sesso = new ArrayList<>();
	            List<LocalDate> dateArrivo = new ArrayList<>();
	            List<LocalTime> oreArrivo = new ArrayList<>();
	            List<String> urgenza = new ArrayList<>();
	            List<String> reparto = new ArrayList<>();
	            List<String> modulo = new ArrayList<>();
	            List<Integer> letto = new ArrayList<>();
				Connection conn = DriverManager.getConnection(DB_URLLOGIC);
				if (conn != null) {
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					if (contesto.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE,Assegnazioneletto.ASSEGNAZIONELETTO).where(Degente.DEGENTE.POSIZIONE.eq(filtro),Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE)).fetch().isNotEmpty()) {
						Result<Record10<String, String, String, LocalDate, LocalTime, String, String, String, String, Integer>> degenti = contesto.selectDistinct(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE,Reparto.REPARTO.NOME_REPARTO,Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO,Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO).from(Degente.DEGENTE,Reparto.REPARTO,Assegnazioneletto.ASSEGNAZIONELETTO).where(Degente.DEGENTE.POSIZIONE.eq(filtro),Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE),Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE)).fetch();
						for (Record10<String, String, String, LocalDate, LocalTime, String, String, String, String, Integer> degenteRecord : degenti) {
							nomi.add(degenteRecord.value1());
						    cognomi.add(degenteRecord.value2());
						    sesso.add(degenteRecord.value3());
						    dateArrivo.add(degenteRecord.value4());
						    oreArrivo.add(degenteRecord.value5());
						    urgenza.add(degenteRecord.value6());
						    codice.add(degenteRecord.value7());
						    reparto.add(degenteRecord.value8());
						    modulo.add(degenteRecord.value9());
						    letto.add(degenteRecord.value10());
						}
						
					}
					else {
						Result<Record7<String, String, String, LocalDate, LocalTime, String, String>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.POSIZIONE.eq(filtro)).fetch();
						for (Record7<String, String, String, LocalDate, LocalTime, String,String> degenteRecord : degenti) {
							nomi.add(degenteRecord.value1());
						    cognomi.add(degenteRecord.value2());
						    sesso.add(degenteRecord.value3());
						    dateArrivo.add(degenteRecord.value4());
						    oreArrivo.add(degenteRecord.value5());
						    urgenza.add(degenteRecord.value6());
						    codice.add(degenteRecord.value7());
						    modulo.add("Nessun modulo");
						    reparto.add("Nessun reparto");
						    letto.add(0);
						}
					}
					modello.modelloGestoreTabella.setTableNomi(nomi);
					modello.modelloGestoreTabella.setTableCognomi(cognomi);
					modello.modelloGestoreTabella.setTableSesso(sesso);
					modello.modelloGestoreTabella.setTableDateArrivo(dateArrivo);
					modello.modelloGestoreTabella.setTableOreArrivo(oreArrivo);
					modello.modelloGestoreTabella.setTableUrgenza(urgenza);
					modello.modelloGestoreTabella.setTableCodice(codice);
					modello.modelloGestoreTabella.setTableReparto(reparto);
					modello.modelloGestoreTabella.setTableModulo(modulo);
					modello.modelloGestoreTabella.setNumeroLetto(letto);
					frameDeiPazienti.posizioneAttuale=filtro;
					SwingUtilities.invokeLater(new Runnable() {
					    @Override
					    public void run() {
					    	frameDeiPazienti.updateViewTabella();
					    }
					});
				}
			} catch (SQLException ev) {
				System.out.println(ev.getMessage());
			}
		}
	}
	
}




