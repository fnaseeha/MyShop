INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, 
refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES 
('myshop', '{bcrypt}$2a$10$hAIYI8xrqI2lf2nWewZ1dOrZ92PVZNnW.pCUHGt378TRwEPyum5sK', 'http://localhost:1993/code',
'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (NAME) VALUES
 ('create_profile'),
 ('read_profile'),
 ('update_profile'),
 ('delete_profile');

 INSERT INTO role (NAME) VALUES
		('ROLE_admin'),('ROLE_operator');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read operator */
     (3,2);  /* update operator */

insert into user(id, username,password, email ,enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) 
VALUES ('1', 'nasee','{bcrypt}$2a$10$GEmy6MWWt/M5ssIam1iYW.Ghlkpm.aDFFM/bWKuBSzBNnbo5IO7ZK', 'nasee@gmail.com', '1', '1', '1', '1');/*na123*/
 
 insert into  user(id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked)
  VALUES ('2', 'hasee', '{bcrypt}$2a$10$e8bVShMmnc0Wfmd5HqBzmONK3hBl6D9p6hcH0ul3jAS4gbZMJt8V2','hasee@gmail.com', '1', '1', '1', '1'); /*ha123*/

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* nasee-admin */,
    (2, 2) /* hasee-operator */ ;