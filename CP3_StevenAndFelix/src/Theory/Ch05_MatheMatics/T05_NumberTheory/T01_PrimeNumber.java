package Theory.Ch05_MatheMatics.T05_NumberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T01_PrimeNumber {
	public static Scanner scn = new Scanner(System.in);

	static int SieveSize;
	static boolean[] prime;
	static List<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		SieveOfErathosthenes(10000000);
		System.out.printf("%b\n", IsPrime(2147483647));
		System.out.printf("%b\n", IsPrime(136117223861L));

		List<Integer> res = primeFactors(2147483647); // 2147483647 is a prime
		for (int i : res)
			System.out.printf("> %d\n", i);

		res = primeFactors(136117223861L); // 2_large_pfactors_104729*1299709
		for (int i : res)
			System.out.printf("# %d\n", i);

		res = primeFactors(142391208960L); // 2^10*3^4*5*7^4*11*13
		for (int i : res)
			System.out.printf("! %d\n", i);

		int ans = numPf(136117223861L);
		System.out.printf("%d\n", ans);

	}

	private static void SieveOfErathosthenes(int upperbound) {
		SieveSize = upperbound + 1;
		prime = new boolean[SieveSize];

		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // not a prime

		for (long i = 2; i < SieveSize; i++) {
			if (prime[(int) i]) { // if it is true then it is a potential prime.
				for (long j = i * i; j < SieveSize; j += i) {
					prime[(int) j] = false;
				}

				primes.add((int) i);
			}
		}

		// System.out.println(primes);
	}

	private static boolean IsPrime(long n) {
		if (n < SieveSize) { // O(1)_for_small_prime
			return prime[(int) n];
		}

		for (long i = 0; i < primes.size(); i++) { // valid till
													// n<=(last_prime_in_list)^2.
			if ((n % primes.get((int) i)) == 0)
				return false;

		}

		return true;
	}

	private static List<Integer> primeFactors(long n) {
		List<Integer> factors = new ArrayList<Integer>();

		int pf_Idx = 0;
		long pf = primes.get(pf_Idx);

		while (n != 1 && pf * pf <= n) {
			while (n % pf == 0) {
				n /= pf;
				factors.add((int) pf);
			}
			pf = primes.get(++pf_Idx);
		}

		if (n != 1) {
			factors.add((int) n);
		}
		return factors;

	}

	// count no of prime factor of n
	private static int numPf(long n) {
		int ans = 0;
		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {
			while (n % pf == 0) {
				n /= pf;
				ans++;
			}

			pf = primes.get(++pf_idx);
		}

		if (n != 1) {
			ans++;
		}

		return ans;
	}

	// count no of different prime factor of n
	private static int numDiffPf(long n) {
		int ans = 0;
		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {

			if (n % pf == 0) {
				ans++;
			}
			while (n % pf == 0) {
				n /= pf;
			}

			pf = primes.get(++pf_idx);
		}

		if (n != 1) {
			ans++;
		}

		return ans;
	}

	// sum the prime factor of n
	private static int sumPf(long n) {
		int ans = 0;
		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {

			while (n % pf == 0) {
				n /= pf;
				ans += pf;
			}

			pf = primes.get(++pf_idx);
		}

		if (n != 1) {
			ans += n;
		}

		return ans;
	}

	// count no of divisors of n
	private static long numDiv(long n) {
		long ans = 1;

		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {
			long power = 0;
			while (n % pf == 0) {
				power++;
				n /= pf;
			}

			pf = primes.get(++pf_idx);
			ans *= (power + 1); // according to formula.
		}

		if (n != 1) { // (last factor has pow = 1, we add 1 to it)
			ans *= 2;
		}

		return ans;
	}

	// Sum Of divisor of n.
	private static long sunDiv(long n) {
		long ans = 1;

		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {
			long power = 0;
			while (n % pf == 0) {
				power++;
				n /= pf;
			}

			pf = primes.get(++pf_idx);
			ans *= ((Math.pow(pf, power + 1.0) - 1) / pf - 1); // according_to_formula.
		}

		if (n != 1) { // (last factor has pow = 1, we add 1 to it)
			ans *= ((Math.pow(n, 2.0) - 1) / (n - 1));
		}

		return ans;
	}

	private static long EulerPhi(long n) {

		long ans = n;

		int pf_idx = 0;
		long pf = primes.get(pf_idx);

		while (n != 1 && pf * pf <= n) {
			if (n % pf == 0) {
				ans -= ans / pf;
			}

			while (n % pf == 0) {
				n /= pf;
			}

			pf = primes.get(++pf_idx);
		}

		if (n != 1) { // (last factor has pow = 1, we add 1 to it)
			ans -= ans / n;
		}

		return ans;

	}

}
