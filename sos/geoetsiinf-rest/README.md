# GeoETSIINF 
Repositorio para proyecto de APIREST de la asignatura de Sistemas Orientados a Servicios

## Installation instrucions

### Useful links

- [Install correctly MySQL on Ubuntu](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04)

### Create a local MySQL database and user

- Log into MySQL as root

  - `sudo mysq` if you used the Ubuntu tutorial
  - `mysql -u root -p` if you installed with some other method

- Create a new user:
  - `CREATE USER 'geoetsiinf'@'localhost' IDENTIFIED BY '<PASSWORD>';`
- Check that the user has been added correctly:
  - `select User, Host from mysql.user;`
    You should see something like this:

     ```txt
    +------------------+-----------+
    | User             | Host      |
    +------------------+-----------+
    | geoetsiinf       | localhost |
    | debian-sys-maint | localhost |
    | mysql.infoschema | localhost |
    | mysql.session    | localhost |
    | mysql.sys        | localhost |
    | root             | localhost |
    +------------------+-----------+
    6 rows in set (0.00 sec)
    ```

- Create the database: `CREATE DATABASE geoetsiinfdb;`
- Grant the created user priveleges only on the database: `GRANT ALL PRIVILEGES on geoetsiinfdb.* to 'geoetsiinf'@'localhost';`
- Log out with `\q`
- Log back in: `mysql -h localhost -u geoetsiinf -p`, you will be prompted for you password.
- Check you're the correct user:`SELECT user();`, you should see:

    ```txt
    mysql> select user();
    +----------------------+
    | user()               |
    +----------------------+
    | geoetsiinf@localhost |
    +----------------------+
    1 row in set (0.00 sec)
    ```

### Edit, import and export the template data (SQL file)

We are going to use a .sql file which we will all use and work with to create template data for the project. 
So you need to import the sql file in order to populate the database. This can also be donde with other applications apart from the command-line.

- Move to the directory where the .SQL file is located (if you don't do this then input the whole path when sourcing the .sql file).
- Log as root into MySQL
- First delete the existing database: `DROP DATABASE geoetsiinfdb;`
- Create the database again:`CREATE DATABASE geoetsiinfdb;`
- Select the database: `USE geoetsiinfdb;`
- Import the SQL file with all all the template data by:`source backup-file.sql;`

You're all set configuring the database.
