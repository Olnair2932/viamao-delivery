CREATE TABLE IF NOT EXISTS order_domain.orders (
    id UUID PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    delivery_address VARCHAR(500) NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
