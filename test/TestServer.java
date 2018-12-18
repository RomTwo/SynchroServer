import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestArchive {

	Fichier f;
	
	@BeforeEach
	void setUp() throws Exception {
		f = new Fichier("f");
	}

	@AfterEach
	void tearDown() throws Exception {
		f = null;
	}

	@Test
	void testGetArchive() throws Exception {
		setUp();
		//Fichier f1 = new Fichier("f_1.rar");
		assert(f.getArchive(1) == null);
		tearDown();
	}
	
	@Test
	void testnbArchive() throws Exception {
		setUp();
		assert(f.nbArchive() == 0);
		tearDown();
	}

}
