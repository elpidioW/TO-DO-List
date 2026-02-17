package main;

import repository.TaskRepository;
import service.TaskService;
import utils.ConsoleUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskRepository repositorio = new TaskRepository();
        TaskService service = new TaskService(repositorio);

        Scanner scanner = new Scanner(System.in);

        int opc = -1;
        do {
            ConsoleUtils.limparTela();

            System.out.println("===== TODO LIST =====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Deletar tarefa");
            System.out.println("4 - Quantidade de Tarefas por Status");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String ent = scanner.nextLine();
            try {
                opc = Integer.parseInt(ent);
            } catch (NumberFormatException e) {
                opc = -1;
            }


            try {
                switch (opc) {
                    case 0:
                        ConsoleUtils.limparTela();
                        System.out.println("Programa Encerrado!\nAté Logo!");
                    case 1:
                        ConsoleUtils.limparTela();
                        System.out.println("===== NOVA TAREFA =====");
                        System.out.print("Titulo: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Descrição: ");
                        String desc = scanner.nextLine();

                        System.out.print("Data (dd/MM/yyyy): ");
                        String data = scanner.nextLine();

                        System.out.print("Prioridade (1-5): ");
                        int prioridade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Categoria: ");
                        String categoria = scanner.nextLine();

                        System.out.println(" 1-TODO 2-DOING 3-DONE\nNº Status: ");
                        int status = scanner.nextInt();

                        service.criaTask(titulo, desc, data, prioridade, categoria, status);

                        break;

                    case 2:
                        ConsoleUtils.limparTela();
                        System.out.println("1-Todas 2-Categoria 3-Prioridade 4-Status\nSelecione o parâmetro de listagem: ");

                        int aux = scanner.nextInt();
                        scanner.nextLine();

                        service.imprimeTasks(aux);
                        break;

                    case 3:
                        ConsoleUtils.limparTela();
                        System.out.println("+++LISTANDO TODAS AS TAREFAS+++");
                        service.imprimeTituloId();

                        System.out.println("Digite o ID da tarefa que será deletada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            service.deletaTask(id);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        ConsoleUtils.limparTela();
                        service.taskPorStatus();
                        break;

                    default:
                        System.out.println("Opção Inválida!");
                        break;


                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }

        System.out.println("Aperte ENTER para voltar ao menu!");
        scanner.nextLine();
        }while (opc != 0);

    }
}