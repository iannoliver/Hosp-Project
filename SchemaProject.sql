CREATE SCHEMA IF NOT EXISTS hosp DEFAULT CHARACTER SET utf8mb4 ;
USE hosp ;

-- -----------------------------------------------------
-- Table especialidade
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS especialidade (
idespecialidade INT AUTO_INCREMENT PRIMARY KEY,
nomeespecialidade VARCHAR(45) NOT NULL
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table medico
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS medico (
idmedico INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomemed VARCHAR(45) NOT NULL,
cpf VARCHAR(15) NOT NULL UNIQUE,
crm VARCHAR(30) NOT NULL UNIQUE,
emailmed VARCHAR(45) NOT NULL UNIQUE,
cargo VARCHAR(50) NOT NULL,
idespecialidade INT NOT NULL,
FOREIGN KEY (idespecialidade)
REFERENCES especialidade (idespecialidade))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table convenio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS convenio (
idconvenio INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomeconvenio VARCHAR(50) NOT NULL,
cnpj VARCHAR(18) NOT NULL,
tempocarencia TIME NOT NULL UNIQUE
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table paciente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS paciente (
idpaciente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomepaciente VARCHAR(50) NOT NULL,
dtnascimento DATE NOT NULL,
sexo CHAR(2) NOT NULL,
cpf VARCHAR(15) NOT NULL UNIQUE,
rg VARCHAR(10) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL UNIQUE,
idconvenio INT NOT NULL,
FOREIGN KEY (idconvenio)
REFERENCES convenio (idconvenio))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table consulta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS consulta (
idconsulta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dataconsulta DATE NOT NULL,
horaconsulta TIME NOT NULL,
valor DECIMAL(10,2) NOT NULL,
idmedico INT NOT NULL,
idpaciente INT NOT NULL,
idespecialidade INT NOT NULL,
FOREIGN KEY (idmedico)
REFERENCES medico (idmedico),
FOREIGN KEY (idpaciente)
REFERENCES paciente (idpaciente),
FOREIGN KEY (idespecialidade)
REFERENCES especialidade (idespecialidade))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
idendereco INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
log VARCHAR(50) NOT NULL,
cep VARCHAR(10) NOT NULL,
numero VARCHAR(10) NOT NULL,
complemento VARCHAR(45) NULL DEFAULT NULL,
referencia VARCHAR(45) NULL DEFAULT NULL,
bairro VARCHAR(45) NOT NULL,
cidade VARCHAR(45) NOT NULL,
estado VARCHAR(45) NOT NULL,
idmedico INT NOT NULL,
idpaciente INT NOT NULL,
FOREIGN KEY (idmedico)
REFERENCES medico (idmedico),
FOREIGN KEY (idpaciente)
REFERENCES paciente (idpaciente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table enfermeira
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS enfermeira (
idenfermeira INT AUTO_INCREMENT PRIMARY KEY,
nomeenfermeira VARCHAR(50) NOT NULL,
cpf VARCHAR(15) NOT NULL UNIQUE,
coren VARCHAR(10) NOT NULL UNIQUE
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table tipoquarto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipoquarto (
idtipo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
valordiario DECIMAL(10,2) NOT NULL,
descquarto TEXT NOT NULL
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table quarto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS quarto (
idquarto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
numero VARCHAR(50) NOT NULL UNIQUE,
tipo VARCHAR(45) NOT NULL,
idtipo INT NOT NULL,
FOREIGN KEY (idtipo)
REFERENCES tipoquarto (idtipo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table internacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS internacao (
idinternacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dataentrada DATE NOT NULL,
dataprevalta DATE NOT NULL,
dataefetalta DATE NOT NULL,
descprocedimentos TEXT NOT NULL,
idpaciente INT NOT NULL,
idmedico INT NOT NULL,
idquarto INT NOT NULL,
FOREIGN KEY (idpaciente)
REFERENCES paciente (idpaciente),
FOREIGN KEY (idmedico)
REFERENCES medico (idmedico),
FOREIGN KEY (idquarto)
REFERENCES quarto (idquarto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table plantao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS plantao (
idplantao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dtplantao DATE NOT NULL,
horaplantao TIME NOT NULL,
idinternacao INT NOT NULL,
idenfermeira INT NOT NULL,
FOREIGN KEY (idinternacao)
REFERENCES internacao (idinternacao),
FOREIGN KEY (idenfermeira)
REFERENCES enfermeira (idenfermeira))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table receita
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS receita (
idreceita INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
medicamento VARCHAR(70) NOT NULL,
qtdmedicamento INT NOT NULL,
instrucaouso LONGTEXT NOT NULL,
idconsulta INT NOT NULL,
FOREIGN KEY (idconsulta)
REFERENCES consulta (idconsulta))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table telefone
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS telefone (
idtelefone INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
numero VARCHAR(10) NOT NULL UNIQUE,
idmedico INT NOT NULL,
idpaciente INT NOT NULL,
FOREIGN KEY (idmedico)
REFERENCES medico (idmedico),
FOREIGN KEY (idpaciente)
REFERENCES paciente (idpaciente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;