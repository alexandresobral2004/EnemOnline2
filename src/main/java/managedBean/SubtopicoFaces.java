/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.SubtopicoDAO;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import model.Subtopico;

/**
 *
 * @author cedsobral
 */
public class SubtopicoFaces implements InterfacePadrao,Serializable{

    
    private Subtopico subtopico;
    private List<Subtopico> subtopicos;
    @Inject
    private SubtopicoDAO subDAO;
    
    @Override
    public String startFaces() {
      this.subtopico = new Subtopico();
      return "/admin/Subtopico.jsf";
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void del() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T getObjetoByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllObjetosByID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
