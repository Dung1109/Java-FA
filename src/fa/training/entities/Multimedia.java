package fa.training.entities;
import fa.training.validator.Validator;
import java.util.Scanner;

/**
 * @author AnhNN66
 * @version 1.0
 * @created 01-�?�?-2021 10:00:00
 */
public abstract class Multimedia {

    private String name;

    private double duration;

    public Multimedia() {
    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Add information of new multimedia
     */
    public void createMultimedia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");

        while (true) {
            String inputName = scanner.nextLine();
            if (inputName != null && !inputName.isEmpty()) {
                setName(inputName);
                break;
            }
            System.out.println("Invalid input. Please enter a string.");
        }

        System.out.print("Enter duration: ");
        while (true) {
            String inputDuration = scanner.nextLine();
            if (Validator.isDouble(inputDuration)) {
                setDuration(Double.parseDouble(inputDuration));
                break;
            }
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
