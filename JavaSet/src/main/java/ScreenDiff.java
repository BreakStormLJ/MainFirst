import java.util.*;

/**
 * Demo class
 *
 * @author liujin
 * @date 2018/11/24
 */
public class ScreenDiff {
    public static void main(String[] args) {
        String stat = "CREATE TABLE select id CREATE TABLE select id CREATE TABLE select id";
        String[] array = stat.split("\\s+");
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        Map map = new HashMap();
        int i = 0;
        for (String ss: array){
            i++;
            map.put(i,ss);
            list.add(ss);
            set.add(ss);

        }
        System.out.println(list);
        System.out.println("这条句子中单词的总数为："+list.size());
        map(stat);
        wordfre(stat);
    }

    public static void map(String stat){
        String[] array = stat.split("\\s+");
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for (String ss:array){
            list.add(ss);
            set.add(ss);
        }
        Map map = new HashMap();

        for (String path1:set){
            System.out.println(path1);
            int count = 0;
            if (list.contains(path1)){
                for (String path2:list){
                    System.out.println(path2);
                    if (path1.equals(path2)) {
                        ++count;
                    }
                }
                map.put(path1,count);
            }
        }
        System.out.println(map);
    }

    public static void wordfre(String stat){
        String[] array = stat.split("\\s+");
        Map<String,Integer> map = new HashMap();
        int val;
        for (String ss:array){

            if (map.containsKey(ss)){
                val = map.get(ss) + 1;

            }else {
                val =  1;
            }
            map.put(ss,val);
        }

        System.out.println(map);
    }
    /*List<String> list=new ArrayList();
    list.add("a");
    list.add("b");
    list.get(0);
    Collections.sort(list);
    Set<String> set=new HashSet();
    set.add("a");*/
}
