package Server;

import org.junit.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;


/**
 * Tests unitaires de la classe Fichier
 * @author Groupe1
 */
public class FichierTest {

    private Fichier fichier, archive1, archive2 ;

    public FichierTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fichier = new Fichier("monFichier.txt");
        archive1 = new Fichier("monFichier_1.txt");
        archive2 = new Fichier("monFichier_2.txt");
        try {
            Files.createFile(fichier.toPath());
            Files.createFile(archive1.toPath());
            Files.createFile(archive2.toPath());
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        try {
            Files.delete(fichier.toPath());
            Files.delete(archive1.toPath());
            Files.delete(archive2.toPath());
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    /**
     * Test of nbArchive method, of class Fichier.
     * 1 seule archive
     */
    @Test
    public void testNbArchive() {
        System.out.println("Test nbArchive : 2 archives ");
        int result = fichier.nbArchive();
        assertEquals(2, result);
    }


    /**
     * Test of getArchive method, of class Fichier.
     */
    @Test
    public void testGetArchive() {
        System.out.println("Test getArchive");
        Fichier result = fichier.getArchive(2);
        assertNotNull(result);
    }

    /**
     * Test of getArchive method, of class Fichier.
     */
    @Test
    public void testGetArchive1() {
        System.out.println("Test getArchive 1");
        Fichier result = fichier.getArchive(1);
        assertEquals("monFichier_1", result.getNom());
    }

    /**
     * Test of getArchive method, of class Fichier.
     */
    @Test
    public void testGetArchiveNull() {
        System.out.println("Test getArchive : archive introuvable");
        Fichier expResult = null;
        Fichier result = fichier.getArchive(5);
        assertNull(result);
    }


    /**
     * Test of isArchivable method, of class Fichier.
     */
    @Test
    public void testIsArchivable() {
        System.out.println("Test isArchivable : non archivable");
        boolean expResult = true;
        boolean result = fichier.isArchivable();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Fichier.
     */
    @Test
    public void testGetNom() {
        System.out.println("Test getNom");
        String expResult = fichier.getNom();
        assertEquals(expResult, "monFichier");
    }

    /**
     * Test of getExtension method, of class Fichier.
     */
    @Test
    public void testGetExtension() {
        System.out.println("Test getExtension");
        String expResult = fichier.getExtension();
        assertEquals(expResult, "txt");
    }

    /**
     * Test of getSize method, of class Fichier.
     */
    @Test
    public void testGetSize() {
        System.out.println("Test getSize");
        long expResult = 0L;
        long result = fichier.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Fichier.
     */
    @Test
    public void testGetSize1() {
        System.out.println("Test getSize : fichier non vide");
        Fichier f = new Fichier("testSize.txt");
        try {
            Files.createFile(f.toPath());
            String str = "Ceci est un test";
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(str);
            writer.close();
        }catch (IOException io){
            io.printStackTrace();
        }
        long expResult = 0L;
        long result = f.getSize();
        try {
            Files.delete(f.toPath());
        }catch (IOException io){
            io.printStackTrace();
        }
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getDateModif method, of class Fichier.
     */
    @Test
    public void testGetDateModif() {
        System.out.println("Test getDateModif");

        Fichier f = new Fichier("testDateModif.txt");
        try {
            Files.createFile(f.toPath());
            String str = "Ceci est un test";
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(str);
            writer.close();
        }catch (IOException io){
            io.printStackTrace();
        }
        long expResult = 0L;
        long result = f.getSize();
        try {
            Files.delete(f.toPath());
        }catch (IOException io){
            io.printStackTrace();
        }
        f.getDateModif();
    }
}
