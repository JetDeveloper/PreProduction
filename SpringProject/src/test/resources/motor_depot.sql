
CREATE TABLE car (
  car_id int NOT NULL,
  car_name varchar(128) NOT NULL,
  trucker_id int NOT NULL,
  max_weight double NOT NULL,
  isOK int NOT NULL,
  CONSTRAINT car_pk PRIMARY KEY (car_id)
);



CREATE TABLE Orders (
  order_id int NOT NULL,
  order_client_fullname varchar(64) NOT NULL,
  order_client_contact varchar(16) NOT NULL,
  order_dispatcher_id int DEFAULT NULL,
  order_distance int NOT NULL,
  order_start_point varchar(64) NOT NULL,
  order_end_point varchar(64) NOT NULL,
  order_weight int NOT NULL,
  order_trucker_id int DEFAULT NULL,
  order_car_id int DEFAULT NULL,
  order_status_id int NOT NULL,
  CONSTRAINT order_pk  PRIMARY KEY (order_id)
);


CREATE TABLE  order_status (
  order_status_id int NOT NULL,
  order_status_name varchar(16) NOT NULL,
  CONSTRAINT order_status_pk PRIMARY KEY (order_status_id)
);

INSERT INTO order_status (order_status_id, order_status_name) VALUES
(1, 'not processed'),
(2, 'processing'),
(3, 'perfoming'),
(4, 'performed');

CREATE TABLE  role (
  role_id int NOT NULL,
  role_name varchar(50) NOT NULL,
  CONSTRAINT role_pk PRIMARY KEY (role_id)
);

INSERT INTO role (role_id, role_name) VALUES
(1, 'trucker'),
(2, 'dispatcher'),
(3, 'client');

CREATE TABLE users (
  user_id int NOT NULL ,
  user_login varchar(32) NOT NULL,
  user_password varchar(32) NOT NULL,
  user_role_id int NOT NULL,
  user_fullname varchar(64) NOT NULL,
  user_contact_number varchar(16) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (user_id)
);

INSERT INTO users (user_id, user_login, user_password, user_role_id, user_fullname, user_contact_number) VALUES
(1, 'ivanov', '35d957317a843b0b7526a26650bbc31f', 1, 'Иванов Иван Иванович', '+380661234567'),
(2, 'petrov', 'd9eaabe53adedb62bc74b7eb0a9477d4', 1, 'Петров Петр Петрович', '+380931112233'),
(3, 'sidor', '849ce91a891a6b4f8bb3216397b78e61', 1, 'Сидоров Никита Сергеевич', '+380934509090'),
(4, 'iphone', '0b3f45b266a97d7029dde7c2ba372093', 2, 'Голопупенко Екатерина Юрьевна', '+380981231212'),
(5, 'pasko_vp', '394d11c8786c696de3399e2bc5cd1875', 2, 'Пасько Виктор Петрович', '+380505556677');

