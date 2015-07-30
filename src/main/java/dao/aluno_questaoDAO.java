/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import model.aluno_questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class aluno_questaoDAO extends DAO<aluno_questao, Long> implements Serializable{

    public aluno_questaoDAO() {
        super(aluno_questao.class);
    }

    @Override
    public void salvar(aluno_questao t) throws Exception {
        super.salvar(t); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void excluir(aluno_questao t) throws Exception {
        super.excluir(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(aluno_questao t) throws Exception {
        super.atualizar(t); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    public aluno_questao findByID(int id) {
      aluno_questao a = (aluno_questao) getEntity(aluno_questao.class, id);
      return a;
    }

   
    public  List<aluno_questao> getListaAll() {
        List<aluno_questao> objetos = getListaAll(aluno_questao.class, "select a from aluno_questao a");
        return objetos;
    }

    
    
    
    
}
