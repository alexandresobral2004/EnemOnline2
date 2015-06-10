/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.util.List;

/**
 *
 * @author cedsobral
 */
public interface InterfacePadrao {
    /*
    Métodos que obrigatoriamente devem ter numa classe Faces
    */
    
    public String startFaces();
    public void add();
    public void edit();
    public void del();
    public <T> T getObjetoByID(int id);
    public void getAllObjetos();
    
}
