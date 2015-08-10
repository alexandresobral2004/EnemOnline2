/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author cedsobral
 */
public abstract class DAO<T, PK extends Serializable> implements Serializable {

    @PersistenceContext(unitName = "PersistenceUnit",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    private final Class<T> entityClass;

    protected EntityManager getEm() {
        return em;
    }

    public DAO(Class classe) {
        this.entityClass = classe;
    }

    public void salvar(T t) throws Exception {
        em.persist(t);
        
    }

    public void excluir(T t) throws Exception {
       T t2 = em.merge(t);
        em.remove(t2);
    }

    public void atualizar(T t) throws Exception {
        em.merge(t);
        em.flush();
        
       
       
        
    
       
    }

   
    
   
    
    public <T> T getEntity(Class<T> entityClass, Serializable pk) {
        //em = getEntityManager();
        T toReturn = em.find(entityClass, pk);

        return toReturn;
    }
    
    public <T> List<T> getEntitiesById(Class<T> entityClass, String jpql, int id) {
      //  em = getEntityManager();
        List toReturn = null;
        Query query = em.createNativeQuery(jpql, entityClass);
        query.setParameter("id", id);
        toReturn = query.getResultList();

        return toReturn;
    }
    
     public <T> List<T> getListaAll(Class<T> entityClass, String jpql) {
      //  em = getEntityManager();
        List toReturn = null;
        Query query = em.createQuery(jpql);
      
        toReturn = query.getResultList();

        return toReturn;
    }
     
      public <T> List<T> getAlunobyLogin(Class<T> entityClass, String jpql, String value) {
      //  em = getEntityManager();
        List toReturn = null;
        Query query = em.createNativeQuery(jpql);
        query.setParameter("login", value);
      
        toReturn = query.getResultList();

        return toReturn;
    }
    
    
    public <T> List<T> getItensByQuestao(Class<T> entityClass,String jpql, int id) {
       // em = getEntityManager();
        List toReturn = null;
        Query query = em.createNativeQuery(jpql,entityClass);
      
        toReturn = query.getResultList();

        return toReturn;
    }

    public int getNumQuestao(String jpql) {
       // em = getEntityManager();
        Integer result = null;
        Query query = em.createQuery(jpql);
        result = (Integer) query.getSingleResult();
        return result;
    }
    
     
    
    public <T> List<T> getQuestaobyDisciplina(Class<T> entityClass,String jpql,int id){
        // em = getEntityManager();
        List toReturn = null;
       Query query = em.createNativeQuery(jpql,entityClass);
      
        
        toReturn = query.getResultList();

        return toReturn;
        
    }
    
   
    
    
    /*
    public List<T> consultarTodos(String ordem) throws Exception {
        Query q = em.createQuery("FROM " + getEntityClass().getName() + " order by :ordem")
                .setParameter("ordem", ordem);
        return q.getResultList().isEmpty() ? new ArrayList<T>()  : q.getResultList();
    }

    public List<T> consultarLike(String nomeCampo, String valor) throws Exception {
        return em.createQuery("FROM " + getEntityClass().getName() + " where UPPER(" + nomeCampo + ") like :vl")
                .setParameter("vl", "%" + valor.toUpperCase() + "%").getResultList();
    }

    public List<T> consultarTodos(String ordem, String campo, String valor) throws Exception {
        return em.createQuery("SELECT a FROM " + getEntityClass().getName() + " a WHERE a." + campo + " like :valor order by a." + ordem).setParameter("valor", valor + "%").getResultList();
    }

    public List<T> pesquisaAutoComplete(String ordem, String campo, String sugest, int numeroResultados) throws Exception {
        return getEm().createQuery("SELECT t FROM " + getEntityClass().getName() + " t WHERE t." + campo + " like :sugest ORDER BY t." + campo).setParameter("sugest", sugest + "%").setMaxResults(numeroResultados).getResultList();
    }

    protected Class getEntityClass() {
        return entityClass;
    }

    public List<Permissao> consultarPermissoes(Usuario usuario, Modulo modulo, Tarefa tarefa) {
        String sql = "SELECT p FROM Permissao p WHERE p.usuario =:u";
        if (tarefa != null) {
            sql += " AND p.tarefa =:t ";
        }
        if (modulo != null) {
            sql += " AND p.tarefa.modulo =:m ";
        }
        Query q = getEm().createQuery(sql);
        q.setParameter("u", usuario);
        if (tarefa != null) {
            q.setParameter("t", tarefa);
        }
        if (modulo != null) {
            q.setParameter("m", modulo);
        }
        return q.getResultList();
    }*/
}

