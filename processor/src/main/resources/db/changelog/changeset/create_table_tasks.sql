create table if not exists tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    notes TEXT
)