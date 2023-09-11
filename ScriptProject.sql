-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hosp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hosp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hosp` DEFAULT CHARACTER SET utf8mb4 ;
USE `hosp` ;

-- -----------------------------------------------------
-- Table `hosp`.`especialidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`especialidade` (
  `idespecialidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeespecialidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idespecialidade`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`medico` (
  `idmedico` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nomemed` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL unique,
  `crm` VARCHAR(30) NOT NULL unique,
  `emailmed` VARCHAR(45) NOT NULL unique,
  `cargo` VARCHAR(50) NOT NULL,
  `idespecialidade` INT NOT NULL,
    FOREIGN KEY (`idespecialidade`)
    REFERENCES `hosp`.`especialidade` (`idespecialidade`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`convenio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`convenio` (
  `idconvenio` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nomeconvenio` VARCHAR(50) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL UNIQUE,
  `tempocarencia` TIME NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`paciente` (
  `idpaciente` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nomepaciente` VARCHAR(50) NOT NULL,
  `dtnascimento` DATE NOT NULL,
  `cpf` VARCHAR(15) NOT NULL UNIQUE,
  `rg` VARCHAR(10) NOT NULL UNIQUE,
  `email` VARCHAR(50) NOT NULL UNIQUE,
  `idconvenio` INT NOT NULL,
    FOREIGN KEY (`idconvenio`)
    REFERENCES `hosp`.`convenio` (`idconvenio`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`consulta` (
  `idconsulta` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `dataconsulta` DATE NOT NULL,
  `horaconsulta` TIME NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `idmedico` INT NOT NULL,
  `idpaciente` INT NOT NULL,
  `idespecialidade` INT NOT NULL,
    FOREIGN KEY (`idmedico`)
    REFERENCES `hosp`.`medico` (`idmedico`),
    FOREIGN KEY (`idpaciente`)
    REFERENCES `hosp`.`paciente` (`idpaciente`),
    FOREIGN KEY (`idespecialidade`)
    REFERENCES `hosp`.`especialidade` (`idespecialidade`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`endereco` (
  `idendereco` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `log` VARCHAR(50) NOT NULL,
  `cep` VARCHAR(10) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `referencia` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `idmedico` INT NOT NULL,
  `idpaciente` INT NOT NULL,
    FOREIGN KEY (`idmedico`)
    REFERENCES `hosp`.`medico` (`idmedico`),
    FOREIGN KEY (`idpaciente`)
    REFERENCES `hosp`.`paciente` (`idpaciente`)
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`enfermeira`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`enfermeira` (
  `idenfermeira` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nomeenfermeira` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL UNIQUE,
  `coren` VARCHAR(10) NOT NULL UNIQUE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`tipoquarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`tipoquarto` (
  `idtipo` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `valordiario` DECIMAL(10,2) NOT NULL,
  `descquarto` TEXT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`quarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`quarto` (
  `idquarto` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `numero` VARCHAR(50) NOT NULL UNIQUE,
  `tipo` VARCHAR(45) NOT NULL,
  `idtipo` INT NOT NULL,
    FOREIGN KEY (`idtipo`)
    REFERENCES `hosp`.`tipoquarto` (`idtipo`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`internacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`internacao` (
  `idinternacao` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `dataentrada` DATE NOT NULL,
  `dataprevalta` DATE NOT NULL,
  `dataefetalta` DATE NOT NULL,
  `descprocedimentos` TEXT NOT NULL,
  `idpaciente` INT NOT NULL,
  `idmedico` INT NOT NULL,
  `idquarto` INT NOT NULL,
    FOREIGN KEY (`idpaciente`)
    REFERENCES `hosp`.`paciente` (`idpaciente`),
    FOREIGN KEY (`idmedico`)
    REFERENCES `hosp`.`medico` (`idmedico`),
    FOREIGN KEY (`idquarto`)
    REFERENCES `hosp`.`quarto` (`idquarto`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`plantao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`plantao` (
  `idplantao` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `dtplantao` DATE NOT NULL,
  `horaplantao` TIME NOT NULL,
  `idinternacao` INT NOT NULL,
  `idenfermeira` INT NOT NULL,
    FOREIGN KEY (`idinternacao`)
    REFERENCES `hosp`.`internacao` (`idinternacao`),
    FOREIGN KEY (`idenfermeira`)
    REFERENCES `hosp`.`enfermeira` (`idenfermeira`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`receita` (
  `idreceita` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `medicamento` VARCHAR(70) NOT NULL,
  `qtdmedicamento` INT(11) NOT NULL,
  `instrucaouso` LONGTEXT NOT NULL,
  `idconsulta` INT NOT NULL,
    FOREIGN KEY (`idconsulta`)
    REFERENCES `hosp`.`consulta` (`idconsulta`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hosp`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp`.`telefone` (
  `idtelefone` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `ddd` VARCHAR(5) NOT NULL,
  `numero` VARCHAR(10) NOT NULL UNIQUE,
  `idmedico` INT NOT NULL,
  `idpaciente` INT NOT NULL,
    FOREIGN KEY (`idmedico`)
    REFERENCES `hosp`.`medico` (`idmedico`),
    FOREIGN KEY (`idpaciente`)
    REFERENCES `hosp`.`paciente` (`idpaciente`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;