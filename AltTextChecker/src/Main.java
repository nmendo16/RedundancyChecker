import java.util.*;
import java.util.regex.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Start the loop to allow multiple tests
        boolean continueTesting = true;
        while (continueTesting) {
            // Get user input for alt text and caption
            System.out.println("Enter alt text (max 120 characters):");
            String altText = getAltTextInput(scanner);

            System.out.println("Enter caption:");
            String caption = scanner.nextLine();

            // Check redundancy between alt text and caption
            checkAltCaptionRedundancy(altText, caption);

            // Ask if the user wants to run another test
            System.out.println("\nDo you want to check another alt text and caption? (yes/no):");
            String userChoice = scanner.nextLine().trim().toLowerCase();
            if (userChoice.equals("no")) {
                continueTesting = false;
                System.out.println("Exiting the program. Goodbye!");
            }
        }

        scanner.close();
    }

    public static String getAltTextInput(Scanner scanner) {
        String altText = scanner.nextLine();

        // Ensure alt text does not exceed 120 characters
        while (altText.length() > 120) {
            System.out.println("Alt text exceeds 120 characters. Please enter alt text (max 120 characters):");
            altText = scanner.nextLine();
        }

        return altText;
    }

    public static void checkAltCaptionRedundancy(String altText, String caption) {
        // Normalize text (remove special characters and convert to lowercase)
        String cleanAltText = cleanText(altText);
        String cleanCaption = cleanText(caption);

        // Remove stop words
        Set<String> stopWords = createStopWordsSet();
        Set<String> altWords = new HashSet<>(Arrays.asList(cleanAltText.split(" ")));
        Set<String> captionWords = new HashSet<>(Arrays.asList(cleanCaption.split(" ")));

        altWords.removeAll(stopWords);
        captionWords.removeAll(stopWords);

        // Compute similarity score using Levenshtein Distance
        int similarity = calculateLevenshteinDistance(cleanAltText, cleanCaption);
        int maxLength = Math.max(cleanAltText.length(), cleanCaption.length());
        double similarityPercentage = 100 - ((double) similarity / maxLength * 100);

        // Find common words (ignoring stop words)
        altWords.retainAll(captionWords);  // Get common words

        // Output results
        System.out.println("Similarity Score: " + String.format("%.2f", similarityPercentage) + "%");
        System.out.println("Common Words (after filtering small words): " + String.join(", ", altWords));

        // Provide recommendation
        if (similarityPercentage > 70) {
            System.out.println("❌ The alt text is likely redundant. Consider making it more distinct.");
        } else if (similarityPercentage > 50) {
            System.out.println("⚠️ Some redundancy detected. Try rewording the alt text for better uniqueness.");
        } else {
            System.out.println("✅ The alt text and caption appear sufficiently distinct.");
        }
    }

    // Clean the input text by removing special characters and converting to lowercase
    public static String cleanText(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();
    }

    // Create a set of stop words (articles, conjunctions, prepositions, pronouns)
    public static Set<String> createStopWordsSet() {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "a", "an", "the", "and", "but", "or", "nor", "for", "yet", "so", "in", "on", "at", "by",
                "to", "with", "from", "of", "as", "if", "it", "he", "she", "they", "we", "you", "I", "me",
                "us", "him", "her", "them", "this", "that", "these", "those"
        ));
        return stopWords;
    }

    // Levenshtein Distance algorithm
    public static int calculateLevenshteinDistance(String source, String target) {
        int[][] matrix = new int[source.length() + 1][target.length() + 1];

        for (int i = 0; i <= source.length(); i++) matrix[i][0] = i;
        for (int j = 0; j <= target.length(); j++) matrix[0][j] = j;

        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                int cost = source.charAt(i - 1) == target.charAt(j - 1) ? 0 : 1;

                matrix[i][j] = Math.min(
                        Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1),
                        matrix[i - 1][j - 1] + cost
                );
            }
        }

        return matrix[source.length()][target.length()];
    }
}
