package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @date 2021年06月03日15:15
 *
 */
public class Test16 {
    public static void main(String[] args) {
        String ss = "6217210402005885924";
        String ss1 = "1";
        System.out.println(Math.abs(ss.hashCode()%32));
        System.out.println("==============================================");
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String format = s.format(new Date());
        System.out.println(format);
        System.out.println("==============================================");
        int i = Math.abs(md5("17303454502").hashCode()) % 1024;
        System.out.println(i);
        int ssdbTest = i / 256;
        System.out.println(String.valueOf(ssdbTest));
        System.out.println(24000/4500);
        System.out.println("==============================================");
        Byte aByte = Byte.valueOf("1");
        Test6 test6=new Test6();
        test6.setSs(Byte.valueOf(ss1));
        System.out.println("aByte"+test6.getSs());
        System.out.println("==============================================");
        List<String> modifyFields = Arrays.asList("accSts_accSts_".split("_"));
        if("again".equals("again") && !"80000".equals("2000") &&
                !"20000".equals("8000")){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
        System.out.println("==============================================");
        System.out.println(UUID.randomUUID());
        System.out.println("==============================================");
        System.out.println(md5("17303454502"));
    }
    public static String md5(final String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(msg.getBytes());
            StringBuilder sb = new StringBuilder();
            @SuppressWarnings("resource")
            Formatter fmt = new Formatter(sb);
            for (byte b : md5) {
                fmt.format("%02x", b & 0xFF);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
