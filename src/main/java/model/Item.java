/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cedsobral
 */
@Entity
@Table(name="item")
public class Item implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     @Column(nullable = true,length = 500)
    private String item;
    @Column(nullable = true)
    private String textoitemQuestao;
    @Column(nullable = true)
    private Boolean resposta;
    @Column(nullable = true)
    private Boolean itemMarcado;
    @Column(nullable = true)
    private String nomeImagem;
    @ManyToOne(fetch = FetchType.EAGER)
    private Questao questao;

    
    
    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    
    
    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

   

    public String getTextoitemQuestao() {
        return textoitemQuestao;
    }

    public void setTextoitemQuestao(String textoitemQuestao) {
        this.textoitemQuestao = textoitemQuestao;
    }


    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        this.resposta = resposta;
    }

    public Boolean getItemMarcado() {
        return itemMarcado;
    }

    public void setItemMarcado(Boolean itemMarcado) {
        this.itemMarcado = itemMarcado;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
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
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
