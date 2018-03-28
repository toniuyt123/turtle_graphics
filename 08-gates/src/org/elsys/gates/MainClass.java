package org.elsys.gates;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Wire[] a = new Wire[8];
		Wire[] b = new Wire[8];
		Wire[] sum = new Wire[8];
		Wire cIn = new Wire("cIn");
		Wire cOut = new Wire("cOut");
		
		for (int i = 0; i < a.length; ++i) {
			a[i] = new Wire("a" + i);
			b[i] = new Wire("b" + i);
			sum[i] = new Wire("sum" + i);
		}
		
		CompositeGate rippleAdd = (CompositeGate)GateFactory.makeRippleCarryAdder(a, b, cIn, sum, cOut);
		
		while(in.hasNext()) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();
						
			for (int i = 0; i < a.length; ++i) {
				int bit = 1 << i;
				a[i].setSignal((bit & num1) != 0);
				b[i].setSignal((bit & num2) != 0);
			}

			rippleAdd.act();
			
			int result = 0;
			for (int i = 0; i < sum.length; ++i) {
				if (sum[i].getSignal()) {
					int bit = 1 << i;
					result = result | bit;
				}
			}
			
			System.out.println(result);
		}
		
		in.close();
	}
}
