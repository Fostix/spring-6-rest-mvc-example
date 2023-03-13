# LearnSpringExample

## mysql tables
CREATE TABLE beer (
    id VARCHAR(36) NOT NULL,
    beer_name VARCHAR(50) NOT NULL,
    beer_style SMALLINT NOT NULL,
    create_date DATETIME(6),
    price DECIMAL(38,2) NOT NULL,
    quantity_on_hand INTEGER,
    upc VARCHAR(255) NOT NULL,
    update_date DATETIME(6),
    version INTEGER,
    PRIMARY KEY (id)
) engine=InnoDB;