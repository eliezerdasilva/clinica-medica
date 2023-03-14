drop database clinica;
-- -----------------------------------------------------
CREATE DATABASE clinica;
USE clinica;

-- -----------------------------------------------------
-- Table `hospital`.`endereco`
-- -----------------------------------------------------
CREATE TABLE  `clinica`.`endereco` (
  `cep` INT(8) NOT NULL AUTO_INCREMENT,
  `cidade` VARCHAR(30) NOT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`cep`));


-- -----------------------------------------------------
-- Table `hospital`.`paciente`
-- -----------------------------------------------------
CREATE TABLE `clinica`.`paciente` (
  `cpf` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  `profissao` VARCHAR(50) NOT NULL,
  `convenio` VARCHAR(30) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `endereco_cep` INT(8) NOT NULL,
  `numero` INT(3) null DEFAULT  NULL,
  `complemento` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `clinica`.`endereco` (`cep`));


-- -----------------------------------------------------
-- Table `hospital`.`usuario`
-- -----------------------------------------------------
CREATE TABLE `clinica`.`usuario` (
  `idusuario` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_usuario` INT NOT NULL,
  PRIMARY KEY (`idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`medico`
-- -----------------------------------------------------
CREATE TABLE `clinica`.`medico` (
  `nome` VARCHAR(45) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `crm` INT(6) NOT NULL,
  `especializacao` VARCHAR(45) NOT NULL,
  `cpf` BIGINT(20) NOT NULL,
  `crm_uf` CHAR(2) NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`cpf`),
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `clinica`.`usuario` (`idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`consulta`
-- -----------------------------------------------------
CREATE TABLE `clinica`.`consulta` (
  `id_consulta` INT(11) NOT NULL AUTO_INCREMENT,
  `data_consulta` DATETIME NOT NULL,
  `paciente_cpf` INT(11) NOT NULL,
  `medico_id` INT(11) NOT NULL,
  `medico_usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`id_consulta`, `paciente_cpf`, `medico_id`, `medico_usuario_idusuario`),
    FOREIGN KEY (`paciente_cpf`)
    REFERENCES `clinica`.`paciente` (`cpf`),
    FOREIGN KEY (`medico_id` , `medico_usuario_idusuario`)
    REFERENCES `clinica`.`medico` (`id` , `usuario_idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE  `clinica`.`funcionario` (
  `cpf` BIGINT(20) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` CHAR(1) NULL DEFAULT NULL,
  `telefone` VARCHAR(12) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `usuario_idusuario` INT NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `endereco_cep` INT(8) NOT NULL,
  `numero` INT(3) null DEFAULT  NULL,
  `complemento` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `clinica`.`endereco` (`cep`)
    REFERENCES `clinica`.`usuario` (`idusuario`));

        insert into usuario(idusuario, login, senha, tipo_usuario) values (1,"teste","teste",1);
        insert into usuario(idusuario, login, senha, tipo_usuario) values (2,"teste","opa",2);
    insert into endereco (cep, cidade, bairro,estado, rua) values (89110000,"Gaspar","centro","Santa Catarina","Maringa");
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110001,"Gaspar","centro","Santa Catarina","Itajai");    
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110002,"Gaspar","centro","Santa Catarina","Bela vista");
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110003,"Gaspar","centro","Santa Catarina","Margem Esquerda");