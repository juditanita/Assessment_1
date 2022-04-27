package lockMe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Allin2 {
	public static void main(String[] args) throws IOException {
		int choice = -1;

		Scanner sc = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		

		do {
			System.out.println("\n\n\t\tWelcome to File Handling");
			System.out.println("This program was created by Judit A. Szabo");

			System.out.println("\n\t1.   Create file");
			System.out.println("\t2.   Read file");
			System.out.println("\t3.   Rename file");
			System.out.println("\t4.   Search word in a file");
			System.out.println("\t5.   Delete file");
			System.out.println("\t6.   List all files from Directory");
			System.out.println("\t0.   Exit program");
			System.out.println("============================================");
			System.out.println("\n\t\tChoose From the Menu: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Create a  File:");

				String filen = input.nextLine();
				File myFl = new File(filen);
				if (!myFl.exists()) {

					System.out.println("Write text, then press enter.");
					String text = input.nextLine();

					FileWriter myObj = new FileWriter(filen);

					if (text.split("\\s").length == 1 && text.split("\\s").length == 0) {
						System.out.println(text.split("\\s").length + " word.");

					} else {
						System.out.println(
								"\n\tYou have added " + text.split("\\s").length + " words in " + filen + " file");
					}

					text += text + "\n<" + text.split("\\s").length + " words> " + "\n\n\n";

					myObj.write(text);
					myObj.close();
				} else {
					System.out.println("file already exist!");
				}
				break;
			case 2:

				// Scanner inp = new Scanner(System.in);
				try {
					System.out.println("Search file: ");

					String filename2 = input.nextLine();

					BufferedReader reader = new BufferedReader(new FileReader(filename2));

					String line;

					while ((line = reader.readLine()) != null) {
						System.out.println("\s" + line);
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("\t\nfile not found");
				}
				break;

			case 3:

				// Scanner i = new Scanner(System.in);
				System.out.println("Search file: ");

				String file = input.nextLine();
				File myFile = new File(file);

				if (myFile.exists()) {
					System.out.println("Add new filename: ");

					String filen2 = input.nextLine();

					while (myFile.renameTo(new File(filen2))) {
						System.out.println("file new name is " + filen2);
					}
				} else {
					System.out.println("file not found ");
				}
				break;

			case 4:
				try {
					int count = 0;
					String[] words = null;

					// Scanner input4 = new Scanner(System.in);
					System.out.println("Search file: ");
					String fN = input.nextLine();

					File myFil = new File(fN);

					FileReader objR = new FileReader(myFil); // filereader object

					BufferedReader objB = new BufferedReader(objR); // BuffReader obj
					String s;

					System.out.println("Add word for search:");
					String winput = input.next(); // add a word for search

					while ((s = objB.readLine()) != null) { // Reading begins

						words = s.split("\\s"); // split with space
						for (String word : words) {
							if (word.equals(winput)) // with the given word
							{
								count++;

							}
						}
					}
					if (count != 0) {
						if (count == 1) {
							System.out.println("Found once.");

						} else {

							System.out.println(winput + " is inside " + count + " times.");

						}
					} else {
						System.out.println("word not found");
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("\n\tfile not found");
				}

				// objR.close();
				break;
			case 5:
				// Scanner input3 = new Scanner(System.in);
				System.out.println("Search file");

				String filename = input.nextLine();
				File myFile1 = new File(filename);
				if (myFile1.exists()) {
					while (myFile1.delete()) {
						System.out.println(myFile1.getName() + " deleted");
					}
				} else {
					System.out.println("\n\tfile not found");
				}
				break;

			case 6:				
				
				// Scanner input3 = new Scanner(System.in);
				System.out.println("List all file in a folder");
				System.out.println("Add path:");
				String pth = input.nextLine();
				

				Path path = Paths.get(pth);
				try (Stream<Path> subPaths = Files.walk(path)) {
					subPaths.forEach(System.out::println);
					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error occured");

				}

				break;
			}

		} while (choice != 0);

	}

}
