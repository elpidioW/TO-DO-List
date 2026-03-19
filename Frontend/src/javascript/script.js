


const botaoAbrir = document.getElementById("botao_abrir_modal");
const botaoFechar = document.getElementById("botao_fechar_modal");
const modalJanela = document.getElementById("janela_modal");



botaoAbrir.onclick = function(){
    modalJanela.showModal();
}


botaoFechar.onclick = function(){
    modalJanela.close()
}