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