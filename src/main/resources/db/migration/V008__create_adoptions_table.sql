
CREATE TABLE adoptions (
    id BIGSERIAL PRIMARY KEY,
    animal_id BIGINT NOT NULL,
    adopter_name VARCHAR(255) NOT NULL,
    adopter_email VARCHAR(255) NOT NULL,
    adopter_phone VARCHAR(20),
    adopter_address TEXT,
    adopter_document VARCHAR(14) NOT NULL,
    adoption_date DATE,
    status VARCHAR(50) NOT NULL,
    observations TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_adoptions_animal FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE INDEX idx_adoptions_animal_id ON adoptions(animal_id);
CREATE INDEX idx_adoptions_status ON adoptions(status);
CREATE INDEX idx_adoptions_adoption_date ON adoptions(adoption_date);
CREATE INDEX idx_adoptions_adopter_document ON adoptions(adopter_document);
