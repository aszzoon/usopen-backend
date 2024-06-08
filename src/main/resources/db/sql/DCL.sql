create user 'usopen'@'*' IDENTIFIED BY '1234';

use busan;

CREATE USER 'usopen'@'%' IDENTIFIED BY '1234';
SELECT User, Host
FROM mysql.user
WHERE User = 'usopen';
DROP USER 'usopen'@'%';
CREATE USER 'usopen'@'%' IDENTIFIED BY '1234';


grant select, update, delete, insert
    on busan.*
    TO 'usopen'@'*';