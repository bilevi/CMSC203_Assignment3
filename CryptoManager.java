package BVining_Assignment3;

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;


	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean inbound = true;
		char spot; //for character spot in string

		for (int i = 0; i < plainText.length(); i++)
		{
			spot = plainText.charAt(i);

			if (spot < LOWER_BOUND || spot > UPPER_BOUND) //if character is out of bounds
			{
				inbound = false;
			}
		}
		return inbound;
	}


	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encrypt = "";
		String empty = "";
		char spot; //for character spot in string

		while (key > RANGE) //bring the key within the range of use
		{
			key -= RANGE; //by subtracting the range
		}

		if (stringInBounds(plainText) == true)
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				spot = plainText.charAt(i); //for the character spot in the string
				spot += key; //main point of caesar cipher, add key to the character to get new value

				while (spot > UPPER_BOUND) //while the character is out of bounds
				{
					spot -= RANGE; //subtract the range to bring inbounds
				}

				encrypt += spot; //add the new character to the encrypted string
			}	
			return encrypt; //return the encrypted string
		}
		else return empty; //otherwise, if out of bounds, return nothing
	}


	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encrypt = "";
		String empty = "";
		char spot; //for character spot in string
		int cipher; 

		if (stringInBounds(plainText) == true)
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				spot = plainText.charAt(i); //for the character spot in the string
				cipher = (int)spot + (int)bellasoStr.charAt(i % bellasoStr.length());
				/* by turning the character into a number value (ASCII) and adding it to
				 *  the number value of the character from the key string (ASCII),
				 *  we get the main proponent of the bellaso cipher.
				 */

				while (cipher > (int)UPPER_BOUND) //while that component is out of bounds
				{
					cipher -= RANGE; //subtract the range to bring it inbounds
				}

				encrypt += (char)cipher; //add the component to the fully encrypted string
			}
			return encrypt; //return the encryption
		}
		else return empty; //otherwise, if out of bounds, return nothing
	}


	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decrypt = "";
		char spot; //for character spot in string

		while (key > RANGE) //while the key is out of the range
		{
			key -= RANGE; //subtract the range until inbounds
		}

		for (int i = 0; i < encryptedText.length(); i++)
		{
			spot = encryptedText.charAt(i); //for the spot in the string
			spot -= key; //subtract the key to get decrypted character

			while (spot < LOWER_BOUND) //while the character is out of bounds
			{
				spot += RANGE; //add the range to bring inbound
			}

			decrypt += spot; //add the character to the decrypted string
		}

		return decrypt; //return the decrypted string
	}


	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decrypt = "";
		char spot; //for character spot in string
		int cipher;

		for (int i = 0; i < encryptedText.length(); i++)
		{
			spot = encryptedText.charAt(i); //for the character spot in the string
			cipher = (int)spot - (int)bellasoStr.charAt(i % bellasoStr.length());
			/* subtract from the number value (ASCII) of the character the 
			 * number value of the character from the key string
			 */

			while (cipher < (int)LOWER_BOUND) //while the new value is out of bounds (still working with numbers)
			{
				cipher += RANGE; //add the range to the new value
			}

			decrypt += (char)cipher; //add the character value to the decrypted string
		}

		return decrypt; //return the decrypted string
	}
}
