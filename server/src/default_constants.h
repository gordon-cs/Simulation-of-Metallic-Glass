/* This class contains all default constants for simulation
 * created by Kuo Lu. Updated: 01/13/2017
 * Note: all length units are in millimeters
 */

 // the header guard
 #ifndef DEFAULT_CONSTANTS_H
 #define DEFAULT_CONSTANTS_H

 //---------------------------- constants -------------------------------------
 const double RADIUS = 7.0;            // radius of the tube
 const double THICKNESS = 1.0;         // thickness of the tube
 const double HEIGHT = 50.0;           // height of the tube
 const double DR = 0.1;                // infinitesimal width step
 const double DZ = 0.1;                // infinitesimal height step
 const double DT = 0.0025;             // infinitesimal time step, dr^2 >= 4*dt
 const double M = HEIGHT/DZ + 1;
 const double N = RADIUS/DR + 1;
 const double R = RADIUS/DR;
 const double MC = 1;
 const double QC = 0.05;

#endif
