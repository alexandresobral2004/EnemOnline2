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
import model.Disciplina;

/**
 *
 * @author cedsobral
 */
@Stateless
public class disciplinaDAO extends DAO <Disciplina, Long> implements Serializable{

    public disciplinaDAO() {
        super(Disciplina.class);
    }
    
    
    public void adddisciplina(Disciplina disciplina) throws Exception {
        salvar(disciplina);
    }
    
    public void editDisciplina(Disciplina disciplina) throws Exception{
        atualizar(disciplina);
    }
    public void delDisciplina(Disciplina disciplina) throws Exception{
        excluir(disciplina);
    }
    
    public Disciplina findDisciplinaByID(int id){
        Disciplina d = (Disciplina) getEntity(Disciplina.class, id);
        return d;
    }
    
    public List<Disciplina> findAllDisciplinas(){
        List<Disciplina> disciplinas = getListaAll(Disciplina.class, "select d from Disciplina d");
        return disciplinas;
    }
  
}
