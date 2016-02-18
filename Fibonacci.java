import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fibonacci {

	private final Map<Integer, Long> map;

	public Fibonacci() {
		map = new HashMap<>();
	}

	public Long get(Integer n) {
		Objects.requireNonNull(n);
		if (n < 0) {
			throw new IllegalArgumentException("Number cannot be negative");
		}
		return getHelper(n);
	}

	private Long getHelper(Integer n) {
		if (n == 0) {
			return 0L;
		} else if (n == 1 || n == 2) {
			return 1L;
		} else if (map.containsKey(n)) {
			return map.get(n);
		} else {
			Long result = get(n - 1) + get(n - 2);
			map.put(n, result);
			System.err.println("Value from taken from map at index " + n);
			return result;
		}
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.get(10));
		System.out.println(f.get(6));
	}
}
