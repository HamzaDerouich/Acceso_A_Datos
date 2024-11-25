-- 6: Encuentra recetas que contienen “sopa” en su nombre.
SELECT *
FROM receta
WHERE nombre LIKE '%sopa%';