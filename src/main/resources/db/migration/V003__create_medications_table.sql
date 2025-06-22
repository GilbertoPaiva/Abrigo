
CREATE TABLE medications (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255),
    active_ingredient VARCHAR(255),
    type VARCHAR(50) NOT NULL,
    dosage VARCHAR(100),
    administration VARCHAR(255),
    stock_quantity INTEGER NOT NULL DEFAULT 0,
    expiration_date DATE,
    supplier VARCHAR(255),
    unit_price DECIMAL(10,2),
    minimum_stock INTEGER NOT NULL DEFAULT 0,
    observations TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_medications_name ON medications(name);
CREATE INDEX idx_medications_type ON medications(type);
CREATE INDEX idx_medications_expiration_date ON medications(expiration_date);
CREATE INDEX idx_medications_stock_low ON medications(stock_quantity, minimum_stock);
