--7: Cambia la región de origen de la receta Sopa de ave a “Cataluña”.
UPDATE origen 
SET region = 'Cataluña' 
WHERE id = (SELECT id FROM receta WHERE receta.nombre = 'Vichyssoise' );
