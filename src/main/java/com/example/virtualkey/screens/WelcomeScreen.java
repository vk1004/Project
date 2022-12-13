package com.example.virtualkey.screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.virtualkey.services.DirectoryService;
import com.example.virtualkey.services.ScreenService;

public class WelcomeScreen implements Screen {

	private String welcomeText = "Welcome to LockedMe.com!";
	privare String welcome = "Designed and developed by Varun Kulkarni" ;
	private ArrayList<String> options = new ArrayList<>();

	public WelcomeScreen() {
		options.add("1. Show Files");
		options.add("2. Show File Options Menu");
		options.add("3. Quit");

	}

	public void introWS() {
		System.out.println(welcomeText);
		System.out.println(welcome);
		System.out.println("\n");
		Show();
	}

	@Override
	public void Show() {
		System.out.println("Main Menu");
		for (String s : options) {
			System.out.println(s);
		}

	}

	public void GetUserInput() {
		int selectedOption = 0;
		while ((selectedOption = this.getOption()) != 3) {
			this.NavigateOption(selectedOption);
		}
	}

	@Override
	public void NavigateOption(int option) {
		switch (option) {

		case 1: // Show Files in Directory
			this.ShowFiles();

			this.Show();

			break;

		case 2: // Show File Options menu
			ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();

			this.Show();

			break;

		default:
			System.out.println("Invalid Option");
			break;
		}

	}

	public void ShowFiles() {

		System.out.println("List of Files: ");
		DirectoryService.PrintFiles();

	}

	private int getOption() {
		Scanner in = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {

		}
		return returnOption;

	}
}
