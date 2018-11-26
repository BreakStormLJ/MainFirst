import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


/**
 * Demo class
 *
 * @author liujin
 * @date 2018/11/26
 */
public class HdfsFileRead {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://10.2.223.242:50070");
        FileSystem fs =  FileSystem.newInstance(conf);
        RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/"),true);
        while (iterator.hasNext()){
            LocatedFileStatus next = iterator.next();
            System.out.println(next.getPath());
        }
        System.out.println("***********************************");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (int i = 0;i<fileStatuses.length;i++){
            FileStatus fileStatus = fileStatuses[i];
            System.out.println(fileStatus.getPath());
        }

    }
}
