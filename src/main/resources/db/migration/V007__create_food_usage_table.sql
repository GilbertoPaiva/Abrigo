    CREATE TABLE food_usage (
    id BIGSERIAL PRIMARY KEY,
    food_id BIGINT NOT NULL,
    animal_id BIGINT,
    quantity_used DOUBLE PRECISION NOT NULL,
    usage_date DATE NOT NULL,
    used_by VARCHAR(255),
    observations TEXT,
    
    CONSTRAINT fk_food_usage_food FOREIGN KEY (food_id) REFERENCES foods(id),
    CONSTRAINT fk_food_usage_animal FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE INDEX idx_food_usage_food_id ON food_usage(food_id);
CREATE INDEX idx_food_usage_animal_id ON food_usage(animal_id);
CREATE INDEX idx_food_usage_usage_date ON food_usage(usage_date);
