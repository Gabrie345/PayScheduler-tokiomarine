CREATE TABLE IF NOT EXISTS TAX_RATE (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        min_days INT NOT NULL,
                                        max_days INT NOT NULL,
                                        valor DOUBLE NOT NULL,
                                        taxa DOUBLE NOT NULL
);

INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (1, 0, 3, 3.00, 2.5);
INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (2, 1, 10, 12.00, 0.0);
INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (3, 11, 20, 0.00, 8.2);
INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (4, 21, 30, 0.00, 6.9);
INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (5, 31, 40, 0.00, 4.7);
INSERT INTO TAX_RATE (id, min_days, max_days, valor, taxa) VALUES (6, 41, 50, 0.00, 1.7);
