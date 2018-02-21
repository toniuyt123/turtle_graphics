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