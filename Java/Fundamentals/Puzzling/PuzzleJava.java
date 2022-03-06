public class PuzzleJava {

    public int[] getTenRolls() {
        int[] arr;
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) Math.floor(Math.random() * 20) + 1;
        }
        return arr;
    }

    public char getRandomLetter() {
        char[] arr;
        arr = new char[26];
        int idx = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            arr[idx] = i;
            idx++;
        }
        return arr[(int) Math.floor(Math.random() * 26)];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;

    }

    public String[] getNewPasswordSet(int arrayLength) {
        String[] passwordSet;
        passwordSet = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            passwordSet[i] = generatePassword();
        }
        return passwordSet;
    }

    public int[] shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int random1 = (int) Math.floor(Math.random() * (arr.length));
            int random2 = (int) Math.floor(Math.random() * (arr.length));
            int temp = arr[random1];
            arr[random1] = arr[random2];
            arr[random2] = temp;

        }
        return arr;
    }
}
