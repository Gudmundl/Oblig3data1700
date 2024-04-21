CREATE TABLE ticketItem(
                        id INT AUTO_INCREMENT,
                        email VARCHAR(255) NOT NULL,
                        phone VARCHAR(255) NOT NULL,
                        firstName VARCHAR(255) NOT NULL,
                        lastName VARCHAR(255) NOT NULL,
                        quantity INT NOT NULL,
                        film VARCHAR(255) NOT NULL,
                        PRIMARY KEY (id)
);