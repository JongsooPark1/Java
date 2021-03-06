import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTenTest {
	
	@Test
	public void makeThirdScroeMarkTestWhenValueNormal() {
		FrameTen FrameTen = new FrameTen(0);
		FrameTen.bowl(1);
		FrameTen.bowl(9);
		FrameTen.bowl(4);
		assertEquals(" 1|/|4|", FrameTen.makeThirdScoreMark());
	}
	
	@Test
	public void makeThirdScroeMarkTestWhenValue10() {
		FrameTen FrameTen = new FrameTen(0);
		FrameTen.bowl(10);
		FrameTen.bowl(10);
		FrameTen.bowl(10);
		assertEquals(" X|X|X|", FrameTen.makeThirdScoreMark());
	}

	@Test
	public void isEndedTestWhenValueSize3() {
		FrameTen FrameTen = new FrameTen(0);
		FrameTen.bowl(10);
		FrameTen.bowl(7);
		FrameTen.bowl(3);
		assertEquals(true, FrameTen.isEnded());
	}
}
