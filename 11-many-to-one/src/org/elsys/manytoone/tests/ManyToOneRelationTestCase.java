package org.elsys.manytoone.tests;

import static org.junit.Assert.*;

import org.elsys.manytoone.ManyToOneRelation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManyToOneRelationTestCase {
	ManyToOneRelation<String, Integer> relation = new ManyToOneRelation<String, Integer>();
	
	@Before
	public void setUp() throws Exception {
		relation.connect("Edno", new Integer(1));
		relation.connect("Parvi", new Integer(1));
		relation.connect("2-1", new Integer(1));
		relation.connect("Vtori", new Integer(2));
		relation.connect("TOni", new Integer(2));
		relation.connect("uyt", new Integer(2));
		relation.connect("TGi", new Integer(3));
		relation.connect("Treti", new Integer(3));
		relation.connect("5-2", new Integer(3));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConnect() {
		assertTrue(relation.connect("Integer1", new Integer(1)));
	}

	@Test
	public void testContainsSource() {
		assertTrue(relation.containsSource("Edno"));
		assertFalse(relation.containsSource("asdf"));
	}

	@Test
	public void testContainsTarget() {
		assertTrue(relation.containsTarget(1));
		assertFalse(relation.containsTarget(4));
	}

	@Test
	public void testGetTarget() {
		assertTrue(relation.getTarget("Vtori").equals(2));
		assertFalse(relation.getTarget("5-2").equals(1));
	}

	@Test
	public void testGetSources() {
		assertTrue(relation.getSources(1).equals());
	}

	@Test
	public void testDisconnectSource() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisconnect() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTargets() {
		fail("Not yet implemented");
	}

}
