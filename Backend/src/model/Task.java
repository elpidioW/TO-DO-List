package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Task implements Comparable<Task>{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        protected int id;
        protected String titulo;
        protected String descricao;
        protected LocalDateTime dataHoraTermino;
        protected int nivelPrioridade;
        protected String categoria;
        protected Status status;
        protected boolean alarmeAtivo;


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

    public LocalDateTime getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(LocalDateTime dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
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

    public boolean getAlarmeAtivo() {
        return alarmeAtivo;
    }

    public void setAlarmeAtivo(boolean alarmeAtivo) {
        this.alarmeAtivo = alarmeAtivo;
    }

    public Task(String titulo, String descricao, LocalDateTime dataHoraTermino, int nivelPrioridade, String categoria, Status status, boolean alarmeAtivo){
        this.titulo = titulo;
        this.descricao= descricao;
        this.dataHoraTermino = dataHoraTermino;
        this.nivelPrioridade = nivelPrioridade;
        this.categoria = categoria;
        this.status = status;
        this.alarmeAtivo = alarmeAtivo;
    }

    public Task(int id, String titulo, String descricao, LocalDateTime dataHoraTermino, int nivelPrioridade, String categoria, Status status, boolean alarmeAtivo){
        this.id = id;
        this.titulo = titulo;
        this.descricao= descricao;
        this.dataHoraTermino = dataHoraTermino;
        this.nivelPrioridade = nivelPrioridade;
        this.categoria = categoria;
        this.status = status;
        this.alarmeAtivo = alarmeAtivo;
    }

    @Override
    public String toString() {
        return  "\n" + titulo +
                "\nDescrição: " + descricao +
                "\nData e Horário de Término: " + dataHoraTermino +
                "\nNível de Prioridade: " + nivelPrioridade +
                "\nCategoria: " + categoria +
                "\nStatus: " + status +
                "\nAlarme: " + ((alarmeAtivo)? "Ativado" : "Desativado") ;
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
