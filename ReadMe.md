The bootstrap user and the role needs to be created in MySQL DB 
using below MySQL scripts.

# Bootstrap Roles
```
insert into `role` (`id`, `name`) values('2','ROLE_UPDATE');
insert into `role` (`id`, `name`) values('1','ROLE_VIEW');
```

# Bootstrap Users with a password as "password"
```
insert into `user` (`id`, `email`, `password`, `username`) values('1','a@a.com','$2a$10$zDc/D2DdbBBJ1brN9HNWXOHG2hhQLG6V2MQmtiIR84tpAFopLpJZ6','user');
insert into `user` (`id`, `email`, `password`, `username`) values('2','b@b.com','$2a$10$zDc/D2DdbBBJ1brN9HNWXOHG2hhQLG6V2MQmtiIR84tpAFopLpJZ6','admin');
```

# Bootstrap Assign Roles to Users
```
insert into `user_role` (`user_id`, `role_id`) values('1','1');
insert into `user_role` (`user_id`, `role_id`) values('2','2');
```



# Sign in first with the below request and get the JWT Token Generated in the response

```
URL : http://localhost:8080/authenticate
Request body:
{
  "username":"user",
  "password":"password"
}
```

# Use the response JWT, append with "Bearer " and use it as the request header name "Authorization" 
```
URL : http://localhost:8080/test/role/view with header "Authentication" with value "Bearer {{JWT Token}}"
```