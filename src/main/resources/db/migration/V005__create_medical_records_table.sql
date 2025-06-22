
CREATE TABLE medical_records (
    id BIGSERIAL PRIMARY KEY,
    animal_id BIGINT NOT NULL,
    treatment_date DATE NOT NULL,
    veterinarian VARCHAR(255),
    diagnosis TEXT,
    treatment TEXT,
    observations TEXT,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_medical_records_animal FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE INDEX idx_medical_records_animal_id ON medical_records(animal_id);
CREATE INDEX idx_medical_records_treatment_date ON medical_records(treatment_date);
CREATE INDEX idx_medical_records_status ON medical_records(status);
