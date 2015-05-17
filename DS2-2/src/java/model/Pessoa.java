/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Rael
 */
public class Pessoa {
    private long id;
    private String nome;
    private String sobrenome;
    private List<Dependente> dependentes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Pessoa() {
    }

    public Pessoa(long id, String nome, String sobrenome, List<Dependente> dependentes) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dependentes = dependentes;
    }
    
    
}
