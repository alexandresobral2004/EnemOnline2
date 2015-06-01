/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.disciplinaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import model.Disciplina;

/**
 *
 * @author cedsobral
 */
public class DisciplinaConverter implements Converter{
    @Inject
    private disciplinaDAO disciDAO;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       Disciplina dis = new Disciplina();
       
      
       Integer id = Integer.valueOf(string);
       try{
           dis = disciDAO.findDisciplinaByID(id);
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
        return dis;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        Disciplina dis = (Disciplina)value;
        if(!value.equals("")){
            return String.valueOf(dis.getID());
        }
        return null;
    }
    
}
