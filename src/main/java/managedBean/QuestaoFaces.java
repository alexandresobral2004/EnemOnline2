/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ItemDAO;
import dao.QuestaoDAO;
import dao.disciplinaDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Disciplina;
import model.Item;
import model.Prova;
import model.Questao;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class QuestaoFaces implements Serializable{

    
    private Prova selectedProva;
    private Questao selectedQuestao;
    private List<Questao> questoes;
//Itens da prova
    private Item selectedItem;
    //Lista de disciplinas
    private List<Disciplina> disciplinas;
    private String newFileName_A;

    
   
    
    //Componentes para renderização
    private Boolean selectCheckbox = false;
    private Boolean renderCompUpload = false;
    private Boolean renderCompText = false;

    //Chamada dos DAO's
    @Inject
    private QuestaoDAO questaoDAO;
    @Inject
    private disciplinaDAO disciDAO;
    
   
  
    
    public Boolean getRenderCompUpload() {
        return renderCompUpload;
    }

    public void setRenderCompUpload(Boolean renderCompUpload) {
        this.renderCompUpload = renderCompUpload;
    }

    public Boolean getRenderCompText() {
        return renderCompText;
    }

    public void setRenderCompText(Boolean renderCompText) {
        this.renderCompText = renderCompText;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    

    public Boolean getSelectCheckbox() {
        return selectCheckbox;
    }

    public void setSelectCheckbox(Boolean selectCheckbox) {
        this.selectCheckbox = selectCheckbox;
    }
    

    public Prova getSelectedProva() {
        return selectedProva;
    }

    public void setSelectedProva(Prova selectedProva) {
        this.selectedProva = selectedProva;
    }

    public Questao getSelectedQuestao() {
        return selectedQuestao;
    }

    public void setSelectedQuestao(Questao selectedQuestao) {
        this.selectedQuestao = selectedQuestao;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    
   
    
    public String startQuestao(){
      this.selectedProva = new Prova();
        this.selectedQuestao = new Questao();
       //Instancia itens das questoes
        this.selectedItem = new Item();
        
        //incrementaNumQuestao();
         findAllQuestaoes();//Carrega a lista de questões cadastradas
         carregaDisciplinas();//carrega a lista de disciplinas
        System.out.println("Inicia Questão");
        return "/admin/Cad_questao.jsf";
    } 
    
    public QuestaoFaces() {
        this.selectedProva = new Prova();
        
    }
    
    
    
    public void addQuestao() throws Exception{
      
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Questão Gravada com Sucesso", "Dados Gravados Com Sucesso!!");
         FacesContext.getCurrentInstance().addMessage("message", message);
          verificaImagem();
        questaoDAO.addquestao(selectedQuestao);
        findAllQuestaoes();
         
        selectedQuestao = new Questao();
        this.newFileName_A = null;
       // incrementaNumQuestao();
        System.out.println("Questão Inserida");
    }
    
    public void verificaImagem(){
      
        if(this.newFileName_A==null){
            this.selectedQuestao.setImagem(".");
        }
        else{
            this.selectedQuestao.setImagem(this.newFileName_A);
        }
    }
    
    public String newQuestao(){
     
      this.selectedQuestao = new Questao();
       this.selectedQuestao.setImagem(".");
        this.newFileName_A = null;
      //incrementaNumQuestao();
        return "/admin/Cad_questao.jsf";
      
    }
    
  
    
    public String startEditQuestao(){
        return "/admin/editQuestao.jsf";
    }
    
    public String editQuestao() throws Exception {
        
       
        questaoDAO.editQuestao(this.selectedQuestao);
          
        FacesMessage msg = new FacesMessage("Questão Editada",null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/admin/Cad_questao.jsf";
    }
     
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Questao Não Editada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
   // FacesContext fc = FacesContext.getCurrentInstance();
    //HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
    //Integer valor = session.setAttribute(this.selectedQuestao.getNumQuestao());
    
    /*   RECUPERANDO VALOR
    HttpServletRequest request = (HttpServletRequest) req;
    HttpSession session = (HttpSession) request.getSession();
    Integer idUsuarioSession = session.getAttribute("NUM");*/
    
   public void delQuestao() throws Exception{
       questaoDAO.delQuestao(selectedQuestao);
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,"Questão Apagada com Sucesso", null);
       FacesContext.getCurrentInstance().addMessage("message", message);
         findAllQuestaoes();
   }
    
    
    
    
    
   
    public void findAllQuestaoes(){
        questoes = new ArrayList<>();
        questoes = questaoDAO.getAllQuestoes();
        
        
        
    }
    
  
    public void carregaDisciplinas(){
        this.disciplinas = null;
        this.disciplinas = disciDAO.findAllDisciplinas();
    }
           

    UploadedFile file;
    

        public void uploadImagem(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_A = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "imagem"+ File.separator +file.getFileName();
                
            System.out.println("Caminho"+ newFileName_A);
     
             
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_A));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }


    
}
