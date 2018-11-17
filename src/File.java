
public class File {

    private String name;
    private int size;
    private String path;
    private String ext;

    public File(String name, int size, String path, String ext) {
        this.name = name;
        this.size = size;
        this.path = path;
        this.ext = ext;
    }

    public int nbArchive() {

        return 0;
    }

    public boolean isArchivable() {

        return false;
    }

    public void save() {

    }


}
