import java.io.*;

import java.util.*;

public class GoodieDilemma{

	public static void main(String[] args) throws Exception	{
		FileInputStream ip = new FileInputStream("Input_TestCase_3.txt");

		Scanner sc = new Scanner(ip);

		int numberOfEmployees = Integer.parseInt(sc.nextLine().split(": ")[1]);

		sc.nextLine();
		sc.nextLine();
		sc.nextLine();

		ArrayList<Item> goodiesItems = new ArrayList<Item>();

		while(sc.hasNextLine()){

			String currentIP[] = sc.nextLine().split(": ");

			goodiesItems.add(new Item(currentIP[0], Integer.parseInt(currentIP[1])));

		}

		sc.close();

		Collections.sort(goodiesItems, new Comparator<Item>(){

			public int compare(Item a, Item b){

				return a.price - b.price ;
			}
		});

		int m = goodiesItems.size();

		int minDifference = goodiesItems.get(m-1).price;

		int minIndex = 0;

		for(int i = 0; i< m - numberOfEmployees + 1 ; i++){

			int difference = goodiesItems.get(numberOfEmployees+i-1).price - goodiesItems.get(i).price;

			if(difference<= minDifference){
				minDifference = difference;
				minIndex = i;
			}
		}

		FileWriter fileWrite = new FileWriter("Output_TestCase_3.txt");

		fileWrite.write("The goodies selected for distribution are: \n\n");

		for(int i = minIndex ; i<minIndex + numberOfEmployees; i++){

			fileWrite.write(goodiesItems.get(i).toString() + "\n");

		}
		fileWrite.write("\nAnd the difference between the chosen goodie with highest price and the lowest price is: " + minDifference);

		fileWrite.close();
	}
}
