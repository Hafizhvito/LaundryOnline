-- Membuat database "laundry_db" jika belum ada --
CREATE DATABASE IF NOT EXISTS laundry_db;

-- Menggunakan database "laundry_db" --
USE laundry_db;

-- Membuat tabel "users" untuk menyimpan data pengguna --
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  address VARCHAR(100) NOT NULL,
  telepon VARCHAR(50) NOT NULL,
  userType ENUM('User', 'Admin') NOT NULL
);

-- Membuat tabel "laundry_types" untuk menyimpan data jenis laundry --
CREATE TABLE IF NOT EXISTS laundry_types (
  id INT AUTO_INCREMENT PRIMARY KEY,
  laundry_type VARCHAR(100) NOT NULL,
  price DECIMAL(10,0) NOT NULL
);

-- Membuat tabel "orders" untuk menyimpan data Order --
CREATE TABLE IF NOT EXISTS orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  customer VARCHAR(50) NOT NULL,
  laundry_type VARCHAR(100) NOT NULL,
  weight VARCHAR(100) NOT NULL,
  total_price VARCHAR(100) NOT NULL,
  payment VARCHAR (100) NOT NULL,
  remaining_balance VARCHAR(100) NOT NULL,
  status VARCHAR(50) NOT NULL
);

-- Memasukkan data pengguna ke dalam tabel "users" --
INSERT INTO users (username, password, address, telepon, userType)
VALUES ('Yanto', '12345678', 'Cikampek', '0987654321', 'User'),
        ('Budi', '12345678', 'Cibadak', '0812345', 'User'),
        ('Naruto', '12345678', 'Konoha', '0123456', 'Admin'),
       ('Dodi', '12345678', 'Cianjur', '0987654322', 'Admin');

-- Memasukkan data laundry type ke dalam tabel  "laundry_types"
INSERT INTO laundry_types (laundry_type, price)
VALUES
  ('Regular Wash', 10000),
  ('Dry Cleaning', 15000),
  ('Delicate Wash', 12000),
  ('Ironing Service', 5000),
  ('Bedding Wash', 20000),
  ('Curtain Cleaning', 40000),
  ('Shirt Laundry', 15000),
  ('Suit Cleaning', 15000),
  ('Uniform Wash', 20000),
  ('Leather Care', 50000);

-- Memasukkan data order ke dalam tabel "orders" --
INSERT INTO orders (customer, laundry_type, weight, total_price, payment, remaining_balance, status)
VALUES ('Yanto', 'Regular Wash', '2', '20000', '20000', '0', 'Settled'),
       ('Budi', 'Dry Cleaning', '3', '45000', '45000', '0', 'Settled'),
       ('Naruto', 'Delicate Wash', '1', '12000', '10000', '2000', 'Unpaid'),
       ('Dodi', 'Ironing Service', '2', '10000', '8000', '2000', 'Unpaid');




