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
  `id` INT(11) NOT NULL,
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
  PRIMARY KEY (`id`, `usuario_idusuario`),
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

   
CREATE TABLE IF NOT EXISTS `estados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) DEFAULT NULL,
  `uf` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 


        insert into usuario(idusuario, login, senha, tipo_usuario) values (1,"teste","teste",1);
        insert into usuario(idusuario, login, senha, tipo_usuario) values (2,"teste","opa",2);
    insert into endereco (cep, cidade, bairro,estado, rua) values (89110000,"Gaspar","centro","Santa Catarina","Maringa");
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110001,"Gaspar","centro","Santa Catarina","Itajai");    
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110002,"Gaspar","centro","Santa Catarina","Bela vista");
	insert into endereco (cep, cidade, bairro,estado, rua) values (89110003,"Gaspar","centro","Santa Catarina","Margem Esquerda");


INSERT INTO `estados` (`id`, `nome`, `uf`) VALUES
(1, 'Acre', 'AC'),
(2, 'Alagoas', 'AL'),
(3, 'Amazonas', 'AM'),
(4, 'AmapÃ¡', 'AP'),
(5, 'Bahia', 'BA'),
(6, 'CearÃ¡', 'CE'),
(7, 'Distrito Federal', 'DF'),
(8, 'EspÃ­rito Santo', 'ES'),
(9, 'GoiÃ¡s', 'GO'),
(10, 'MaranhÃ£o', 'MA'),
(11, 'Minas Gerais', 'MG'),
(12, 'Mato Grosso do Sul', 'MS'),
(13, 'Mato Grosso', 'MT'),
(14, 'ParÃ¡', 'PA'),
(15, 'ParaÃ­ba', 'PB'),
(16, 'Pernambuco', 'PE'),
(17, 'PiauÃ­', 'PI'),
(18, 'ParanÃ¡', 'PR'),
(19, 'Rio de Janeiro', 'RJ'),
(20, 'Rio Grande do Norte', 'RN'),
(21, 'RondÃ´nia', 'RO'),
(22, 'Roraima', 'RR'),
(23, 'Rio Grande do Sul', 'RS'),
(24, 'Santa Catarina', 'SC'),
(25, 'Sergipe', 'SE'),
(26, 'SÃ£o Paulo', 'SP'),
(27, 'Tocantins', 'TO');