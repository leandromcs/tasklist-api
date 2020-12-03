package com.leandro.desafio.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1)
    private String titulo;

    @NotNull
    private Boolean status;

    private String descricao;

    public TaskDTO(Long id, String titulo, Boolean status, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
