/*
 * This file is generated by jOOQ.
 */
package medDB.jooq.generated.tables.records;


import medDB.jooq.generated.tables.Personale;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonaleRecord extends UpdatableRecordImpl<PersonaleRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PERSONALE.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PERSONALE.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PERSONALE.NOME</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PERSONALE.NOME</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PERSONALE.COGNOME</code>.
     */
    public void setCognome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PERSONALE.COGNOME</code>.
     */
    public String getCognome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PERSONALE.MANSIONE</code>.
     */
    public void setMansione(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PERSONALE.MANSIONE</code>.
     */
    public String getMansione() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Personale.PERSONALE.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Personale.PERSONALE.NOME;
    }

    @Override
    public Field<String> field3() {
        return Personale.PERSONALE.COGNOME;
    }

    @Override
    public Field<String> field4() {
        return Personale.PERSONALE.MANSIONE;
    }

    @Override
    public String component1() {
        return getCodice();
    }

    @Override
    public String component2() {
        return getNome();
    }

    @Override
    public String component3() {
        return getCognome();
    }

    @Override
    public String component4() {
        return getMansione();
    }

    @Override
    public String value1() {
        return getCodice();
    }

    @Override
    public String value2() {
        return getNome();
    }

    @Override
    public String value3() {
        return getCognome();
    }

    @Override
    public String value4() {
        return getMansione();
    }

    @Override
    public PersonaleRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public PersonaleRecord value2(String value) {
        setNome(value);
        return this;
    }

    @Override
    public PersonaleRecord value3(String value) {
        setCognome(value);
        return this;
    }

    @Override
    public PersonaleRecord value4(String value) {
        setMansione(value);
        return this;
    }

    @Override
    public PersonaleRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonaleRecord
     */
    public PersonaleRecord() {
        super(Personale.PERSONALE);
    }

    /**
     * Create a detached, initialised PersonaleRecord
     */
    public PersonaleRecord(String codice, String nome, String cognome, String mansione) {
        super(Personale.PERSONALE);

        setCodice(codice);
        setNome(nome);
        setCognome(cognome);
        setMansione(mansione);
        resetChangedOnNotNull();
    }
}
