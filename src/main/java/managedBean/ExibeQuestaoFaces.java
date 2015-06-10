/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ItemDAO;
import dao.QuestaoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static javafx.application.Platform.exit;
import javafx.scene.control.CheckBox;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Item;
import model.Questao;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.ItemSelectEvent;
/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class ExibeQuestaoFaces implements Serializable {

    @Inject
    QuestaoDAO quesDAO;
    @Inject
    ItemDAO itemDAO;

    private Questao selectedQuestao;
    private Item selectItem;
    private Item selectItem_a;
    private Item selectItem_b;
    private Item selectItem_c;
    private Item selectItem_d;
    private Item selectItem_e;
    private List<Item> itens;
    private List<Questao> questoes;
    private Boolean mostraquestao;
    private int acertos;
    private int erros;
    private int totalQuestoes;
    private Boolean imagemQuestao;

    public Questao getSelectedQuestao() {
        return selectedQuestao;
    }

    public Item getSelectItem() {
        
        return selectItem;
    }

    public void setSelectItem(Item selectItem) {
        this.selectItem = selectItem;
    }

    
    
    public void setSelectedQuestao(Questao selectedQuestao) {
        this.selectedQuestao = selectedQuestao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Item getSelectItem_a() {
        return selectItem_a;
    }

    public void setSelectItem_a(Item selectItem_a) {
        this.selectItem_a = selectItem_a;
    }

    public Item getSelectItem_b() {
        return selectItem_b;
    }

    public void setSelectItem_b(Item selectItem_b) {
        this.selectItem_b = selectItem_b;
    }

    public Item getSelectItem_c() {
        return selectItem_c;
    }

    public void setSelectItem_c(Item selectItem_c) {
        this.selectItem_c = selectItem_c;
    }

    public Item getSelectItem_d() {
        return selectItem_d;
    }

    public void setSelectItem_d(Item selectItem_d) {
        this.selectItem_d = selectItem_d;
    }

    public Item getSelectItem_e() {
        return selectItem_e;
    }

    public void setSelectItem_e(Item selectItem_e) {
        this.selectItem_e = selectItem_e;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Boolean getMostraquestao() {
        return mostraquestao;
    }

    public void setMostraquestao(Boolean mostraquestao) {
        this.mostraquestao = mostraquestao;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getTotalQuestoes() {
        return totalQuestoes;
    }

    public void setTotalQuestoes(int totalQuestoes) {
        this.totalQuestoes = totalQuestoes;
    }

    public Boolean getImagemQuestao() {
        return imagemQuestao;
    }

    public void setImagemQuestao(Boolean imagemQuestao) {
        this.imagemQuestao = imagemQuestao;
    }

    

    
   
    
    
    public String startQuestao() {

        selectedQuestao = new Questao();
        this.selectItem_a = new Item();
        this.selectItem_b = new Item();
        this.selectItem_c = new Item();
        this.selectItem_d = new Item();
        this.selectItem_e = new Item();
        this.itens = null;
        this.mostraquestao = false;
        this.acertos = 0;
        this.erros = 0;
        this.totalQuestoes = 0;
        this.imagemQuestao = false;
       
        
        
       
        System.out.println("Inicia Questao");
        return "/aluno/questoes.jsf";

    }

    public List<Questao> pegaQuestaoBanco() {
        this.questoes = new ArrayList<Questao>();
        System.out.println("ID da disciplina " + String.valueOf(selectedQuestao.getDisciplina().getID()));
        questoes = quesDAO.getQuestaoPorDiscip(selectedQuestao.getDisciplina().getID());
        return questoes;

    }

   

    public void preencheItens(Questao q) {
       try{
           
       
        this.itens = new ArrayList<>();

        this.itens = itemDAO.getItemsQuestao(q.getId());
        this.selectItem_a = this.itens.get(0);
        this.selectItem_b = this.itens.get(1);
        this.selectItem_c = this.itens.get(2);
        this.selectItem_d = this.itens.get(3);
        this.selectItem_e = this.itens.get(4);
        }
       catch(ArrayIndexOutOfBoundsException e){
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Itens não cadastrados", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
       }

    }

    public void mostraQuestao() {
        this.mostraquestao = true;

    }
    
    
    private Item getItemCorreto(){
        for (int i = 0; i < itens.size(); i++) {
            if (this.itens.get(i).getResposta()) {

               return this.itens.get(i);
                

            }

        } 
        return null;
        
    }

    public FacesMessage validaItemQuestao() {
        Boolean acertou = false;
       
        for (int i = 0; i < itens.size(); i++) {
            if (this.itens.get(i).getItemMarcado() && this.itens.get(i).getResposta()) {

                acertou = true;
               

            }

        }

        if (acertou) {
             this.acertos++;
             this.totalQuestoes++;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resposta Correta, parabéns!!", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } else {
            this.erros++;
              this.totalQuestoes++;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resposta incorreta, o ítem correto é o :  ("+this.getItemCorreto().getItem(), null);
            FacesContext.getCurrentInstance().addMessage("message", message);

        }

        return null;

    }
    
    
  
    
    
    
    
    public void selectOneitem_a(){
        if (this.selectItem_a.getItemMarcado()) {
            this.selectItem_b.setItemMarcado(false);
            this.selectItem_c.setItemMarcado(false);
            this.selectItem_d.setItemMarcado(false);
            this.selectItem_e.setItemMarcado(false);
            
        }
    }
    
     public void selectOneitem_b() {
        if (this.selectItem_b.getItemMarcado() == true) {
            this.selectItem_a.setItemMarcado(false);
            this.selectItem_c.setItemMarcado(false);
            this.selectItem_d.setItemMarcado(false);
            this.selectItem_e.setItemMarcado(false);
            exit();
        }
    }

    public void selectOneitem_c() {
        if (this.selectItem_c.getItemMarcado() == true) {
            this.selectItem_a.setItemMarcado(false);
            this.selectItem_b.setItemMarcado(false);
            this.selectItem_d.setItemMarcado(false);
            this.selectItem_e.setItemMarcado(false);
            exit();
        }
    }

    public void selectOneitem_d() {
        if (this.selectItem_d.getItemMarcado() == true) {
            this.selectItem_a.setItemMarcado(false);
            this.selectItem_b.setItemMarcado(false);
            this.selectItem_c.setItemMarcado(false);
            this.selectItem_e.setItemMarcado(false);
            exit();
        }
    }

    public void selectOneitem_e() {
        if (this.selectItem_e.getItemMarcado() == true) {
            this.selectItem_a.setItemMarcado(false);
            this.selectItem_b.setItemMarcado(false);
            this.selectItem_c.setItemMarcado(false);
            this.selectItem_d.setItemMarcado(false);
            exit();
        }
    }
       
       
    
    
     private List<Questao> lista  = null;
     
    public void carregaQuestao() {
        try{
            
        
        this.var = 0;
       this.lista = null;
        this.lista = pegaQuestaoBanco();
        this.selectedQuestao = this.lista.get(0);
        System.out.println(String.valueOf(this.lista.size()));
        caminhoImagem(this.selectedQuestao);
        preencheItens(selectedQuestao);
        this.mostraquestao = true;
        this.imagemQuestao = true;
        }
        catch(StringIndexOutOfBoundsException e){
           
        }

    }

   
    int var = 0;
    public void carregaNovaQuestao() {
       
             try {

            if (this.var <= this.lista.size()) {
                this.var++;
                this.selectedQuestao = this.lista.get(this.var);
                preencheItens(this.selectedQuestao);
                this.mostraquestao = true;
                caminhoImagem(this.selectedQuestao);
                
            }
            else{
                this.var = 1;
                this.lista = null;
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Questões Encerradas", null);
                FacesContext.getCurrentInstance().addMessage("message", message);      
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            this.lista = null;

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Questões Encerradas", null);
            FacesContext.getCurrentInstance().addMessage("message", message);

        } catch (StringIndexOutOfBoundsException f) {

        }

   
        
        
        
    }
    
    public void caminhoImagem(Questao q){
        int x = q.getImagem().length();
        String imagem = q.getImagem();
        System.out.println("Número de Bytes: "+String.valueOf(x));
        String caminho = imagem.substring(86,x);
        
        q.setImagem(caminho);
        System.out.println("Caminho modificado: "+caminho);
    }
    
    
    

}
