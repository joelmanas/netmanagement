# Net Management
> Just testing running Linux commands in Java.

Simple example application on how to run Linux commands in Java.
***
Realize an inventory of your network connected devices on a database using famous utility Nmap. It uses MAC address as a primary key and updates the IP address as it changes. By default you have access to a ```label``` field to differentiate each device. You can have it running periodically at [application.properties](src/main/resources/application.properties) with parametrized intervals of time ```SCHEDULED``` & ```SCHEDULED_INTERVAL``` or run it once.
## Requirements
* **Java 8** or higher.
* Some commands can only be executed on **Unix-like machinnes**.
* This program requires sudo privileges to execute its commands effectively. **Provide a sudo password** at [application.properties](src/main/resources/application.properties) ```ROOT_PWD```.
* You must provide a **MySQL database connection** to save the collected devices. A ```.sql``` script is given at [create_table.sql](src/main/resources/create_table.sql) to create the necessary table. Fill all ```[DB_*]``` fields in [mybatis-config.xml](src/main/resources/mybatis-config.xml) and [generator_DEVICE.xml](mybatis_generator/generator_DEVICE.xml) with your own to create a successful connection with your database. In case you modify the database table ```DEVICE``` you will have to remove packages ```netmanagement.database.vo``` and ```netmanagement.database.dao``` then rerun [generator_DEVICE.xml](mybatis_generator/generator_DEVICE.xml) by right-clicking on the file and hitting Run As > Run MyBatis Generator (you will need to install the [MyBatis eclipse extension](https://marketplace.eclipse.org/content/mybatis-generator) for the run configuration to appear)
* Obviously, having Nmap installed on your machinne is crucial. I'm using version 7.80 while developing.

Although, since you have full access to the code you could really do whatever you want.
