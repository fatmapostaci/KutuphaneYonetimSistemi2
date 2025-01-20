package utilities;

public class MailFormatControl {

    /*
        Task-> girilen mailın doğrulugunu aşağıdaki şartlarda  control eden METHOD create ediniz.
        1- @ karakteri olmalı
        2- . (nokta) karakteri olmalı
        3- @ karakterinden önce mutlaka en az bir karakter olmalı.
        4- com ile bittiği kontrolü
     */
    String mail;
    public String MailGirisi(){
        boolean endOfLoop=false;
        while(!endOfLoop){
            System.out.print("---Mail Adress: ");
            mail = TryCatch.scan.next();
            boolean isMailValid = isFormatAccepted();
            if(isMailValid){
                endOfLoop=true;
            }
            else System.out.println("Format Error!");
        }
        return mail;
    }
    public boolean isFormatAccepted() {

        return isDotIncluded() &&
                isAtIncluded() &&
                isStringEntered() &&
                isComEntered();
    }

    /** @ karakteri kontrolü
     * @return true yada false
     */
    private boolean isDotIncluded(){
        if (mail.contains("."))
            return true;
        else return false;
    }

    /**
     * . (nokta) karakteri olmalı
     * @return true yada false
     */
    private boolean isAtIncluded(){
        if (mail.contains("@"))
            return true;
        else return false;
    }

    /**
     * metin girilmesi gerektiği kontrolü
     * @return true yada false
     */
    private boolean isStringEntered(){
        int index = mail.indexOf("@");
        if (index >1)
            return true;
        else return false;
    }
    private boolean isComEntered(){
        int index = mail.indexOf(".");
        if(mail.substring(index+1).contains("com"))
            return true;
        else return false;
    }

}
