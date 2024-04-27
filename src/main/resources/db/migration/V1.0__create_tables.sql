CREATE TABLE placement_area (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64)
);

CREATE TABLE luggage (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(64),
    extra_charge DOUBLE,
    quantity INT,
    width DOUBLE,
    height DOUBLE,
    length DOUBLE,
    weight DOUBLE,
    description VARCHAR(64),
    user_id BIGINT,
    flight_id BIGINT,
    booking_id BIGINT,
    placement_area_id BIGINT,
    FOREIGN KEY (placement_area_id) REFERENCES placement_area(id)
);

-- REVERT
-- DROP TABLE IF EXISTS Luggage;
-- DROP TABLE IF EXISTS PlacementArea;
-- DELETE FROM flyway_schema_history WHERE version = '1.0';
