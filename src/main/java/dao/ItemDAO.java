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
import model.Item;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class ItemDAO extends DAO<Item, Long> implements Serializable{

    public ItemDAO() {
        super(Item.class);
    }

    
    public void addItem(Item item) throws Exception {
        salvar(item);
    }

    public void editItem(Item item) throws Exception {
        atualizar(item);
    }

    public void delItem(Item item) throws Exception {
        excluir(item);
    }

    public Item getItemByID(int id) {
        Item item  = getEntity(Item.class, id);
        return item ;
    }

    public List<Item> getAllItems() {
       List<Item> itens = getListaAll(Item.class, "SELECT i From Item i");
       return itens;
    }
    //"SELECT i FROM Item i where i.questao_id='"+id+"' ",id
     public List<Item> getItemsQuestao(int id) {
        List<Item> itens = getItensByQuestao(Item.class,"select * from Item  where questao_id='"+id+"' order by item", id);
        return itens;
    }
    
}
