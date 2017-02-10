# Requirement Analysis
_Updated on 12/14 by Kuo Lu & Chris Qiao_

## 1. Introduction

### 1.1 Purpose of the system
The purpose of the system is to produce heat diffusion simulation of the quenching in the production process of metallic glass.

### 1.2 Scope of the system
The system may be accessed by researchers around the world.

### 1.3 Objectives and Success Criteria of the Project
This is a server-client project. The server shall successfully produce a binary file that contain the simulation result. User on the client software should be able to login and initiate computation on the server.

After computation is done, the client software shall receive and read the binary file, and provide multiple analysis options.

### 1.4 References
1. [Bulk Metallic Glass](http://dx.doi.org/10.1063/PT.3.1885)
2. [A study of cooling process in bulk metallic glasses fabrication](http://dx.doi.org/10.1063/1.4935440)


### 1.5 Overview
Manual and input template can both be found on Github repository.

A user can use client software to send initial-condition xml file to the server. The template xml file has default values. It allows user to add/change constants, or add path to other files (such as matrix csv files) in the xml template.

After the server finishes computations, it sends back the data file.

The data file consists of hundreds of matrices with each one representing temperatures at 2-D locations at a specific time.
The user can then use software to analyze data, for instance, show temperature difference between two different points at the same time on the graph, or show a graph of temperature vs. time at one specific position.

## 2. Proposed system
### 2.1 Overview
Our client software will allow the user to login to the server on the supercomputer and link initial-condition xml file, which includes properties such as initial temperature, tube radius, heat conductivity, reservoir temperature. It can also open any existing result files, display the cooling process and show analysis options. Client will also have a tool set for graph-cropping or save.

The server on the supercomputer receives initial-condition files, triggers computations, and send back the result file onto the user's computer. No result files will be saved on server computer.


### 2.2 Functional requirements
The program asks the user to enter required information for simulation calculation, so it has link to input xml file that has these values. After the calculation, the program produce a visualized video/image that shows temperature vs. time at each position.


### 2.3 Nonfunctional requirements
#### 2.3.1 Usability
This program is designed for physics researchers or students who are studying thermal properties of heat diffusion of quenching of metallic glass in a quartz tube. And the user should be able to give necessary information that is needed to let the program to run. The program should be simple to use, as well as examples and documentations hosted on our Github repository.

#### 2.3.2 Reliability
The program is designed to do simulation of heat diffusion, so it should be pretty reliable if all the data that is required to input is correct. And if there is a event of failure, restarting the system is acceptable, but that means the simulation is somehow wrong. When it is running, it produces simulation data and stores it in a file, so it should take some space in the hard drive. The system should handle improper inputs and prompt the user to give the correct inputs. There is not safety and security requirements.

The computational algorithms are developed based on our team's research on the same topic. Our team will compare and report the simulation results and experimental results, which will be included in our report folder.

#### 2.3.3 Performance
The simulation is associated with huge amount of calculation, it is assumed that the computations are done on a supercomputer. The computation algorithms are parallelized, but it still depends on the hardware of the computer.

#### 2.3.4 Supportability
The project can be expanded in many ways such as adding more shapes of quartz tubes or calculating some properties of the materials. We don't have a plan to have future support or development on this project. However, very likely these expansions will be developed by future physics students as their senior projects.

#### 2.3.5 Implementation
Our system will be coded in the most popular programming language and thus shall be platform independent.

#### 2.3.6 Interface
Only the client software has a user interface. It reads the result file and display the quenching process of the metallic glass.

#### 2.3.7 Packaging
Users can download client software and server are in scripts from our Github repository. They then just need to compile the scripts. A manual will be provided.

#### 2.3.8 Legal
It is going to be an open source project on Github, under GNU General Public License (GPL).

### 2.4 System models

#### 2.4.1 Scenarios
There is only one scenario: a user wants to use the program to simulate heat diffusion of a specific set up using quartz tube quenching. He enters information of the set up and start the simulation. After a while, the program finishes the calculation and allows the user to see the result of the simulation.

#### 2.4.2 Use case model
Before the program does calculation:
A user wants to enter simulation setup information and submit.
After the calculation:
- A user wants to play the video of the simulation.
- A user wants to use a mouse to pick a point to get the temperature of the point.
- A user wants to play or pause the video.
- A user wants to see the graph of temperature at a particular time he chooses.
- A user wants to store data for one simulation in the computer.
- A user wants to read data that was previously stored in the computer.

#### 2.4.3 Object model
The output result file will be in object model. It is static.

#### 2.4.4 Dynamic model
There is no dynamic model in this project.

#### 2.4.5 User interface—navigational paths and screen mock-ups
![Image of interface diagram](../diagrams/interface_model.png)

## 3. Glossary
| Vocabulary   | Definition   |
|:------------:|:------------:|
| Quenching | The cooling process of liquid metal in a quartz tube|
| Diffusion | Energy transfers from one object to another|
| Metallic Glass| Solid alloy that has glassy structure in microscopic level |
