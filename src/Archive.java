public class Archive extends File {

    private int number;

    public Archive(String name, int size, String path, String ext, int number) {
        super(name, size, path, ext);
        this.number = number;
    }
}
