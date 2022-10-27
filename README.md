# Net Management
> Just testing running Linux commands in Java.

Simple example application for how to run Linux commands in Java.
***
Realize an inventory of your network connected devices on a database using famous utility Nmap. It uses MAC address as a primary key and updates the IP address as it changes with time. By default you have access to a ```label``` field to differentiate each device. You can have it running periodically at [application.properties](src/main/resources/application.properties) on parametrized intervals of time (SCHEDULED & SCHEDULED_INTERVAL) or run it once.
## Requirements
* Some commands can only be executed on Unix-like machinnes.
* This program requires sudo privileges to execute its commands effectively. Provide a sudo password at [application.properties](src/main/resources/application.properties) (ROOT_PWD).
* You must provide a MySQL database connection to save the collected devices. A ```.sql``` script is given at [create_table.sql](src/main/resources/create_table.sql) to create the necessary table. Fill all ```DB_*``` fields in [application.properties](src/main/resources/application.properties) to create a successful connection with your database.

Although, since you have full access to the code you could really do whatever you want.
