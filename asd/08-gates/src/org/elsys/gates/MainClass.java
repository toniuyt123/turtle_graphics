package org.elsys.gates;

import java.util.Scanner;
import org.elsys.gates.GateFactory.makeRippleCarryAdder;

public class MainClass {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Wire[] a = new Wire[8];
		Wire[] b = new Wire[8];
		Wire[] sum = new Wire[8];
		
		while(in.hasNext()) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			
			
			for (int i = 0; i < a.length; ++i) {
				int bit = 1 << i;
				a[i].setSignal((bit & num1) != 0);
				b[i].setSignal((bit & num2) != 0);
			}

			CompositeGate rippleAdd = (CompositeGate)makeRippleCarryAdder(a, b, new Wire("cIn"), sum, new Wire("cOut"));
			
			int result = 0;
			for (int i = 0; i < sum.length; ++i) {
				if (sum[i].getSignal()) {
					int bit = 1 << i;
					result = result | bit;
				}
			}
			
			System.out.println(result);
		}
	}
}
