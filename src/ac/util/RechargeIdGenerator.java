package ac.util;

import java.util.Random;

public class RechargeIdGenerator {
	 
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
}
