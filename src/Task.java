import javax.xml.crypto.Data;
import java.time.LocalDate;

public class Task {

        protected String nome;
        protected String descricao;
        protected LocalDate dataTermino;
        protected int nivelPrioridade;
        protected String categoria;
        protected String status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Task(String nome, String descricao, LocalDate dataTermino, int nivelPrioridade, String categoria, String status){
        this.nome = nome;
        this. descricao= descricao;
        this.dataTermino = dataTermino;
        this.nivelPrioridade = nivelPrioridade;
        this.categoria = categoria;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                " " + nome + '\'' +
                ", Descricao='" + descricao + '\'' +
                ", Data de Término=" + dataTermino +
                ", Nivel de Prioridade=" + nivelPrioridade +
                ", Categoria='" + categoria + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}