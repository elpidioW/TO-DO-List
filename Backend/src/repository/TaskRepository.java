package repository;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository{
    private List<Task> listaTarefas = new ArrayList<>();



    public TaskRepository() {}
    public TaskRepository(List<Task> listaArquivo){
        this.listaTarefas = listaArquivo;
        int maior = 0;

        if(!listaArquivo.isEmpty()){
            for (Task task : listaArquivo){
                if(task.getId() > maior){
                    maior = task.getId();
                }
            }
        }
        this.id = maior + 1;
    }

    int id = 0;
    public void addTaskRepo(Task tarefa){
        tarefa.setId(id);
        listaTarefas.add(tarefa);
        id++;
    }

    public boolean delTaskRepo(int id){
        return listaTarefas.removeIf(task -> task.getId() == id);
    }

    public List<Task> getTaskRepo(){
        return listaTarefas;
    }

}
