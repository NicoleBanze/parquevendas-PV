/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
    import DAO.ViaturaDAO;
    import DAO.ImplementarViaturaDAO;
    import java.util.List;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.ViewScoped;
    import javax.faces.context.FacesContext;
    import Modelos.Viatura;

    @ManagedBean
    @ViewScoped
/**
 *
 * @author 25885
 */
public class ViaturaBean {
    private Viatura viatura;
    private List<Viatura> viaturas;

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public List<Viatura> getViaturas() {
        ImplementarViaturaDAO dao=new ImplementarViaturaDAO();
        viaturas=dao.apresentarViatura();
        return viaturas;
    }

    public void setViatura(List<Viatura> viaturas) {
        this.viaturas = viaturas;
    }
    
    /**
     * Creates a new instance of CursoBean
     */
    public ViaturaBean() {
        viatura=new Viatura();
        
    }

    public void inserir(){
        ImplementarViaturaDAO dao=new ImplementarViaturaDAO();
        dao.inserirViatura(viatura);
        viatura=new Viatura();
        addMessage("Viatura inserida com sucesso");
    } 
    public void modificar(){
        ImplementarViaturaDAO dao=new ImplementarViaturaDAO();
        dao.actualizarViatura(viatura);
        viatura=new Viatura();
        addMessage("Viatura modificada com sucesso");
    }
        public void eliminar(){
        ImplementarViaturaDAO dao=new ImplementarViaturaDAO();
        dao.apagarViatura(viatura);
        viatura=new Viatura();
        addMessage("Viatura eliminada com sucesso");
    }
    public void addMessage(String summary){
        FacesMessage messagem=new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, messagem);
    }
}
