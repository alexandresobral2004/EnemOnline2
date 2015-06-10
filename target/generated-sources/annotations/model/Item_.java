package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Questao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-09T14:32:50")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> item;
    public static volatile SingularAttribute<Item, String> textoitemQuestao;
    public static volatile SingularAttribute<Item, String> nomeImagem;
    public static volatile SingularAttribute<Item, Boolean> resposta;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, Boolean> itemMarcado;
    public static volatile SingularAttribute<Item, Questao> questao;

}