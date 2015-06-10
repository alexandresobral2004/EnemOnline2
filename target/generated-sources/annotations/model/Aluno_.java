package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Escola;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-09T14:32:50")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, Escola> escola;
    public static volatile SingularAttribute<Aluno, String> cpf;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, Long> ID;
    public static volatile SingularAttribute<Aluno, String> email;
    public static volatile SingularAttribute<Aluno, Date> dtNasc;

}