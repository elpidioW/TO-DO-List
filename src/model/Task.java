package model;

import java.time.LocalDate;


public class Task implements Comparable<Task>{
        protected int id;
        protected String titulo;
        protected String descricao;
        protected LocalDate dataTermino;
        protected int nivelPrioridade;
        protected String categoria;
        protected Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Task(String titulo, String descricao, LocalDate dataTermino, int nivelPrioridade, String categoria, Status status){
        this.titulo = titulo;
        this.descricao= descricao;
        this.dataTermino = dataTermino;
        this.nivelPrioridade = nivelPrioridade;
        this.categoria = categoria;
        this.status = status;

    }

    @Override
    public String toString() {
        return  "\n" + titulo +
                "\nDescrição: " + descricao +
                "\nData de Término: " + dataTermino +
                "\nNível de Prioridade: " + nivelPrioridade +
                "\nCategoria: " + categoria +
                "\nStatus: " + status;
    }

    @Override
    public int compareTo(Task task) {
        if(this.getNivelPrioridade() > task.getNivelPrioridade())
            return 1;

        if(this.getNivelPrioridade() < task.getNivelPrioridade())
            return -1;

        return 0;
    }
}
