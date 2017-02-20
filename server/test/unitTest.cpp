/* Unit tests for server
 * created by Kuo Lu
 */

//#include "../controller.cc"
#include "tinyxml2.h"
#include <cassert>
#include <iostream>
#include <vector>

using namespace tinyxml2;
using namespace std;
int gPass = 0;
int gFail = 0;
const char* in_name = "sample_sent_file.xml";


// ======== unit tests for reading xml file ==========
bool readXMLMethod(const char* file_name)
{
  bool pass = false;
  XMLDocument doc;
  doc.LoadFile( file_name );
  string method = doc.FirstChildElement( "calculation" ) 
                  -> Attribute("method");
  if(method == "sequential" || method == "MPI"){
    pass = true;
    gPass ++;
  } 
  else{
    printf("\n[FAIL]Method reading failed...\n\n");
    gFail ++;
  }
  return pass;
}

bool readXMLTimelength(const char* file_name)
{
  bool pass = false;
  XMLDocument doc;
  doc.LoadFile( file_name );
  string length = doc.FirstChildElement( "calculation" ) 
                  -> FirstChildElement( "general")
                  -> FirstChildElement( "time_length") ->GetText();
  if(length == " default "){
    pass = true;
    gPass ++;
  } 
  else{
    printf("\n[FAIL]Time reading failed...\n\n");
    gFail ++;
  }
  return pass;
}

bool readXMLHeight(const char* file_name)
{
  bool pass = false;
  XMLDocument doc;
  doc.LoadFile( file_name );
  double height = stod(doc.FirstChildElement( "calculation" )
    ->FirstChildElement( "tube" )->FirstChildElement( "height" )->GetText());

  if(height == 45){
    pass = true;
    gPass ++;
  } 
  else{
    printf("\n[FAIL]Height reading failed...\n\n");
    gFail ++;
  }
  return pass;
}

bool readXMLTemperature(const char* file_name)
{
  bool pass = false;
  XMLDocument doc;
  doc.LoadFile( file_name );
  string path = doc.FirstChildElement( "calculation" ) 
                  -> FirstChildElement( "material")
                  -> FirstChildElement( "temperature") 
                  -> FirstChildElement("path")->GetText();
  if(path == " temp.csv "){
    pass = true;
    gPass ++;
  } 
  else{
    printf("\n[FAIL]Temperature reading failed...\n\n");
    gFail ++;
  }
  return pass;
}

bool readXMLConductivity(const char* file_name)
{
  bool pass = false;
  XMLDocument doc;
  doc.LoadFile( file_name );
  string path = doc.FirstChildElement( "calculation" ) 
                  -> FirstChildElement( "material")
                  -> FirstChildElement( "conductivity") 
                  -> FirstChildElement("path")->GetText();
  if(path == " //users/someone/somefolder/someproject/conductivity.csv "){
    pass = true;
    gPass ++;
  } 
  else{
    printf("\n[FAIL]Method reading failed...\n\n");
    gFail ++;
  }
  return pass;
}

// ======== main function =======
int main(void)
{
  // run tests
  readXMLMethod(in_name);
  readXMLTimelength(in_name);
  readXMLHeight(in_name);
  readXMLTemperature(in_name);
  readXMLConductivity(in_name);


  printf("Number of test passed: %i\n", gPass);
  printf("Number of test failed: %i\n", gFail);
  return 0;
}
