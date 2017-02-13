# Makefile for sequential.cc compilation
# created by: Kuo Lu, Updated on: 01/13/2017

# define variables
# CC=g++
# OBJECTS = sequential.o read_hdf5.o

# sequential: $(OBJECTS)
# 	$(CC) -o sequential $(OBJECTS) -lhdf5

# sequential.o : read_hdf5.h default_constants.h
# read_hdf5.o : read_hdf5.h

# .PHONY : clean
# clean:
# 	rm sequential $(OBJECTS)

all: controller staticlib unitTest

rebuild: clean all

controller: controller.cc src/libtinyxml2.a

unitTest: unitTest.cc src/libtinyxml2.a

.PHONY : clean
clean:
	$(RM) src/*.a src/*.o controller unitTest

test: clean unitTest
	./unitTest

staticlib: src/libtinyxml2.a

src/libtinyxml2.a: src/tinyxml2.o
	$(AR) $(ARFLAGS)s $@ $^
	
tinyxml2.o: src/tinyxml2.cpp src/tinyxml2.h