package service;

import model.Status;
import model.Task;
import persistence.TaskPersistence;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class TaskService {

    protected TaskRepository repositorio;
    protected TaskPersistence persistencia;

    public TaskService(TaskRepository repositorio, TaskPersistence persistecia){
        this.repositorio = repositorio;
        this.persistencia = persistecia;
    }


    public void criaTask(String titulo, String descricao, String dataString, int nivelPrioridade, String categoria, int statusInt, int alarmeInt) throws Exception{

        if(titulo == null || titulo.isBlank()){
            throw new Exception("Titulo não pode ser vazio");
        }

        if(descricao == null || descricao.isBlank()){
            throw new Exception("Descrição não pode ser vazia");
        }

        LocalDateTime dataHoraTermino;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try{
            dataHoraTermino = LocalDateTime.parse(dataString, formatter);
        }catch(DateTimeParseException e){
            throw new Exception("Data ou horário inválido");
        }

        if(nivelPrioridade < 1 || nivelPrioridade > 5){
            throw new Exception("O nivel de prioridade deve estar no intervalo 1-5");
        }

        if(categoria == null || categoria.isBlank()){
            throw new Exception("Categoria não pode ser nula");
        }

        Status status;
        if(statusInt < 1 || statusInt > 3){
            throw new Exception("Status Inválido");
        }
        else{
            if (statusInt == 1)
                status = Status.TODO;
            else if (statusInt == 2)
                status = Status.DOING;
            else
                status = Status.DONE;
        }


        boolean alarmeAtivo;

        if(alarmeInt < 1 || alarmeInt > 2){
            throw new Exception("Alarme Inválido");
        }
        else{
            if(alarmeInt == 1)
                alarmeAtivo = true;
            else
                alarmeAtivo = false;
        }




        Task tarefa = new Task(titulo, descricao, dataHoraTermino, nivelPrioridade, categoria, status, alarmeAtivo);
        repositorio.addTaskRepo(tarefa);
        repositorio.getTaskRepo().sort(null);
        persistencia.salvarArquivo(repositorio.getTaskRepo());

    }

    public void imprimeTasks(int impressao) throws Exception{

        List<Task> lista = new ArrayList<>(repositorio.getTaskRepo());

        switch (impressao){
            case 1://Geral
                for(Task t : lista)
                    System.out.println(t);
                break;
            case 2: //Categoria
                lista.sort(Comparator.comparing(Task::getCategoria));
                for(Task t : lista)
                    System.out.println(t);
                break;

            case 3: //Prioridade
                lista.sort(Comparator.comparing(Task::getNivelPrioridade));
                for(Task t : lista)
                    System.out.println(t);
                break;

            case 4://Status
                lista.sort(Comparator.comparing(Task::getStatus));
                for(Task t : lista)
                    System.out.println(t);
                break;

            default:
                throw new Exception("Opção Inválida");
        }
    }


    public void taskPorStatus() {
        int todo = 0;
        int doing = 0;
        int done = 0;

        for (Task t : repositorio.getTaskRepo()) {
            switch (t.getStatus()) {
                case TODO:
                    todo++;
                    break;
                case DOING:
                    doing++;
                    break;
                case DONE:
                    done++;
                    break;
            }
        }

        System.out.println("===== RESUMO DE TAREFAS =====");
        System.out.println("TODO: " + todo);
        System.out.println("DOING: " + doing);
        System.out.println("DONE: " + done);
    }

    public void imprimeTituloId(){
        List<Task> lista = new ArrayList<>(repositorio.getTaskRepo());
        lista.sort(Comparator.comparing(Task::getId));
        for(Task t : lista)
            System.out.println(+ t.getId() + " | " + t.getTitulo() + "\n");
    }


    public void deletaTask(int id) throws Exception{

        boolean aux = repositorio.delTaskRepo(id);

        if(aux) {
            System.out.println("Tarefa removida");
            persistencia.salvarArquivo(repositorio.getTaskRepo());
        }

        else
            throw new Exception("ID Inválido");


    }
}