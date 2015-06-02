/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import model.Escola;

/**
 *
 * @author cedsobral
 */
public class EscolaDAO extends DAO<Escola, Long> implements Serializable{

    public EscolaDAO() {
        super(Escola.class);
    }
    
     public void addEscola(Escola escola) throws Exception {
        salvar(escola);
    }

    public void editEscola(Escola escola) throws Exception {
        atualizar(escola);
    }

    public void delEscola(Escola escola) throws Exception {
        excluir(escola);
    }

    public Escola getEscolaByID(int id) {
        Escola escola  = getEntity(Escola.class, id);
        return escola ;
    }

    public List<Escola> getAllEscolas() {
       List<Escola> itens = getListaAll(Escola.class, "SELECT i From Escola i");
       return itens;
    }
    //"SELECT i FROM Escola i where i.questao_id='"+id+"' ",id
     
    
}
