#include <iostream>
#include "turtle.hh"
#include "SVGTurtle.hh"
#include "coordinate.hh"
using namespace std;

#define CANVAS_WIDTH_ 1000
#define CANVAS_HEIGHT_ 1000

int main(int argc, char* argv[]) {
	Color red(1, 0, 0);
	string type = argv[1];
	Turtle *t;
	if(type == "svg") {
		t = new SVGTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	} else if(type == "eps") {
		t = new PSTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	}
	t->setup().pendown();
	Hexagon hex(t, 400);
	hex.draw_axis();
	t->pencolor(red).pensize(3);
	hex.draw();
	delete t;

	return 0;
}