
CREATE TABLE adoption_visits (
    id BIGSERIAL PRIMARY KEY,
    adoption_id BIGINT NOT NULL,
    visit_date DATE NOT NULL,
    visited_by VARCHAR(255),
    animal_condition TEXT,
    environment_condition TEXT,
    approved BOOLEAN,
    observations TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_adoption_visits_adoption FOREIGN KEY (adoption_id) REFERENCES adoptions(id)
);

CREATE INDEX idx_adoption_visits_adoption_id ON adoption_visits(adoption_id);
CREATE INDEX idx_adoption_visits_visit_date ON adoption_visits(visit_date);
CREATE INDEX idx_adoption_visits_approved ON adoption_visits(approved);
