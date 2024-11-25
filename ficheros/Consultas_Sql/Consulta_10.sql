-- 10: Calcula el número total de ingredientes únicos utilizados en todas las recetas.
SELECT COUNT(DISTINCT ingrediente.nombre) 'Ingredientes únicos utilizados'
FROM receta 
INNER JOIN ingrediente ON receta.id = ingrediente.receta_id;