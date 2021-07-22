package controller.Calculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AgeCalculator {

    public static int calculateAge(LocalDate date) {
    	LocalDate currentDate = LocalDate.now();
    	System.out.println("current date: "+currentDate);
    	System.out.println("date of birth: "+date);
    	
    	Period period = Period.between(date, currentDate);
    	
    	return period.getYears();
    	
//    	return 3;
    	
//        if ((date != null) && (currentDate != null)) {
//            return Period.between(date, currentDate).getYears();
//        } else {
//            return 0;
//        }
    }
}
