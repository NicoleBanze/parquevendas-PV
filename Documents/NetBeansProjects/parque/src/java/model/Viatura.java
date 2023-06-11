/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 25885
 */
@Entity
@Table(name = "viatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viatura.findAll", query = "SELECT v FROM Viatura v"),
    @NamedQuery(name = "Viatura.findByCodigoViatura", query = "SELECT v FROM Viatura v WHERE v.codigoViatura = :codigoViatura"),
    @NamedQuery(name = "Viatura.findByMarca", query = "SELECT v FROM Viatura v WHERE v.marca = :marca"),
    @NamedQuery(name = "Viatura.findByModelo", query = "SELECT v FROM Viatura v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Viatura.findByNumeroPortas", query = "SELECT v FROM Viatura v WHERE v.numeroPortas = :numeroPortas"),
    @NamedQuery(name = "Viatura.findByCilindrada", query = "SELECT v FROM Viatura v WHERE v.cilindrada = :cilindrada"),
    @NamedQuery(name = "Viatura.findByPotencia", query = "SELECT v FROM Viatura v WHERE v.potencia = :potencia"),
    @NamedQuery(name = "Viatura.findByPreco", query = "SELECT v FROM Viatura v WHERE v.preco = :preco"),
    @NamedQuery(name = "Viatura.findByCor", query = "SELECT v FROM Viatura v WHERE v.cor = :cor")})
public class Viatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_viatura")
    private Integer codigoViatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_portas")
    private int numeroPortas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cilindrada")
    private String cilindrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "potencia")
    private String potencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private BigInteger preco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cor")
    private String cor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codViatura")
    private Collection<Stock> stockCollection;

    public Viatura() {
    }

    public Viatura(Integer codigoViatura) {
        this.codigoViatura = codigoViatura;
    }

    public Viatura(Integer codigoViatura, String marca, String modelo, int numeroPortas, String cilindrada, String potencia, BigInteger preco, String cor) {
        this.codigoViatura = codigoViatura;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPortas = numeroPortas;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.preco = preco;
        this.cor = cor;
    }

    public Integer getCodigoViatura() {
        return codigoViatura;
    }

    public void setCodigoViatura(Integer codigoViatura) {
        this.codigoViatura = codigoViatura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public BigInteger getPreco() {
        return preco;
    }

    public void setPreco(BigInteger preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoViatura != null ? codigoViatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viatura)) {
            return false;
        }
        Viatura other = (Viatura) object;
        if ((this.codigoViatura == null && other.codigoViatura != null) || (this.codigoViatura != null && !this.codigoViatura.equals(other.codigoViatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Viatura[ codigoViatura=" + codigoViatura + " ]";
    }
    
}
