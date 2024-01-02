/*
 * This file is generated by jOOQ.
 */
package med_db.jooq.generated.tables.records;


import med_db.jooq.generated.tables.Degente;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DegenteRecord extends UpdatableRecordImpl<DegenteRecord> implements Record5<String, String, String, Integer, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>DEGENTE.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>DEGENTE.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DEGENTE.NOME</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DEGENTE.NOME</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DEGENTE.COGNOME</code>.
     */
    public void setCognome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DEGENTE.COGNOME</code>.
     */
    public String getCognome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DEGENTE.URGENZA</code>.
     */
    public void setUrgenza(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DEGENTE.URGENZA</code>.
     */
    public Integer getUrgenza() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DEGENTE.IN_ATTESA</code>.
     */
    public void setInAttesa(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>DEGENTE.IN_ATTESA</code>.
     */
    public Boolean getInAttesa() {
        return (Boolean) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, Integer, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, Integer, Boolean> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Degente.DEGENTE.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Degente.DEGENTE.NOME;
    }

    @Override
    public Field<String> field3() {
        return Degente.DEGENTE.COGNOME;
    }

    @Override
    public Field<Integer> field4() {
        return Degente.DEGENTE.URGENZA;
    }

    @Override
    public Field<Boolean> field5() {
        return Degente.DEGENTE.IN_ATTESA;
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
    public Integer component4() {
        return getUrgenza();
    }

    @Override
    public Boolean component5() {
        return getInAttesa();
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
    public Integer value4() {
        return getUrgenza();
    }

    @Override
    public Boolean value5() {
        return getInAttesa();
    }

    @Override
    public DegenteRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public DegenteRecord value2(String value) {
        setNome(value);
        return this;
    }

    @Override
    public DegenteRecord value3(String value) {
        setCognome(value);
        return this;
    }

    @Override
    public DegenteRecord value4(Integer value) {
        setUrgenza(value);
        return this;
    }

    @Override
    public DegenteRecord value5(Boolean value) {
        setInAttesa(value);
        return this;
    }

    @Override
    public DegenteRecord values(String value1, String value2, String value3, Integer value4, Boolean value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DegenteRecord
     */
    public DegenteRecord() {
        super(Degente.DEGENTE);
    }

    /**
     * Create a detached, initialised DegenteRecord
     */
    public DegenteRecord(String codice, String nome, String cognome, Integer urgenza, Boolean inAttesa) {
        super(Degente.DEGENTE);

        setCodice(codice);
        setNome(nome);
        setCognome(cognome);
        setUrgenza(urgenza);
        setInAttesa(inAttesa);
        resetChangedOnNotNull();
    }
}