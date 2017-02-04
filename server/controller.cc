/* This is the controller of the server, responding to
 * the user software and start computation
 * created by: Kuo Lu, updated: 12/21/2016
 */

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <math.h>
#include "src/tinyxml2.h"


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

  tinyxml2::XMLDocument doc;
  doc.LoadFile( in_name );

  const char* height = doc.FirstChildElement( "calculation" )
    ->FirstChildElement( "tube" )->FirstChildElement( "height" )->GetText();
  
  printf( "the height is: %s\n", height );
  
  return 0;
}
