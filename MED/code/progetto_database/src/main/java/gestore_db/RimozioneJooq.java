package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;

public class RimozioneJooq {
	
	public void personale(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(codice)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void degente(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
				System.out.println(result);
				//cancellazione delle entità daboli diaria med e inf e assLetto da implementare
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void rilevazione(String ID, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.ID.eq(ID), Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void reparto(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				//cancello il reparto
				int result = delete.deleteFrom(Reparto.REPARTO).where(Reparto.REPARTO.CODICE.eq(codice)).execute();
				System.out.println(result);
				//cancellazione di entità deboli da implementare
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void modulo(String codRep, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codRep), Modulo.MODULO.NOME.eq(nome)).execute();
				System.out.println(result);
				//cancelazione entità deboli da implementare
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void letto(String codRep, String nomeMod, int numero) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codRep), Letto.LETTO.NOME_MODULO.eq(nomeMod), Letto.LETTO.NUMERO.eq(numero)).execute();
				System.out.println(result);
				//rimozione dell'entità debole assegnazione letto da implementare
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numLetto) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(codDeg) ,Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep), Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeMod), Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(numLetto)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String codice, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE.eq(codice), Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaInf(String codice, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE.eq(codice), Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {
		RimozioneJooq rm= new RimozioneJooq();
		rm.personale("P2");
		rm.rilevazione("Ri1","D1");
		rm.degente("D1");
		rm.reparto("Re1");
		rm.modulo("Re1","ModuloA");
		rm.letto("Re1", "ModuloA", 1);
		rm.assegnazioneLetto("D1","Re1", "ModuloA", 1);
		rm.diariaInf("DiariaInf1", "D1");
		rm.diariaMed("DiariaMed1","D1");

	}

}