import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			//Declear an automata object
			Automata automata = new Automata();

			//Read transition, starting/finishing state. 
			File fileInput = new File("input.txt");
			if (fileInput.exists()) {
				Scanner scan = new Scanner(fileInput);
				while (scan.hasNextLine()) {
					String data = scan.nextLine();
					if (data.contains("start")) {						 //Check starting state
						automata.setStart(data.charAt(data.length() - 1));
					} else if (data.contains("finish")) { 				//Check finishing state
						ArrayList<Character> finish = new ArrayList<Character>();
						finish.add(data.charAt(data.length() - 1));
						automata.setFinish(finish);
					} else {														//Adding transition
						char [] state = data.toCharArray();
						automata.addTransition(state[0], state[2], state[4]);
					}
				}
				scan.close();													//Shutdown scanner
			}
			
			//Minimizing
			automata.MinimizeAutomata();
			
			//Print minimized DFA to output file
			File fileOutput = new File("output.txt");
			if (fileOutput.exists()) {
				automata.printAutomata(fileOutput.toString());
			} else {
				fileOutput.createNewFile();
				automata.printAutomata(fileOutput.toString());
			}
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}
	}
}
