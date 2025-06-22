
CREATE TABLE medication_usage (
    id BIGSERIAL PRIMARY KEY,
    medical_record_id BIGINT NOT NULL,
    medication_id BIGINT NOT NULL,
    quantity_used INTEGER NOT NULL,
    dosage_administered VARCHAR(100),
    administration_date TIMESTAMP NOT NULL,
    administered_by VARCHAR(255),
    observations TEXT,
    
    CONSTRAINT fk_medication_usage_medical_record FOREIGN KEY (medical_record_id) REFERENCES medical_records(id),
    CONSTRAINT fk_medication_usage_medication FOREIGN KEY (medication_id) REFERENCES medications(id)
);

CREATE INDEX idx_medication_usage_medical_record ON medication_usage(medical_record_id);
CREATE INDEX idx_medication_usage_medication ON medication_usage(medication_id);
CREATE INDEX idx_medication_usage_administration_date ON medication_usage(administration_date);
