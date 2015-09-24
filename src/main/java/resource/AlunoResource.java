/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import dao.AlunoDAO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Aluno;

/**
 *  CLASSE RESPONSÁVEL PELOS MÉTODOS DE ACESSO AO WEBSERVICE
 * @author cedsobral
 */
@Path("/aluno")
public class AlunoResource {
    private AlunoDAO dao = new AlunoDAO();
    private List<Aluno> alunos;
    
    
    @GET
    @Path("/listarTodos")
    @Produces("application/json")
    public List<Aluno> listarTodos(){
        alunos = dao.getAllAlunos();
        return alunos;
    }
    
    
}
