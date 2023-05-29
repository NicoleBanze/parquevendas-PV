/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.FuncionarioDAO;
import DAO.ImplementarFuncionarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Modelos.Funcionario;

@ManagedBean
@ViewScoped

/**
 *
 * @author 25885
 */
public class FuncionarioBean {
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        ImplementarFuncionarioDAO dao=new ImplementarFuncionarioDAO();
        funcionarios=dao.apresentarFuncionario();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    /**
     * Creates a new instance of CursoBean
     */
    public FuncionarioBean() {
        funcionario=new Funcionario();
        
    }

    public void inserir(){
        ImplementarFuncionarioDAO dao=new ImplementarFuncionarioDAO();
        dao.inserirFuncionario(funcionario);
        funcionario=new Funcionario();
        addMessage("Funcionario inserido com sucesso");
    } 
    public void modificar(){
        ImplementarFuncionarioDAO dao=new ImplementarFuncionarioDAO();
        dao.actualizarFuncionario(funcionario);
        funcionario=new Funcionario();
        addMessage("Funcionario modificado com sucesso");
    }
        public void eliminar(){
        ImplementarFuncionarioDAO dao=new ImplementarFuncionarioDAO();
        dao.apagarFuncionario(funcionario);
        funcionario=new Funcionario();
        addMessage("Funcionario eliminado com sucesso");
    }
    public void addMessage(String summary){
        FacesMessage messagem=new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, messagem);
    }
}
