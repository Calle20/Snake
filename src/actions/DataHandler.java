package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import game.Snake;

public class DataHandler {
	public static int Load() {
		File file = new File("rsc/save.txt");
		
		try {
			Scanner sc = new Scanner(file);
			int bestscore=sc.nextInt();
			sc.close();
			return bestscore;
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void Save() {
		File file = new File("rsc/save.txt");
		
		try {
			OutputStream stream=new FileOutputStream(file);
			try {
				stream.write(Integer.toString(Snake.bestscore).getBytes());
				stream.close();
				}
			catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
