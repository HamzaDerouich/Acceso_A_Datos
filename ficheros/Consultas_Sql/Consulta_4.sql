-- 4: Cuenta el número de recetas de cada tipo.
SELECT tipo, COUNT(*) AS cantidad
FROM receta
GROUP BY tipo;