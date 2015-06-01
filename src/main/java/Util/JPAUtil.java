/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alexandrerocha
 */
@Stateless
public class JPAUtil {

    private static JPAUtil me;
    
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager em;

    public JPAUtil() {

    }

    public static JPAUtil getInstance() {

        me = new JPAUtil();

        return me;
    }

   /* public EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager toReturn = (EntityManager) request.getAttribute("EntityManager");
        return toReturn;
    }*/

    public <T> List<T> getList(Class<T> classToClass, String jpql, Object... parameters) {
        List toReturn = null;
       // em = getEntityManager();
        Query qr = em.createQuery(jpql);

        for (int i = 0; i < parameters.length; i++) {
            qr.setParameter(i + 1, parameters[i]);
        }
        toReturn = qr.getResultList();

        return toReturn;

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

    public <T> List<T> getItensByQuestao(Class<T> entityClass,String jpql, int id) {
       // em = getEntityManager();
        List toReturn = null;
        Query query = em.createNamedQuery(jpql);
        query.setParameter("id", id);
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
    
    public <T> List<T> getQuestaobyNUM(Class<T> entityClass,String jpql, int id){
        // em = getEntityManager();
        List toReturn = null;
       Query query = em.createNamedQuery(jpql);
        query.setParameter("id",id);
        
        toReturn = query.getResultList();

        return toReturn;
        
    }
    
    
    
    

    /*    
      
      
     public <T> List<T> getIstituicaoByInep(Class<T> entityClass,String jpql,String inep){
     em = getEntityManager();
     List toReturn = null;
     Query query =  em.createNativeQuery(jpql, entityClass);
     query.setParameter("inep", inep);
     toReturn = query.getResultList();
       
     return toReturn;
     }
      
      
      
     public <T> List<T> getEntitiesByEstado(Class<T> entityClass,String jpql, String estado){
     em = getEntityManager();
     List toReturn = null;
     Query query = em.createNativeQuery(jpql, entityClass);
     query.setParameter("estado", estado);
     toReturn = query.getResultList();
       
       
     return toReturn;
     }
      
      
     public <T>  T getUserByLogin(Class<T> entityClass,String jpql,String username){
     em = getEntityManager();
     T toReturn  = null;
     Query query = em.createNativeQuery(jpql, entityClass);
     query.setParameter("username", username);
     toReturn = (T) query.getSingleResult();
     return toReturn;
     }
      
      
     public <T> List  <T> getUsersByLogin(Class<T> entityClass,String jpql,String username){
     em = getEntityManager();
     List  toReturn  = null;
     Query query = em.createNativeQuery(jpql, entityClass);
     query.setParameter("username", username);
     toReturn = query.getResultList();
     return toReturn;
     }
    
     public <T> List  <T> getEntradasByUser(Class<T> entityClass,String jpql,int usuario_id){
     em = getEntityManager();
     List  toReturn  = null;
     Query query = em.createNativeQuery(jpql, entityClass);
     query.setParameter("usuario_id",usuario_id);
     toReturn = query.getResultList();
     return toReturn;
     }
    
     public <T> List  <T> getEscolasByMun(Class<T> entityClass,String jpql,int id){
     em = getEntityManager();
     List  toReturn  = null;
     Query query = em.createQuery(jpql);
     query.setParameter("id",id);
     toReturn = query.getResultList();
     return toReturn;
     }
     
     public <T> List <T> getVisitasporDatas(Class<T> entityClass,String jpql,Date data_inicial,Date data_final){
     em = getEntityManager();
     List toReturn = null;
     Query query = em.createQuery(jpql);
     query.setParameter("data_inicial", data_inicial,TemporalType.DATE);
     query.setParameter("data_final", data_final, TemporalType.DATE);
     toReturn = query.getResultList();
         
     return toReturn;
         
     }
     
     public <T> List <T> getRelatorioporDatas(Class<T> entityClass,String jpql,java.sql.Date data_inicial,java.sql.Date data_final){
     em = getEntityManager();
     List toReturn = null;
     Query query = em.createQuery(jpql);
     query.setParameter("data_inicial", data_inicial,TemporalType.DATE);
     query.setParameter("data_final", data_final, TemporalType.DATE);
     toReturn = query.getResultList();
         
     return toReturn;
         
     }

     public <T> List <T> getRelatorioporID(Class<T> entityClass,String jpql,int id){
     em = getEntityManager();
     List toReturn = null;
     Query query = em.createQuery(jpql);
     query.setParameter("id", id);
     toReturn = query.getResultList();
         
     return toReturn;
         
     }
       
      
      
    
     public <T> List<T> getAlunosByVisita(Class<T> entityClass,String jpql,int visita_id){
     em = getEntityManager();
     List toReturn = null;
     Query query =  em.createQuery(jpql);
     query.setParameter("visita_id", visita_id);
     toReturn = query.getResultList();
       
     return toReturn;
     }
       
       
       
      
      
    
     */
}
