package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;
import med_db.jooq.generated.tables.records.*;


public class InserimentoJooq {
	//pattern singleton
	private static InserimentoJooq istanza= new InserimentoJooq();
	
	private InserimentoJooq() {}
	
	public static InserimentoJooq getIstanza() {
		return istanza;
	}

	public void personale(String codice, String nome, String cognome, String mansione, String password) {
		
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

					PersonaleRecord persona = new PersonaleRecord(codice, nome, cognome, mansione, password);

					int result = create.insertInto(Personale.PERSONALE).set(persona).execute();

					System.out.println(result);
					//System.out.println("Membro del personale inserito con successo");
				} else {
					System.out.println("mansione del membro del personale non valida");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void degente(String codice, String nome, String cognome, String sesso, LocalDate dataArrivo, LocalTime oraArrivo,  String urgenza) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if ((urgenza=="verde" || urgenza=="giallo" || urgenza=="rosso") && (sesso=="M" || sesso=="F")) {
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
					//il degente è in pronto soccorso all'inserimento nel DB
					DegenteRecord degente = new DegenteRecord(codice, nome, cognome, sesso, dataArrivo, oraArrivo, urgenza, "in Pronto Soccorso");

					int result = create.insertInto(Degente.DEGENTE).set(degente).execute();

					System.out.println(result);
				} else {
					System.out.println("urgenza e/o sesso inseriti non validi");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void rilevazione(String ID, String codDeg, double temp, int pressMax,int pressMin, int glicem,LocalDate data, LocalTime ora, int freqCard, int dol) {
		try {
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		if (conn != null) {
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

			RilevazioneRecord rilevazione = new RilevazioneRecord(ID, codDeg, temp, pressMax, pressMin, glicem, data, ora, freqCard, dol);

			int result = create.insertInto(Rilevazione.RILEVAZIONE).set(rilevazione).execute();

			System.out.println(result);

		}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
}

	public void reparto(String codice, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				RepartoRecord reparto = new RepartoRecord(codice, nome);

				int result = create.insertInto(Reparto.REPARTO).set(reparto).execute();

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void modulo(String codRep, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				ModuloRecord modulo = new ModuloRecord(codRep, nome);

				int result = create.insertInto(Modulo.MODULO).set(modulo).execute();

				System.out.println(result);
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
	}
	
	public void letto(String codRep, String nomeMod, int numero) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				LettoRecord letto = new LettoRecord(codRep, nomeMod, numero);

				int result = create.insertInto(Letto.LETTO).set(letto).execute();

				System.out.println(result);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numero, LocalDate dataAss) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				AssegnazionelettoRecord assLetto = new AssegnazionelettoRecord(codDeg, codRep, nomeMod, numero, dataAss);

				int result = create.insertInto(Assegnazioneletto.ASSEGNAZIONELETTO).set(assLetto).execute();
				
				//se assegno un letto, il degente non è più in attesa, bensì in reparto
				AggiornamentiJooq.getIstanza().degente(codDeg,"posizione", "in reparto");
				System.out.println(result);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void diariaInf(String codice, String codiceDegente, String codiceInfermiere, LocalDate data, LocalTime ora, String noteParticolari, Boolean importante, String farmaco) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				DiariainfRecord diariaInf = new DiariainfRecord(codice, codiceDegente, codiceInfermiere, data, ora, noteParticolari, importante, farmaco);

				int result = create.insertInto(Diariainf.DIARIAINF).set(diariaInf).execute();

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String codice, String codiceDegente, String codiceMedico, String storico, String motivo, String farmaci, LocalDate data, LocalTime ora, String allergie) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				DiariamedRecord diariaMed = new DiariamedRecord(codice, codiceDegente, codiceMedico, storico, motivo, farmaci, data, ora, allergie);

				int result = create.insertInto(Diariamed.DIARIAMED).set(diariaMed).execute();
				//alla scrittura della diaria medica, il degente viene posto in attesa finchè non gli viene assegnato il letto
				AggiornamentiJooq.getIstanza().degente(codiceDegente, "posizione", "in attesa");

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		//getIstanza().degente("D3","Lara","Longhi","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		//getIstanza().degente("D2","Gabriele","Masinari","M",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		//getIstanza().personale("P1","Daniele","Gotti","M", "SpostamiSeCiRiesci");
		//getIstanza().personale("P2","Filippo","Bolis","I","HaiGiocatoAdOuterWilds");
		//getIstanza().personale("P3","Gabriele","Masinari","S","pw");
		//getIstanza().degente("D1","Gabriele","Mazzoleni","M",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		//getIstanza().rilevazione("Ri1","D1",36.8,150,90,100, LocalDate.now(),LocalTime.now().withNano(0),60,5);
		//getIstanza().reparto("Re1","Cardiologia");
		//getIstanza().modulo("Re1","ModuloA");
		//getIstanza().letto("Re1","ModuloA",1);
		//getIstanza().assegnazioneLetto("D1","Re1","ModuloA",1,LocalDate.now());
		//getIstanza().diariaInf("DiariaInf1","D1","P2",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è diventato enorme dottore",true,"Trembolone");
		//getIstanza().diariaMed("DiariaMed1","D1","P1","il paziente non soffre di nulla in particolare","Vuole diventare più grosso","Trembolone",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
	}

}
