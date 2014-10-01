package com.dotloop.test;

import com.dotloop.writer.AgentItemWriter;

import junit.framework.TestCase;

public class ExampleItemWriterTests extends TestCase {

	private AgentItemWriter writer = new AgentItemWriter();
	
	public void testWrite() throws Exception {
		writer.write(null); // nothing bad happens
	}

}
