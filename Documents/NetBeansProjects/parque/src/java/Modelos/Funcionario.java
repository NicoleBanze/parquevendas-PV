package Modelos;
// Generated 28/mai/2023 21:10:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private int codigoFuncionario;
     private String nome;
     private String apelido;
     private Date dataNascimento;
     private String bi;
     private String contacto;
     private String endereco;
     private String posicao;
     private String email;
     private Set vendases = new HashSet(0);

    public Funcionario() {
    }

	
    public Funcionario(int codigoFuncionario, String nome, String apelido, Date dataNascimento, String bi, String contacto, String endereco, String posicao, String email) {
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
    public Funcionario(int codigoFuncionario, String nome, String apelido, Date dataNascimento, String bi, String contacto, String endereco, String posicao, String email, Set vendases) {
       this.codigoFuncionario = codigoFuncionario;
       this.nome = nome;
       this.apelido = apelido;
       this.dataNascimento = dataNascimento;
       this.bi = bi;
       this.contacto = contacto;
       this.endereco = endereco;
       this.posicao = posicao;
       this.email = email;
       this.vendases = vendases;
    }
   
    public int getCodigoFuncionario() {
        return this.codigoFuncionario;
    }
    
    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelido() {
        return this.apelido;
    }
    
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getBi() {
        return this.bi;
    }
    
    public void setBi(String bi) {
        this.bi = bi;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getPosicao() {
        return this.posicao;
    }
    
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getVendases() {
        return this.vendases;
    }
    
    public void setVendases(Set vendases) {
        this.vendases = vendases;
    }




}

