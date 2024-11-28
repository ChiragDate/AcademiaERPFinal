ALTER TABLE employees_salary
    ADD CONSTRAINT fk_employee_salary
        FOREIGN KEY (employee_Id) REFERENCES employees(employee_Id);
