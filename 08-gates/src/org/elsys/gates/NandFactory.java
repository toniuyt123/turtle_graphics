package org.elsys.gates;

public abstract class NandFactory {

	public static Gate makeNotGate(Wire in, Wire out, String name) {
		return new NandGate(in, in, out, name);
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate and = new CompositeGate(name);
		and.addInput(in1);
		and.addInput(in2);
		and.addOutput(out);
		
		Wire connection = new Wire("NandAndConn");
		and.addGate(new NandGate(in1, in2, connection));
		and.addGate(new NandGate(connection, connection, out));
		
		return and;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate or = new CompositeGate(name);
		or.addInput(in1);
		or.addInput(in2);
		or.addOutput(out);
		
		Wire nand1Out = new Wire("Nand1Out");
		Wire nand2Out = new Wire("Nand2Out");
		
		or.addGate(new NandGate(in1, in1, nand1Out));
		or.addGate(new NandGate(in2, in2, nand2Out));
		or.addGate(new NandGate(nand1Out, nand2Out, out));
		
		return or;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xor = new CompositeGate(name);
		xor.addInput(in1);
		xor.addInput(in2);
		xor.addOutput(out);
		
		Wire nand1Out = new Wire("Nand1Out");
		Wire nand2Out = new Wire("Nand2Out");
		Wire nand3Out = new Wire("Nand3Out");
		
		xor.addGate(new NandGate(in1, in2, nand1Out));
		xor.addGate(new NandGate(in1, nand1Out, nand2Out));
		xor.addGate(new NandGate(nand1Out, in2, nand3Out));
		xor.addGate(new NandGate(nand2Out, nand3Out, out));
		
		return xor;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}
