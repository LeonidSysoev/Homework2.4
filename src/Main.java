public class Main {
    public static void main(String[] args) {
        String login = "Leokjljkljl12212!!!!";
        System.out.println("login.length() = " + login.length());
        String password = "wwwwwwwww";
        String confirmPassword = "wwwwwwwww";

        if (checkRegistration(login, password, confirmPassword)) {
            System.out.println("Регистрация успешно пройдена");
        } else {
            System.out.println("Регистрация неудачна");
        }
    }

    public static boolean checkRegistration(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password);
            checkConfirm(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Проверка завершена");
        }
        return true;
    }


    public static boolean checkLogin(String str) {
        if (str.length() >= 20 || !str.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Логин не соответствует требованиям");
        }
        return true;
    }

    public static boolean checkPassword(String str) {
        if (str.length() > 20 || !str.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Пароль не соответствует требованиям");
        }
        return true;
    }

    public static boolean checkConfirm(String str1, String str2) {
        if (!str1.equals(str2)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }

}