//--------------------------------------------
// NAME: Antonio Milev
// CLASS: XIb
// NUMBER: 02
// PROBLEM: #1
// FILE NAME: SVGTurtle.hh
// FILE PURPOSE:
// Describtion of the SVGTurtle class implemented in SVGTurtle.cc
//---------------------------------------------
#ifndef SVGTURTLE_HH_
#define SVGTURTLE_HH_

#include "turtle.hh"

class SVGTurtle: public Turtle {
	std::ostream &out_;

public:
	SVGTurtle(double width, double height, std::ostream& out=std::cout);
	~SVGTurtle();

	Turtle& setup();
	Turtle& moveto(const Point& p);
};

#endif