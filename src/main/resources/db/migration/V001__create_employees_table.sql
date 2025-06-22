
CREATE TABLE employees (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    document VARCHAR(14) UNIQUE NOT NULL,
    address TEXT,
    role VARCHAR(50) NOT NULL,
    hire_date DATE NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    observations TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_employees_role ON employees(role);
CREATE INDEX idx_employees_active ON employees(active);
CREATE INDEX idx_employees_email ON employees(email);
CREATE INDEX idx_employees_document ON employees(document);
