INSERT INTO placement_area (name) VALUES ('EQUIPAJE DE MANO');
INSERT INTO placement_area (name) VALUES ('EQUIPAJE DE BODEGA');
INSERT INTO placement_area (name) VALUES ('EQUIPAJE DE CABINA');

-- REVERT
-- DELETE FROM PlacementArea WHERE name IN ('EQUIPAJE DE MANO', 'EQUIPAJE DE BODEGA', 'EQUIPAJE DE CABINA');
-- DELETE FROM flyway_schema_history WHERE version = '1.1';