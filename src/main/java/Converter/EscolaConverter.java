/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.EscolaDAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import model.Escola;
import model.Questao;

/**
 *
 * @author cedsobral
 */
public class EscolaConverter implements Converter{

    @Inject
    private EscolaDAO escDAO;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
      Escola esc = new Escola();
        Integer id = Integer.valueOf(string);
       
        try
        {
           esc = escDAO.getEscolaByID(id);
       }
        catch (Exception e) {
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Converter Escola", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return esc;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       Escola esc = (Escola)o;
       if(!esc.equals("")){
           return String.valueOf(esc.getId());
       }
        return null;
    }
    
}
