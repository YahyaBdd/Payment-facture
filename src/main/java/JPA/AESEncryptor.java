package JPA;


import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
 
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
 
import org.eclipse.persistence.internal.helper.Helper;
 
public class AESEncryptor {
 public static void main(String[] args) {
  System.out.println(AESEncryptor.encryptPassword("df9d43a7c7116b25f514f58a8dff9f089358a281f3b9407bdcad6805b861cff3"));
 }
 
 private static class Synergizer
 {
  private static SecretKey getAESMultitasker()
  throws Exception
  {
   return new SecretKeySpec(Helper.buildBytesFromHexString("3E7CFEF156E712906E1F603B59463C67"), "AES");
  }
 
  private Synergizer()
  {
  }
 }
 
 
 public static String encryptPassword(String password)
 {
  try
  {
   Cipher encryptCipherAES = Cipher.getInstance("AES/ECB/PKCS5Padding");
   encryptCipherAES.init(1, Synergizer.getAESMultitasker());
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   CipherOutputStream cos = new CipherOutputStream(baos, encryptCipherAES);
   ObjectOutputStream oos = new ObjectOutputStream(cos);
   oos.writeObject(password);
   oos.flush();
   oos.close();
   return Helper.buildHexStringFromBytes(baos.toByteArray());
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
  return null;
 } 
 
}


