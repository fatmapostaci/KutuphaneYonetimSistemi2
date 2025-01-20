package utilities;

public class PasswordFormatControl {
    static String password1;
    static String password2;

    static boolean isPasswordValid = false;

    public static void getAndValidatePassword1and2() {
         do{
            setPassword1();

            if (isPasswordAllInteger()) {
                System.out.println("Parola sadece sayılardan oluşamaz.");
                continue; // Döngünün başına dön
            }

            if (!isLongerThanEight()) {
                System.out.println("Karakter uzunluğu en az 8 olmalı.");
                continue; // Döngünün başına dön
            }

            isPasswordValid = true; // Eğer buraya ulaşıldıysa, password1 geçerli
        }while (!isPasswordValid);

         //ilk password koşulları sağladıysa teyit amaçlı tekrar password sorulur
        System.out.print("---Tekrar ");
        setPassword2();

        if (isPasswordMatches()) {
            System.out.println("Şifre başarıyla kaydedildi!");
        } else {
            System.out.println("Şifreler eşleşmiyor. Lütfen tekrar deneyin.");
            isPasswordValid = false; // Tekrar baştan başlat
            getAndValidatePassword1and2();
        }
    }

    /**
     * Checks the user's password by comparing it with the input.
     * The user has three attempts to enter the correct password.
     *
     * @return true if the password matches, false otherwise.
     */
    public static boolean getAndValidatePasword2(String password) {

        //kullanıcı ismi listede mevcut ise password kontrolü yapar
        password1 = password;
        int counter = 0;
        do {
            // döngü bitene kadar password kullanıcıdan input olarak alınır

            //kullanıcıdan password2 input olarak alınır.
            setPassword2();

            //eğerki password1 ile pasword2 eşleşiyorsa method sonlanır, true döner
            if (isPasswordMatches()) {
                return true;
            } else System.out.print("Hatalı password.Tekrar deneyin! \n");
            counter++;
        } while (counter < 3);  //3 kez şifre girene kadar döngü devam eder

        //password1 ile pasword2 eşleşmiyorsa method false döner
        return false;
    }

    public static String getPassword1() {
        return password1;
    }

    public static String getPassword2() {
        return password2;
    }

    public static void setPassword1(String password1) {
        password1 = password1;
    }
    public static void setPassword1() {
        System.out.print("---Password: ");
        password1 = TryCatch.scan.next();
    }
    public static void setPassword2() {
        System.out.print("Password: ");
        password2 = TryCatch.scan.next();
    }

    public static boolean isPasswordMatches() {
        return password1.equals(password2);
    }

    public static boolean isPasswordAllInteger() {
        // Parolanın her bir karakterini kontrol et
        for (int i = 0; i < password1.length(); i++) {
            if (!Character.isDigit(password1.charAt(i))) {
                return false; // Eğer sayı olmayan bir karakter bulursa false döner
            }
        }
        return true; // Eğer tüm karakterler sayı ise true döner
    }

    public static boolean isLongerThanEight() {
        return password1.length() >= 8;
    }


}
