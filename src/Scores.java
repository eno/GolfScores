import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Scores {
	//final String FILENAME = "ScoreSheet";//

	public Scores() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This function will create a file and write the scores of 18 holes of golf.
	 * in the format of <p></p><code>par player1score player2score player3score player4score</code><p></p>
	 * @param name Identifier of the file to write to.
	 */


	public void generateRandomScoreSheet(String name) {
		Random rand = new Random();
		FileWriter print;

		try {
			print = new FileWriter(new File(name));
			PrintWriter pw = new PrintWriter(print);
			//String sc = rand.nextInt(4)+3+" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1);

			for(int i = 0; i < 18 ; i ++){
				pw.println(rand.nextInt(4)+3+" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1) +" "+ (rand.nextInt(9)+1));
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ioexception in generateRandomScoreSheet()");
		}
		
	}

	/**
	 * This method analyzes the score sheet and declares a winner depending on which player's score was closer to par.
	 * It Would be better with printf for clarity.
	 * @param name Identifier of the file to read from.
	 * @throws FileNotFoundException
	 */
	public void readScoreSheet(String name) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(name));
		int count = 1;
		int p1 = 0,p2 = 0,p3 = 0,p4 = 0,par,parsum=0, hole, p1sum = 0, p2sum = 0,p3sum = 0,p4sum = 0;
		System.out.println("hole#\tpar\tP1 \tP2 \tP3 \tP4 ");
		while(scan.hasNext()){
			hole =count;
			par =scan.nextInt();
			p1 =scan.nextInt();
			p2 =scan.nextInt();
			p3 =scan.nextInt();
			p4 =scan.nextInt();
			p1sum+=p1;
			p2sum+=p2;
			p3sum+=p3;
			p4sum+=p4;
			parsum+=par;
			System.out.println("#" + count + "\t\t" + par + "\t" + p1 + " \t" + p2 + " \t" + p3 + " \t" + p4 + " \t");
			count++;
		}
		System.out.println(" " +"\tpar: "+parsum+"\t"+p1sum+" \t"+p2sum+" \t"+p3sum+" \t"+p4sum+" \t");
		System.out.println();
		int winner = Math.min(Math.min(p1sum, p2sum),Math.min(p3sum, p4sum));
		if (winner == p1sum) System.out.println("P1 wins with "+p1sum+"!");
		else if (winner == p2sum) System.out.println("P2 wins with "+p2sum+"!");
		else if (winner == p3sum) System.out.println("P3 wins with "+p3sum+"!");
		else if (winner == p4sum) System.out.println("P4 wins with "+p4sum+"!");
		//System.out.println("that is ");
		scan.close();
	}
}
