package androidassetsizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;

public class AndroidAssetSizer {
    private static String folderName = "AppIcons";
    private static File folderAppIcon = new File(folderName);
        
    public static void main(String[] args) throws IOException{
        File fileAppIcon = new File("appicon.png");
        if(!fileAppIcon.exists()){
            JOptionPane.showMessageDialog(null, "Error. No 'appicon.png' File Found.");
        }else{
            createAppiconFolder();
            resizePngFiles(fileAppIcon);
            JOptionPane.showMessageDialog(null, "Done.");
        }
    }

    public static void createAppiconFolder() throws IOException{
        if(!folderAppIcon.exists()){
            try{
                folderAppIcon.mkdir();
            }catch(SecurityException e){
                
            }
        }
    }
    
    public static void resizePngFiles(File file) throws IOException{
        int[] appiconSizes = {192, 144, 96, 72, 48, 32};
        
        for(int size : appiconSizes){
            Thumbnails.of(file).size(size, size).toFile(System.getProperty("user.dir") + "//" + folderName + "//" + "appicon_" + size);
        }
    }}
