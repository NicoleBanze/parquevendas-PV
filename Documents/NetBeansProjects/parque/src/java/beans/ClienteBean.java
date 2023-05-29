/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.ClienteDAO;
import DAO.ImplementarClienteDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Modelos.Cliente;

@ManagedBean
@ViewScoped

/**
 *
 * @author 25885
 */
public class ClienteBean {
    private Cliente cliente;
    private List<Cliente> clientes;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCurso(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        ImplementarClienteDAO dao=new ImplementarClienteDAO();
        clientes=dao.apresentarCliente();
        return clientes;
    }

    public void setCursos(List<Cliente> cursos) {
        this.clientes = clientes;
    }
    
    /**
     * Creates a new instance of CursoBean
     */
    public ClienteBean() {
        cliente=new Cliente();
        
    }

    public void inserir(){
        ImplementarClienteDAO dao=new ImplementarClienteDAO();
        dao.inserirCliente(cliente);
        cliente=new Cliente();
        addMessage("Cliente inserido com sucesso");
    } 
    public void modificar(){
        ImplementarClienteDAO dao=new ImplementarClienteDAO();
        dao.actualizarCliente(cliente);
        cliente=new Cliente();
        addMessage("Cliente modificado com sucesso");
    }
        public void eliminar(){
        ImplementarClienteDAO dao=new ImplementarClienteDAO();
        dao.apagarCliente(cliente);
        cliente=new Cliente();
        addMessage("Cliente eliminado com sucesso");
    }
    public void addMessage(String summary){
        FacesMessage messagem=new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, messagem);
    }
    
}
