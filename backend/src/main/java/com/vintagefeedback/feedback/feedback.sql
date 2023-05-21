CREATE TABLE feedback (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  likes BOOLEAN NOT NULL,
  submitter_name VARCHAR(255) NOT NULL,
  submitter_email VARCHAR(255) NOT NULL
);
