CREATE DATABASE `db_apirest_store_procedure` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- db_apirest_store_procedure.car definition

CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `km` int DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- LIST CARS STORE PROCEDURE
CREATE DEFINER=`root`@`localhost` PROCEDURE `db_apirest_store_procedure`.`list_procedure`()
begin
	select * from car;
END;
--{ CALL db_apirest_store_procedure.list_procedure() }



--SAVE CAR STORE PROCEDURE
CREATE PROCEDURE db_apirest_store_procedure.save_procedure(brandIn varchar(255), in modelIn varchar(255), in yearIn int(11), in kmIn int(11))
BEGIN
	INSERT INTO db_apirest_store_procedure.car (brand, km, model, `year`) VALUES(brandIn, modelIn, yearIn, kmIn);
END;

--{ CALL db_apirest_store_procedure.save_procedure(:brandIn,:modelIn,:yearIn,:KmIn) }



--FIND BY ID STORE PROCCEDURE
CREATE PROCEDURE db_apirest_store_procedure.find_by_id_procedure(idIn int(11))
begin
	select * from car where id = idIn;
END;
--{ CALL db_apirest_store_procedure.find_by_id_procedure(:idIn) }



--DELETE STORE PROCEDURE
CREATE PROCEDURE db_apirest_store_procedure.delete_procedure(idIn int(11))
begin
	DELETE FROM db_apirest_store_procedure.car WHERE id = idIn;
END;
--{ CALL db_apirest_store_procedure.delete_procedure(:idIn) }



--UPDATE STORE PROCEDURE
CREATE PROCEDURE db_apirest_store_procedure.update_procedure(idIn int (11),in brandIn varchar(255), in modelIn varchar(255), in yearIn int(11), in kmIn int(11))
begin
	UPDATE db_apirest_store_procedure.car SET brand = brandIn, km = kmIn, model = modelIn, `year` = yearIn WHERE id = idIn;
END;
--{ CALL db_apirest_store_procedure.update_procedure(:idIn,:brandIn,:modelIn,:yearIn,:kmIn) }

