/* This is the serial version of calculation
 * created by: Kuo Lu, updated: 01/05/2017
 * Note: all length units are in millimeters
 */

#include <iostream>
using namespace std;

// Compute index into single linear array for matrix element (i,j)
#define IDX(i,j,stride) ((i)*(stride)+(j)) // row major (c/c++ ordering)

// constants ------------------------------------------------------------------
// ----------------------------------------------------------------------------
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


// read function --------------------------------------------------------------
// ----------------------------------------------------------------------------
void dumpVector(double* x, int cols){
	for(int i = 0; i < cols; i++) printf("%f ",x[i] );
}


// HDF5 functions -------------------------------------------------------------
// ----------------------------------------------------------------------------

// Display matrix values on standard output
void dumpMatrix(
    double* a,      // in  - address of matrix data
    int rows,       // in  - number of rows in matrix
    int cols,       // in  - number of cols in matrix
    int stride      // in  - row length in memory (assuming C/C++ storage)
    )
{
    for ( int i = 0; i < rows; i++ )
    {
        for ( int j = 0; j < cols; j++ )
        {
          printf( " %8.2f", a[IDX(i,j,stride)] );
        }
        printf( "\n" );
    }
    printf( "\n" );
    fflush( stdout );
}

// Read matrix from HDF5 data file
void readMatrix(char* filename, double* &addr, hsize_t* &dims ){
	hid_t file_id;         // HDF5 id for file
	hid_t dataspace_id;    // HDF5 id for dataspace in file
	hid_t dataset_id;      // HDF5 id for dataset in file
	hid_t memspace_id;     // HDF5 id for dataset in memory
	herr_t status;         // HDF5 return code
	int ndim; 						 // number of dimensions in HDF5 dataset
	const char* path = "/A/value";

	// Open existing HDF5 file
	file_id = H5Fopen( filename, H5F_ACC_RDONLY, H5P_DEFAULT );
	if ( file_id < 0 ) exit( EXIT_FAILURE );

	// Open dataset in file
	dataset_id = H5Dopen( file_id, path, H5P_DEFAULT );
	if ( dataset_id < 0 ) exit( EXIT_FAILURE );

	// Determine dataset parameters
	dataspace_id = H5Dget_space( dataset_id );
	ndim = H5Sget_simple_extent_ndims( dataspace_id );
	dims = new hsize_t [ndim];

	// Get dimensions for dataset
	ndim = H5Sget_simple_extent_dims( dataspace_id, dims, NULL );
	if ( ndim != 2 )
	{
			fprintf( stderr, "Expected dataspace to be 2-dimensional " );
			fprintf( stderr, "but it appears to be %d-dimensional\n", ndim );
			exit( EXIT_FAILURE );
	}

	// Create memory dataspace
	memspace_id = H5Screate_simple( ndim, dims, NULL );
	if ( memspace_id < 0 ) exit( EXIT_FAILURE );

	// Allocate memory for matrix and read data from file
	addr = new double [dims[0] * dims[1]];
	status = H5Dread( dataset_id, H5T_NATIVE_DOUBLE, memspace_id,
										dataspace_id, H5P_DEFAULT, addr );
	CHKERR( status, "H5Dread()" );

	// Close all remaining HDF5 objects
	CHKERR( H5Sclose( memspace_id ), "H5Sclose()" );
	CHKERR( H5Dclose( dataset_id ), "H5Dclose()" );
	CHKERR( H5Sclose( dataspace_id ), "H5Sclose()" );
	CHKERR( H5Fclose( file_id ), "H5Fclose()" );
}

// Functions ------------------------------------------------------------------
// ----------------------------------------------------------------------------
int main(int argc, char* argv[])
{
  cout << "Hello World! constants all set! "<< endl;
  return 0;
}
