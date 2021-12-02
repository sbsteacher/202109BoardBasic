CREATE TABLE t_user(
   iuser INT UNSIGNED AUTO_INCREMENT,
   uid VARCHAR(20) UNIQUE NOT NULL,
   upw VARCHAR(150) NOT NULL,
   nm VARCHAR(5) NOT NULL,
   gender tinyINT unsigned CHECK(gender IN (1, 2)),
   rdt DATETIME DEFAULT NOW(),
   PRIMARY KEY(iuser)
);