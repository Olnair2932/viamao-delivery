CREATE TABLE IF NOT EXISTS delivery.deliveries (
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    courier_name VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
