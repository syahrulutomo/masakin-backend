  CREATE TABLE users (
  id varchar(255) NOT NULL,
  dob date NOT NULL,
  email varchar(255) NOT NULL,
  full_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  user_name varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(email)
);

  CREATE TABLE restaurant (
  id varchar(255) NOT NULL,
  alamat varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  foto varchar(255) DEFAULT NULL,
  nama_restaurant varchar(255) NOT NULL,
  nomor_rekening_bank varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
);

 CREATE TABLE menu (
  id varchar(255) NOT NULL,
  foto varchar(255) DEFAULT NULL,
  harga int(11) NOT NULL,
  jenis varchar(255) NOT NULL,
  nama_menu varchar(255) NOT NULL,
  id_restaurant varchar(255) NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (id_restaurant) REFERENCES restaurant (id)
);

CREATE TABLE pesanan (
  id varchar(255) NOT NULL,
  alamat varchar(255) NOT NULL,
  jumlah_pesan int(11) DEFAULT NULL,
  status_bayar varchar(255) NOT NULL,
  status_delivery varchar(255) NOT NULL,
  tgl_pesan date NOT NULL,
  total_bayar int(11) NOT NULL,
  id_menu varchar(255) NOT NULL,
  id_user varchar(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users (id),
  FOREIGN KEY (id_menu) REFERENCES menu (id)
)