SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Sexo` VARCHAR(15) NULL,
  `CPF` VARCHAR(11) NULL,
  `Tel_Residencial` VARCHAR(15) NULL,
  `Tel_Celular` VARCHAR(15) NULL,
  `Data_Nascimento` DATE NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendedor` (
  `idVendedor` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Sexo` VARCHAR(45) NULL,
  `CPF` VARCHAR(11) NULL,
  `Contato` VARCHAR(15) NULL,
  `Comissao` DOUBLE NULL,
  PRIMARY KEY (`idVendedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carro` (
  `idCarro` INT NOT NULL,
  `Marca` VARCHAR(255) NULL,
  `Modelo` VARCHAR(255) NULL,
  PRIMARY KEY (`idCarro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estoque` (
  `idEstoque` INT NOT NULL,
  `ano` YEAR NULL,
  `cor` VARCHAR(45) NULL,
  `quilometragem` DOUBLE NULL,
  `placa` VARCHAR(45) NULL,
  `situação` VARCHAR(45) NULL,
  `valorFIPE` DOUBLE NULL,
  `Carro_idCarro` INT NOT NULL,
  PRIMARY KEY (`idEstoque`),
  INDEX `fk_Estoque_Carro_idx` (`Carro_idCarro` ASC),
  CONSTRAINT `fk_Estoque_Carro`
    FOREIGN KEY (`Carro_idCarro`)
    REFERENCES `mydb`.`Carro` (`idCarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendas` (
  `idVendas` INT NOT NULL,
  `Valor_Revenda` DOUBLE NOT NULL,
  `Data_Venda` DATE NOT NULL,
  `Cliente_idCliente1` INT NOT NULL,
  `Estoque_idEstoque1` INT NOT NULL,
  `Vendedor_idVendedor1` INT NOT NULL,
  PRIMARY KEY (`idVendas`, `Cliente_idCliente1`, `Estoque_idEstoque1`, `Vendedor_idVendedor1`),
  INDEX `fk_Vendas_Cliente2_idx` (`Cliente_idCliente1` ASC),
  INDEX `fk_Vendas_Estoque2_idx` (`Estoque_idEstoque1` ASC),
  INDEX `fk_Vendas_Vendedor2_idx` (`Vendedor_idVendedor1` ASC),
  CONSTRAINT `fk_Vendas_Cliente2`
    FOREIGN KEY (`Cliente_idCliente1`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Estoque2`
    FOREIGN KEY (`Estoque_idEstoque1`)
    REFERENCES `mydb`.`Estoque` (`idEstoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Vendedor2`
    FOREIGN KEY (`Vendedor_idVendedor1`)
    REFERENCES `mydb`.`Vendedor` (`idVendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
