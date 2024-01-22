package logiche_frame_pronto_soccorso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.PazientiFrame;
import gui.VisualizzaDiarieInfFrame;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Diariainf;
import med_db.jooq.generated.tables.Letto;
import med_db.jooq.generated.tables.Modulo;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaDelleDiarieInfermieristicheTabella{
	
	VisualizzaDiarieInfFrame frameDelleDiarieInfermieristiche;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaDelleDiarieInfermieristicheTabella(VisualizzaDiarieInfFrame v, ModelloGestoreLogicaGenerale m) {
		frameDelleDiarieInfermieristiche = v;
		modello = m;
		update();
	}
	
	public void update() {
		if(!frameDelleDiarieInfermieristiche.updating) {
			try {
				List<String> codiceInfermiere = new ArrayList<>();
				List<String> noteParticolari = new ArrayList<>();
				List<String> farmaci = new ArrayList<>();
				List<Boolean> importante = new ArrayList<>();
				List<LocalDate> dataCreazione = new ArrayList<>();
				List<LocalTime> oreCreazione = new ArrayList<>();
				String codiceDegente = modello.modelloGestorePaziente.getCodice();
				Connection conn = DriverManager.getConnection(DB_URLLOGIC);
				if (conn != null) {
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					if (contesto.select(Diariainf.DIARIAINF.CODICE).from(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codiceDegente)).fetch().isNotEmpty()) {
						Result<Record6<String, String, String, Boolean, LocalDate, LocalTime>> diarie = contesto.selectDistinct(Diariainf.DIARIAINF.CODICE_INFERMIERE,Diariainf.DIARIAINF.NOTE_PARTICOLARI,Diariainf.DIARIAINF.FARMACO,Diariainf.DIARIAINF.IMPORTANTE,Diariainf.DIARIAINF.DATA,Diariainf.DIARIAINF.ORA).from(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codiceDegente)).fetch();
						for (Record6<String, String, String, Boolean, LocalDate, LocalTime> diariaRecord : diarie) {
							codiceInfermiere.add(diariaRecord.value1());
						    noteParticolari.add(diariaRecord.value2());
						    farmaci.add(diariaRecord.value3());
						    importante.add(diariaRecord.value4());
						    dataCreazione.add(diariaRecord.value5());
						    oreCreazione.add(diariaRecord.value6());
						}
						
					}
					else {
						codiceInfermiere.add("Non ancora inserito");
						noteParticolari.add(" ");
						farmaci.add(" ");
						importante.add(false);
						dataCreazione.add(LocalDate.now());
						oreCreazione.add(LocalTime.now().withNano(0));
					}
					modello.modelloGestoreDiarieInfermieristiche.setTableCodiceInfermiere(codiceInfermiere);
					modello.modelloGestoreDiarieInfermieristiche.setTableDateArrivo(dataCreazione);
					modello.modelloGestoreDiarieInfermieristiche.setTableFarmaci(farmaci);
					modello.modelloGestoreDiarieInfermieristiche.setTableImportante(importante);
					modello.modelloGestoreDiarieInfermieristiche.setTableNoteParticolari(noteParticolari);
					modello.modelloGestoreDiarieInfermieristiche.setTableOreArrivo(oreCreazione);
					SwingUtilities.invokeLater(new Runnable() {
					    @Override
					    public void run() {
					    	frameDelleDiarieInfermieristiche.updateViewTabella();
					    }
					});
				}
			} catch (SQLException ev) {
				System.out.println(ev.getMessage());
			}
		}
	}
	
}




