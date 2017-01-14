# created by: Kuo Lu, Updated on: 01/13/2017
CC=g++
objects = sequential.o read_hdf5.o

sequential: $(objects)
	$(CC) -o sequential $(objects) -lhdf5

sequential.o : read_hdf5.h default_constants.h
read_hdf5.o : read_hdf5.h

.PHONY : clean
clean:
	rm sequential $(objects)
