public class main {
	public static void main(String [] args) {
		GameInfo Info = new GameInfo(Integer.parseInt(args[0]));
		java.util.Scanner scan = new java.util.Scanner(System.in);
		do {
			System.out.print("What would you like to do? (\"combine\" , \"find\" , \"exit\"): ");
			System.out.println(Info.toString());
			String input = scan.next();
			if (input.equals("combine"))
				Combine(Info);
			else if (input.equals("find"))
				Find(Info);
			else if (input.equals("exit"))
				System.exit(1);
			else
				System.out.println("INVALID. Please try again.");
		} while (true);
	}
	public static void Combine(GameInfo Info) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print("What two elements would you like to combine? (enter one element at a time):\n");
		String elementA = scan.next();
		String elementB = scan.next();
		System.out.println(Info.combine(elementA,elementB) + "\n");		
	}
	public static void Find(GameInfo Info) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print("What element would you like to create?: ");
		System.out.println(Info.find(scan.next()));
	}
/*	public static void Load(GameInfo Info) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print("Which episode would you like to load? (enter a number):\n1 - Episode 1\n2 - Episode 2\n3 - Episode 3\n4 - Episode 4\n5 - Sin vs Virtue\n6 - Save the Princess\n7 - Run Santa Run");
		System.out.println(Info.load(scan.nextInt()));
	}*/
}
