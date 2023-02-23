 DROP DATABASE hospital;
-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE DATABASE hospital;
USE hospital;

-- -----------------------------------------------------
-- Table `hospital`.`endereco`
-- -----------------------------------------------------
CREATE TABLE  `hospital`.`endereco` (
  `cep` INT(8) NOT NULL AUTO_INCREMENT,
  `cidade` VARCHAR(30) NOT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  `numero` INT(3) NOT NULL,
  `complemento` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`cep`));


-- -----------------------------------------------------
-- Table `hospital`.`paciente`
-- -----------------------------------------------------
CREATE TABLE `hospital`.`paciente` (
  `cpf` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  `profissao` VARCHAR(50) NOT NULL,
  `convenio` VARCHAR(30) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `endereco_cep` INT(8) NOT NULL,
  PRIMARY KEY (`cpf`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `hospital`.`endereco` (`cep`));


-- -----------------------------------------------------
-- Table `hospital`.`usuario`
-- -----------------------------------------------------
CREATE TABLE `hospital`.`usuario` (
  `idusuario` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_usuario` INT NOT NULL,
  PRIMARY KEY (`idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`medico`
-- -----------------------------------------------------
CREATE TABLE `hospital`.`medico` (
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
    REFERENCES `hospital`.`usuario` (`idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`consulta`
-- -----------------------------------------------------
CREATE TABLE `hospital`.`consulta` (
  `id_consulta` INT(11) NOT NULL AUTO_INCREMENT,
  `data_consulta` DATETIME NOT NULL,
  `paciente_cpf` INT(11) NOT NULL,
  `medico_id` INT(11) NOT NULL,
  `medico_usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`id_consulta`, `paciente_cpf`, `medico_id`, `medico_usuario_idusuario`),
    FOREIGN KEY (`paciente_cpf`)
    REFERENCES `hospital`.`paciente` (`cpf`),
    FOREIGN KEY (`medico_id` , `medico_usuario_idusuario`)
    REFERENCES `hospital`.`medico` (`id` , `usuario_idusuario`));


-- -----------------------------------------------------
-- Table `hospital`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE  `hospital`.`funcionario` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` CHAR(1) NULL DEFAULT NULL,
  `telefone` VARCHAR(12) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`id`, `usuario_idusuario`),
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `hospital`.`usuario` (`idusuario`));

