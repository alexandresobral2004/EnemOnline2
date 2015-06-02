package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Prova;
import model.Questao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-01T18:00:56")
@StaticMetamodel(prova_questao.class)
public class prova_questao_ { 

    public static volatile SingularAttribute<prova_questao, Boolean> resultado;
    public static volatile SingularAttribute<prova_questao, Prova> prova;
    public static volatile SingularAttribute<prova_questao, Integer> ID;
    public static volatile SingularAttribute<prova_questao, Questao> questao;

}