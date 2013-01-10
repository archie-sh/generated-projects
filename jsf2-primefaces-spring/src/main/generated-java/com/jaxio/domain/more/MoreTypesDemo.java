/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity.e.vm.java
 */
package com.jaxio.domain.more;

import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIMESTAMP;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import com.google.common.base.Objects;
import com.jaxio.domain.Identifiable;
import com.jaxio.domain.IdentifiableHashBuilder;

@Entity
@Table(name = "MORE_TYPES_DEMO")
@Cache(usage = NONSTRICT_READ_WRITE)
public class MoreTypesDemo implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(MoreTypesDemo.class);

    // Raw attributes
    private Integer id; // pk
    private Integer numberInt;
    private Long numberLong;
    private Double numberDouble;
    private Float numberFloat;
    private BigInteger numberBigInteger;
    private BigDecimal numberBigDecimal;
    private Date dateJavaTemporalDate;
    private Date dateJavaTemporalTimestamp;
    private LocalDate dateJoda;
    private LocalDateTime dateTimeJoda;
    private Integer version;

    // ---------------------------
    // Constructors
    // ---------------------------

    public MoreTypesDemo() {
    }

    public MoreTypesDemo(Integer primaryKey) {
        setId(primaryKey);
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [numberInt] ------------------------

    @Column(name = "NUMBER_INT", precision = 10)
    public Integer getNumberInt() {
        return numberInt;
    }

    public void setNumberInt(Integer numberInt) {
        this.numberInt = numberInt;
    }

    // -- [numberLong] ------------------------

    @Column(name = "NUMBER_LONG", precision = 19)
    public Long getNumberLong() {
        return numberLong;
    }

    public void setNumberLong(Long numberLong) {
        this.numberLong = numberLong;
    }

    // -- [numberDouble] ------------------------

    @Column(name = "NUMBER_DOUBLE", precision = 17)
    public Double getNumberDouble() {
        return numberDouble;
    }

    public void setNumberDouble(Double numberDouble) {
        this.numberDouble = numberDouble;
    }

    // -- [numberFloat] ------------------------

    @Column(name = "NUMBER_FLOAT", precision = 7)
    public Float getNumberFloat() {
        return numberFloat;
    }

    public void setNumberFloat(Float numberFloat) {
        this.numberFloat = numberFloat;
    }

    // -- [numberBigInteger] ------------------------

    @Column(name = "NUMBER_BIG_INTEGER", precision = 20)
    public BigInteger getNumberBigInteger() {
        return numberBigInteger;
    }

    public void setNumberBigInteger(BigInteger numberBigInteger) {
        this.numberBigInteger = numberBigInteger;
    }

    // -- [numberBigDecimal] ------------------------

    @Digits(integer = 20, fraction = 2)
    @Column(name = "NUMBER_BIG_DECIMAL", precision = 20, scale = 2)
    public BigDecimal getNumberBigDecimal() {
        return numberBigDecimal;
    }

    public void setNumberBigDecimal(BigDecimal numberBigDecimal) {
        this.numberBigDecimal = numberBigDecimal;
    }

    // -- [dateJavaTemporalDate] ------------------------

    @Column(name = "DATE_JAVA_TEMPORAL_DATE", length = 8)
    @Temporal(DATE)
    public Date getDateJavaTemporalDate() {
        return dateJavaTemporalDate;
    }

    public void setDateJavaTemporalDate(Date dateJavaTemporalDate) {
        this.dateJavaTemporalDate = dateJavaTemporalDate;
    }

    // -- [dateJavaTemporalTimestamp] ------------------------

    @Column(name = "DATE_JAVA_TEMPORAL_TIMESTAMP", length = 23)
    @Temporal(TIMESTAMP)
    public Date getDateJavaTemporalTimestamp() {
        return dateJavaTemporalTimestamp;
    }

    public void setDateJavaTemporalTimestamp(Date dateJavaTemporalTimestamp) {
        this.dateJavaTemporalTimestamp = dateJavaTemporalTimestamp;
    }

    // -- [dateJoda] ------------------------

    @Column(name = "DATE_JODA", length = 8)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getDateJoda() {
        return dateJoda;
    }

    public void setDateJoda(LocalDate dateJoda) {
        this.dateJoda = dateJoda;
    }

    // -- [dateTimeJoda] ------------------------

    @Column(name = "DATE_TIME_JODA", length = 23)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getDateTimeJoda() {
        return dateTimeJoda;
    }

    public void setDateTimeJoda(LocalDateTime dateTimeJoda) {
        this.dateTimeJoda = dateTimeJoda;
    }

    // -- [version] ------------------------

    @Column(name = "VERSION", precision = 10)
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    /**
     * equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof MoreTypesDemo && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this MoreTypesDemo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("numberInt", getNumberInt()) //
                .add("numberLong", getNumberLong()) //
                .add("numberDouble", getNumberDouble()) //
                .add("numberFloat", getNumberFloat()) //
                .add("numberBigInteger", getNumberBigInteger()) //
                .add("numberBigDecimal", getNumberBigDecimal()) //
                .add("dateJavaTemporalDate", getDateJavaTemporalDate()) //
                .add("dateJavaTemporalTimestamp", getDateJavaTemporalTimestamp()) //
                .add("dateJoda", getDateJoda()) //
                .add("dateTimeJoda", getDateTimeJoda()) //
                .add("version", getVersion()) //
                .toString();
    }

}