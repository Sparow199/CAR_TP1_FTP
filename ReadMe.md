
# CAR TP1 - FTP server
=================================


Structure:
===================

```
CAR_TP1_FTP
|____src
| |____test
| | |____java
| | | |____ftpUnitTests
| | | | |____FtpTest.java
| |____main
| | |____resources
| | |____java
| | | |____ftpServer
| | | | |____FtpRequest.java
| | | | |____FtpServer.java
| | | | |____UserInfos.java
|____ReadMe.md
|____pom.xml

```

Package src / main / javaftpServer
------------------
+ FtpServer.java: class containing the hand to start the FTP server
+ FtpRequest.java: class (extends thread) representing a connection from a client
+ UserInfos.java: class representing the information of FTP server users
On the server

Package src / test / java / FtpUnitTests
----------------
+ FtpTest.java: test class for commands managed by the FTP server


Implementation:
================
The connection to the FTP server is on port 20000.
Connecting a client to the server triggers a thread to
Manage connection (allows multiple connections).

Functional messages are:
+ QUIT: closes the connection
+ USER: tells the server the username for the connection
+ PASS: Password login attempt for user
+ STOR: sending a file from the client to the server
+ RETR: removing a file from the server to the client
+ LIST: sends to the client the list of files present in the current directory
+ SYST: sends the client information about the server system
+ PORT: Similar to the EPRT command but specific to the IPv4 protocol
+ PWD: shows the current folder
+ CWD: Changes the working folder
+ CDUP: Changes the folder to the parent folder
+ PASV: enters passive mode.
+ NOOP: no operation (fictitious package, used mainly on keepalives).
+ TYPE: Sets the transfer mode (ASCII / Binary).


Use :
================

Command has started in the terminal:

Java -jar FTPServer.jar // launch the server

Ftp 127.0.0.1 20000 // connect to server

List of authorized users and their home directories:

        Username: "toto" -> password: "root" -> default directory: "/ home"

Username: "root" -> password: "root" -> default directory: "/ tmp"

The tests:

Unit tests (JUnit) using the ftp client (ftp4j-1.7.2.jar)

        To run a test class, you must first run the Server.