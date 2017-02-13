/* To-do list:
 * 1. converting from row major to col major
 * 2. converting to 3-d matrix from 2-d
 *
 * IMPORTANT: Fuctions read binary files using column major
 * since column major is commonly used among scientific softwares
 * such us MATLAB, Fortran, and GNU Octave
 */


#include "read_hdf5.h"

//=============================================================================
//===================== functions to read HDF5 files ==========================

// Check return values from HDF5 routines
#define CHKERR(status,name) if ( status < 0 ) \
    fprintf( stderr, "Error: nonzero status (%d) in %s\n", status, name )

// Compute index into single linear array for matrix element (i,j)
#define IDX(i,j,stride) ((i)*(stride)+(j)) // row major (c/c++ ordering)

// read function
void dumpVector(double* x, int cols){
	for(int i = 0; i < cols; i++) printf("%f ",x[i] );
}

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

// int main(void){return 0;}
