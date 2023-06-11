/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 25885
 */
@Entity
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByCodigoVenda", query = "SELECT v FROM Vendas v WHERE v.codigoVenda = :codigoVenda"),
    @NamedQuery(name = "Vendas.findByQuantidade", query = "SELECT v FROM Vendas v WHERE v.quantidade = :quantidade"),
    @NamedQuery(name = "Vendas.findByPrecoVenda", query = "SELECT v FROM Vendas v WHERE v.precoVenda = :precoVenda")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_venda")
    private Integer codigoVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco_venda")
    private BigInteger precoVenda;
    @JoinColumn(name = "cliente_cod", referencedColumnName = "codigo_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteCod;
    @JoinColumn(name = "funcionario_cod", referencedColumnName = "codigo_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioCod;
    @JoinColumn(name = "stock_cod", referencedColumnName = "codigo_stock")
    @ManyToOne(optional = false)
    private Stock stockCod;

    public Vendas() {
    }

    public Vendas(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Vendas(Integer codigoVenda, int quantidade, BigInteger precoVenda) {
        this.codigoVenda = codigoVenda;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigInteger getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigInteger precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Cliente getClienteCod() {
        return clienteCod;
    }

    public void setClienteCod(Cliente clienteCod) {
        this.clienteCod = clienteCod;
    }

    public Funcionario getFuncionarioCod() {
        return funcionarioCod;
    }

    public void setFuncionarioCod(Funcionario funcionarioCod) {
        this.funcionarioCod = funcionarioCod;
    }

    public Stock getStockCod() {
        return stockCod;
    }

    public void setStockCod(Stock stockCod) {
        this.stockCod = stockCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenda != null ? codigoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.codigoVenda == null && other.codigoVenda != null) || (this.codigoVenda != null && !this.codigoVenda.equals(other.codigoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendas[ codigoVenda=" + codigoVenda + " ]";
    }
    
}
