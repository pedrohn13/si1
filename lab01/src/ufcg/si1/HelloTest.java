package ufcg.si1;

import junit.framework.Assert;

import org.junit.Test;

public class HelloTest {
	@Test
	public void test() {
		Assert.assertEquals("Hello, Git!", Hello.xpto());
	}
}
