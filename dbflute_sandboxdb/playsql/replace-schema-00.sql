-- #df:changeUser(system)#
-- #df:checkUser(mainSchema)#
create user /*$dfprop.mainUser*/@'127.0.0.1' identified by '/*$dfprop.mainPassword*/';
-- #df:checkUser(mainSchema)#
create database /*$dfprop.mainCatalog*/ character set utf8mb4;

-- #df:reviveUser()#
-- #df:checkUser(mainUser, grant)#
grant all privileges on /*$dfprop.mainCatalog*/.*
  to /*$dfprop.mainUser*/@'127.0.0.1' identified by '/*$dfprop.mainPassword*/';

flush privileges;