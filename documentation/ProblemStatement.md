Project Title: Computational Modeling of Quartz Tube Quenching of Metallic Glasses

Students: Kuo Lu and Chris Qiao

Client: Dr. David Lee, Physics Department of Gordon College

Departmental Supervisor: Dr. Jonathan Senning

Problem Statement:

Researchers in the field of metallic glasses have developed a standard method for comparing the ease with which a metal alloy forms an amorphous solid (a “metallic glass”) when cooled rapidly from the melt (“rapid quenching” or “rapid solidification”), typically by submersing and stirring the tube in water. In this method, the molten alloy is melted in quartz tubes of varying inner diameters with wall thicknesses of either 1 mm or 0.5 mm. The maximum diameter at which the alloy retains its glassy structure in the middle of the quenched sample is referred to as the alloy’s glass-forming ability. For example, an alloy that is fully amorphous when quenched from a 6 mm diameter quartz tube with 0.5 mm wall thickness would be called a “6 mm glass”. The larger the diameter capable of retaining an amorphous structure, the better the glass-forming ability. Clearly, the critical cooling rate (the rate at which a material must be cooled to form a glass) is found at the center of the sample in this geometry. This project solves the two-dimensional heat flow equation for this geometry and takes into account conduction and radiation in order to model this “quartz tube quench” process.

Different combinations of alloys have different maximum thickness while staying pure glass. Yet finding the maximum thickness for each new combination can be tedious: trying tubes with small radius, repeatedly doing the same experiment until finding crystal at the center. And our mission is to make software that simulates this experimental process and offer researchers a good estimation of the maximum thickness is for new alloys.
As a physics research project, on the other hand, understanding the real process is challenging. Heat transfers via two main ways in this specific scenario: radiation heat transfer and heat conduction. But there are many unknown elements in it, for instance, conductivity varies as temperature changes, and the reservoir doesn’t have a static temperature, and more. So we will start with basic physics and add more considerations, like assuming conductivity as constant and then set it vary in the next step, as we go in order to increase accuracy.

We are planning to make multi-platform software: server on a physics cluster for computation, and client-end software to send request and receive data file. A user can use client software to send initial conditions to the server. After the server finishes computations, it sends back the data file. The data file consists of hundreds of matrices with each one representing temperatures at 2-D locations at a specific time. The user can then use software to analyze data, for instance, show temperature difference between two different points at the same time on the graph, or show a graph of temperature vs. time at one specific position.
