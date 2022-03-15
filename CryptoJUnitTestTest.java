package BVining_Assignment3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoJUnitTestTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD BE INBOUNDS"));
		assertFalse(CryptoManager.stringInBounds("FAIL BECAUSE { IS OUTSIDE THE RANGE"));
		assertFalse(CryptoManager.stringInBounds("fail because of lowercase letters"));
		assertFalse(CryptoManager.stringInBounds("FAIL BECAUSE OF ESC CHAR "+((char) 27)));
	}

	@Test
	void testEncryptCaesar() {
		assertEquals("UFTUJOH",CryptoManager.encryptCaesar("TESTING", 1));
		assertEquals(";,:;05.G(56;/,9G:;905.", CryptoManager.encryptCaesar("TESTING ANOTHER STRING", 999));
		assertEquals("4188;LC;>80", CryptoManager.encryptCaesar("HELLO WORLD", 300));
	}

	@Test
	void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager.encryptBellaso("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.encryptBellaso("MERRY CHRISTMAS", "HELLO"));
		assertEquals("PR%UKP:K_\\VF=8V", CryptoManager.encryptBellaso("MERRY CHRISTMAS", "CMSC207")); 
	}

	@Test
	void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager.decryptCaesar("UFTUJOH", 1));
		assertEquals("TESTING ANOTHER STRING", CryptoManager.decryptCaesar(";,:;05.G(56;/,9G:;905.", 999));
		assertEquals("HELLO WORLD", CryptoManager.decryptCaesar("4188;LC;>80", 300));
	}

	@Test
	void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.decryptBellaso("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.decryptBellaso("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.decryptBellaso("PR%UKP:K_\\VF=8V", "CMSC207")); 
	}

}
