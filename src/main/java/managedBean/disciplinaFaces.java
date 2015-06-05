/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.disciplinaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Disciplina;
import model.Escola;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class disciplinaFaces implements Serializable{
    
    private Disciplina selectedDisci;
    private List<Disciplina> disciplinas;
    
    
    @Inject
    private disciplinaDAO  disciDAO;

    
    
    public Disciplina getSelectedDisci() {
        return selectedDisci;
    }

    public void setSelectedDisci(Disciplina selectedDisci) {
        this.selectedDisci = selectedDisci;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
    
    public String startDisciplina(){
        this.selectedDisci = new Disciplina();
        return "/admin/disciplina";
    }

    
    public disciplinaFaces() {
       this.selectedDisci = new Disciplina();
    }
    
    public void newObject(){
        this.selectedDisci = new Disciplina();
    }
    
    
       public void addDisciplina() throws Exception {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Gravada com Sucesso", "Dados Gravados Com Sucesso!!");
        FacesContext.getCurrentInstance().addMessage("message", message);
        disciDAO.adddisciplina(selectedDisci);
        selectedDisci = new Disciplina();
    }

    public List findAllDisciplinas() {
        this.disciplinas = null;
        this.disciplinas = disciDAO.findAllDisciplinas();
        return disciplinas;
        

    }
    
}
