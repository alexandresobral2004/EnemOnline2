/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import model.Subtopico;

/**
 *
 * @author cedsobral
 */
@Stateless
public class SubtopicoDAO extends DAO<Subtopico, Long>{

    public SubtopicoDAO() {
        super(Subtopico.class);
    }
    
   public void add(Subtopico sub) throws Exception{
       salvar(sub);
   }
   
   public void edit(Subtopico sub){
       edit(sub);
   }
   
   public void del(Subtopico sub) throws Exception{
       excluir(sub);
   }
   
   public Subtopico getSubByID(int id){
       Subtopico sub = getEntity(Subtopico.class, id);
       return sub;
   }
   
   public List<Subtopico> getAllSubtopicos(){
       List<Subtopico> lista = getListaAll(Subtopico.class, "select sub from Subtopico sub");
       
       return lista;
      
   }
   
   
    
}
