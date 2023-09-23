$("#enviar").click(enviaCadastroNotebook);

function enviaCadastroNotebook(){
    let numero = $("#numero").val();
    let numeroPatrimonio = $("#numeroPatrimonio").val();

    $.ajax({
        type: "POST",
        url: "/cadastro/notebook",
        data: {
            numero: numero,
            numeroPatrimonio: numeroPatrimonio
        },
        success: function(data){
            alert("Notebook cadastrado com sucesso!");
        },
        error: function(){
            alert("Erro");
        }
    });
}