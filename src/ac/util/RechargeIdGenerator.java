package ac.util;

import java.util.Random;

public class RechargeIdGenerator {
	 
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	
	public int vergen(){
		    Random r = new Random( System.currentTimeMillis() );
		    return (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		
	}
}
