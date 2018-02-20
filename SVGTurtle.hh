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