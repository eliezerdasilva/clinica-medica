

create database clinica;
USE `clinica` ;


-- -----------------------------------------------------
-- Table `clinica`.`estados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica`.`estados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(75) NULL DEFAULT NULL unique,
  `uf` VARCHAR(5) NULL DEFAULT NULL unique,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `clinica`.`convenio` (
  `id` INT NOT NULL AUTO_INCREMENT primary key,
  `convenio` VARCHAR(75) NULL DEFAULT NULL unique
 );

CREATE TABLE IF NOT EXISTS `clinica`.`endereco` (
  `cep` INT NOT NULL AUTO_INCREMENT,
  `cidade` VARCHAR(30) NOT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  `id_estado` INT NOT NULL,
  PRIMARY KEY (`cep`),
    FOREIGN KEY (`id_estado`)
    REFERENCES `clinica`.`estados` (`id`));


-- -----------------------------------------------------
-- Table `clinica`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica`.`paciente` (
  `cpf` bigint primary key,
  `nome` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(35) NOT NULL,
  `email` VARCHAR(45) NOT NULL unique,
  `telefone` VARCHAR(12) NOT NULL unique,
  `profissao` VARCHAR(50) NOT NULL,
  `convenio_id` int  NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `endereco_cep` INT NOT NULL,
  `numero` INT NULL DEFAULT NULL,
  `complemento` VARCHAR(30) NULL DEFAULT NULL,


    FOREIGN KEY (`endereco_cep`)
    REFERENCES endereco (cep),
    FOREIGN KEY (`convenio_id`)
    REFERENCES convenio (id));


-- -----------------------------------------------------
-- Table `clinica`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica`.`usuario` (
  `idusuario` bigint NOT NULL auto_increment,
  `login` VARCHAR(45) NOT NULL unique,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_usuario` INT NOT NULL,
  PRIMARY KEY (`idusuario`));


-- -----------------------------------------------------
-- Table `clinica`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica`.`medico` (
`cpf` bigint primary key,
  `nome` VARCHAR(45) NOT NULL,
   `sexo` VARCHAR(35) NOT NULL,
  `email` VARCHAR(45) NOT NULL unique,
  `telefone` VARCHAR(12) NOT NULL unique,
  `data_nascimento` DATE not null,
  `endereco_cep` INT NOT NULL,
  `numero` INT NULL DEFAULT NULL,
  `complemento` VARCHAR(30) NULL DEFAULT NULL,
  `usuario_idusuario` bigint not null,
  `crm` bigint NOT NULL unique,
  `especializacao` VARCHAR(45) NOT NULL,
    FOREIGN KEY (`endereco_cep`)
    REFERENCES endereco (`cep`),

    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES usuario (`idusuario`));



CREATE TABLE IF NOT EXISTS `clinica`.`consulta` (
  `id_consulta` int primary key auto_increment,
  `data_consulta` DATE NOT NULL,
  `hora_consulta` TIME NOT NULL,
  `paciente_cpf` BIGINT NOT NULL,
  `sobre_consulta` Text, 
   `tipo_consulta` VARCHAR(45) NOT NULL,
  `medico_cpf` bigint NOT NULL,
  `observacao` VARCHAR(45) NOT NULL,
  `status` VARCHAR(255),

    FOREIGN KEY (`paciente_cpf`)
    REFERENCES `clinica`.`paciente` (`cpf`),
    FOREIGN KEY (`medico_cpf`)
    REFERENCES `clinica`.`medico` (`cpf`));


-- -----------------------------------------------------
-- Table `clinica`.`convenio`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `clinica`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica`.`funcionario` (
  `cpf` BIGINT NOT NULL  ,
  `nome` VARCHAR(45) not null,
  `sexo`  VARCHAR(45) not null,
  `email` VARCHAR(45) not null unique,
  `telefone` VARCHAR(12) not null unique,
  `data_nascimento` DATE not null,
  `endereco_cep` INT NOT NULL,
  `numero` INT not null,
  `complemento` VARCHAR(30) not null, 
   `usuario_idusuario` bigint NOT NULL,
  primary key (`cpf`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `clinica`.`endereco` (`cep`),
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `clinica`.`usuario` (`idusuario`));



INSERT INTO `estados` (`id`, `nome`, `uf`) VALUES
(1, 'Acre', 'AC'),
(2, 'Alagoas', 'AL'),
(3, 'Amazonas', 'AM'),
(4, 'Amapá', 'AP'),
(5, 'Bahia', 'BA'),
(6, 'Ceará', 'CE'),
(7, 'Distrito Federal', 'DF'),
(8, 'Espí­rito Santo', 'ES'),
(9, 'Goiás', 'GO'),
(10, 'Maranhão', 'MA'),
(11, 'Minas Gerais', 'MG'),
(12, 'Mato Grosso do Sul', 'MS'),
(13, 'Mato Grosso', 'MT'),
(14, 'Pará', 'PA'),
(15, 'Paraí­ba', 'PB'),
(16, 'Pernambuco', 'PE'),
(17, 'Piauí­', 'PI'),
(18, 'Paraná', 'PR'),
(19, 'Rio de Janeiro', 'RJ'),
(20, 'Rio Grande do Norte', 'RN'),
(21, 'Rondônia', 'RO'),
(22, 'Roraima', 'RR'),
(23, 'Rio Grande do Sul', 'RS'),
(24, 'Santa Catarina', 'SC'),
(25, 'Sergipe', 'SE'),
(26, 'São Paulo', 'SP'),
(27, 'Tocantins', 'TO');



insert into usuario(idusuario, login, senha, tipo_usuario) values (1,"medico","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (2,"funcionario","1234",2);
insert into usuario(idusuario, login, senha , tipo_usuario) values (3,"admin","1234",0);


insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110000,"Gaspar","centro", 24,"Maringa");
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110001,"Gaspar","centro", 24,"Itajai");    
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110002,"Gaspar","centro", 24,"Bela vista");
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110003,"Gaspar","centro", 24,"Margem Esquerda");

