SELECT *
FROM recipe
WHERE(
            ( CASE
                  WHEN 2 = 0 THEN preparation_time_id
                  ELSE 1
                END
                ) > 0
        AND
            ( CASE
                  WHEN 2 <> 0 THEN 2
                  ELSE preparation_time_id
                END
                ) = preparation_time_id)

  AND

    (
                ( CASE
                      WHEN 16 = 0 THEN recipe_category_id
                      ELSE 1
                    END
                    ) > 0
            AND
                ( CASE
                      WHEN 16 <> 0 THEN 16
                      ELSE recipe_category_id
                    END
                    ) = recipe_category_id)
  AND name LIKE '%%';

SELECT ris.id as recipe_in_section_id,i.id as ingredient_id, ig.id as ingredient_group_id, mu.id as measurement_unit_id, (ri.quantity / r.serving_size * ris.planned_serving_size) as final_quantity
FROM recipe_in_section ris
         JOIN recipe r ON ris.recipe_id = r.id
         JOIN recipe_ingredient ri ON r.id = ri.recipe_id
         JOIN ingredient i ON i.id = ri.ingredient_id
         JOIN ingredient_group ig ON ig.id = i.ingredient_group_id
         JOIN measurement_unit mu ON mu.id = ri.measure_unit_id
         JOIN section_in_menu sim ON sim.id = ris.section_in_menu_id
         JOIN menu m ON m.id = sim.menu_id
WHERE sim.menu_id = 1;