package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public abstract class GateFactory {

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xorGate = new CompositeGate(name);

		xorGate.addInput(in1);
		xorGate.addInput(in2);
		xorGate.addOutput(out);

		Wire a = new Wire("xorA");
		Wire b = new Wire("xorB");
		Wire c = new Wire("xorC");

		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate1 = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate2 = new AndGate(a, c, out);

		xorGate.addGate(orGate);
		xorGate.addGate(andGate1);
		xorGate.addGate(notGate);
		xorGate.addGate(andGate2);

		return xorGate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "XorGate");
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c, String name) {
		CompositeGate halfAdd = new CompositeGate(name);
		halfAdd.addInput(a);
		halfAdd.addInput(b);
		halfAdd.addOutput(s);
		halfAdd.addOutput(c);
		
		halfAdd.addGate(makeXorGate(a, b, s, "HalfAdderXor"));
		halfAdd.addGate(new AndGate(a, b, c, "HalfAdderAnd"));
		
		return halfAdd;
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c) {
		return makeHalfAdder(a, b, s, c, "HalfAdder");
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut, String name) {
		CompositeGate fullAdd = new CompositeGate(name);
		fullAdd.addInput(a);
		fullAdd.addInput(b);
		fullAdd.addInput(cIn);
		fullAdd.addOutput(sum);
		fullAdd.addOutput(cOut);
		
		Wire halfAdd1OutS = new Wire("halfAdd1OutS");
		Wire halfAdd1OutC = new Wire("halfAdd1OutC");
		Wire halfAdd2OutC = new Wire("halfAdd2Out");
		
		
		fullAdd.addGate(makeHalfAdder(a, b, halfAdd1OutS, halfAdd1OutC, "FullAdderhalf1"));
		fullAdd.addGate(makeHalfAdder(halfAdd1OutS, cIn, sum, halfAdd2OutC, "FullAdderhalf2"));
		fullAdd.addGate(new OrGate(halfAdd1OutC, halfAdd2OutC, cOut, "FullAdderOr"));
		
		return fullAdd;
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut) {
		return makeFullAdder(a, b, cIn, sum, cOut, "FullAdder");
	}
	
	public static Gate makeRippleCarryAdder(Wire a[], Wire b[], Wire cIn, Wire sum[], Wire cOut) {
		assert a.length == b.length;
		assert a.length == sum.length;
		int count = a.length;
		
		CompositeGate rippleAdder = new CompositeGate("rippleAdder");
		private List<Wire> cIns = new ArrayList<Wire>();
		
		
		for(int i = 0;i < count;i++) {
			rippleAdder.addGate(makeFullAdder(a[i], b[i], halfAdd1OutS, halfAdd1OutC, "FullAdderhalf1"));
		}
		
		return null;
	}
}
