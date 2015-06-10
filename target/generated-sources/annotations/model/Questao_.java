package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Disciplina;
import model.Item;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-09T14:32:50")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, String> texto;
    public static volatile SingularAttribute<Questao, Integer> numQuestao;
    public static volatile ListAttribute<Questao, Item> itens;
    public static volatile SingularAttribute<Questao, String> tema;
    public static volatile SingularAttribute<Questao, Disciplina> disciplina;
    public static volatile SingularAttribute<Questao, String> imagem;
    public static volatile SingularAttribute<Questao, Integer> id;

}