/*
 * This file is generated by jOOQ.
 */
package medDB.jooq.generated;


import java.util.Arrays;
import java.util.List;

import medDB.jooq.generated.tables.Assegnazioneletto;
import medDB.jooq.generated.tables.Degente;
import medDB.jooq.generated.tables.Diariainf;
import medDB.jooq.generated.tables.Diariamed;
import medDB.jooq.generated.tables.Letto;
import medDB.jooq.generated.tables.Modulo;
import medDB.jooq.generated.tables.Personale;
import medDB.jooq.generated.tables.Reparto;
import medDB.jooq.generated.tables.Rilevazione;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>ASSEGNAZIONELETTO</code>.
     */
    public final Assegnazioneletto ASSEGNAZIONELETTO = Assegnazioneletto.ASSEGNAZIONELETTO;

    /**
     * The table <code>DEGENTE</code>.
     */
    public final Degente DEGENTE = Degente.DEGENTE;

    /**
     * The table <code>DIARIAINF</code>.
     */
    public final Diariainf DIARIAINF = Diariainf.DIARIAINF;

    /**
     * The table <code>DIARIAMED</code>.
     */
    public final Diariamed DIARIAMED = Diariamed.DIARIAMED;

    /**
     * The table <code>LETTO</code>.
     */
    public final Letto LETTO = Letto.LETTO;

    /**
     * The table <code>MODULO</code>.
     */
    public final Modulo MODULO = Modulo.MODULO;

    /**
     * The table <code>PERSONALE</code>.
     */
    public final Personale PERSONALE = Personale.PERSONALE;

    /**
     * The table <code>REPARTO</code>.
     */
    public final Reparto REPARTO = Reparto.REPARTO;

    /**
     * The table <code>RILEVAZIONE</code>.
     */
    public final Rilevazione RILEVAZIONE = Rilevazione.RILEVAZIONE;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Assegnazioneletto.ASSEGNAZIONELETTO,
            Degente.DEGENTE,
            Diariainf.DIARIAINF,
            Diariamed.DIARIAMED,
            Letto.LETTO,
            Modulo.MODULO,
            Personale.PERSONALE,
            Reparto.REPARTO,
            Rilevazione.RILEVAZIONE
        );
    }
}
