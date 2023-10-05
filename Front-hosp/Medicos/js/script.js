function exibirMedicos() {
    let saida = ""
    fetch("http://localhost:5000/api/medico/listar")
    .then((response)=>response.json())
    .then((dados) => {
        console.log(dados)
        dados.map((itens,ix)=>{
            saida += `<tr><td>${itens.idmedico}</td>
            <td>${itens.nomemed}</td>
            <td>${itens.cpf}</td>
            <td>${itens.crm}</td>
            <td>${itens.emailmed}</td>
            <td>${itens.cargo}</td>
            </tr>`
        })
        document.getElementsByTagName("tbody")[0].innerHTML = saida
    }).catch((error)=>console.error("Erro na api "+error))
}