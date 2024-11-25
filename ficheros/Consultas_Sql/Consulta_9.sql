--9: Lista todas las recetas y sus ingredientes en una sola consulta.
SELECT receta.nombre, ingrediente.nombre
FROM receta
INNER JOIN ingrediente ON receta.id = ingrediente.receta_id;