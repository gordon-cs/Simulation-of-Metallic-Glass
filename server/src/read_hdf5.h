/*
 * hdf5 functions borrowed from Dr. Senning
 */
// the header guard.
#ifndef READ_HDF5_H
#define READ_HDF5_H

#include <hdf5.h>

void dumpVector(double* x, int cols);
void dumpMatrix(
    double* a,      // in  - address of matrix data
    int rows,       // in  - number of rows in matrix
    int cols,       // in  - number of cols in matrix
    int stride);    // in  - row length in memory (assuming C/C++ storage)

// Read matrix from HDF5 data file
void readMatrix(char* filename, double* &addr, hsize_t* &dims );

#endif
