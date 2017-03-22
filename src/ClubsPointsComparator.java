import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class ClubsPointsComparator implements Comparator<FootballClub>{

	public int compare(FootballClub club1, FootballClub club2) {
		// TODO Auto-generated method stub
		
		return club2.getPoints() - club1.getPoints();
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<FootballClub> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<FootballClub> thenComparing(
			Comparator<? super FootballClub> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<FootballClub> thenComparing(
			Function<? super FootballClub, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<FootballClub> thenComparing(
			Function<? super FootballClub, ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<FootballClub> thenComparingDouble(
			ToDoubleFunction<? super FootballClub> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<FootballClub> thenComparingInt(
			ToIntFunction<? super FootballClub> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<FootballClub> thenComparingLong(
			ToLongFunction<? super FootballClub> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}