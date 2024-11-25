--8.0: Elimina la receta Vichyssoise de la base de datos.
DELETE FROM receta
WHERE receta.nombre = 'Vichyssoise';

-- 8.1: Elimina la receta Vichyssoise de la base de datos.
DELETE FROM `receta` WHERE `receta`.`id` = 2;