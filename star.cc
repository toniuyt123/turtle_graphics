#include <iostream>
#include "turtle.hh"
#include "SVGTurtle.hh"
#include "coordinate.hh"
using namespace std;

#define CANVAS_WIDTH_ 1000
#define CANVAS_HEIGHT_ 1000

int main(int argc, char* argv[]) {
	Color green(0, 1, 0);
	string type = argv[1];
	Turtle *t;
	if(type == "svg") {
		t = new SVGTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	} else if(type == "eps") {
		t = new PSTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	}
	t->setup().pendown();
	Star st(t, 200);
	st.draw_axis();
	t->pencolor(green).pensize(3);
	st.draw();
	delete t;

	return 0;
}