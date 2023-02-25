package fa.training.entities;


public class Video extends Multimedia {

    public Video() {
        super();
    }

    public Video(String title, double duration) {
        super(title, duration);
    }

    public void createVideo() {

        System.out.println("\n------Enter video information------");
        super.createMultimedia();
    }

    @Override
    public String toString() {
        return String.format("Video:\t%s\t%.2f", getName(), getDuration());
    }
}
