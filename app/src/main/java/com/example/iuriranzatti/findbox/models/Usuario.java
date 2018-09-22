package com.example.iuriranzatti.findbox.models;

public class Usuario {
    private static int id;
    private String nome;
    private String sexo;
    private String email;
    private String senha;
    private String cpf;
    private String celular;

    public Usuario(String nome, String sexo, String email, String senha, String cpf, String celular) {
        this.id++;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


}
