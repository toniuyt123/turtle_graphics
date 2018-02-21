//--------------------------------------------
// NAME: Antonio Milev
// CLASS: XIb
// NUMBER: 02
// PROBLEM: #1
// FILE NAME: sierpinski.cc
// FILE PURPOSE:
// Draws a sierpinski curve in the given order and
// format - svg or eps
//---------------------------------------------
#include <iostream>
#include <string>
#include <cstdlib>
#include <cassert>
#include <cmath>
#include "turtle.hh"
#include "SVGTurtle.hh"
using namespace std;

#define CANVAS_WIDTH_ 2048
#define CANVAS_HEIGHT_ 2048

class Sierpinski {
	Turtle& turtle_;
	double side_;
	double diag_;

public:
	Sierpinski(Turtle& t) 
		: turtle_(t), side_(t.get_width() / 4),
		diag_(sqrt((side_ * side_) / 2)) {}

	
	//--------------------------------------------
	// FUNCTION: draw_a
	// Draws 1/4 of the curve (upper quarter)
	// PARAMETERS:
	// order - the order of the part that is needed to be drawn
	//----------------------------------------------
	void draw_a(int order) {
		assert(order >= 0 && order <= 7);
		if(order > 0){
			order--;
			draw_a(order);
			turtle_.set_heading(45).forward(diag_);
			draw_b(order);
			turtle_.set_heading(0).forward(side_);
			draw_d(order);
			turtle_.set_heading(-45).forward(diag_);
			draw_a(order);
		}
	}

	//--------------------------------------------
	// FUNCTION: draw_b
	// Draws 1/4 of the curve (right quarter)
	// PARAMETERS:
	// order - the order of the part that is needed to be drawn
	//----------------------------------------------
	void draw_b(int order) {
		assert(order >= 0 && order <= 7);
		if(order > 0){
			order--;
			draw_b(order);
			turtle_.set_heading(135).forward(diag_);
			draw_c(order);
			turtle_.set_heading(90).forward(side_);
			draw_a(order);
			turtle_.set_heading(45).forward(diag_);
			draw_b(order);
		}
	}

	//--------------------------------------------
	// FUNCTION: draw_c
	// Draws 1/4 of the curve (lower quarter)
	// PARAMETERS:
	// order - the order of the part that is needed to be drawn
	//----------------------------------------------
	void draw_c(int order) {
		assert(order >= 0 && order <= 7);
		if(order > 0){
			order--;
			draw_c(order);
			turtle_.set_heading(-135).forward(diag_);
			draw_d(order);
			turtle_.set_heading(180).forward(side_);
			draw_b(order);
			turtle_.set_heading(135).forward(diag_);
			draw_c(order);
		}
	}

	//--------------------------------------------
	// FUNCTION: draw_d
	// Draws 1/4 of the curve (left quarter)
	// PARAMETERS:
	// order - the order of the part that is needed to be drawn
	//----------------------------------------------
	void draw_d(int order) {
		assert(order >= 0 && order <= 7);
		if(order > 0){
			order--;
			draw_d(order);
			turtle_.set_heading(-45).forward(diag_);
			draw_a(order);
			turtle_.set_heading(-90).forward(side_);
			draw_c(order);
			turtle_.set_heading(-135).forward(diag_);
			draw_d(order);
		}
	}

	//--------------------------------------------
	// FUNCTION: draw_a
	// Draws the whole sierpinski curve in a recursive way.
	// Calling all the qarters and connecting them.
	// Each quarter calls itsself and the other ones in such a way that 
	// the curve arranges correctly in higher orders.
	// PARAMETERS:
	// order - the order of the curve
	//----------------------------------------------
	void draw(int order) {
		assert(order >= 0 && order <= 7);
		calc_side(order);
		turtle_.moveto(Point(0, 0)).forward(side_).left(90).forward(side_ / 2).pendown();
		draw_a(order);
		turtle_.set_heading(45).forward(diag_);
		draw_b(order);
		turtle_.set_heading(135).forward(diag_);
		draw_c(order);
		turtle_.set_heading(-135).forward(diag_);
		draw_d(order);
		turtle_.set_heading(-45).forward(diag_);
	}

	void calc_side(int order) {
		if(order != 1) {
			side_ = turtle_.get_width() / (4 * pow(2, (order - 1)));
			diag_ = sqrt((side_ * side_) / 2);
		}
	}
};

int main(int argc, char* argv[]) {
	int order = atoi(argv[2]);
	string type = argv[1];
	Turtle* t;
	if(type == "svg") {
		t = new SVGTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	} else if(type == "eps") {
		t = new PSTurtle(CANVAS_WIDTH_, CANVAS_HEIGHT_);
	}
	t.setup();
	Sierpinski s(t);
	s.draw(order);
	delete t;

	return 0;
}