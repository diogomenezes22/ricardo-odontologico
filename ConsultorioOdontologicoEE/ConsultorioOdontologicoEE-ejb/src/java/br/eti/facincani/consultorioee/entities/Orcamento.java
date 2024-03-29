/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.facincani.consultorioee.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricardo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orc_id", nullable = false)
    private Integer orcId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orc_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orcDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orc_hour", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date orcHour;
    @Lob
    @Size(max = 65535)
    @Column(name = "orc_obs", length = 65535)
    private String orcObs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orc_total", precision = 16, scale = 2)
    private BigDecimal orcTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "orc_paymentType", nullable = false, length = 9)
    private String orcpaymentType;
    @Column(name = "orc_times")
    private Integer orcTimes;
    @JoinColumn(name = "orc_customer", referencedColumnName = "cus_id", nullable = false)
    @ManyToOne(optional = false)
    private Customer orcCustomer;
    @JoinColumn(name = "orc_dentist", referencedColumnName = "usu_id", nullable = false)
    @ManyToOne(optional = false)
    private Users orcDentist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oriOrcamento")
    private List<Orcamentoitem> orcamentoitemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ansOrcamento")
    private List<Anamnese> anamneseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parOrcamento")
    private List<Parcela> parcelaList;

    public Orcamento() {
    }

    public Orcamento(Integer orcId) {
        this.orcId = orcId;
    }

    public Orcamento(Integer orcId, Date orcDate, Date orcHour, String orcpaymentType) {
        this.orcId = orcId;
        this.orcDate = orcDate;
        this.orcHour = orcHour;
        this.orcpaymentType = orcpaymentType;
    }

    public Integer getOrcId() {
        return orcId;
    }

    public void setOrcId(Integer orcId) {
        this.orcId = orcId;
    }

    public Date getOrcDate() {
        return orcDate;
    }

    public void setOrcDate(Date orcDate) {
        this.orcDate = orcDate;
    }

    public Date getOrcHour() {
        return orcHour;
    }

    public void setOrcHour(Date orcHour) {
        this.orcHour = orcHour;
    }

    public String getOrcObs() {
        return orcObs;
    }

    public void setOrcObs(String orcObs) {
        this.orcObs = orcObs;
    }

    public BigDecimal getOrcTotal() {
        return orcTotal;
    }

    public void setOrcTotal(BigDecimal orcTotal) {
        this.orcTotal = orcTotal;
    }

    public String getOrcpaymentType() {
        return orcpaymentType;
    }

    public void setOrcpaymentType(String orcpaymentType) {
        this.orcpaymentType = orcpaymentType;
    }

    public Integer getOrcTimes() {
        return orcTimes;
    }

    public void setOrcTimes(Integer orcTimes) {
        this.orcTimes = orcTimes;
    }

    public Customer getOrcCustomer() {
        return orcCustomer;
    }

    public void setOrcCustomer(Customer orcCustomer) {
        this.orcCustomer = orcCustomer;
    }

    public Users getOrcDentist() {
        return orcDentist;
    }

    public void setOrcDentist(Users orcDentist) {
        this.orcDentist = orcDentist;
    }

    @XmlTransient
    public List<Orcamentoitem> getOrcamentoitemList() {
        return orcamentoitemList;
    }

    public void setOrcamentoitemList(List<Orcamentoitem> orcamentoitemList) {
        this.orcamentoitemList = orcamentoitemList;
    }

    @XmlTransient
    public List<Anamnese> getAnamneseList() {
        return anamneseList;
    }

    public void setAnamneseList(List<Anamnese> anamneseList) {
        this.anamneseList = anamneseList;
    }

    @XmlTransient
    public List<Parcela> getParcelaList() {
        return parcelaList;
    }

    public void setParcelaList(List<Parcela> parcelaList) {
        this.parcelaList = parcelaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orcId != null ? orcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.orcId == null && other.orcId != null) || (this.orcId != null && !this.orcId.equals(other.orcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.eti.facincani.consultorioee.entities.Orcamento[ orcId=" + orcId + " ]";
    }
    
}
