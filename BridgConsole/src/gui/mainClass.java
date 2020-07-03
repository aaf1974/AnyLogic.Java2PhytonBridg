package gui;

import java.util.Date;


public class mainClass {
	
	public static void main(String[] args) {
		
        System.out.println("Run bridge console" + new Date());
        
        mainWindow window = new mainWindow();
		window.open();
    }
}
