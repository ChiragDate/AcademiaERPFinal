-- INSERT INTO Departments (name, capacity)
-- VALUES
--     ('Computer Science', 120),
--     ('Information Technology', 100),
--     ('Electronics and Communication Engineering', 80),
--     ('Digital Society', 50);
-- password123
-- password456
-- password789
-- password101
-- password102
-- Dummy Data for Employees Table
INSERT INTO employees (employee_Id, first_name, last_name, email, password, department, title, photograph_path) VALUES
(1, 'Akash', 'Das', 'Akash.Das@example.com', '$2a$10$LAK/yrxMPmTHCgKep0F0tO2hh3cVeSd.0aYXQtOxqj6RyRmBBNC0.', 'Admin', 'Admin', '/photos/Akash_Das.jpg'),
(2, 'Akshay', 'Shah', 'Akshay.Shah@example.com', '$2a$10$An9tqlra.7zhoicNjBNXhuwccIFsVlkQ62LTJPIUpq7Tyunwl17Sq', 'Information Technology', 'Assistant Professor', '/photos/Akshay_Shah.jpg'),
(3, 'Omkar', 'Patil', 'Omkar.Patil@example.com', '$2a$10$2PxZv2Rdh4rX6duzA/Twq.kfs9gzbG.3M.WsJDdAIjgb8aLGIo9Ri', 'Computer Science', 'Assistant Professor', '/photos/Omkar_Patil.jpg'),
(4, 'Jay', 'Patel', 'Jay.Patel@example.com', '$2a$10$yToB8bQCywyenMezLXG9NuA9RCtTZj715MpnZP3DEciRTGUatT4qS', 'Accounts', 'Accounts Manager', '/photos/Jay_Patel.jpg'),
(5, 'Jash', 'Shah', 'Jash.Shah@example.com', '$2a$10$E.GGbqZSf1rLyk64VT4hVuSdCWmeVf5CTwGUFgcE7L4SXf3/PsEnm', 'Computer Science', 'Professor', '/photos/Jash_Shah.jpg');

-- Mapping Departments to IDs:
-- 1 = CSE
-- 2 = ECE
-- 3 = Digital Society
-- 4 = DSAI

INSERT INTO employees_salary (id, employee_Id, payment_date, amount, description) VALUES
(1, 1, '2024-10-01', 75000.00, 'Monthly Salary'),
(2, 2, '2024-10-01', 65000.00, 'Monthly Salary'),
(3, 3, '2024-10-01', 85000.00, 'Monthly Salary'),
(4, 4, '2024-10-01', 90000.00, 'Monthly Salary'),
(5, 5, '2024-10-01', 70000.00, 'Monthly Salary'),
(6, 1, '2024-11-01', 75000.00, 'Monthly Salary'),
(7, 2, '2024-11-01', 65000.00, 'Monthly Salary'),
(8, 3, '2024-11-01', 85000.00, 'Monthly Salary'),
(9, 4, '2024-11-01', 90000.00, 'Monthly Salary'),
(10, 5, '2024-11-01', 70000.00, 'Monthly Salary');