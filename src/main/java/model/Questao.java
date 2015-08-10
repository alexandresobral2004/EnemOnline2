/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cedsobral
 */
@Entity
@Table(name = "questao")
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 2000)
    private String texto;
    @Column(length = 50)
    private String tema;
    private int numQuestao;
     @Column()
    private String imagem;
    @ManyToOne(fetch = FetchType.EAGER)
    private Disciplina disciplina;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "questao_id")
    private List<Item> itens;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumQuestao() {
        return numQuestao;
    }

    public void setNumQuestao(int numQuestao) {
        this.numQuestao = numQuestao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getImagem() {
       
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    

    

    
    
    //Busca numero de questoes no banco
    private int findNumQuestoes(){
        int qtde = 0;
        return qtde;
    }
    //incrementa a quantidade de questões
    private void IncNumQuestao(){
       int qtde = findNumQuestoes();
       
        if(qtde == 0){
            this.numQuestao = 1;
        }
        else{
            
            this.numQuestao= qtde + 1;
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questao other = (Questao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
   
}
