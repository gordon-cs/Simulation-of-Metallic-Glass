/* This is the serial version of calculation
 * created by: Kuo Lu, updated: 01/05/2017
 * Note: all length units are in millimeters
 */

#include <iostream>
using namespace std;

// ----------------------------------------- constants
double radius = 7.0;            // radius of the tube
double thickness = 1.0;         // thickness of the tube
double height = 50.0;           // height of the tube
double dr = 0.1;                // infinitesimal width step
double dz = 0.1;                // infinitesimal height step
double dt = 0.0025;             // infinitesimal time step, dr^2 >= 4*dt
double m = height/dz + 1;
double n = radius/dr + 1;
double r = radius/dr;
double mc = 1;
double qc = 0.05;

// ---------------------------------------- functions
int main(int argc, char* argv[])
{
  cout << "Hello World! constants all set! "<< endl;
  return 0;
}
