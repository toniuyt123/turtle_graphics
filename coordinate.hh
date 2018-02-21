//--------------------------------------------
// NAME: Antonio Milev
// CLASS: XIb
// NUMBER: 02
// PROBLEM: #1
// FILE NAME: coordinate.hh
// FILE PURPOSE:
// Describtion of the Coordinate, Hexaon and Star class. Coordinate is the superclass
// of the other two. It;s used to draw the axis. The virtual function draw is the one 
// that the other classes use to draw their shapes
//---------------------------------------------
#ifndef COORDINATE_HH_
#define COORDINATE_HH_

#include <string.h>
#include "turtle.hh"
#include "SVGTurtle.hh"

class Coordinate {
	Point center_;
protected:
	Turtle* turtle_;
public:
	Coordinate(Turtle* t);

	void reset();
	void draw_axis();

	virtual void draw() = 0;
};

class Hexagon : public Coordinate{
	int side_;
public:
	Hexagon(Turtle* t, int side);

	void draw();
};

class Star : public Coordinate {
	int side_;
public:
	Star(Turtle* t, int side);

	void draw();
};

#endif