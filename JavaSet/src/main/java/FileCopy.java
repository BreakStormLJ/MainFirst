import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // src 源目录，dest 目标目录
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\audio");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\effect\\sfx");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\effect\\skill");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\scene\\map");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\scene\\minimap");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\monster");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\role");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\npc");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\role");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\player");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\role");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\weapon");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\role");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\role\\wings");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\role");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\boss_icon");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\buff_icon");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\item");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\level");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\pet_equip");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\pet_equip");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\pet_icon");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\role_icon");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\public_ui");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\activity_daily");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\lvup_ui");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\notice_ui");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\throw_damage_num");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui");*/
        /*File src = new File("F:\\XueYin_Svn\\resource\\美术资源\\stab\\platform\\ui_cocos310\\private_ui\\tipsorder_ui");
        File dest = new File("F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui");*/
        try {
            copyfile(src,dest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void copyfile(File src,File dest){
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
                        copyfile(file, newFile);
                    }
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
