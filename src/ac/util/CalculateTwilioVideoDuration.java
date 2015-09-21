package ac.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ac.dto.TwilioVideoDTO;

public class CalculateTwilioVideoDuration {
	private static final Logger logger = Logger.getLogger(CalculateTwilioVideoDuration.class);
	
	
	
	public long GetVideoDuration(List<TwilioVideoDTO> video) {
		logger.info("Entered GetVideoDuration method of CalculateTwilioVideoDuration");
		long duration=0;
		for(TwilioVideoDTO twil : video){
		/*	Calendar c = Calendar.getInstance();
			c.setTime(new Date(twil.getStart().getTime()));
			Date startDate = c.getTime();
			
			Calendar c1 = Calendar.getInstance();
			c1.setTime(new Date(twil.getEnd().getTime()));
			Date endDate = c1.getTime();*/
			long diff = twil.getEnd().getTime() - twil.getStart().getTime();
			long seconds = (diff)/1000;
			duration = duration + seconds;
		}
        logger.info("Exit GetVideoDuration method of CalculateTwilioVideoDuration");
		return duration;
	}
}
