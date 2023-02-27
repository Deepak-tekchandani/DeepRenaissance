drop database if exists demo_spring_boot;
create database demo_spring_boot;

use demo_spring_boot;
CREATE TABLE Product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price FLOAT NOT NULL
);

-- INSERT INTO Product (name, price)
-- VALUES ('Apple iPhone XR', 799.00), 
   --    ('Samsung Galaxy S21', 999.00), 
     --  ('Google Pixel 5', 699.00), 
      -- ('OnePlus 9 Pro', 749.00), 
       -- ('Huawei P40 Pro', 699.00);

drop database if exists renaissance;
create database renaissance;

use renaissance;

CREATE TABLE client (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(255),
last_name VARCHAR(255),
email VARCHAR(255),
tel VARCHAR(255)
);
CREATE TABLE product (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT,
price DOUBLE
);

INSERT INTO product (id, name, description, price)
VALUES (1, 'La Roche-Posay Effaclar Purifying Foaming Gel', 'This gel cleanser deeply cleanses oily and acne-prone skin, removes impurities and excess sebum. It contains Thermal Spring Water to soothe and hydrate the skin. Suitable for sensitive skin. Non-comedogenic. 200ml', 19.95),
(2, 'CeraVe Moisturizing Cream', 'This moisturizing cream is suitable for dry to very dry skin. It contains ceramides and hyaluronic acid to hydrate and restore the skin barrier. Non-greasy and non-comedogenic. Fragrance-free. 454g', 24.99),
(3, 'The Ordinary Niacinamide 10% + Zinc 1%', 'This serum reduces the appearance of blemishes and congestion. It contains Niacinamide and Zinc to regulate sebum production and balance the skin. Alcohol-free. Oil-free. Vegan. 30ml', 5.90),
(4, 'Drunk Elephant C-Firma Day Serum', 'This serum contains a potent antioxidant complex with L-ascorbic acid, ferulic acid and vitamin E to brighten and firm the skin. It also contains pumpkin ferment extract and pomegranate enzyme to exfoliate and smooth the skin. Free of fragrance, essential oils, silicones and irritants. 30ml', 80.00),
(5, 'Vichy Mineral 89 Hydrating Serum', 'This serum contains 89% of Mineralizing Thermal Water to hydrate, plump and fortify the skin. It also contains hyaluronic acid to further boost hydration and provide a smooth and supple finish. Suitable for all skin types. Non-greasy. Non-sticky. Paraben-free. 50ml', 39.95),
(6, 'Lancôme Advanced Génifique Youth Activating Serum', 'This serum targets multiple signs of aging, such as dullness, fine lines, uneven texture and loss of firmness. It contains a patented complex of prebiotics and probiotics to strengthen the skin microbiome and improve skin health. Suitable for all skin types. Non-comedogenic. 50ml', 178.00),
(7, 'Neutrogena Hydro Boost Water Gel', 'This moisturizer contains hyaluronic acid to deeply hydrate and plump the skin. It is oil-free, non-comedogenic and fragrance-free. Suitable for sensitive skin. 50g', 19.99),
(8, 'Bioderma Sensibio H2O Micellar Water', 'This micellar water gently cleanses and removes makeup from sensitive and reactive skin. It contains fatty acid esters that resemble the natural phospholipids of the skin, to restore the skin barrier and prevent irritation. Non-rinse formula. Non-comedogenic. Fragrance-free. 500ml', 23.95),
(9, 'Sunday Riley Good Genes All-In-One Lactic Acid Treatment', 'This treatment exfoliates and brightens the skin with a blend of lactic acid, licorice and lemongrass. It also smooths and plumps the skin with purified-grade glycolic acid. Suitable for all skin types.', 19.99);

CREATE TABLE orders (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
order_number VARCHAR(255) NOT NULL,
client_id BIGINT,
FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE reservation (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
client_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
start_date DATETIME NOT NULL,
end_date DATETIME NOT NULL,
FOREIGN KEY (client_id) REFERENCES client(id),
FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO client (first_name, last_name, email, tel) 
VALUES ('Adam', 'adm', 'adam@yahoo.ca', '1234567890'),('Frank', 'Gibault', 'frank@admin.ca', '1234567891'),
('alfred', 'sa', 'alfred@admin.ca', '1234567892'),('sarah', 'sa', 'sarah@admin.ca', '134567892'),('Sophie', 'Gagnon', 'sophie.gagnon@email.com', '514-555-1234'),
('Guillaume', 'Leblanc', 'guillaume.leblanc@email.com', '514-555-5678'),
('Mélanie', 'Desjardins', 'melanie.desjardins@email.com', '450-555-4567'),
('Louis', 'Bélanger', 'louis.belanger@email.com', '819-555-8901'),
('Isabelle', 'Dumont', 'isabelle.dumont@email.com', '514-555-2345'),
('Gabriel', 'Beaulieu', 'gabriel.beaulieu@email.com', '450-555-7890'),
('Geneviève', 'Rousseau', 'genevieve.rousseau@email.com', '418-555-3456'),
('Mathieu', 'Bergeron', 'mathieu.bergeron@email.com', '450-555-6789'),
('Audrey', 'Thibault', 'audrey.thibault@email.com', '819-555-9012'),
('Antoine', 'Gagné', 'antoine.gagne@email.com', '514-555-4567');

INSERT INTO orders (order_number, client_id) VALUES ('ORD-123', 1),('ORD-124', 1),
('ORD-125', 2),('ORD-126', 2),('ORD-127', 3),('ORD-128', 3),('ORD-129', 4),('ORD-130', 4),
('ORD-131', 5),('ORD-132', 5), ('ORD-133', 5), ('ORD-134', 5), ('ORD-135', 5), ('ORD-136', 5), 
('ORD-137', 5),('ORD-138', 5),('ORD-139', 5),('ORD-140', 5),('ORD-141', 5),
('ORD-142', 6),('ORD-143', 6),('ORD-144', 7),('ORD-154', 7),('ORD-146', 8),('ORD-147', 8),
('ORD-148', 9),('ORD-149', 9),('ORD-150', 10),('ORD-151', 10),
('ORD-153', 11),('ORD-154', 11),('ORD-155', 12),('ORD-156', 12),('ORD-157', 13),('ORD-158', 13),
('ORD-159', 14),('ORD-160', 14),('ORD-161', 5);



INSERT INTO reservation (client_id, product_id, start_date, end_date)
VALUES (1, 1, '2022-01-01 10:00:00', '2022-01-03 10:00:00'),
       (2, 2, '2022-02-01 12:00:00', '2022-02-03 12:00:00'),
       (3, 3, '2022-03-01 14:00:00', '2022-03-03 14:00:00'),
       (4, 4, '2022-04-01 16:00:00', '2022-04-03 16:00:00');


select * from client;
select * from orders;