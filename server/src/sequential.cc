/* This is the serial version of calculation
 * created by: Kuo Lu
 * updated: 01/05/2017
 */

#include <stdio.h>
#include <cstdlib>
#include "read_hdf5.h"
#include "default_constants.h"
using namespace std;

//------------------- assign constants to default values ----------------------

double radius = RADIUS;             // radius of the tube
double thickness = THICKNESS;       // thickness of the tube
double height = HEIGHT;             // height of the tube
double dr = DR;                     // infinitesimal width step
double dz = DZ;                     // infinitesimal height step
double dt = DT;                     // infinitesimal time step, dr^2 >= 4*dt
double m = M;
double n = N;
double r = R;
double mc = MC;
double qc = QC;

//=============================================================================
//================== Sequential calculation functions =========================

void initialize_temp()
{

}

//----------------------------- Main Function ---------------------------------

int main(int argc, char* argv[])
{
  printf("radius is %f mm\nthickness is %f mm\n", radius, qc);
  return 0;
}
