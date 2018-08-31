DROP TABLE category;
CREATE TABLE category(

  id IDENTITY,
  name VARCHAR (50),
  description VARCHAR(255),
  image_url VARCHAR(50),
  is_active BOOLEAN,

  CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category(name, description, image_url, is_active) VALUES

  ('Television', 'Television category', 'CAT_1.png', true),
  ('Mobile', 'Mobile category', 'CAT_2.png', true),
  ('Book', 'Book category', 'CAT_3.png', true),
  ('Laptop', 'Laptop category', 'CAT_4.png', true),
  ('Watches', 'Watches category', 'CAT_5.png', true),
  ('Tablet', 'Tablet category', 'CAT_6.png', true);

CREATE TABLE user_detail(

  id IDENTITY,
  first_name VARCHAR (50),
  last_name VARCHAR (50),
  email VARCHAR (50),
  role VARCHAR (50),
  is_active BOOLEAN,
  password VARCHAR (50),
  contact_number VARCHAR (15),
  CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user_detail(first_name, last_name, email, role, is_active, password, contact_number) VALUES

  ('Mike', 'BubleGum', 'Mike@email.com', 'user', true, 'password', '123456789'),
  ('Tracy', 'Bullock', 'Tracy@email.com', 'user', true, 'password', '123456789'),
  ('John', 'Voinich', 'John@email.com', 'user', true, 'password', '123456789');

CREATE TABLE product (
  id IDENTITY,
  code VARCHAR(20),
  name VARCHAR(255),
  brand VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(50),
  size VARCHAR(50),
  weight VARCHAR(50),
  unit_price DECIMAL(10,2),
--   quantity INT,
  is_active BOOLEAN,
  category_id INT,
  supplier_id INT,
  purchases INT DEFAULT 0,
  views INT DEFAULT 0,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);

INSERT INTO product(code, name, brand, description, image_url, size, weight, unit_price, is_active, category_id, supplier_id) VALUES

  ('627420', 'Приготовление супов и соусов (ПМ.03). Учебное пособие ФГОС', '', 'ISBN: 978-5-222-29807-7; Серия: Среднее профессиональное образование', 'https://img2.labirint.ru/books63/627420/covermid.jpg', '', '', 332, true, 63, 1),
  ('626778', 'Джон Бейктал: Конструируем роботов от А до Я. Полное руководство для начинающих', '', 'Автор: Бейктал Джон; Редактор: Хохлова Т. Г.; ISBN: 978-5-00101-026-5; Страниц: 394 (Офсет); Серия: РОБОФИШКИ', 'https://img2.labirint.ru/books63/626778/covermid.jpg', '241x172x25 мм', '672 г', 694, true, 63, 1),
  ('627420', 'Приготовление супов и соусов (ПМ.03). Учебное пособие ФГОС', '', 'ISBN: 978-5-222-29807-7; Серия: Среднее профессиональное образование', 'https://img2.labirint.ru/books63/627420/covermid.jpg', '241x172x25 мм', '672 г', 332, true, 63, 1),
  ('627420', 'Приготовление супов и соусов (ПМ.03). Учебное пособие ФГОС', '', 'ISBN: 978-5-222-29807-7; Серия: Среднее профессиональное образование', 'https://img2.labirint.ru/books63/627420/covermid.jpg', '241x172x25 мм', '672 г', 332, true, 63, 1),
  ('627420', 'Приготовление супов и соусов (ПМ.03). Учебное пособие ФГОС', '', 'ISBN: 978-5-222-29807-7; Серия: Среднее профессиональное образование', 'https://img2.labirint.ru/books63/627420/covermid.jpg', '241x172x25 мм', '672 г', 332, true, 63, 1),
  ('627420', 'Приготовление супов и соусов (ПМ.03). Учебное пособие ФГОС', '', 'ISBN: 978-5-222-29807-7; Серия: Среднее профессиональное образование', 'https://img2.labirint.ru/books63/627420/covermid.jpg', '241x172x25 мм', '672 г', 332, true, 63, 1);