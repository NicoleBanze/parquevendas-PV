/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 25885
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodigoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codigoFuncionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByApelido", query = "SELECT f FROM Funcionario f WHERE f.apelido = :apelido"),
    @NamedQuery(name = "Funcionario.findByDataNascimento", query = "SELECT f FROM Funcionario f WHERE f.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Funcionario.findByBi", query = "SELECT f FROM Funcionario f WHERE f.bi = :bi"),
    @NamedQuery(name = "Funcionario.findByContacto", query = "SELECT f FROM Funcionario f WHERE f.contacto = :contacto"),
    @NamedQuery(name = "Funcionario.findByEndereco", query = "SELECT f FROM Funcionario f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Funcionario.findByPosicao", query = "SELECT f FROM Funcionario f WHERE f.posicao = :posicao"),
    @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_funcionario")
    private Integer codigoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apelido")
    private String apelido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "BI")
    private String bi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Posicao")
    private String posicao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioCod")
    private Collection<Vendas> vendasCollection;

    public Funcionario() {
    }

    public Funcionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Funcionario(Integer codigoFuncionario, String nome, String apelido, Date dataNascimento, String bi, String contacto, String endereco, String posicao, String email) {
        this.codigoFuncionario = codigoFuncionario;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.bi = bi;
        this.contacto = contacto;
        this.endereco = endereco;
        this.posicao = posicao;
        this.email = email;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ codigoFuncionario=" + codigoFuncionario + " ]";
    }
    
}
