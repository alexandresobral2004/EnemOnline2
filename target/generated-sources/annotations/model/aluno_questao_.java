package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Aluno;
import model.Questao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-30T17:53:24")
@StaticMetamodel(aluno_questao.class)
public class aluno_questao_ { 

    public static volatile SingularAttribute<aluno_questao, Aluno> aluno;
    public static volatile SingularAttribute<aluno_questao, Boolean> resultado;
    public static volatile SingularAttribute<aluno_questao, Long> ID;
    public static volatile SingularAttribute<aluno_questao, Questao> questao;

}