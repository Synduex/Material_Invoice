package sample;

import java.io.File;

/**
 * Created by Roboto on 21/03/16.
 */
public class Utils {
    String organisationName, organisationAddress, organisationTanId, organisationVatId;

    public static String getDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "sample");
        dir = new File(dir, "resources");

        for (String s : c.getName().split("\\.")){
            dir = new File(dir, s);
            if (!dir.isDirectory())
                dir.mkdir();
        }
        System.out.println("Using Data Directory: " + dir.toString());
        return dir.toString() + File.separator;
    }

    public static String GetOutputFilePath(String inputFilePath){
        String extension = "";
        int i = inputFilePath.lastIndexOf(".");
        if (i > 0){
            extension = inputFilePath.substring(i+1);
        }
        if (inputFilePath.contains(".")){
            inputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf("."));
        }

        return inputFilePath + "_out_." + extension;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(){
        this.organisationName = "TuckBasket LLP";
    }

    public String getOrganisationAddress() {
        return organisationAddress;
    }

    public void setOrganisationAddress() {
        this.organisationAddress = "C-502 Maurya Apartments \n I.P.EXTN Patparganj \n Delhi-92 ";
    }

    public String getOrganisationTanId() {
        return organisationTanId;
    }

    public void setOrganisationTanId(String organisationTanId) {
        this.organisationTanId = organisationTanId;
    }

    public String getOrganisationVatId() {
        return organisationVatId;
    }

    public void setOrganisationVatId(String organisationVatId) {
        this.organisationVatId = organisationVatId;
    }
}
