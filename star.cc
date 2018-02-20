#include <iostream>
#include "turtle.hh"
#include "SVGTurtle.hh"
using namespace std;

#define CANVAS_WIDTH_ 1000
#define CANVAS_HEIGHT_ 1000

int main() {
	SVGTurtle t(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	Color green(0, 1, 0);
	Point center(CANVAS_WIDTH_ / 2, CANVAS_HEIGHT_ / 2);
	int size = 200;
	t.setup().pendown();
	
	//drawing the coordinate system
	for(int i = 0;i < 4;i++) {
		if(i % 2 == 0) {
			t.forward(CANVAS_WIDTH_ / 2);
		} else {
			t.forward(CANVAS_HEIGHT_ / 2);
		}
		t.moveto(center).left(90);
	}

	//drawing the star
	t.forward(size).pencolor(green).pensize(3).left(60);
	for(int i =0;i < 6;i++) {
		t.forward(size).left(120).forward(size).right(60);
	}

	//reset
	t.penup().moveto(center).set_heading(0);
}