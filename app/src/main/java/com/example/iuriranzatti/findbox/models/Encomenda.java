package com.example.iuriranzatti.findbox.models;

public class Encomenda {
   // private String idusuario;
    private String codigo;
    private String categoria;

    public Encomenda(String codigo, String descricao) {
     //   this.idusuario = idusuario;
        this.codigo = codigo;
        this.categoria = categoria;
    }

//    public String getIdusuario() {
//        return idusuario;
//    }

//    public void setIdusuario(String idusuario) {
//        this.idusuario = idusuario;
//    }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

//    public String getDescricao() {
//        return descricao;
//    }

//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
