
CREATE TABLE animal_status_history (
    id BIGSERIAL PRIMARY KEY,
    animal_id BIGINT NOT NULL,
    previous_status VARCHAR(50),
    new_status VARCHAR(50) NOT NULL,
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(255),
    reason TEXT,
    observations TEXT,
    
    CONSTRAINT fk_animal_status_history_animal FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE INDEX idx_animal_status_history_animal_id ON animal_status_history(animal_id);
CREATE INDEX idx_animal_status_history_change_date ON animal_status_history(change_date);
CREATE INDEX idx_animal_status_history_new_status ON animal_status_history(new_status);
