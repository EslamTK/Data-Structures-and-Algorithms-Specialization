package Week4;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro2 {
	static ArrayList<String>[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt(), n = scan.nextInt();
		arr = new ArrayList[m];
		String command, s;
		for (int i = 0; i < n; i++) {
			command = scan.next();
			switch (command) {
			case "add":
				s = scan.next();
				addString(s, m);
				break;
			case "find":
				s = scan.next();
				findString(s, m);
				break;
			case "del":
				s = scan.next();
				delString(s, m);
				break;
			default:
				int index = scan.nextInt();
                checkList(index);
				break;
			}
		}
	}

	private static long getHashIndex(String s) {
		int x = 263;
		long p = 1000000007;
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			hash *= x;
			hash += (int) s.charAt(i);
			if (hash > p) hash %= p;
		}
		return hash;
	}

	private static void addString(String s, int m) {
		int index = (int) (getHashIndex(s) % m);
		if (arr[index] == null) {
			arr[index] = new ArrayList<>();
			arr[index].add(s);
		} else {
			for (int i = arr[index].size() - 1; i >= 0; i--) {
				if (arr[index].get(i)!=null && arr[index].get(i).equals(s))
					return;
			}
			arr[index].add(s);
		}
	}

	private static void delString(String s, int m) {
		int index = (int) (getHashIndex(s) % m);
		if (arr[index] == null)
			return;
		else {
			for (int i = arr[index].size() - 1; i >= 0; i--) {
				if (arr[index].get(i)!=null && arr[index].get(i).equals(s)) {
					arr[index].set(i, null);
					return;
				}
			}
		}
	}

	private static void findString(String s, int m) {
		int index = (int) (getHashIndex(s) % m);
		if (arr[index] == null) {
			System.out.println("no");
		} else {
			for (int i = arr[index].size() - 1; i >= 0; i--) {
				if (arr[index].get(i)!=null && arr[index].get(i).equals(s)) {
					System.out.println("yes");
					return;
				}
			}
			System.out.println("no");
		}
	}

	private static void checkList(int index) {
		
		if (arr[index] == null) {
			System.out.println();
		} else {
			for (int i = arr[index].size() - 1; i >= 0; i--) {
				if (arr[index].get(i) != null) {
					System.out.print(arr[index].get(i) + " ");
				}
			}
			System.out.println();
		}
	}
}
