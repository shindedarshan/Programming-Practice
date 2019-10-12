package sorting;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class SortingBasedOnMultipleVariables {

	public class Movie implements Comparable<Movie>{
		private String name;
		private Date releaseDate;
		private double rating;
		private long revenue;

		public Movie(String name, Date releaseDate, double rating, long revenue) {
			this.name = name;
			this.releaseDate = releaseDate;
			this.rating = rating;
			this.revenue = revenue;
		}

		public String getName() {
			return name;
		}

		public Date getReleaseDate() {
			return releaseDate;
		}

		public double getRating() {
			return rating;
		}

		public long getRevenue() {
			return revenue;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public void setRevenue(long revenue) {
			this.revenue = revenue;
		}

		@Override
		public String toString() {
			return "Movie [name=" + name + ", releaseDate=" + releaseDate + ", rating=" + rating + ", revenue="
					+ revenue + "]";
		}

		@Override
		public int compareTo(Movie o) {
			return this.name.compareTo(o.getName());
		}
	}
	
	public class ByDate implements Comparator<Movie> {
		@Override
		public int compare(Movie o1, Movie o2) {
			if (o1.getReleaseDate().before(o2.getReleaseDate())) return -1;
			else if (o2.getReleaseDate().before(o1.getReleaseDate())) return 1;
			else return 0;
		}
	}
	
	public class ByRating implements Comparator<Movie> {
		@Override
		public int compare(Movie o1, Movie o2) {
			if (o1.getRating() < o2.getRating()) return -1;
			else if (o2.getRating() < o1.getRating()) return 1;
			else return 0;
		}
	}
	
	public class ByRevenue implements Comparator<Movie> {
		@Override
		public int compare(Movie o1, Movie o2) {
			if (o1.getRevenue() < o2.getRevenue()) return -1;
			else if (o2.getRevenue() < o1.getRevenue()) return 1;
			else return 0;
		}
	}
	
	private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	private static double randBetween(double start, double end) {
        return start + Math.round(Math.random() * (end - start));
    }
	
	private static String randString(int len) {
		byte[] array = new byte[len];
	    new Random().nextBytes(array);
	    return new String(array, Charset.forName("UTF-8"));
	}
	
	private static void printList(List<Movie> l) {
		for(Movie m : l)
			System.out.println(m);
	}
	
	public static void main(String[] args) {
		List<Movie> arr = new ArrayList<Movie>();
		for (int i = 0; i < 5; i++) {
			GregorianCalendar gc = new GregorianCalendar();
	        int year = randBetween(1900, 2010);
	        gc.set(Calendar.YEAR, year);
	        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
	        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
	        Date d = gc.getTime();
			String name = randString(randBetween(7, 15)); 
			double rating = randBetween(0.0, 5.0);
			long revenue = randBetween(10000, 99999);
			Movie m = new SortingBasedOnMultipleVariables().new Movie(name, d, rating, revenue);
			arr.add(m);
		}
		
		System.out.println("Original list");
		printList(arr);
		
		System.out.println("Sort by name");
		Collections.sort(arr);
		printList(arr);
		
		System.out.println("Sort by relaease date");
		Collections.sort(arr, new SortingBasedOnMultipleVariables().new ByDate());
		printList(arr);

		System.out.println("Sort by rating");
		Collections.sort(arr, new SortingBasedOnMultipleVariables().new ByRating());
		printList(arr);

		System.out.println("Sort by revenue");
		Collections.sort(arr, new SortingBasedOnMultipleVariables().new ByRevenue());
		printList(arr);
	}

}
