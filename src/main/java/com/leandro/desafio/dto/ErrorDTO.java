package com.leandro.desafio.dto;

public class ErrorDTO {

    private int status;
    private String titulo;
    private String descricao;
    private long timeStamp;

    public ErrorDTO() {
    }

    public ErrorDTO(int status, String titulo, String descricao, long timeStamp) {
        this.status = status;
        this.titulo = titulo;
        this.descricao = descricao;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
