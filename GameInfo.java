public class GameInfo {
	private java.util.List<String> elements = new java.util.ArrayList<String>();
	private Object[][] combinations;
	private Combination[] combos;
	private int score;
	public GameInfo(int episode) {
		combos = readFile(load(episode));
		score = 0;
		this.combinations = Combinations.combinations;
	}
	public String lookup(int index) {
		try {
			return elements.get(index);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		} 
	}
	public Combination combine(String elementA, String elementB) {
		Combination toCheck = new Combination(elementA, elementB);
		for (Combination combo : combos) {
			if (combo.equals(toCheck))
				return combo;
		}
		return null;
	}
	public Combination find(String elemToFind) {
		for (int i = 0; i < elements.size(); i++)
			if (elements.get(i).equals(elemToFind))
				return combos[i];
		return null;
	}
	private String load(int episode) {
		String filename = "ElementsList";
		if (episode == 1)
			return filename + "Episode1.txt";
		else if (episode == 2)
			return filename + "Episode2.txt";
		else if (episode == 3)
			return filename + "Episode3.txt";
		else if (episode == 4)
			return filename + "Episode4.txt";
		else if (episode == 5)
			return filename + "SvV.txt";
		else if (episode == 6)
			return filename + "STP.txt";
		else if (episode == 7)
			return filename + "RSR.txt";
		else
			System.out.println("please choose a different episode");
		return null;
	}
	public int getScore() {
		return score;
	}
	public int getMax() {
		return elements.size();
	}
	private Combination[] readFile(String fileName) {
		System.out.println("reading: " + fileName);
		java.util.Scanner scan;
		try {
			scan = new java.util.Scanner(new java.io.File(fileName));
		} catch (java.io.IOException e) {
			return null;
		}
		java.util.List<Combination> toReturn = new java.util.ArrayList<Combination>();
		java.util.regex.Pattern a = java.util.regex.Pattern.compile("\\w+ \\+");
		java.util.regex.Pattern b = java.util.regex.Pattern.compile("\\+ \\w+");
		java.util.regex.Pattern c = java.util.regex.Pattern.compile("= \\w+");
		while (scan.hasNextLine()) {
			String toScan = scan.nextLine();
			java.util.regex.Matcher elA = a.matcher(toScan);
			java.util.regex.Matcher elB = b.matcher(toScan);
			java.util.regex.Matcher elC = c.matcher(toScan);
			while (elA.find() && elB.find() && elC.find()) {
				toReturn.add(new Combination(elA.group().substring(0, (elA.group().length()-2)), elB.group().substring(2), elC.group().substring(2)));
				elements.add(elC.group().substring(2));
			}
		}
		return toReturn.toArray(new Combination[0]);
	}
	private int[][] readCombos(String fileName) {
		return null;
	}
	private int indexOf(String toFind) {
		for (int i = 0; i < elements.size(); i++)
			if (elements.get(i).equals(toFind))
				return i;
		return -1;
	}
	public String toString() {
		for (int i = 0; i < combinations.length; i++)
			for (int j = 0; j < combinations[i].length; j++)
				System.out.println(combinations[i][j]);
		return null;
	}
}
