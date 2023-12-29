/*
 * This file is generated by jOOQ.
 */
package medDB.jooq.generated.tables.records;


import medDB.jooq.generated.tables.Reparto;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RepartoRecord extends UpdatableRecordImpl<RepartoRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>REPARTO.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>REPARTO.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>REPARTO.NOME_REPARTO</code>.
     */
    public void setNomeReparto(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>REPARTO.NOME_REPARTO</code>.
     */
    public String getNomeReparto() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Reparto.REPARTO.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Reparto.REPARTO.NOME_REPARTO;
    }

    @Override
    public String component1() {
        return getCodice();
    }

    @Override
    public String component2() {
        return getNomeReparto();
    }

    @Override
    public String value1() {
        return getCodice();
    }

    @Override
    public String value2() {
        return getNomeReparto();
    }

    @Override
    public RepartoRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public RepartoRecord value2(String value) {
        setNomeReparto(value);
        return this;
    }

    @Override
    public RepartoRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RepartoRecord
     */
    public RepartoRecord() {
        super(Reparto.REPARTO);
    }

    /**
     * Create a detached, initialised RepartoRecord
     */
    public RepartoRecord(String codice, String nomeReparto) {
        super(Reparto.REPARTO);

        setCodice(codice);
        setNomeReparto(nomeReparto);
        resetChangedOnNotNull();
    }
}
