-- 3: Obtén las recetas que tienen como ingrediente Tomate.
SELECT *
FROM receta
INNER JOIN ingrediente on receta.id = ingrediente.receta_id
WHERE ingrediente.nombre = 'Tomate';