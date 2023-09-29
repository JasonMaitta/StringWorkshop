import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";

        System.out.print("Enter a starting string: ");
        inputString = scanner.nextLine();

        while (true) {
            System.out.println("\nCurrent string: " + inputString);
            System.out.println("Pick an option:");
            System.out.println("1. Add content");
            System.out.println("2. Check if string contains substring");
            System.out.println("3. Output length");
            System.out.println("4. Output substring after prefix");
            System.out.println("5. Output substring before suffix");
            System.out.println("6. Output substring between prefix and suffix");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter content to add: ");
                String contentToAdd = scanner.nextLine();
                inputString = addContent(inputString, contentToAdd);
            } else if (choice == 2) {
                System.out.print("Enter substring to check: ");
                String substringToCheck = scanner.nextLine();
                checkSubstring(inputString, substringToCheck);
            } else if (choice == 3) {
                outputLength(inputString);
            } else if (choice == 4) {
                System.out.print("Enter prefix: ");
                String prefix = scanner.nextLine();
                outputSubstringAfterPrefix(inputString, prefix);
            } else if (choice == 5) {
                System.out.print("Enter suffix: ");
                String suffix = scanner.nextLine();
                outputSubstringBeforeSuffix(inputString, suffix);
            } else if (choice == 6) {
                System.out.print("Enter prefix: ");
                String start = scanner.nextLine();
                System.out.print("Enter suffix: ");
                String end = scanner.nextLine();
                outputSubstringBetweenPrefixAndSuffix(inputString, start, end);
            } else if (choice == 7) {
                System.exit(0);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static String addContent(String input, String content) {
        return input.concat(content);
    }

    private static void checkSubstring(String input, String substring) {
        if (input.contains(substring)) {
            System.out.println("The string contains the substring.");
        } else {
            System.out.println("The string does not contain the substring.");
        }
    }

    private static void outputLength(String input) {
        System.out.println("Length is: " + input.length());
    }

    private static void outputSubstringAfterPrefix(String input, String prefix) {
        int index = input.indexOf(prefix);
        if (index != -1) {
            String substring = input.substring(index + prefix.length());
            System.out.println("Substring: " + substring);
        } else {
            System.out.println("Prefix not found in the string.");
        }
    }

    private static void outputSubstringBeforeSuffix(String input, String suffix) {
        int index = input.lastIndexOf(suffix);
        if (index != -1) {
            String substring = input.substring(0, index);
            System.out.println("Substring: " + substring);
        } else {
            System.out.println("Suffix not found in the string.");
        }
    }

    private static void outputSubstringBetweenPrefixAndSuffix(String input, String start, String end) {
        int startIndex = input.indexOf(start);
        int endIndex = input.lastIndexOf(end);
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            String substring = input.substring(startIndex + start.length(), endIndex);
            System.out.println("Substring: " + substring);
        } else {
            System.out.println("Prefix and/or suffix not found in the string.");
        }
    }
}