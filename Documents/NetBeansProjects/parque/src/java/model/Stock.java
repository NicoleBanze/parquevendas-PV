/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 25885
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByCodigoStock", query = "SELECT s FROM Stock s WHERE s.codigoStock = :codigoStock"),
    @NamedQuery(name = "Stock.findByQuantidade", query = "SELECT s FROM Stock s WHERE s.quantidade = :quantidade")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_stock")
    private Integer codigoStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockCod")
    private Collection<Vendas> vendasCollection;
    @JoinColumn(name = "cod_viatura", referencedColumnName = "codigo_viatura")
    @ManyToOne(optional = false)
    private Viatura codViatura;

    public Stock() {
    }

    public Stock(Integer codigoStock) {
        this.codigoStock = codigoStock;
    }

    public Stock(Integer codigoStock, int quantidade) {
        this.codigoStock = codigoStock;
        this.quantidade = quantidade;
    }

    public Integer getCodigoStock() {
        return codigoStock;
    }

    public void setCodigoStock(Integer codigoStock) {
        this.codigoStock = codigoStock;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    public Viatura getCodViatura() {
        return codViatura;
    }

    public void setCodViatura(Viatura codViatura) {
        this.codViatura = codViatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoStock != null ? codigoStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codigoStock == null && other.codigoStock != null) || (this.codigoStock != null && !this.codigoStock.equals(other.codigoStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stock[ codigoStock=" + codigoStock + " ]";
    }
    
}
