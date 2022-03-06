public class TestPuzzle {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        // Ten Rollds Test

        int[] tenRolls = generator.getTenRolls();
        for (int i = 0; i < tenRolls.length; i++) {
            System.out.println(String.format("Roll number %d: ", i + 1) + tenRolls[i]);
        }

        // Random Letter Test

        char randomLetter = generator.getRandomLetter();
        System.out.println("\nRandom Letter: " + randomLetter);

        // Generate Password Test

        String password = generator.generatePassword();
        System.out.println("\nGenerated Password: " + password);

        // Generate Password Set Test

        String[] passwordSet = generator.getNewPasswordSet(10);
        System.out.println(String.format("\nGenerated %d Password Set:\n", passwordSet.length));
        for (int i = 0; i < passwordSet.length; i++) {
            System.out.println("\n" + passwordSet[i]);
        }

        // Shuffle Array Test
        int[] array = { 1, 2, 3, 4, 5 };
        int[] shuffledArray = generator.shuffleArray(array);
        System.out.println("\nShuffled Array:\n");
        for (int i = 0; i < shuffledArray.length; i++) {
            System.out.println(shuffledArray[i]);
        }
    }
}
