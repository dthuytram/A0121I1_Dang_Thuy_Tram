use class1;
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

-- thêm chỉ mục cho bảng 
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName,contactLastName);
EXPLAIN SELECT * FROM customers
WHERE contactLastName = 'King' or contactFirstName = 'Jean';