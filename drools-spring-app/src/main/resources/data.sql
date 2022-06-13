


INSERT INTO COMPANIES (establishment_date,company_type,income,name) VALUES ('2008-05-04',0,23400.31,'Vega IT');


INSERT INTO CONTRACTS (start_date, wage, company_id) VALUES ('2021-03-03', 15432.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-12-04', '2020-12-03', 5432.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-05-05', '2019-04-03', 5765.00, 1);
INSERT INTO CONTRACTS (end_date, start_date, wage, company_id) VALUES ('2022-12-06', '2018-08-03', 7653.00, 1);
INSERT INTO TEMPLATE (basket_of_goods) VALUES (500);


INSERT INTO USERS (birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id, username, password) VALUES ('1999-10-29','Petar',100,true,'Markovic', 0, '2910999730020', 1 , 'markuza99', '$2a$12$ZnZBw8Op7MxwDmQXYTaFk..y0Pu7xGTLybrAfi9BZmDmjuItU8kDC');
INSERT INTO USERS (birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id, username, password) VALUES ('1999-05-02','Damjan',200,false,'Ivetic', 0, '050219996450020', 2, 'damjan99', '$2a$12$9g8ihxhzgIW2vskSYUk8eeKpmHmo.ECfirEtFF/gQYSg.QqrFJojW');
INSERT INTO USERS (birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id, username, password) VALUES ('2009-10-02','Luka',400,false,'Zeljkovic', 0, '10021999650020', 3, 'zelje99', '$2a$12$oWQoi.HHpSqCZPvD4zgAd.Gj6BynJwH9UF7BtPA6SiD3J5PB.ljs6');
INSERT INTO USERS (birthday,first_name,indebtedness_amount,bank_client,last_name,penalties,ucid, contract_id, username, password) VALUES ('1929-02-18','Nenad',500,false,'Jocko', 0, '18021999430020', 4, 'jocko99', '$2a$12$LDEHVVgk4yhOSMvItyYvYezyYSRil94a4.DXgr7nicS5AasEfedDi');

INSERT INTO ROLES (name, description) VALUES ('ROLE_BANKER', 'banker');
INSERT INTO ROLES (name, description) VALUES ('ROLE_CLIENT', 'client');

INSERT INTO USER_ROLES (user_id, role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (1,1);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (2,2);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (3,2);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (4,2);





INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-03-03', '2020-03-01', 1);
INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-05-27', '2020-05-23', 1);
INSERT INTO BLOCKADES (end_date, start_date, company_id) VALUES ('2020-06-15', '2020-06-11', 1);

