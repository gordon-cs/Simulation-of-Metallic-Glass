/* This is the controller of the server, responding to
 * the user software and start computation
 * created by: Kuo Lu, updated: 12/21/2016
 */

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <math.h>
// #include <string>
#include <vector>
#include "../include/tinyxml2.h"
// #include "sequential.cpp"

using namespace tinyxml2;
using namespace std;

//=============================================================================
//============================= functions =====================================



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

  printf( "infile name %s \n", in_name);

  // read xml file and get necessary information
  vector<string> input_variables;
  vector<double> inputs;

  XMLDocument doc;
  doc.LoadFile( in_name );

  string method = doc.FirstChildElement( "calculation" ) -> Attribute("method");

  double height = stod(doc.FirstChildElement( "calculation" )
    ->FirstChildElement( "tube" )->FirstChildElement( "height" )->GetText());
  input_variables.push_back("height");
  inputs.push_back(height);
  

  // run the method
  // if (method == "sequential") sequential(input_variables, inputs);

  return 0;
}
