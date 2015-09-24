/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class QuestaoDAO extends DAO<Questao, Long> implements Serializable{

    public QuestaoDAO() {
        super(Questao.class);
    }
   
    
    public void addquestao(Questao questao) throws Exception{
         salvar(questao);
        
    }
    
    public void editQuestao(Questao questao) throws Exception{
        atualizar(questao);
        
    }
    public void delQuestao(Questao questao) throws Exception{
        excluir(questao);
    }
    
    public Questao getQuestaoByID(int id){
        Questao q = (Questao) getEntity(Questao.class, id);
        return q;
    }
    
    public List<Questao> getAllQuestoes(){
        List<Questao> questoes = getListaAll(Questao.class, "SELECT q FROM Questao q order by q.id desc");
        return questoes;
    }
    
     public List<Questao> getQuestaoPorDiscip(int id){
          List<Questao> questao = getQuestaobyDisciplina(Questao.class, "SELECT * FROM questao WHERE disciplina_id='"+id+"'",id);
          
          return questao;
        
     }
      
  
    
    
}
