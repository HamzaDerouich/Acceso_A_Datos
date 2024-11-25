--Selecciona todas las recetas cuyo origen sea España.
SELECT * 
FROM receta
INNER JOIN origen on receta.origen = origen.id
WHERE origen.pais = 'España';