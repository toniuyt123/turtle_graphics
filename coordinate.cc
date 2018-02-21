//--------------------------------------------
// NAME: Antonio Milev
// CLASS: XIb
// NUMBER: 02
// PROBLEM: #1
// FILE NAME: coordinate.cc
// FILE PURPOSE:
// Implementation of the Coordinate class. The superclass of the Star and Hexagon shapes(Also implemented here).
// It's used to draw the axis and have basic oepration like reseting the turtle position
//---------------------------------------------
#include "SVGTurtle.hh"
#include "turtle.hh"
#include "coordinate.hh"
#include <cassert>
#include <iostream>

using namespace std;

Coordinate::Coordinate(Turtle* t) 
	: turtle_(t), center_(Point(t->get_width() / 2, t->get_height() / 2)) {}

//Coordinate::~Coordinate() 

void Coordinate::reset() {
	turtle_->moveto(center_).set_heading(0);
}

//--------------------------------------------
// FUNCTION: draw_axis
// Draws axis on the plane spreading out to the end
// of the canvas
// PARAMETERS:
//----------------------------------------------
void Coordinate::draw_axis() {
	reset();
	for(int i = 0;i < 4;i++) {
		if(i % 2 == 0) {
			turtle_->forward(turtle_->get_width() / 2);
		} else {
			turtle_->forward(turtle_->get_height() / 2);
		}
		turtle_->moveto(center_).left(90);
	}
	reset();
}

Hexagon::Hexagon(Turtle* t, int side) 
	: side_(side), Coordinate(t) {}

void Hexagon::draw() {
	turtle_->penup().forward(side_).left(120).pendown();
	for(int i =0;i < 6;i++) {
		turtle_->forward(side_).left(60);
	}
}

Star::Star(Turtle* t, int side)
	: side_(side), Coordinate(t) {}

void Star::draw() {
	turtle_->penup().forward(side_).left(60).pendown();
	for(int i =0;i < 6;i++) {
		turtle_->forward(side_).left(120).forward(side_).right(60);
	}
}