/**
 * Confirmacao exclusao
 */

 function confirmar(idcli){
	 let resposta = confirm ("Tem certeza que deseja excluir o cliente?")
	 if (resposta === true) {
		 //alert(idcli)
		 window.location.href = "delete?idcli=" + idcli
	 }
 }