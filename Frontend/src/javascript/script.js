const modalJanela = document.getElementById("janela_modal");
const botaoAbrir = document.getElementById("botao_abrir_modal");

const botaoCancelar = document.getElementById("botao_cancelar");
const botaoDeletar = document.getElementById("botao_deletar");
const botaoCriarTarefa = document.getElementById("botao_criar_tarefa");


botaoAbrir.onclick = function(){
    modalJanela.showModal();
}

botaoCancelar.onclick = function(){
    modalJanela.close();
    console.log("Cancelou");
}

botaoDeletar.onclick = function(){
    console.log("Deletou!")
    modalJanela.close();
}

botaoCriarTarefa.onclick = function(){
    modalJanela.close();
    console.log("Tarefa Criada");
}