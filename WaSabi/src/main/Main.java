package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import compiler.Compiler;
import exceptions.SemanticException;

public class Main {

	private static Compiler compiler;

	public static void main(String[] args) throws IOException, SemanticException {

		int state = 0;
		compiler = null;
		String path = null;

		String input;
		Scanner scanIn = new Scanner(System.in);

		while (true) {
			System.out.println("Possible command: ");

			System.out.println(" - compile 'path' \t to compile a new wasabi source file");

			if (state == 10 || state == 20)
				System.out.println(" - recompile \t\t to compile the same file");

			if (state == 10)
				System.out.println(" - export 'path' \t to create the SPICE equivalent");

			System.out.println(" - exit \t\t to exit the program");

			System.out.println();

			input = scanIn.nextLine();
			boolean fatto = false;

			if (input.equalsIgnoreCase("exit")) {
				scanIn.close();
				return;
			}

			if (input.length() > 8 && input.substring(0, 9).equalsIgnoreCase("compile '")) {
				path = input.substring(9, input.length() - 1);
				state = compile(path);
				fatto = true;
			}

			if (input.equalsIgnoreCase("recompile"))
			{
				state = compile(path);
				fatto = true;
			}

			if (input.length() > 7 && input.substring(0, 8).equalsIgnoreCase("export '")) {
				String writingString = input.substring(8, input.length() - 1);
				File file = new File(writingString);
				if(file.exists()){
					System.out.println("File already exists: are you sure you want to overwrite it? (Y/N)");
					if(scanIn.nextLine().equalsIgnoreCase("Y")){
						String[] temp=file.toString().split("\\.");
						if(temp[temp.length-1].equalsIgnoreCase("cir")||temp[temp.length-1].equalsIgnoreCase("net")||temp[temp.length-1].equalsIgnoreCase("sp")){
						compiler.writeOnFile(file);

						System.out.println("---------------------");
						System.out.println("EXPORT SUCCESSFUL");
						System.out.println("Exported file: " + path);
						System.out.println("---------------------");
						}
						else{
							System.out.println("---------------------");
							System.out.println("ERROR: WRONG EXTENSION TYPE");
							System.out.println("Please choose a .cir .net or .sp extension");
							System.out.println("---------------------");
						}
					}
					else{
						System.out.println("---------------------");
						System.out.println("EXPORT ABORTED");
						System.out.println("---------------------");
					}
					fatto=true;
						
				}else{
					String[] temp=file.toString().split("\\.");
					if(temp[temp.length-1].equalsIgnoreCase("cir")||temp[temp.length-1].equalsIgnoreCase("net")||temp[temp.length-1].equalsIgnoreCase("sp")){
						compiler.writeOnFile(file);

						System.out.println("---------------------");
						System.out.println("EXPORT SUCCESSFUL");
						System.out.println("Exported file: " + path);
						System.out.println("---------------------");
						fatto=true;
					}
					else{
						System.out.println("---------------------");
						System.out.println("ERROR: WRONG EXTENSION TYPE");
						System.out.println("Please choose a .cir .net or .sp extension");
						System.out.println("---------------------");
					}
					fatto=true;
				}
			}
			if (!fatto)
				System.out.println("Unknown command");
			
		}
	}

	private static int compile(String path) {

		System.out.println("---------------------");

		try {
			compiler = new Compiler(path);
			System.out.println("BUILD SUCCESSFUL");
			System.out.println("Compiled file: " + path);

			System.out.println("---------------------");

			compiler.stampAll();

			System.out.println("---------------------");
			return 10;

		} catch (IOException | SemanticException e) {
			System.out.println("ERROR IN BUILD");
			System.out.println("Compiled file: " + path);
			System.out.println("\t" + e.getMessage());

			System.out.println("---------------------");
			return 20;
		}

	}
}
