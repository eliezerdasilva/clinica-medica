

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
  `cep` INT NOT NULL ,
  `cidade` VARCHAR(255) NOT NULL,
  `bairro` VARCHAR(25) NOT NULL,
  `rua` VARCHAR(255) NOT NULL,
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
  `observacao` VARCHAR(255) NOT NULL,
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



insert into usuario(idusuario, login, senha, tipo_usuario) values (1,"Carlo","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (2,"Enzo","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (3,"Beatriz","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (4,"Paulo","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (5,"Irineu","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (6,"Karine","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (7,"Cristiano","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (8,"Emanuel","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (9,"Igor","1234",1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (10,"Yuri","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (11,"Ana","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (12,"Eduarda","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (13,"Maria","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (14,"Thiago","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (15,"Claudia","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (16,"Bruno","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (17,"Jonas","1234",2);
insert into usuario(idusuario, login, senha, tipo_usuario) values (18,"Ivete","1234",2);
insert into usuario(idusuario, login, senha , tipo_usuario) values (19,"Admin","1234",0);

select * from endereco;
INSERT INTO `clinica`.`endereco` (`cep`, `cidade`, `bairro`, `rua`, `id_estado`)
VALUES 
    (89110100, 'Gaspar', 'Centro', 'Avenida Paulista', 18),
    (89110200, 'Gaspar', 'Copacabana', 'Rua Barata Ribeiro', 2),
    (89110300, 'Gaspar', 'Savassi', 'Rua Pernambuco', 20),
    (89110400, 'Gaspar', 'Moinhos de Vento', 'Rua Padre Chagas', 25),
    (89110500, 'Gaspar', 'Barra', 'Avenida Oceânica', 24),
    (89110600, 'Gaspar', 'Batel', 'Rua Bispo Dom José', 8),
    (89110700, 'Gaspar', 'Asa Sul', 'Quadra 301', 7),
    (89110800, 'Gaspar', 'Meireles', 'Avenida Beira Mar', 6),
    (89110900, 'Gaspar', 'Boa Viagem', 'Avenida Boa Viagem', 5),
    (89111000, 'Gaspar', 'Centro', 'Rua Felipe Schmidt', 1),
    (89111100, 'Gaspar', 'Vila Mariana', 'Rua Domingos de Morais', 20),
    (89111200, 'Gaspar', 'Ipanema', 'Avenida Vieira Souto', 21),
    (89111300, 'Gaspar', 'Funcionários', 'Rua Alagoas', 22),
    (89111400, 'Gaspar', 'Bela Vista', 'Rua Barão de Santo Ângelo', 23),
    (89111500, 'Gaspar', 'Ondina', 'Avenida Adhemar de Barros', 24),
    (89111600, 'Gaspar', 'Centro Cívico', 'Rua Cândido Lopes', 25),
    (89111700, 'Gaspar', 'Asa Norte', 'Quadra 102', 26),
    (89111800, 'Gaspar', 'Praia de Iracema', 'Avenida Historiador Girão', 27),
    (89111900, 'Gaspar', 'Boa Vista', 'Rua da Aurora', 21),
    (89112000, 'Gaspar', 'Trindade', 'Rua Deputado Antônio Edu', 19),
    (89112100, 'Gaspar', 'Moema', 'Avenida Ibirapuera', 18),
    (89112200, 'Gaspar', 'Leblon', 'Avenida Ataulfo de Paiva', 17),
    (89112300, 'Gaspar', 'Pampulha', 'Avenida Otacílio Negrão de Lima', 20),
    (89112400, 'Gaspar', 'Bom Fim', 'Rua Garibaldi', 7),
    (89112500, 'Gaspar', 'Pituba', 'Avenida Manoel Dias da Silva', 8),
    (89112600, 'Gaspar', 'Batel', 'Rua Gutemberg', 9),
    (89112700, 'Gaspar', 'Sudoeste', 'Quadra 300', 10),
    (89112800, 'Gaspar', 'Aldeota', 'Avenida Dom Luís', 12),
    (89112900, 'Gaspar', 'Pina', 'Avenida Boa Viagem', 11),
    (89113000, 'Gaspar', 'Centro', 'Rua Conselheiro Mafra', 15),
    (89113100, 'Gaspar', 'Pinheiros', 'Rua dos Pinheiros', 14),
    (89113200, 'Gaspar', 'Botafogo', 'Rua Voluntários da Pátria', 16);



INSERT INTO convenio(id,convenio) VALUES (1, "Unimed");
INSERT INTO convenio(id,convenio) VALUES (2, "SulAmérica");
INSERT INTO convenio(id,convenio) VALUES (3, "Bradesco Saúde");
INSERT INTO convenio(id,convenio) VALUES (4, "Cartão de todos");
INSERT INTO convenio(id,convenio) values (5, "Notre Dame Intermédica");
INSERT INTO convenio(id,convenio) values (6, "Anjos da Vida");
INSERT INTO convenio(id,convenio) values (7, "Salvamed");
INSERT INTO convenio(id,convenio) values (8, "Intermédica Saúde");



INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (12345678901, 'João Silva', 'Masculino', 'joao.silva@example.com', '1234567890', 'Engenheiro', 1, '1990-01-01', 89110100, 10, 'Bloco A');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (98765432109, 'Maria Santos', 'Feminino', 'maria.santos@example.com', '9876543210', 'Advogada', 2, '1985-05-10', 89110100, 20, 'Bloco B');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (56789012345, 'Pedro Oliveira', 'Masculino', 'pedro.oliveira@example.com', '5678901234', 'Estudante', 1, '1995-07-15', 89110100, 5, 'Bloco C');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (54321098765, 'Ana Rodrigues', 'Feminino', 'ana.rodrigues@example.com', '5432109876', 'Médica', 3, '1980-03-20', 89110100, 15, 'Bloco D');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (13579246801, 'Lucas Lima', 'Masculino', 'lucas.lima@example.com', '1357924680', 'Programador', 2, '1992-11-05', 89110100, 25, 'Bloco E');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (24681357904, 'Camila Costa', 'Feminino', 'camila.costa@example.com', '2468135790', 'Enfermeira', 1, '1988-09-14', 89110100, 30, 'Bloco F');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (86420975301, 'Rafael Santos', 'Masculino', 'rafael.santos@example.com', '8642097530', 'Estudante', 3, '1997-02-18', 89110100, 8, 'Bloco G');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (12345098765, 'Fernando Oliveira', 'Masculino', 'fernando.oliveira@example.com', '1234509876', 'Advogado', 1, '1991-08-30', 89110100, 12, 'Bloco I');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (97531086420, 'Larissa Silva', 'Feminino', 'larissa.silva@example.com', '9753108642', 'Engenheira', 2, '1983-06-25', 89110100, 18, 'Bloco H');

INSERT INTO `clinica`.`paciente` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `profissao`, `convenio_id`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`) 
VALUES (56789123450, 'Amanda Rodrigues', 'Feminino', 'amanda.rodrigues@example.com', '5678912345', 'Médica', 3, '1986-12-07', 89110100, 22, 'Bloco J');
-- medico

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (12345678901, 'Dr. João Silva', 'Masculino', 'joao.silva@example.com', '1234567890', '1980-01-01', 89110100, 10, 'Bloco A', 1, 12345, 'Cardiologia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (98765432109, 'Dra. Maria Santos', 'Feminino', 'maria.santos@example.com', '9876543210', '1975-05-10', 89110100, 20, 'Bloco B', 2, 23456, 'Dermatologia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (56789012345, 'Dr. Pedro Oliveira', 'Masculino', 'pedro.oliveira@example.com', '5678901234', '1990-07-15', 89110100, 5, 'Bloco C', 3, 34567, 'Ortopedia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (54321098765, 'Dra. Ana Rodrigues', 'Feminino', 'ana.rodrigues@example.com', '5432109876', '1975-03-20', 89110100, 15, 'Bloco D', 4, 45678, 'Ginecologia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (13579246801, 'Dr. Lucas Lima', 'Masculino', 'lucas.lima@example.com', '1357924680', '1982-11-05', 89110100, 25, 'Bloco E', 5, 56789, 'Pediatria');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (24681357904, 'Dra. Camila Costa', 'Feminino', 'camila.costa@example.com', '2468135790', '1986-09-14', 89110100, 30, 'Bloco F', 6, 67890, 'Oftalmologia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (86420975301, 'Dr. Rafael Santos', 'Masculino', 'rafael.santos@example.com', '8642097530', '1995-02-18', 89110100, 8, 'Bloco G', 7, 78901, 'Psiquiatria');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (97531086420, 'Dra. Larissa Silva', 'Feminino', 'larissa.silva@example.com', '9753108642', '1980-06-25', 89110100, 18, 'Bloco H', 8, 89012, 'Oncologia');

INSERT INTO `clinica`.`medico` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`, `crm`, `especializacao`) 
VALUES (56789123450, 'Dra. Amanda Rodrigues', 'Feminino', 'amanda.rodrigues@example.com', '5678912345', '1985-12-07', 89110100, 22, 'Bloco J', 9, 01234, 'Dermatologia');

-- funcionario

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (12345678901, 'Fulano Silva', 'Masculino', 'fulano.silva@example.com', '1234567890', '1990-01-01', 89110100, 10, 'Bloco A', 10);


INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (98765432109, 'Beltrana Santos', 'Feminino', 'beltrana.santos@example.com', '9876543210', '1985-05-10', 89110100, 20, 'Bloco B',11);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (56789012345, 'Ciclano Oliveira', 'Masculino', 'ciclano.oliveira@example.com', '5678901234', '1995-07-15', 89110100, 5, 'Bloco C', 12);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (54321098765, 'Beltrano Rodrigues', 'Masculino', 'beltrano.rodrigues@example.com', '5432109876', '1980-03-20', 89110100, 15, 'Bloco D', 13);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (13579246801, 'Ciclana Lima', 'Feminino', 'ciclana.lima@example.com', '1357924680', '1992-11-05', 89110100, 25, 'Bloco E', 14);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (24681357904, 'Beltrana Costa', 'Feminino', 'beltrana.costa@example.com', '2468135790', '1988-09-14', 89110100, 30, 'Bloco F', 15);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (86420975301, 'Cicrano Santos', 'Masculino', 'cicrano.santos@example.com', '8642097530', '1991-02-18', 89110100, 8, 'Bloco G', 16);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (12345098765, 'Ciclano Martins', 'Masculino', 'ciclano.Martins@example.com', '1234509876', '1990-07-30', 89110100, 12, 'Bloco I', 17);

INSERT INTO `clinica`.`funcionario` (`cpf`, `nome`, `sexo`, `email`, `telefone`, `data_nascimento`, `endereco_cep`, `numero`, `complemento`, `usuario_idusuario`) 
VALUES (56789123450, 'Beltrana Rodrigues', 'Feminino', 'beltrana.rodrigues@example.com', '5678912345', '1986-12-07', 89110100, 22, 'Bloco J', 18);

INSERT INTO consulta (data_consulta, hora_consulta, paciente_cpf, sobre_consulta, tipo_consulta, medico_cpf, observacao)
VALUES 
    (CURRENT_DATE(), '14:00', '12345678901', 'Consulta de rotina', 'Consulta médica', '12345678901', 'Nenhuma observação no momento'),
    (CURRENT_DATE() - INTERVAL 1 DAY, '10:30', '12345678901', 'Acompanhamento pós-operatório', 'Consulta médica', '12345678901', 'Realizar exames de sangue'),
    (CURRENT_DATE() - INTERVAL 2 DAY, '16:45', '98765432109', 'Dor abdominal intensa', 'Consulta médica', '56789012345', 'Receitar medicamentos para alívio da dor'),
    (CURRENT_DATE() - INTERVAL 3 DAY, '08:15', '56789012345', 'Avaliação odontológica', 'Consulta odontológica', '54321098765', 'Agendar procedimento de limpeza'),
    (CURRENT_DATE() - INTERVAL 4 DAY, '11:30', '54321098765', 'Consulta pediátrica', 'Consulta médica', '56789012345', 'Verificar peso e altura da criança'),
    (CURRENT_DATE() - INTERVAL 5 DAY, '09:00', '13579246801', 'Consulta de nutrição', 'Consulta nutricional', '56789012345', 'Elaborar plano alimentar personalizado'),
    (CURRENT_DATE() - INTERVAL 6 DAY, '14:30', '24681357904', 'Avaliação psicológica', 'Consulta psicológica', '56789012345', 'Iniciar terapia cognitivo-comportamental'),
    (CURRENT_DATE() - INTERVAL 7 DAY, '13:00', '86420975301', 'Consulta de fisioterapia', 'Consulta fisioterapêutica', '56789012345', 'Realizar exercícios de fortalecimento'),
    (CURRENT_DATE() - INTERVAL 8 DAY, '16:30', '13579246801', 'Acompanhamento de diabetes', 'Consulta médica', '54321098765', 'Ajustar dosagem de insulina'),
    (CURRENT_DATE() - INTERVAL 9 DAY, '10:00', '98765432109', 'Consulta ginecológica', 'Consulta médica', '54321098765', 'Realizar exame de ultrassom'),
    (CURRENT_DATE() - INTERVAL 10 DAY, '15:30', '13579246801', 'Consulta dermatológica', 'Consulta médica', '54321098765', 'Prescrever tratamento para acne'),
    (CURRENT_DATE() - INTERVAL 11 DAY, '14:45', '12345678901', 'Consulta de psiquiatria', 'Consulta médica', '54321098765', 'Ajustar medicação para transtorno de ansiedade'),
    (CURRENT_DATE() - INTERVAL 12 DAY, '11:15', '98765432109', 'Avaliação oftalmológica', 'Consulta médica', '54321098765', 'Realizar exame de acuidade visual'),
    (CURRENT_DATE() - INTERVAL 13 DAY, '09:30', '54321098765', 'Consulta de ortopedia', 'Consulta médica', '12345678901', 'Solicitar ressonância magnética'),
    (CURRENT_DATE() - INTERVAL 14 DAY, '12:30', '56789123450', 'Consulta de alergologia', 'Consulta médica', '12345678901', 'Realizar teste de alergia');

