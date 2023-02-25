package fa.training.main;

import fa.training.entities.Song;
import fa.training.entities.Video;
import fa.training.management.MultimediaManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MultimediaManagement multimediaManagement = new MultimediaManagement(new ArrayList<>());

        /**
         * Display menu
         */
        while (true) {
            display();

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                scanner.nextLine();
                continue;
            }

            /**
             * Switch case: 1. Add new video 2. Add new song 3. Display all multimedia 4. Exit 5. Sort 6. Save to file 7. Load from file
             */
            switch (choice) {
                case 1 -> {
                    Video video = new Video();
                    video.createVideo();
                    multimediaManagement.addMultimedia(video);
                }
                case 2 -> {
                    Song song = new Song();
                    song.createSong();
                    multimediaManagement.addMultimedia(song);
                }
                case 3 -> multimediaManagement.displayMultimedia();
                case 4 -> System.exit(0);
                case 5 -> {
                    while (true) {
                        System.out.println("Please input the type of sort (name/duration): ");
                        scanner.nextLine();
                        String type = scanner.nextLine();
                        if (type.equalsIgnoreCase("name") || type.equalsIgnoreCase("duration")) {
                            multimediaManagement.sort(type);
                            break;
                        }
                    }

                }
                case 6 -> multimediaManagement.saveToFile();
                case 7 -> multimediaManagement.loadFromFile();
                default -> System.out.println("Invalid input. Please enter a number from 1 to 4.");
            }
        }

    }

    public static void display() {
        System.out.println("\n------MULTIMEDIA MANAGEMENT SYSTEM------");
        System.out.println("Choose a function: ");
        System.out.println("1. Add a new Video");
        System.out.println("2. Add a new Song");
        System.out.println("3. Display all media");
        System.out.println("4. Exit");
        System.out.println("5. Sort");
        System.out.println("6. Save to file 'input.txt'");
        System.out.println("7. Load from file 'input.txt'");
        System.out.println("Your choice: ");
    }
}
