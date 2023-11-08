/**
 * validacao de formulario 
 */

 function validar() {
	 let nome = frmCliente.nome.value;
	 let email = frmCliente.email.value;
	 let senha = frmCliente.senha.value;
	 
	 if (nome === "") {
		 alert('Preencha o campo Nome.')
		 frmCliente.nome.focus()
		 return false
	 } else if (email === ""){
		alert('Preencha o campo Email.')
		 frmCliente.email.focus()
		 return false  
	 } else if (senha === "") {
		 alert('Preencha o campo Senha.')
		 frmCliente.senha.focus()
		 return false		 
	 } else {
		 document.forms["frmCliente"].submit()
	 }
	 
	 
 }