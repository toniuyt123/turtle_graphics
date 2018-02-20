#include <iostream>
#include "turtle.hh"
#include "SVGTurtle.hh"
using namespace std;

#define CANVAS_WIDTH_ 1000
#define CANVAS_HEIGHT_ 1000

int main() {
	PSTurtle t(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	Color red(1, 0, 0);
	Point center(CANVAS_WIDTH_ / 2, CANVAS_HEIGHT_ / 2);
	int size = 400;
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

	//drawing the hexagon
	t.forward(size).pencolor(red).pensize(3).left(120);
	for(int i =0;i < 6;i++) {
		t.forward(size).left(60);
	}

	//reset
	t.penup().moveto(center).set_heading(0);
}