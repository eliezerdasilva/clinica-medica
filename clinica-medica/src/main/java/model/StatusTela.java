package model;

public enum StatusTela {
	
	VALORESNULOS ,INCLUIR, LISTAR, EDITAR, EXCLUIR,   FUNCIONARIEDITADO, ERROAOEDITAROFUNCIONARIO, FUNCIONARIOCADASTRADO, ERROCADASTROFUNCIONARIO, NAOEXIBIRMENSSAGEM, FUNCIONARIOJACADASTRADO, USUARIOJAEXISTENTE,

	//Endereco
	 ENDERECOCADASTRADO, ERROCADASTRARENDERECO, ENDERECOALTERADO, ERROALTERARENDERECO, ENDERECOCORRETO ,
	 
	 //Medico
	 MEDICOCADASTRADO, MEDICONAOCADASTRADO,MEDICOEDITADO,
	 
	 //Usuario
	 USUARIOEXISTENTE, USUARIONAOCADASTRADO, USUARIONAOEXISTENTE,

	 // Paciente
	 PACIENTECADASTRADO, ERROCADASTROPACIENTE,PACIENTENAOEXISTENTE,ERROALTERARPACIENTE,PACIENTEALTERADO,
	 
	 //TODOS
	 CPFEXISTENTE;
	
}
