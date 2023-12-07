package com.muskan.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.muskan.creator.Dialog;
import com.muskan.creator.HtmlDialog;
import com.muskan.creator.WindowsDialog;

@SpringBootApplication
public class FactoryApplication {
	private static Dialog dialog;
	public static void main(String[] args) {
		SpringApplication.run(FactoryApplication.class, args);

		configure();
		runBusinessLogic();

	}

	static void configure(){
		if(System.getProperty("os.name").equals("Windows 10")){
			dialog = new WindowsDialog();
		}
		else{
			dialog = new HtmlDialog();
		}
	}	

	static void runBusinessLogic(){
		dialog.renderWindow();
	}
}
