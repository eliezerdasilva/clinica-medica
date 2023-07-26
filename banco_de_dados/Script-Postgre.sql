-- Create database
CREATE SCHEMA IF NOT EXISTS clinica_medica;
SET search_path TO clinica_medica;


-- Create table estados
CREATE TABLE IF NOT exists 'estados' (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(75) not null unique,
  uf VARCHAR(5) NULL
);

-- Create table convenio
CREATE TABLE IF NOT EXISTS convenio (
  id SERIAL PRIMARY KEY,
  convenio VARCHAR(75) null unique
);

-- Create table endereco
CREATE TABLE IF NOT EXISTS endereco (
  cep INT PRIMARY KEY,
  cidade VARCHAR(30) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  rua VARCHAR(30) NOT NULL,
  id_estado INT NOT NULL,
  FOREIGN KEY (id_estado) REFERENCES estados (id)
);

-- Create table paciente
CREATE TABLE IF NOT EXISTS paciente (
  cpf BIGINT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  sexo VARCHAR(35) NOT NULL,
  email VARCHAR(45) NOT null unique,
  telefone VARCHAR(12) NOT null unique,
  profissao VARCHAR(50) NOT NULL,
  convenio_id INT NOT NULL,
  data_nascimento DATE NOT NULL,
  endereco_cep INT NOT NULL,
  numero INT DEFAULT NULL,
  complemento VARCHAR(30) DEFAULT NULL,
  FOREIGN KEY (endereco_cep) REFERENCES endereco (cep),
  FOREIGN KEY (convenio_id) REFERENCES convenio (id)
);

-- Create table usuario
CREATE TABLE IF NOT EXISTS usuario (
  idusuario BIGSERIAL PRIMARY KEY,
  login VARCHAR(45) NOT null unique,
  senha VARCHAR(45) NOT NULL,
  tipo_usuario INT NOT NULL
);

-- Create table medico
CREATE TABLE IF NOT EXISTS medico (
  cpf BIGINT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  sexo VARCHAR(35) NOT NULL,
  email VARCHAR(45) NOT NULL,
  telefone VARCHAR(12) NOT null unique,
  data_nascimento DATE NOT NULL,
  crm BIGINT NOT null unique,
  especializacao VARCHAR(45) NOT NULL,
  endereco_cep INT NOT NULL,
  numero INT DEFAULT NULL,
  usuario_idusuario BIGINT NOT NULL,
  complemento VARCHAR(30) DEFAULT NULL,
  FOREIGN KEY (endereco_cep) REFERENCES endereco (cep),
  FOREIGN KEY (usuario_idusuario) REFERENCES usuario (idusuario)
);

-- Create table consulta
CREATE TABLE IF NOT EXISTS consulta (
  id_consulta SERIAL PRIMARY KEY,
  data_consulta DATE NOT NULL,
  hora_consulta TIME NOT NULL,
  paciente_cpf BIGINT NOT NULL,
  sobre_consulta TEXT,
  tipo_consulta VARCHAR(45) NOT NULL,
  medico_cpf BIGINT NOT NULL,
  observacao VARCHAR(45) NOT NULL,
  status INT,
  FOREIGN KEY (paciente_cpf) REFERENCES paciente (cpf),
  FOREIGN KEY (medico_cpf) REFERENCES medico (cpf)
);

-- Create table funcionario
CREATE TABLE IF NOT EXISTS funcionario (
  cpf BIGINT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  sexo VARCHAR(45) NOT NULL,
  telefone VARCHAR(12) NOT null unique,
  data_nascimento DATE NOT NULL,
  usuario_idusuario BIGINT NOT NULL,
  endereco_cep INT NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(30) NOT NULL,
  FOREIGN KEY (endereco_cep) REFERENCES endereco (cep),
  FOREIGN KEY (usuario_idusuario) REFERENCES usuario (idusuario)
);

-- Insert data into estados table
INSERT INTO estados (id, nome, uf) VALUES
(1,'Acre', 'AC'),
(2,'Alagoas', 'AL'),
(3, 'Amazonas','AM'),
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


insert into usuario(idusuario, login, senha, tipo_usuario) values (1,'teste','teste',1);
insert into usuario(idusuario, login, senha, tipo_usuario) values (2,'medico','opa',2);
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110000,'Gaspar','centro', 24,'Maringa');
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110001,'Gaspar','centro', 24,'Itajai');    
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110002,'Gaspar','centro', 24,'Bela vista');
insert into endereco (cep, cidade, bairro, id_estado, rua) values (89110003,'Gaspar','centro', 24,'Margem Esquerda');


INSERT INTO convenio(id,convenio) VALUES (1, 'Unimed');
INSERT INTO convenio(id,convenio) VALUES (2, 'SulAmérica');
INSERT INTO convenio(id,convenio) VALUES (3, 'Bradesco Saúde');
INSERT INTO convenio(id,convenio) VALUES (4, 'Cartão de todos');
INSERT INTO convenio(id,convenio) values (5, 'Notre Dame Intermédica');
INSERT INTO convenio(id,convenio) values (6, 'Anjos da Vida');
INSERT INTO convenio(id,convenio) values (7, 'Salvamed');
INSERT INTO convenio(id,convenio) values (8, 'Intermédica Saúde');