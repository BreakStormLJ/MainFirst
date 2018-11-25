import java.io.*;

public class FileRemove {
    public static void main(String[] args) {
        String dir1 = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect";
        String dir2 = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role";
        String dir3 = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene";
        String dir4 = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310";
        String dir5 = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui";
        String dir6 = "F:\\XueYin_Project\\xycq_res\\stab\\platform";
        String[][] dirArray = {{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\effect\\sfx",dir1},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\effect\\skill",dir1},
                {"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\monster",dir2},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\npc",dir2},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\player",dir2},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\weapon",dir2},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\wings",dir2},
                {"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\scene\\map",dir3},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\scene\\minimap",dir3},
                {"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\boss_icon",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\buff_icon",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\item",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\level",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\pet_equip",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\pet_icon",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\public_ui",dir4},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\role_icon",dir4},
                {"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\activity_daily",dir5},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\lvup_ui",dir5},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\notice_ui",dir5},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\skills",dir5},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\tipsorder_ui",dir5},{"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\throw_damage_num",dir5},
                {"F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\audio",dir6}};
        try {
            for (String[] dir:dirArray){
                // src 源目录，dest 目标目录
                File src = new File(dir[0]);
                File dest = new File(dir[1]);
                removefile(src,dest);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void removefile(File src,File dest){
        try {
            File newFile = new File(dest,src.getName());
            // 判断拼接成的路径是否存在
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            // 获取源目录中的所有的文件和文件夹
            File[] files = src.listFiles();
            for (File file : files)
                if (file.isFile()) {
                    System.out.println(file.getAbsoluteFile());
                    // 开始复制文件
                    FileInputStream fis = new FileInputStream(file);
                    // c:\\Test\\day09\\ppt
                    FileOutputStream fos = new FileOutputStream(new File(newFile, file.getName()));
                    byte[] b = new byte[1024];
                    int len;
                    while ((len = fis.read(b)) != -1) {
                        fos.write(b, 0, len);
                    }

                    fos.close();
                    fis.close();

                } else {
                    if (file.isDirectory()) {
                        removefile(file, newFile);
                    }
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
