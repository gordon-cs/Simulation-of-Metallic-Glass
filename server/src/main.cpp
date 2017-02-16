/* This is the controller of the server, responding to
 * the user software and start computation
 * created by: Kuo Lu, updated: 12/21/2016
 */

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <math.h>
// #include <string>
#include <array>
#include "tinyxml2.h"
#include "sequential.h"
#include <H5Cpp.h>
#include "default_constants.h"
 
using namespace tinyxml2;
using namespace std;

#define outputfile_name "output.h5"
#define num_of_variables 4

//------------------- assign constants to default values ----------------------
string method;                      // name of the calculation method
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

array<string,num_of_variables> variable_names = { "time_length",
                                                  "radius",
                                                  "thickness",
                                                  "height"};
array<const double,num_of_variables> variable_values = { TIME_LENGTH,
                    RADIUS,
                    THICKNESS,
                    HEIGHT};
// read input file function
void readXMLFile(char* in_name)
{
    XMLDocument doc;
    doc.LoadFile( in_name );
    XMLElement* calcElement = doc.FirstChildElement( "calculation" );
    method =  calcElement -> Attribute("method");
    const char* type;
    for (int i = 0; i < num_of_variables; i++){
      printf("hello from for loop\n");
      // type = doc.FirstChildElement( "calculation" )
      //     ->FirstChildElement(variable_names[i])-> Attribute("method");
      // if(type != const char* ("default") {
      //   variable_values[i] = const_cast<const double>(stod(doc.FirstChildElement( "calculation" )
      //     ->FirstChildElement(variable_names[i])->GetText()));
      // }
    }

    for (int i = 0; i < num_of_variables; i++){
      printf("variable %s has value %f \n",variable_names[i].c_str(),variable_values[i]);
    }
}

// ======================== main function =====================================
int main(int argc, char * argv[])
{
	/* Process command line */
	if ( argc != 2 )
  {
      fprintf( stderr, "usage: %s INPUT_FILE.xml \n", argv[0] );
      return EXIT_FAILURE;
  }
	char* in_name = argv[1];

  printf( "infile name: %s \n", in_name);

  try{
    readXMLFile(in_name);
  }catch(const std::exception& e){
    printf("error\n");
  }

  // Create a file
  H5::H5File* outputfile = new H5::H5File( outputfile_name, H5F_ACC_TRUNC );
  // run the method
  // if (method == "sequential") sequential(output);
  // outputfile.write(output);
  printf("compile finished\n");
  return 0;
}
