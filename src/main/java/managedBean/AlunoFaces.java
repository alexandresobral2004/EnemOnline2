/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.AlunoDAO;
import dao.EscolaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Aluno;
import model.Escola;
import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class AlunoFaces implements Serializable,InterfacePadrao{
    
    //Objetos usados nas páginas XHTML
    private Aluno selectedAluno;
    private List<Aluno> alunos;
    private List<Escola> escolas;
    private List nivelAcessoUsuario;
    private List nivelAcessoAluno;
    
    
    //Chamada dos DAO's
    @Inject
    private AlunoDAO alunoDAO;
    @Inject
    private EscolaDAO escDAO;

   
   

    public Aluno getSelectedAluno() {
        return selectedAluno;
    }

    public void setSelectedAluno(Aluno selectedAluno) {
        this.selectedAluno = selectedAluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
   

    public List<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    public List getNivelAcessoUsuario() {
        return nivelAcessoUsuario;
    }

    public void setNivelAcessoUsuario(List nivelAcessoUsuario) {
        this.nivelAcessoUsuario = nivelAcessoUsuario;
    }

    public List getNivelAcessoAluno() {
        return nivelAcessoAluno;
    }

    public void setNivelAcessoAluno(List nivelAcessoAluno) {
        this.nivelAcessoAluno = nivelAcessoAluno;
    }
    
    public void nivelAcessoUsuario(){
       
    }
    
    public void permissoes(){
        this.nivelAcessoUsuario = new ArrayList();
        this.nivelAcessoUsuario.add("ADMIN");
        this.nivelAcessoUsuario.add("ESCOLA");
        this.nivelAcessoUsuario.add("PUBLICO");
        
    }
    
     public String startEditAluno(){
        return "/aluno/editAluno.jsf";
    }
     
      @Override
    public String startFaces() {
       this.selectedAluno = new Aluno();
      permissoes();
       this.alunos = alunoDAO.getAllAlunos();
       this.escolas = escDAO.getAllEscolas();
       return "/admin/cad_aluno.jsf";
       
    }
    
     public String cad_aluno_entrada() {
       this.selectedAluno = new Aluno();
       this.selectedAluno.setAuthority("ESCOLA");
          this.escolas = escDAO.getAllEscolas();
          
          System.out.println("Chamada Aluno");
          return "/cad_aluno.jsf";
    }
     
      public String fazer_login() {
      
          return "/login.jsf";
    }
  
    
    

    @Override
    public void add() {
        try {
            alunoDAO.addAluno(selectedAluno);
            selectedAluno = new Aluno();
            this.alunos = alunoDAO.getAllAlunos();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado Realizado com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Houve um Erro ao Gravar os Dados", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
            Logger.getLogger(AlunoFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit() {
        try {
            alunoDAO.editAluno(selectedAluno);
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados Editados com Sucesso", null);
         FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Editar os Dados", null);
         FacesContext.getCurrentInstance().addMessage("message", message);
            Logger.getLogger(AlunoFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void del() {
        try {
            alunoDAO.delAluno(selectedAluno);
            this.alunos = alunoDAO.getAllAlunos();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro Apagado com Sucesso", null);
         FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Apagar os Dados", null);
         FacesContext.getCurrentInstance().addMessage("message", message);
            Logger.getLogger(AlunoFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    @Override
    public void getAllObjetos() {
        this.alunos = null;
        this.alunos = alunoDAO.getAllAlunos();
        
    }
    

    @Override
    public Aluno getObjetoByID(int id) {
       this.selectedAluno = alunoDAO.getAlunoByID(id);
       return selectedAluno;
    }
    
    public void newAluno(){
        selectedAluno = new Aluno();
    }
   
    
    public String editAluno() throws Exception {
        alunoDAO.editAluno(selectedAluno);
        FacesMessage msg = new FacesMessage("Aluno Editado",null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/admin/cad_aluno.jsf";
    }
     
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Aluno não Editado", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public void userLogado(){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        this.alunos = null;
        this.alunos = alunoDAO.getAlunobyLogin(login);
        this.selectedAluno = this.alunos.get(0);
        System.out.println(this.selectedAluno.getNome());
    }
    
   
    
    
    
}
