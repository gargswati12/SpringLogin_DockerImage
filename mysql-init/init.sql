CREATE USER 'swati'@'%' IDENTIFIED WITH caching_sha2_password BY 'springpass';
GRANT ALL PRIVILEGES ON mydb.* TO 'swati'@'%';
FLUSH PRIVILEGES;
