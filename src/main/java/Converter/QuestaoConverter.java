/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.QuestaoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import model.Questao;

/**
 *
 * @author cedsobral
 */
public class QuestaoConverter implements Converter{

    @Inject
    private QuestaoDAO quesDAO;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Questao q = new Questao();
        Integer id = Integer.valueOf(string);
        try
        {
         q  = quesDAO.getQuestaoByID(id);
         return q;
        }
        catch(Exception e){
            System.out.println("ERRO AO VALIDAR GET AS OBJECT");
            e.printStackTrace();
        }
        return q;
    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        Questao q = (Questao)value;
        if(!value.equals("")){
            return String.valueOf(q.getId());
        }
        return null;
    }
    
}
