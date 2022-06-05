-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za user - User1234
                -- admin - Admin123



INSERT INTO COMPANIES (establishment_date,company_type,income,name) VALUES ('2008-05-04',0,23400.31,'Vega IT');


INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-03-03', '2021-03-03', 15432.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-12-04', '2020-12-03', 5432.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-05-05', '2019-04-03', 5765.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-12-06', '2018-08-03', 7653.00, 1);


INSERT INTO USERS (basket_of_goods,birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id) VALUES (500,'1999-10-29','Petar',100,true,'Markovic', 0, '2910999730020', 1);
INSERT INTO USERS (basket_of_goods,birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id) VALUES (500,'1999-05-02','Damjan',200,false,'Ivetic', 0, '050219996450020', 2);
INSERT INTO USERS (basket_of_goods,birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id) VALUES (500,'1999-10-02','Luka',400,false,'Zeljkovic', 0, '10021999650020', 3);
INSERT INTO USERS (basket_of_goods,birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id) VALUES (500,'1999-02-18','Nenad',500,false,'Jocko', 0, '18021999430020', 4);


INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-03-03', '2020-03-01', 1);
INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-05-27', '2020-05-23', 1);
INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-06-16', '2020-06-11', 1);

