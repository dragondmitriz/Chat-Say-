package resource;
/**
 *
 * @author dmitriz
 */
public class Client implements java.io.Serializable{
   private String name;
   private String ip;
   Client(String Name,String Ip){
       name=Name;
       ip=Ip;
   }
   public String getName(){
       return name;
   }
   public void setName(String Name){
       name=Name;
   }
   public String getIp(){
       return ip;
   }
}
