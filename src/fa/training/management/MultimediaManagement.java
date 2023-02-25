package fa.training.management;

import fa.training.entities.Multimedia;
import fa.training.entities.Song;
import fa.training.entities.Video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AnhNN66
 * @version 1.0
 * @created 01-�?�?-2021 10:00:00
 */
public class MultimediaManagement {

    private final List<Multimedia> listOfMultimedia;

    public MultimediaManagement(List<Multimedia> listOfMultimedia) {
        this.listOfMultimedia = listOfMultimedia;
    }

    public void addMultimedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    /**
     * Display multimedia list
     */
    public void displayMultimedia() {

        System.out.println("\n------LIST OF MULTIMEDIA------");
        if (listOfMultimedia.isEmpty()) {
            System.out.println("No multimedia in the list.");
            return;
        }
        for (Multimedia multimedia : listOfMultimedia) {
            System.out.println(multimedia);
        }
    }

    /**
     * sort the list by name or duration
     */
    public void sort(String type) {

        if (listOfMultimedia.isEmpty()) {
            System.out.println("No multimedia in the list.");
            return;
        }

        // copy the list into a new mutable list
        List<Multimedia> sortedList = new ArrayList<>(listOfMultimedia);

        // sort the list
        sortedList.sort((o1, o2) -> type.equalsIgnoreCase("name") ? o1.getName().compareTo(o2.getName()) : Double.compare(o1.getDuration(), o2.getDuration()));

        System.out.println("Sorted successfully!");
        for (Multimedia multimedia : sortedList) {
            System.out.println(multimedia);
        }
    }

    /**
     * Save the list to file named "input.txt"
     */
    public void saveToFile() {

        // check empty
        if (listOfMultimedia.isEmpty()) {
            System.out.println("No multimedia in the list.");
            return;
        }

        // save listOfMultimedia to file input.txt
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("input.txt"))) {
            for (Multimedia multimedia : listOfMultimedia) {
                bufferedWriter.write(multimedia.toString());
                bufferedWriter.newLine();
                System.out.println("Saved successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving to file.");
        }
    }

    /**
     * Load the list from file named "input.txt"
     */
    public void loadFromFile() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            // clear list
            listOfMultimedia.clear();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] multimediaInfo = line.split("\t");
                if (multimediaInfo[0].equalsIgnoreCase("Video:")) {
                    Video video = new Video(multimediaInfo[1], Double.parseDouble(multimediaInfo[2]));
                    listOfMultimedia.add(video);
                } else if (multimediaInfo[0].equalsIgnoreCase("Song:")) {
                    Song song = new Song(multimediaInfo[1], Double.parseDouble(multimediaInfo[2]), multimediaInfo[3]);
                    listOfMultimedia.add(song);
                }
            }
            System.out.println("Loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while loading from file.");
        }
    }
}
