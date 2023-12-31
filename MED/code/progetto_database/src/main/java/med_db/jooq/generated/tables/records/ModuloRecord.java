/*
 * This file is generated by jOOQ.
 */
package med_db.jooq.generated.tables.records;


import med_db.jooq.generated.tables.Modulo;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ModuloRecord extends UpdatableRecordImpl<ModuloRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>MODULO.CODICE_REPARTO</code>.
     */
    public void setCodiceReparto(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>MODULO.CODICE_REPARTO</code>.
     */
    public String getCodiceReparto() {
        return (String) get(0);
    }

    /**
     * Setter for <code>MODULO.NOME</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>MODULO.NOME</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
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
        return Modulo.MODULO.CODICE_REPARTO;
    }

    @Override
    public Field<String> field2() {
        return Modulo.MODULO.NOME;
    }

    @Override
    public String component1() {
        return getCodiceReparto();
    }

    @Override
    public String component2() {
        return getNome();
    }

    @Override
    public String value1() {
        return getCodiceReparto();
    }

    @Override
    public String value2() {
        return getNome();
    }

    @Override
    public ModuloRecord value1(String value) {
        setCodiceReparto(value);
        return this;
    }

    @Override
    public ModuloRecord value2(String value) {
        setNome(value);
        return this;
    }

    @Override
    public ModuloRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ModuloRecord
     */
    public ModuloRecord() {
        super(Modulo.MODULO);
    }

    /**
     * Create a detached, initialised ModuloRecord
     */
    public ModuloRecord(String codiceReparto, String nome) {
        super(Modulo.MODULO);

        setCodiceReparto(codiceReparto);
        setNome(nome);
        resetChangedOnNotNull();
    }
}
