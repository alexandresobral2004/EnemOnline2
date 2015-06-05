/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.EscolaDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Escola;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class EscolaFaces implements Serializable, InterfacePadrao {

    private Escola selectedEscola;
    private List<Escola> escolas;

    //Chamada dos DAO's
    @Inject
    private EscolaDAO escDAO;

    public Escola getSelectedEscola() {
        return selectedEscola;
    }

    public void setSelectedEscola(Escola selectedEscola) {
        this.selectedEscola = selectedEscola;
    }

    public List<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    @Override
    public String startFaces() {
        this.selectedEscola = new Escola();
        getAllEscolas();
        
        return "/aluno/cad_escola.jsf";
    }
    
    public void newObject(){
         this.selectedEscola = new Escola();
    }
    

    @Override
    public void add() {
        try {
            escDAO.addEscola(this.selectedEscola);
             this.selectedEscola = new Escola();
              getAllEscolas();
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola cadastrada!", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar escola!!", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
            Logger.getLogger(EscolaFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit() {
        try {
            escDAO.editEscola(this.selectedEscola);
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola editada!", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
            Logger.getLogger(EscolaFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void del() {
        try {
            escDAO.delEscola(this.selectedEscola);
              getAllEscolas();
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola Apagada!", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
            Logger.getLogger(EscolaFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Escola getObjetoByID(int id) {
    this.selectedEscola  = escDAO.getEntity(Escola.class, id);
        return this.selectedEscola;
    }

    @Override
     public void getAllObjetosByID() {
        this.escolas=null;
        this.escolas = escDAO.getAllEscolas();
        
    }
     
     
     public void getAllEscolas() {
        this.escolas=null;
        this.escolas = escDAO.getAllEscolas();
        
    }
    
    
    
    
    
     public void editEscola(RowEditEvent event) throws Exception {
        escDAO.editEscola(selectedEscola);
        FacesMessage msg = new FacesMessage("Escola Editada",null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Escola Não Editada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