INSERT INTO convenio(id,convenio) VALUES (1, "Unimed");
INSERT INTO convenio(id,convenio) VALUES (2, "SulAmérica");
INSERT INTO convenio(id,convenio) VALUES (3, "Bradesco Saúde");
INSERT INTO convenio(id,convenio) VALUES (4, "Cartão de todos");
INSERT INTO convenio(id,convenio) values (5, "Notre Dame Intermédica");
INSERT INTO convenio(id,convenio) values (6, "Anjos da Vida");
INSERT INTO convenio(id,convenio) values (7, "Salvamed");
INSERT INTO convenio(id,convenio) values (8, "Intermédica Saúde");



insert into paciente(cpf,nome,sexo,email,telefone,profissao,convenio_id,data_nascimento,endereco_cep,numero,complemento)values
(12345678998,"Paciente","M","paciente@gmail.com","47123456789","carteiro",2,'1990-01-01', 89110001, 123, 'Apartamento 1');

insert into medico(cpf,nome,sexo,email,telefone,data_nascimento,endereco_cep,numero,complemento,usuario_idusuario,crm,especializacao)values
(98765432145,"Medico","F","medico@gmail.com","47987654321",'1990-02-02', 89110002, 1234, 'Apartamento 2',1,654321,"podólogo ");

insert into funcionario(cpf,nome,sexo,email,telefone,data_nascimento,endereco_cep,numero,complemento,usuario_idusuario)values
(98765432145,"Funcionario","M","funcionario@gmail.com","47546789123",'1910-02-02', '89110003', 1534, 'Apartamento 3',2);


insert into consulta(data_consulta,hora_consulta,paciente_cpf,sobre_consulta,tipo_consulta,medico_cpf,observacao)
VALUES (CURRENT_DATE(), '14:00', '12345678998', 'Consulta de rotina', 'Consulta médica', '98765432145', 'Nenhuma observação no momento');
