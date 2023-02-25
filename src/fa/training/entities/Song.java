package fa.training.entities;

import java.util.Scanner;

/**
 * @author AnhNN66
 * @version 1.0
 * @created 01-�?�?-2021 10:00:00
 */
public class Song extends Multimedia {
    private String singer;

    public Song() {
        super();
    }

    public Song(String title, double duration, String singer) {
        super(title, duration);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * Add information of new song
     */
    public void createSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------Enter song information------");

        super.createMultimedia();

        while (true) {
            System.out.print("Enter singer: ");
            String inputSinger = scanner.nextLine();
            if (inputSinger != null && !inputSinger.isEmpty()) {
                setSinger(inputSinger);
                break;
            }
            System.out.println("Invalid input. Please enter a string.");
        }
    }

    @Override
    public String toString() {
        return String.format("Song:\t%s\t%.2f\t%s", getName(), getDuration(), getSinger());
    }
}
