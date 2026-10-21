import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("       Menu      ");
            System.out.println("1. Task 1");
            System.out.println("2. Task 2");
            System.out.println("3. Task 3");
            System.out.println("4. Task 4");
            System.out.println("0. End");
            System.out.print("Select a task: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    task1(scanner);
                    break;
                case 2:
                    task2(scanner);
                    break;
                case 3:
                    task3(scanner);
                    break;
                case 4:
                    task4(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Program end.");
                    break;
                default:
                    System.out.println("invalid choice.");
            }
        }
        scanner.close();
    }

    //Завдання 1
    private static void task1(Scanner in) {
        System.out.println("\nTask1");

        System.out.println("\n1: valid data -> valid result");
        System.out.print("Enter a (double): ");
        double a1 = in.nextDouble();
        System.out.print("Enter b (double): ");
        double b1 = in.nextDouble();
        double res1 = 1.0 / (a1 * Math.pow(b1, 2) - 2 * b1) + b1 / (3 * Math.pow(a1, 2) + 2);
        System.out.println("Result: " + res1);

        System.out.println("\n2: integer data -> valid result");
        System.out.print("Enter a (int): ");
        int a2 = in.nextInt();
        System.out.print("Enter b (int): ");
        int b2 = in.nextInt();
        double res2 = 1.0 / (a2 * b2 * b2 - 2 * b2) + (double) b2 / (3 * a2 * a2 + 2);
        System.out.println("Result: " + res2);

        System.out.println("\nВаріант 3: valid data -> integer result");
        System.out.print("Enter a (double): ");
        double a3 = in.nextDouble();
        System.out.print("Enter b (double): ");
        double b3 = in.nextDouble();
        int res3 = (int) (1.0 / (a3 * Math.pow(b3, 2) - 2 * b3) + b3 / (3 * Math.pow(a3, 2) + 2));
        System.out.println("Result: " + res3);
    }

    //Завдання 2
    private static void task2(Scanner in) {
        System.out.println("\nTask 2");

        System.out.print("Enter the size of array A (n):");
        int n = in.nextInt();
        int[] A = new int[n];
        System.out.print("Enter the size of array B (m):");
        int m = in.nextInt();
        int[] B = new int[m];

        System.out.println("Enter the elements of array A:");
        for (int i = 0; i < n; i++) A[i] = in.nextInt();
        System.out.println("Enter the elements of array B:");
        for (int i = 0; i < m; i++) B[i] = in.nextInt();

        int[] C = new int[n + m];
        int k = 0;

        // Елементи A, яких немає в B
        for (int i = 0; i < n; i++) {
            if (!contains(B, m, A[i]) && !contains(C, k, A[i])) {
                C[k++] = A[i];
            }
        }

        // Елементи B, яких немає в A
        for (int i = 0; i < m; i++) {
            if (!contains(A, n, B[i]) && !contains(C, k, B[i])) {
                C[k++] = B[i];
            }
        }

        System.out.println("Symmetric difference (array C):");
        if (k == 0) {
            System.out.println("The symmetric difference is empty.");
        } else {
            for (int i = 0; i < k; i++) {
                System.out.print(C[i] + " ");
            }
            System.out.println();
        }
    }

    private static boolean contains(int[] arr, int length, int val) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == val) return true;
        }
        return false;
    }

    // Завдання 3
    private static void task3(Scanner in) {
        System.out.println("\nTask 3");

        System.out.print("Enter the dimension of the square matrix (n):");
        int n = in.nextInt();
        int[][] A = new int[n][n];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = in.nextInt();
            }
        }

        System.out.print("Line numbers with symmetrical sequences:");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (isSymmetric(A[i])) {
                System.out.print((i + 1) + " "); // Виведення номеру (від 1)
                found = true;
            }
        }

        if (!found) {
            System.out.print("There are no such lines.");
        }
        System.out.println();
    }

    private static boolean isSymmetric(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            if (row[left] != row[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Завдання 4
    private static void task4(Scanner in) {
        System.out.println("\nTask 4");

        in.nextLine();

        System.out.println("Enter text:");
        String text = in.nextLine();

        String[] words = text.split("[\\s,.:;-?!]+");

        System.out.println("Text after removing words containing repeated letters:");
        boolean wordsFound = false;

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (!hasRepeatingLetters(word)) {
                System.out.print(word + " ");
                wordsFound = true;
            }
        }

        if (!wordsFound) {
            System.out.println("(All words were removed or the text was empty)");
        } else {
            System.out.println();
        }
    }

    private static boolean hasRepeatingLetters(String word) {
        String lowerWord = word.toLowerCase();
        for (int i = 0; i < lowerWord.length(); i++) {
            for (int j = i + 1; j < lowerWord.length(); j++) {
                if (lowerWord.charAt(i) == lowerWord.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}