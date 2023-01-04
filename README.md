# StudentManager

This project was a part of a course work in CIS 2109 Database Management course at Temple and conducted by a team of 7 to present the skill of database manipulation and understanding of database system acquired from the course.
### Product Image
![image](https://user-images.githubusercontent.com/71058334/210538013-3ba72798-bedb-4139-aca3-58822fb4eee7.png)

## Project Abstract
This application aims to provide a system that enables users to explore the data inside the specific database table in an efficient way. The system is specifically made for the student database system and provides the efficient way to view and manipulate the data inside the student database table.

## Project Goal
Our goal in this project was to 
1. Combine Java and MySQL
2. Create interactive GUI in Java and have an experience developing fully working GUI with external component, MySQL in this project.
3. Develope the efficient database structure for student management.
4. Have an Experience working as a team.

# Requirement
- JDK 16
- Apatch Netbeans 12.5
- MySQL Workbench 8.0 CE

# How to Run
## Preparation - Java
1. Install Java JDK 16 - https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html
2. Install Apatch netbeans - https://netbeans.apache.org/download/nb125/nb125.html
3. Clone the project and open in Netbeans - 
  ```
  git clone https://github.com/fes7713/StudentManager.git 
  ```
## Preparation - MySQL
1. Install MySQL Workbench 8.0 - https://dev.mysql.com/downloads/workbench/
2. Locate sql file, Class Project.sql in the repository and open it in MySQL WorkBench
3. Create new schema and set it as default schema.
4. execute the sql code in Class Project.sql. Uncomment the first codes for dropping table if you have error creating new tables.

## Build and run
1. Open StudentManager project in Netbeans and run StudentManager.java under studentmanager package.
2. You will see log-in form for the database access so fill the form by specifying the port number, table name, root name and  password
![image](https://user-images.githubusercontent.com/71058334/210542032-cb305250-8cb4-460b-89eb-85fa1d144192.png)


# Development
![Capture 1](https://user-images.githubusercontent.com/71058334/210331324-93e3b6e9-9166-496c-984a-9cce4d12d185.PNG)
This application was developed by a team of 7 in two weeks of time along with coursework. The team was divided into two teams to split the work and it was very important for the smooth development of the application. The team 1 was responsible for creating GUI application in Java using Java Swing GUI library and the team 2 was responsible for creating sql manipulating functions in Java.

## Team 1 - GUI Team.
- Creating GUI with Java Swing was main responsibility for this team and this task included a bunch of smaller tasks, for example,
1. Creating Database data entry forms for students, courses and professors.
2. Creating output GUI view that shows the data inside the specified table.

## Team 2 - MySQL Team.
- Creating MySQL manipulation funcionss in Java and provide a way to controle MySQL database tables from Java GUI was main responsibilities of this team.
1. Finding a way to connect MySQL tables from Java using MySQL connector and drivers.
2. Provide methods to manipulate MySQL tables in Java. (Search, Update, Insert and Delete)


