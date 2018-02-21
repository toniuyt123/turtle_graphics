//--------------------------------------------
// NAME: Antonio Milev
// CLASS: XIb
// NUMBER: 02
// PROBLEM: #1
// FILE NAME: SVGTurtle.cc
// FILE PURPOSE:
// Implementation of the SVGTurtle class described in SVGTurtle.hh
//---------------------------------------------
#include "SVGTurtle.hh"
#include <cassert>
#include <iostream>

using namespace std;

SVGTurtle::SVGTurtle(double width, double height, ostream& out) :
		Turtle(width, height), out_(out) {
}

//--------------------------------------------
// FUNCTION: setup
// Sets up an svg document ready to be used by our turtle
// PARAMETERS:
//----------------------------------------------
Turtle& SVGTurtle::setup() {
	out_ << "<html>" << endl;
	out_ << "<body>" << endl;
	out_ << endl;
	out_ << "<h1> SVG Turtle Graphics</h1>" << endl;
	out_ << endl;
	out_ << "<svg width=\"" << get_width() << "\" height=\"" << get_height() << "\">" << endl;
	Turtle::setup();

	return *this;
}

SVGTurtle::~SVGTurtle() {
	out_ << "</svg>" << endl;
	out_ << endl;
	out_ << "</body>" << endl;
	out_ << "</html>" << endl;
}

//--------------------------------------------
// FUNCTION: moveto
// Depending on whether the pen is down or not
// the turtle uses svg line or empty path to
// move to the given position.
// PARAMETERS:
// Point& p - the point to wich we must move
//----------------------------------------------
Turtle& SVGTurtle::moveto(const Point& p) {
	assert(is_setup());
	assert(inside(p));

	if (is_pendown()) {
		out_ << "\t<line x1=\"" << get_pos().get_x() << "\" y1=\"" << get_pos().get_y() << 
			"\" x2=\"" << p.get_x() << "\" y2=\"" << p.get_y() << "\"";
		out_ << " style=\"stroke:rgb(" << get_color().red() * 255 << "," << get_color().green() * 255 <<
			"," << get_color().blue() * 255 << ");stroke-width:" << get_pensize() << "\" />" << endl;
	} else {
		out_ << "\t<path d=\"M" << get_pos().get_x() << " " << get_pos().get_y() << "\" />" << std::endl;
	}
	Turtle::moveto(p);
	return *this;
}