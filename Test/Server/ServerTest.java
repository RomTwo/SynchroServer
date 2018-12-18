import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ../../src/Server/Server.java;

class ServerTest {

    Socket s;
    Fichier f;

    @BeforeEach
    void setUp() throws Exception {
        f = new Fichier("test_fichier");
    }

    @AfterEach
    void tearDown() throws Exception {
        f = null;
    }

    @Test
    void testArchive1() throws Exception{
        if (f.nbArchive() < 5) {
            assert(s.archive(f) == "test_fichier_"+f.nbArchive()+1+"."+f.getExtension());
        }
        else if (f.nbArchive() == 5){
            assert(s.archive(f) == "test_fichier_5."+f.getExtension());
        }
    }

    @Test
    void testCommuniate() throws Exception{
        byte[] buffer b = null;
        assert(s.communicate(SEND, b) == false);
        assert(s.communicate(RECV, b) == false);
        assert(s.communicate(SCAN, b) == false);
        assert(s.communicate(STOPSCAN, b) == false);
        assert(s.communicate(ARCHIVE, b) == false);
        assert(s.communicate(TIME, b) == false);

    }

}