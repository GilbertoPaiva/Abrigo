
CREATE TABLE foods (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255),
    target_animal VARCHAR(50) NOT NULL,
    age_group VARCHAR(50) NOT NULL,
    flavor VARCHAR(100),
    package_weight DECIMAL(6,2),
    stock_quantity INTEGER NOT NULL DEFAULT 0,
    expiration_date DATE,
    supplier VARCHAR(255),
    unit_price DECIMAL(10,2),
    minimum_stock INTEGER NOT NULL DEFAULT 0,
    nutritional_info TEXT,
    observations TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_foods_name ON foods(name);
CREATE INDEX idx_foods_target_animal ON foods(target_animal);
CREATE INDEX idx_foods_age_group ON foods(age_group);
CREATE INDEX idx_foods_expiration_date ON foods(expiration_date);
CREATE INDEX idx_foods_stock_low ON foods(stock_quantity, minimum_stock);
