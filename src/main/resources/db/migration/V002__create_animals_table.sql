
CREATE TABLE animals (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(100) NOT NULL,
    breed VARCHAR(100),
    age INTEGER,
    weight DECIMAL(5,2),
    size VARCHAR(20) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    color VARCHAR(100),
    found_location TEXT,
    rescue_date DATE NOT NULL,
    current_status VARCHAR(50) NOT NULL,
    arrival_status VARCHAR(50) NOT NULL,
    observations TEXT,
    microchipped BOOLEAN DEFAULT FALSE,
    microchip_number VARCHAR(50),
    vaccinated BOOLEAN DEFAULT FALSE,
    sterilized BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE INDEX idx_animals_species ON animals(species);
CREATE INDEX idx_animals_current_status ON animals(current_status);
CREATE INDEX idx_animals_rescue_date ON animals(rescue_date);
CREATE INDEX idx_animals_name ON animals(name);
CREATE INDEX idx_animals_microchip ON animals(microchip_number);
