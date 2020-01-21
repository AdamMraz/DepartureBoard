import com.skillbox.airport.Airport;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Source {
    final static SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("HH:mm");

    public static void main (String[] args) {
        Airport airport = Airport.getInstance();
        GregorianCalendar thisDate = new GregorianCalendar();
        GregorianCalendar thisDatePlus2 = new GregorianCalendar();
        thisDatePlus2.set(Calendar.HOUR_OF_DAY, (thisDate.get(Calendar.HOUR_OF_DAY) + 2));
        airport.getTerminals()
                .forEach(t -> t.getFlights()
                        .stream()
                        .filter(f ->  (thisDate.getTimeInMillis() <= f.getDate().getTime())
                                && (f.getDate().getTime() < thisDatePlus2.getTimeInMillis()))
                        .forEach(f -> System.out.println(HOUR_FORMAT.format(f.getDate()) + " " + f.getAircraft())));
    }
}
