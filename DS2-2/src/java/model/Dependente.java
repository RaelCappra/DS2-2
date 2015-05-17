/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rael
 */
public class Dependente {
    private long id;
    private String nome;
    private String sobrenome;
    
    private long idPessoa;

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

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

    public Dependente() {
    }

    public Dependente(long id, String nome, String sobrenome, long idPessoa) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idPessoa = idPessoa;
    }
}
