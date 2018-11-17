import java.util.ArrayList;

public class Profil {

    private String name;
    private String ipSrc;
    private String ipDest;
    private String dirSrc;
    private String dirDest;
    private ArrayList<String> exts;

    public Profil(String name, String ipSrc, String ipDest, String dirSrc, String dirDest) {
        this.name = name;
        this.ipSrc = ipSrc;
        this.ipDest = ipDest;
        this.dirSrc = dirSrc;
        this.dirDest = dirDest;
        this.exts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getIpSrc() {
        return ipSrc;
    }

    public String getIpDest() {
        return ipDest;
    }

    public String getDirSrc() {
        return dirSrc;
    }

    public String getDirDest() {
        return dirDest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpSrc(String ipSrc) {
        this.ipSrc = ipSrc;
    }

    public void setIpDest(String ipDest) {
        this.ipDest = ipDest;
    }

    public void setDirSrc(String dirSrc) {
        this.dirSrc = dirSrc;
    }

    public void setDirDest(String dirDest) {
        this.dirDest = dirDest;
    }

    public void addExt(String ext) {
        this.exts.add(ext);
    }

    public void removeExt(String ext) {
        this.exts.remove(ext);
    }
}
