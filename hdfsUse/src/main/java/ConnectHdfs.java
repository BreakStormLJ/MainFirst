import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


import java.io.IOException;
import java.net.URI;

public class ConnectHdfs {
//    public static final Log LOG = LogFactory.getLog(ConnectHdfs.class);
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        String hdfsUserName = "root";
//        URI hdfsUri = null;
       /* try {
//            hdfsUri = new URI("hdfs://10.2.223.242:50070");
        }catch (URISyntaxException e){
            e.printStackTrace();
            //logger.error(e);
        }*/
        try {
            FileSystem fs = FileSystem.get(URI.create("hdfs://10.2.223.242:8020/user"),conf);
            fs.exists(new Path("/user/liujin"));
//            FileSystem fs=FileSystem.get(conf);
//            checkThisFile(fs);
        }catch (IOException e){
//           LOG.error(e.getMessage());
        }/*catch (InterruptedException e){
            e.printStackTrace();
        }*/

    }

    public static void checkThisFile(FileSystem fs){
        boolean isExists = false;
        boolean isDirectory =false;
        boolean isFile = false;

        Path path = new Path("hdfs://10.2.223.242:50070/test/hdfs-site.xml");

        try {
            isExists = fs.exists(path);
            isDirectory = fs.isDirectory(path);
            isFile = fs.isFile(path);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fs.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if (!isExists){
            System.out.println("该路径不存在");
        }else {
            System.out.println("该路径存在");
            if (isDirectory){
                System.out.println("这是一个目录");
            }
            else if(isFile){
                System.out.println("这是一个文件");
            }
        }
    }
}
