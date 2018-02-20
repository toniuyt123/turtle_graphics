#include "SVGTurtle.hh"
#include <cassert>
#include <iostream>

using namespace std;

SVGTurtle::SVGTurtle(double width, double height, ostream& out) :
		Turtle(width, height), out_(out) {
}

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