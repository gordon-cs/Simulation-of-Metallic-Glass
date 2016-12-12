# System Design Document
_Updated on 12/12/16 by Kuo & Chris_

##### Overview
1. The project is static: user only need to reading, and should not modify result file.
2. No database: we don't have a database since the user is using his existing account on Canaan, and the result file will be sent back to the user's own computer for analysis.
3. Language: User software in Java, Server in C++. Java is good for building interface and can be interactive with the user. C++ is good for parallelizing algorithms and shortening computational time.
4. Input and output: text, csv, and hdf5 binary files. User software will generate a initial-condition text file with user's inputs in the software. Matrices (such as conductivity vs temperature matrix) are in csv format, so that all inputs sent from the user to server will be in text files. The result file will be in hdf5 binary for the convenience of being read by different software (such as matlab) for complex analysis.

##### 1. User software design
1. The main functionality of the the user software is to analysis the calculated result file from the server. It reads the data file and translate the data into pixel data that will be used to generate heat graphs.
2. The second functionality is to log in the server, because in order to use the server, we have to log in using user name, password and the ip address of the workstation.
3. The third functionality is to read inputs(initial conditions for calculation) from the user.

![Image of user class diagram](diagrams/classDiagram_user.png)
##### 2. Server class design
1. Input submission from User Software will trigger the controller. The controller will read and trigger the method user desires to use, as well as read and send the initial conditions.
2. The computational method class will compute and generate the result file. After the computation is done, the controller will send back to User Software.
![Image of user class diagram](diagrams/classDiagram_server.png)
