import java.io.File;

public class FileDelOne {
    public static void main(String[] args) {
        //String url = "";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\audio";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect\\sfx";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect\\skill";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\monster";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\npc";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\player";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\weapon";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\wings";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene\\map";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene\\minimap";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\boss_icon";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\buff_icon";
        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\item";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\level";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\pet_equip";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\pet_icon";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\role_icon";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\activity_daily";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\lvup_ui";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\notice_ui";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\throw_damage_num";
//        String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\tipsorder_ui";
        //String url = "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\public_ui";
        try {
            File file = new File(url);
            deleteDir(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteDir(File file){
        try {
            if(!file.exists()){//判断是否待删除目录是否存在
                System.err.println("The dir are not exists!");
            }else {
                if (file.isFile()){
                    System.out.println(file.getAbsoluteFile());
                    file.delete();
                }else {
                    String[] childFilePath = file.list();
                    for (String path:childFilePath){
                        File childFile = new File(file.getAbsoluteFile()+"/"+path);
                        deleteDir(childFile);
                    }
                    System.out.println(file.getAbsoluteFile());
                    file.delete();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
