insert into User (user_id, user_name, password)
values (1, 'shamsh', '$2y$12$g/YAYclkRp5fB8/rBkqOTerQdISQGlIV9.VjkNNTqwvnNJb9Hek/W');
 

---
 
insert into Role (role_id, role)
values (1, 'ROLE_ADMIN');
 

---
 
insert into user_role (user_id, role_id)
values (1, 1);