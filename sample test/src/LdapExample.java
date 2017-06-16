import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapExample {
 
 
 public boolean ladpTest(){
  try {
   final String ldapAdServer = "ldap://127.0.0.1:10389";

   Hashtable env = new Hashtable();
   env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
   env.put(Context.SECURITY_AUTHENTICATION, "simple");
   env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
   env.put(Context.SECURITY_CREDENTIALS, "secret");
   env.put(Context.PROVIDER_URL, ldapAdServer);
   // LdapContext ctx = new InitialLdapContext(env, null);
   DirContext ctx = new InitialDirContext(env);
   System.out.println("connected");
   boolean result = ctx != null;
   if (ctx != null) {
   ctx.close();
   
   }
   return result;
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }

 }
 public static void main(String[] args) {
  LdapExample ld=new LdapExample(); 
  ld.ladpTest();
 }

}