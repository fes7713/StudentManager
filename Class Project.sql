
-- drop table student_course_list;
-- drop table students;
-- drop table course_details;
-- drop table professor_table;
-- drop table department;



CREATE TABLE IF NOT EXISTS Department
(
    Department_ID varchar(255),
    Department_Name varchar(255),
    PRIMARY KEY (Department_ID, Department_Name)
    );

CREATE TABLE IF NOT EXISTS Professor_Table
(
    Professor_ID int NOT NULL PRIMARY KEY,
    Professor_First_Name varchar(255) NOT NULL,
    Professor_Last_Name varchar(255) NOT NULL,
    Department_ID varchar(255) NOT NULL,
    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)
    ON UPDATE CASCADE ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS Course_Details
(
    Department_ID varchar(255),
    Course_ID int,
    Semester_Taken varchar(255),
    Time varchar(255),
    Course_Title varchar(255),
    Professor_ID int,
    PRIMARY KEY (Department_ID, Course_ID),
    FOREIGN KEY (Professor_ID) REFERENCES Professor_Table(Professor_ID)
    ON UPDATE CASCADE ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS Students
(
    TU_ID INT NOT NULL PRIMARY KEY,
    Student_First_Name varchar(255),
    Student_Last_Name varchar(255),
    Major varchar(255)
    );

CREATE TABLE IF NOT EXISTS Student_Course_List
(
    TU_ID int NOT NULL,
    Course_ID int,
    PRIMARY KEY (TU_ID, Course_ID),
    FOREIGN KEY (TU_ID) REFERENCES Students(TU_ID)
    ON UPDATE CASCADE ON DELETE CASCADE
    );


INSERT IGNORE INTO Department
VALUES 	('CIS', 'Computer and Information Sciences'),
		('ACCT', 'Accounting'),
		('ARTU', 'Art'),
        ('ASST', 'Asian Studies'),
        ('ECON', 'Economics'),
        ('ENG', 'English'),
        ('JPNS', 'Japanese'),
        ('PSY', 'Psychology');

INSERT IGNORE INTO Professor_Table
VALUES  (123456789, 'Damon', 'Boyd', 'ECON'),
		(234567890, 'Jason', 'King', 'ENG'),
        (345678901, 'Tony', 'Kang', 'CIS'),
        (456789012, 'Reika', 'Hashimoto', 'CIS');

INSERT IGNORE INTO Course_Details
VALUES	('ECON', 0858, 'FALL 2020', '10:00-11:15', 'The American Economy', '123456789'),
		('ENG' , 0701, 'FALL 2020', '12:00-13:15', 'Intro to Academic Discourse', 234567890),
        ('CIS', 2109, 'FALL 2020', '0800-0915', 'Database Management Systems', 345678901),
        ('CIS', 2168, 'FALL 2020', '1700-1815', 'Data Structures', 456789012),
		('JPNS', 1001, 'FALL 2020', '1300-1500', 'Japanese Elements I', 456789012)
		;

INSERT IGNORE INTO Students
VALUES 	(915909999, 'Curtis', 'Rumph', 'Information Technology'),
		(912345678, 'Silly', 'Wabbit', 'Economics'),
		(923456789, 'Daisuke', 'Oku', 'English'),
		(934567890, 'Chaki', 'Aki', 'Information Technology');

INSERT IGNORE INTO Student_Course_List
VALUES 	(915909999, '2109'),
		(912345678,'0858'),
		(923456789, '0701'),
		(934567890,'2168');