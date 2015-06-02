/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import model.Aluno;

/**
 *
 * @author cedsobral
 */
public class AlunoDAO extends DAO<Aluno, Long> implements Serializable{

    public AlunoDAO() {
        super(Aluno.class);
    }
    
     
    public void addAluno(Aluno aluno) throws Exception {
        salvar(aluno);
    }

    public void editAluno(Aluno aluno) throws Exception {
        atualizar(aluno);
    }

    public void delAluno(Aluno aluno) throws Exception {
        excluir(aluno);
    }

    public Aluno getAlunoByID(int id) {
        Aluno aluno  = getEntity(Aluno.class, id);
        return aluno ;
    }

    public List<Aluno> getAllAlunos() {
       List<Aluno> itens = getListaAll(Aluno.class, "SELECT i From Aluno i");
       return itens;
    }
    //"SELECT i FROM Aluno i where i.questao_id='"+id+"' ",id
     
    
}
