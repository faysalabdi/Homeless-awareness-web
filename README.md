# Studio Project - Web Application for Social Challenges

## Overview

This project is a web-based application addressing the social challenge of homelessness in Victoria. The goal is to create solutions that have a positive impact on communities using front-end, and back-end skills learned in the course, such as design, development, usability testing, and presentation. 

Some skills I gained from this project include ethical software development, creating a user-centered design, working with database systems, and how to effectivly communicate within a team project.


This result is a simple website connected to an SQL database that presents the current homeless crisis in Victoria. 


This website involves:

* A Java class for the Index page (index.html)
* Java classes for additional pages 
* JDBCConnection Java class, that uses the Homeless Database which is taken from the government 
    * using the JDBCConnection methods, we created SQL Queries to support the web page
* App Java class to configure and setup the Javalin web server. 
   

Classes backing Web pages:
```bash
├── Index                        - Homepages/index page. Provides a directory to all other pages
├── Page1                        - Sets of 6 other Java class files backing 6 other pages.
├── ...
└── Page6                        
```

Other Classes:
```bash
├── App                          - Main Application entrypoint for Javalin
└── JDBCConnection               - Example JDBC Connection class based on Studio Project Workshop content
```

Folders:
```bash
├── /src/main                    - Location of all files as required by MAVEN build
│         ├── java               - Java Source location
│         │    └── app           - package location for all Java files
│         └── resources          - Web resources (html templates / style sheets)
│               ├── css          - CSS Style-sheets. Base example style sheet (common.css) provided
│               └── images       - Image files. Base example image (RMIT Logo) provided
│ 
├── /target                      - build directory (DO NOT MODIFY)
├── /database                    - The folder to store sqlite database files (*.db files)
├── pom.xml                      - Configure Build (DO NOT MODIFY)
└── README.md                    - This file ;
```

Libraries
* org.xerial.sqlite-jdbc         - SQLite JDBC library
* javalin (lightweight java webserver)

Libraries required as dependencies
* By javalin
   * slf4j-simple (lightweight logging)
* By xerial/jdbc
   * sqlite-jdbc


# How to run the code
1. Open this project within VSCode
2. Allow VSCode to read the Maven pom.xml file
 - Allow the popups to run and "say yes" to VSCode configuring Maven
 - Allow VSCode to download the required Java libraries
3. To Build & Run
 - Open the src/main/java/app/App.java source file, and select "Run" from the pop-up above the main function
4. Go to: http://localhost:7000







Copyright RMIT University (c) 2021

