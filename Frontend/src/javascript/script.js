
const modalJanela = document.getElementById("janela_modal");
const botaoAbrir = document.getElementById("botao_abrir_modal");

const botaoCancelar = document.getElementById("botao_cancelar");
const botaoDeletar = document.getElementById("botao_deletar");

const formulario = document.getElementById("formularioTarefa");
let listaTarefas = [];
let tarefa = null;


botaoAbrir.onclick = function(){
    tarefa = null;
    formulario.reset();
    botaoDeletar.style.display = 'none';
    modalJanela.showModal();
}

var auxID = 0;
formulario.addEventListener("submit", function(evento){
    evento.preventDefault();

    const titulo = document.getElementById("titulo").value;
    const categoria = document.getElementById("categoria").value;
    const status = document.getElementById("status").value;
    const prioridade = document.getElementById("prioridade").value;
    const descricao = document.getElementById("descricao").value;

    const novaTarefa = {
        id: auxID++,
        titulo,
        categoria,
        status,
        prioridade,
        descricao
    }

    if(tarefa){
        tarefa.titulo = titulo;
        tarefa.categoria = categoria;
        tarefa.status = status;
        tarefa.prioridade = prioridade;
        tarefa.descricao = descricao;
        tarefa = null;
    }else{
        listaTarefas.push(novaTarefa);
    }

    console.log(listaTarefas);

    modalJanela.close();
    renderizarTarefas();
});


function renderizarTarefas(){

    document.querySelectorAll(".lista-tarefas").forEach(lista => {//apaga tudo q tá na tela
        lista.innerHTML = "";
    });

    listaTarefas.forEach(t => {
        const coluna = document.querySelector(`[data-col="${t.status}"] .lista-tarefas`);//descobrindo pra qual coluna a tarefa deve ir de acordo com o status

        //criação do html de cada tarefa
        const div = document.createElement("div");
        div.classList.add("tarefa");

        div.innerHTML = `
            <p>${t.titulo}</p>
        `;
        coluna.appendChild(div);



        //edição pra quando clicamos em alguma tarefa
        div.onclick = function(){
            tarefa = t;
            document.getElementById("titulo").value = t.titulo;
            document.getElementById("categoria").value = t.categoria;
            document.getElementById("status").value = t.status;
            document.getElementById("prioridade").value = t.prioridade;
            document.getElementById("descricao").value = t.descricao;
            botaoDeletar.style.display = "block";
            modalJanela.showModal();
        }
    });
}



botaoCancelar.onclick = function(){
    modalJanela.close();
    console.log("Cancelou");
}

botaoDeletar.onclick = function(){
    if(tarefa){
        listaTarefas = listaTarefas.filter(t => t.id !== tarefa.id);
        tarefa = null;
        renderizarTarefas();
    }

    modalJanela.close();
}

