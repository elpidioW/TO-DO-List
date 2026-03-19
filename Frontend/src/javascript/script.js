

const modalJanela = document.getElementById("janela_modal");

const botaoAbrir = document.getElementById("botao_abrir_modal");
const botaoFechar = document.getElementById("botao_fechar_modal");
const botaoCriarTarefa = document.getElementById("botao_criar_tarefa");



botaoAbrir.onclick = function(){
    modalJanela.showModal();
}

botaoFechar.onclick = function(){
    modalJanela.close();
}

botaoCriarTarefa.onclick = function(){
    console.log("funcionou");
}