package Server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

/**
 * Tests unitaires de la classe Profile
 * @Author Groupe1
 */
public class ProfilTest {
    private Profil profile;

    @Before
    public void setUp() {
        profile = new Profil("texte","192.168.0.5","192.168.0.6","/home/src/","c:/dest");
    }

    @After
    public void tearDown() {
    }


    @Test
    public void getName() {
        assertEquals("texte", profile.getName());
    }

    @Test
    public void getIpSrc() {
        assertEquals("192.168.0.5", profile.getIpSrc());
    }

    @Test
    public void getIpDest() {
        assertEquals("192.168.0.6", profile.getIpDest());
    }

    @Test
    public void getDirSrc() {
        assertEquals("/home/src/", profile.getDirSrc());
    }

    @Test
    public void getDirDest() {
        assertEquals("c:/dest", profile.getDirDest());
    }

    @Test
    public void getExtsSynchro() {

    }

    @Test
    public void getExtsArchivable() {
    }
}