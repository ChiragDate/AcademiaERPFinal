CREATE TABLE employees (
                           employee_Id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           first_name VARCHAR(255),
                           last_name VARCHAR(255),
                           email VARCHAR(255) UNIQUE NOT NULL,
                           password VARCHAR(255) NOT NULL,
                           department VARCHAR(255) NOT NULL,
                           title VARCHAR(255),
                           photograph_path VARCHAR(255)
);

    CREATE TABLE employees_salary (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 employee_Id BIGINT NOT NULL,
                                 payment_date DATE,
                                 amount BIGINT,
                                 description VARCHAR(255)
);
