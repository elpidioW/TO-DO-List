package persistence;

import model.Status;
import model.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class TaskPersistence {

    protected String caminho;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TaskPersistence(String caminho){

        this.caminho = caminho;
    }


    public void salvarArquivo(List<Task> lista) throws IOException {;

        File file = new File(caminho);

        try (FileWriter fw = new FileWriter(file); BufferedWriter br = new BufferedWriter(fw)){
            for(Task t : lista){
                br.write(t.getId() + ";" + t.getTitulo() + ";" + t.getDescricao() + ";" + t.getDataTermino().format(formatter) + ";" + t.getNivelPrioridade() + ";" + t.getCategoria() + ";" + t.getStatus());
                br.newLine();
            }
            br.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }



    public List<Task> carregarArquivo(){
        List<Task> listaTarefas = new ArrayList<>();
        Path path = Paths.get(caminho);


        if(Files.exists(path)){
            List<String> linhas = null;
            try {
                linhas = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for(String linha : linhas){
                String[] campos = linha.split(";");

                Task aux = new Task(Integer.parseInt(campos[0]), campos[1], campos[2], LocalDate.parse(campos[3], formatter), Integer.parseInt(campos[4]), campos[5], Status.valueOf(campos[6]));
                listaTarefas.add(aux);

            }
        }

        return listaTarefas;
    }
}
