package learnswing;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

class AES {
byte[] skey = new byte[1000];
String skeyString;
static byte[] raw;
String encryptedData,decryptedMessage=null;

public AES(String inputMessage,String key,int c) {
try {
	if(c>0 && Integer.parseInt(key)!=c)
		{
		JOptionPane.showMessageDialog(null,"Wrong key");
		return;
		}

		
generateSymmetricKey(key);

byte[] ibyte = inputMessage.getBytes();

//if(c==0){
byte[] ebyte=encrypt(raw, ibyte);
encryptedData = new String(ebyte);
System.out.println("Encrypted message :\n"+encryptedData);

//}
//else{
	try{
byte[] dbyte= decrypt(raw,ebyte);
decryptedMessage = new String(dbyte);
System.out.println("Decrypted message :\n"+decryptedMessage);

	}
	catch (Exception e){
		JOptionPane.showMessageDialog(null,"Wrong key");
	}
}
//}

catch(Exception e) {
System.out.println(e);
}

}
void generateSymmetricKey(String key) {
try {
String knum = key;
byte[] knumb = knum.getBytes();
skey=getRawKey(knumb);
skeyString = new String(skey);
System.out.println("AES Symmetric key = "+skeyString);
}
catch(Exception e) {
System.out.println(e);
}
}
private static byte[] getRawKey(byte[] seed) throws Exception {
KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(seed);
kgen.init(128, sr);
SecretKey skey = kgen.generateKey();
raw = skey.getEncoded();
return raw;
}
private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] encrypted = cipher.doFinal(clear);
return encrypted;
}

private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
byte[] decrypted = cipher.doFinal(encrypted);
return decrypted;
}

public String EncryptedData()
{
	return encryptedData;
}

public String DecryptedData()
{
	return decryptedMessage;
}

public static void main(String args[]) {
}
}