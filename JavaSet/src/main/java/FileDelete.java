import java.io.File;

/*
 *
 * @ author lj
 * @ data 2018-10-26
 */
public class FileDelete {
    public static void main(String[] args) {
        /*String[] urlArray = {"F:\\stab\\platform\\effect\\sfx","F:\\stab\\platform\\effect\\skill","F:\\stab\\platform\\role\\npc","F:\\stab\\platform\\role\\player","F:\\stab\\platform\\role\\monster","F:\\stab\\platform\\role\\weapon","F:\\stab\\platform\\role\\wings","F:\\stab\\platform\\scene\\map","F:\\stab\\platform\\scene\\minimap","F:\\stab\\platform\\ui_cocos310\\boss_icon",
                "F:\\stab\\platform\\ui_cocos310\\buff_icon","F:\\stab\\platform\\ui_cocos310\\item","F:\\stab\\platform\\ui_cocos310\\level","F:\\stab\\platform\\ui_cocos310\\pet_equip","F:\\stab\\platform\\ui_cocos310\\pet_icon","F:\\stab\\platform\\ui_cocos310\\public_ui","F:\\stab\\platform\\ui_cocos310\\private_ui\\activity_daily","F:\\stab\\platform\\ui_cocos310\\private_ui\\lvup_ui",
                "F:\\stab\\platform\\ui_cocos310\\private_ui\\notice_ui","F:\\stab\\platform\\ui_cocos310\\private_ui\\tipsorder_ui"};*/
        String[] urlArray = {"F:\\XueYin_Project\\xycq_res\\stab\\platform\\audio","F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect\\sfx",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\effect\\skill","F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\monster","F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\npc",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\player","F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\weapon","F:\\XueYin_Project\\xycq_res\\stab\\platform\\role\\wings",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene\\map","F:\\XueYin_Project\\xycq_res\\stab\\platform\\scene\\minimap","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\boss_icon",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\buff_icon","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\item","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\level",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\pet_equip","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\pet_icon","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\public_ui",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\role_icon","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\activity_daily","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\notice_ui",
                "F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\throw_damage_num","F:\\XueYin_Project\\xycq_res\\stab\\platform\\ui_cocos310\\private_ui\\tipsorder_ui"};
        try {
            for (String url:urlArray){
                File file = new File(url);
                deleteFile(file);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
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
                        deleteFile(childFile);
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
