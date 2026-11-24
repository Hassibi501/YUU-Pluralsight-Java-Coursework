package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * =============================================================================
 * BED FRAME WEBSHOP - JAVA STREAM API LEARNING APPLICATION
 * =============================================================================
 *
 * BEFORE YOU READ THE CODE: THE "CONVEYOR BELT" MENTAL MODEL
 *
 * If Streams feel confusing right now, think of a Stream as a FACTORY CONVEYOR BELT.
 *
 *   1. A List (like our list of BedFrames) is a STORAGE WAREHOUSE. It holds data.
 *   2. Calling .stream() puts those items onto a CONVEYOR BELT, one at a time.
 *      A Stream does NOT store data—it only moves data through processing stations.
 *   3. INTERMEDIATE OPERATIONS (like filter, map, sorted, distinct, limit) are
 *      WORKSTATIONS along the belt. Each station inspects or transforms an item
 *      and passes it down the belt to the next station.
 *   4. TERMINAL OPERATIONS (like forEach, toList, count, min, max, reduce, collect)
 *      are the END OF THE BELT—and also the "ON" SWITCH.
 *
 * THREE GOLDEN RULES OF STREAMS:
 *   - Rule 1 (LAZY EVALUATION): Setting up workstations (intermediate operations)
 *     does NOTHING on its own. The conveyor belt does not even turn on until you
 *     attach a terminal operation at the end.
 *   - Rule 2 (NON-DESTRUCTIVE): A Stream NEVER modifies your original List.
 *     Your warehouse (bedFrames) stays completely untouched; the belt produces
 *     a brand-new result at the end.
 *   - Rule 3 (ONE-TIME USE): Once a terminal operation finishes, that Stream is
 *     closed and cannot be reused. To process the data again, just call .stream()
 *     again on your original List.
 *
 * QUICK JARGON DECODER (explained in even more detail in the examples below):
 *   - Lambda expression (x -> x.price() < 300):
 *       A mini, nameless method you write on the spot. Read "->" as "goes to" or "do this with it".
 *   - Method reference (BedFrame::name):
 *       A shorter way to write a lambda when you are just calling one existing method.
 *       BedFrame::name means the exact same thing as: frame -> frame.name()
 *   - Predicate:
 *       Fancy word for a yes/no question (a lambda that returns true or false).
 *   - Comparator:
 *       A "judge" that compares two items to decide which one should come first when sorting.
 *   - Optional:
 *       A "safety box" that might hold a value, or might be empty. It prevents crashes
 *       when a search (like finding the cheapest item) finds nothing.
 * =============================================================================
 */
public class Main {

    /**
     * WHAT IS A 'record'?
     * Normally in Java, creating a simple data class requires writing a lot of repetitive
     * boilerplate code: private fields, a constructor, getters (getName(), getPrice()),
     * equals(), hashCode(), and toString().
     *
     * A 'record' (added in Java 16) is a shortcut for a simple data carrier.
     * By writing just these 7 fields below, Java automatically generates:
     *   - A constructor: new BedFrame(1, "Nordic...", "Pine Wood", ...)
     *   - Getter methods named AFTER THE FIELD (without "get"):
     *       frame.id(), frame.name(), frame.price(), frame.stockQuantity(), etc.
     *   - Automatic immutability: once a BedFrame is created, its fields cannot be changed.
     *   - Automatic equals(), hashCode(), and toString() methods.
     */
    public record BedFrame(
            int id,
            String name,
            String material,
            String size,
            double price,
            int stockQuantity,
            double customerRating
    ) {
        /**
         * Formats a BedFrame into a neat, aligned table row for printing in the console.
         * (String.format uses placeholders like %-23s = left-aligned text of 23 characters,
         *  %02d = 2-digit whole number with leading zero, %.2f = decimal with 2 digits.)
         */
        public String toDisplayString() {
            // Ternary operator: a compact if/else -> (condition ? valueIfTrue : valueIfFalse)
            String stockStatus = stockQuantity > 0
                    ? stockQuantity + " in stock"
                    : "OUT OF STOCK";

            return String.format(
                    "#%02d | %-23s | %-11s | %-10s | €%6.2f | %-12s | Rating: %.1f/5.0",
                    id, name, material, size, price, stockStatus, customerRating
            );
        }
    }

    public static void main(String[] args) {
        // Create our "warehouse" of 16 bed frames.
        // We pass this same list into every example method.
        List<BedFrame> bedFrames = createSampleDataset();

        // Scanner reads text typed by the user in the console.
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===========================================================================");
        System.out.println("        WELCOME TO THE BED FRAME WEBSHOP - JAVA STREAM API TRAINER         ");
        System.out.println("===========================================================================");

        while (running) {
            printMenu();
            System.out.print("Enter your choice (0-11): ");

            // Read the whole line as text and .trim() removes accidental spaces at the start/end.
            String userInput = scanner.nextLine().trim();

            // Try to turn the text into an integer. If the user typed "abc", catch the error
            // instead of crashing the program.
            int choice;
            try {
                choice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("\n[Invalid Input] Please enter a whole number between 0 and 11.\n");
                continue; // Jump back to the top of the while loop to ask again.
            }

            System.out.println();

            // Modern Java "arrow switch" (Java 14+):
            // Unlike older switch statements, you do NOT need 'break;' after each case.
            switch (choice) {
                case 1 -> example01ForEach(bedFrames);
                case 2 -> example02Filter(bedFrames);
                case 3 -> example03Map(bedFrames);
                case 4 -> example04Sorted(bedFrames);
                case 5 -> example05Distinct(bedFrames);
                case 6 -> example06Count(bedFrames);
                case 7 -> example07MinAndMax(bedFrames);
                case 8 -> example08Reduce(bedFrames);
                case 9 -> example09CollectAndGroupingBy(bedFrames);
                case 10 -> example10CombinedOperations(bedFrames);
                case 11 -> runAllExamples(bedFrames);
                case 0 -> {
                    System.out.println("Thank you for practicing the Java Stream API. Happy coding!");
                    running = false;
                }
                default -> System.out.println("[Invalid Choice] Please pick a number from 0 to 11.\n");
            }
        }

        scanner.close();
    }

    /**
     * Prints the interactive console menu.
     */
    private static void printMenu() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select a Java Stream API example to run:");
        System.out.println("  1.  forEach()               - Display all bed frames");
        System.out.println("  2.  filter()                - Find in-stock bed frames under €300");
        System.out.println("  3.  map()                   - Extract a list of product names");
        System.out.println("  4.  sorted()                - Sort bed frames by price (lowest to highest)");
        System.out.println("  5.  distinct()              - List all unique bed frame materials");
        System.out.println("  6.  count()                 - Count bed frames currently in stock");
        System.out.println("  7.  min() and max()         - Find cheapest and most expensive bed frames");
        System.out.println("  8.  reduce()                - Calculate total inventory value");
        System.out.println("  9.  collect() & groupingBy()- Group bed frames by material");
        System.out.println("  10. Combined operations     - Top 3 highest-rated in-stock frames < €500");
        System.out.println("  11. Run ALL examples");
        System.out.println("  0.  Exit");
        System.out.println("---------------------------------------------------------------------------");
    }

    /**
     * Helper method to print a consistent header for every example.
     */
    private static void printExampleHeader(int number, String title, String businessProblem, String operations) {
        System.out.println("===========================================================================");
        System.out.println("EXAMPLE " + number + ": " + title);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Business Problem : " + businessProblem);
        System.out.println("Stream Operations: " + operations);
        System.out.println("===========================================================================");
    }

    /**
     * Creates our sample dataset of 16 bed frames.
     *
     * Note on List.of(...):
     * This creates an "unmodifiable" (read-only) List. You cannot call .add() or .remove()
     * on it. That is great for Streams, because Streams never modify the source list anyway!
     */
    private static List<BedFrame> createSampleDataset() {
        return List.of(
                new BedFrame(1,  "Nordic Minimalist",      "Pine Wood",   "Single",     189.99, 12, 4.3),
                new BedFrame(2,  "Milan Metal Loft",       "Metal",       "Single",     149.50,  8, 4.1),
                new BedFrame(3,  "Cozy Cabin Frame",       "Pine Wood",   "Double",     249.00,  0, 4.5),
                new BedFrame(4,  "Urban Iron Classic",     "Metal",       "Double",     229.99, 15, 4.6),
                new BedFrame(5,  "Copenhagen Oak",         "Oak Wood",    "Queen",      459.00,  6, 4.8),
                new BedFrame(6,  "Velvet Dream",           "Velvet",      "Queen",      489.99,  4, 4.9),
                new BedFrame(7,  "Zen Bamboo Low",         "Bamboo",      "Double",     279.00,  9, 4.7),
                new BedFrame(8,  "Royal Heritage Oak",     "Oak Wood",    "King",       799.00,  3, 4.9),
                new BedFrame(9,  "CloudSoft Upholstered",  "Upholstered", "Queen",      399.50,  7, 4.4),
                new BedFrame(10, "Studio Compact",         "Metal",       "Single",     129.00, 20, 3.9),
                new BedFrame(11, "Eco Bamboo Haven",       "Bamboo",      "Queen",      349.00,  0, 4.8),
                new BedFrame(12, "Parisian Velvet Luxe",   "Velvet",      "King",       649.00,  2, 4.7),
                new BedFrame(13, "Scandi Pine Storage",    "Pine Wood",   "Queen",      319.00, 11, 4.5),
                new BedFrame(14, "Industrial Steel Pro",   "Metal",       "King",       429.00,  5, 4.2),
                new BedFrame(15, "Comfort Linen Platform", "Upholstered", "Double",     289.99, 10, 4.4),
                new BedFrame(16, "Artisan Solid Oak",      "Oak Wood",    "Super King", 949.00,  1, 5.0)
        );
    }

    /**
     * Runs all 10 examples one after another.
     */
    private static void runAllExamples(List<BedFrame> bedFrames) {
        example01ForEach(bedFrames);
        example02Filter(bedFrames);
        example03Map(bedFrames);
        example04Sorted(bedFrames);
        example05Distinct(bedFrames);
        example06Count(bedFrames);
        example07MinAndMax(bedFrames);
        example08Reduce(bedFrames);
        example09CollectAndGroupingBy(bedFrames);
        example10CombinedOperations(bedFrames);
    }

    // =========================================================================
    // EXAMPLE 1: forEach() — Learning Lambdas & Terminal Operations
    // =========================================================================
    private static void example01ForEach(List<BedFrame> bedFrames) {
        printExampleHeader(
                1,
                "forEach() - Display All Bed Frames",
                "Show every bed frame currently listed in the webshop catalog.",
                "stream(), forEach() [terminal]"
        );

        // --- PART A: TRADITIONAL (IMPERATIVE) APPROACH ---
        // "Imperative" means you give the computer step-by-step instructions on HOW to do the work
        // (like giving turn-by-turn driving directions).
        System.out.println("[Traditional Loop Output]");
        for (BedFrame frame : bedFrames) {
            System.out.println("  " + frame.toDisplayString());
        }

        System.out.println();

        // --- PART B: STREAM (DECLARATIVE) APPROACH ---
        // "Declarative" means you focus on WHAT you want done, and let Java handle the looping behind the scenes.
        //
        // BREAKING DOWN THE LAMBDA EXPRESSION:
        //   frame -> System.out.println("  " + frame.toDisplayString())
        //
        // Think of a lambda as a tiny, unnamed method written directly inside the parentheses:
        //   1. Left side of arrow ('frame'):
        //        This is the parameter name YOU invent for the current item on the conveyor belt.
        //        You could call it 'b' or 'bed' instead of 'frame'—Java doesn't care!
        //        Notice we didn't have to write '(BedFrame frame)'. Because the stream comes from
        //        List<BedFrame>, Java automatically knows 'frame' is a BedFrame (this is called "type inference").
        //   2. The arrow ('->'):
        //        Read this out loud as: "take this item, and do the following with it..."
        //   3. Right side of arrow ('System.out.println(...)'):
        //        The action to perform on that single item.
        //
        // WHAT IS forEach()?
        //   forEach() is a TERMINAL operation (the end of the conveyor belt).
        //   It takes a "Consumer" (a lambda that consumes an item and returns nothing / void).
        //   Once forEach() finishes printing all 16 items, the stream is done and closed.
        System.out.println("[Stream API Output]");
        bedFrames.stream()                                                    // Start conveyor belt: Stream<BedFrame>
                .forEach(frame -> System.out.println("  " + frame.toDisplayString())); // Terminal: print each item

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 2: filter() — Learning Predicates, Lazy Evaluation & Immutability
    // =========================================================================
    private static void example02Filter(List<BedFrame> bedFrames) {
        printExampleHeader(
                2,
                "filter() - Affordable & In-Stock Bed Frames",
                "Find all bed frames that cost less than €300 and are currently in stock.",
                "stream(), filter() [intermediate], toList() [terminal]"
        );

        // --- PART A: TRADITIONAL (IMPERATIVE) APPROACH ---
        // Notice all the manual bookkeeping we have to do:
        // 1) Create an empty list, 2) Loop over everything, 3) Check an 'if', 4) Manually add matches.
        List<BedFrame> affordableLoopResult = new ArrayList<>();
        for (BedFrame frame : bedFrames) {
            if (frame.price() < 300.0 && frame.stockQuantity() > 0) {
                affordableLoopResult.add(frame);
            }
        }
        System.out.println("[Traditional Loop Output] Found " + affordableLoopResult.size() + " matching frames:");
        for (BedFrame frame : affordableLoopResult) {
            System.out.println("  " + frame.toDisplayString());
        }

        System.out.println();

        // --- PART B: STREAM (DECLARATIVE) APPROACH ---
        // WHAT IS filter()?
        //   filter() is an INTERMEDIATE operation (a security checkpoint on the conveyor belt).
        //   You give it a PREDICATE — that's just a fancy word for a yes/no test (a lambda that
        //   returns a boolean: true = "let this item continue", false = "drop this item off the belt").
        //
        // WHY TWO filter() CALLS?
        //   You COULD write one filter: .filter(frame -> frame.price() < 300.0 && frame.stockQuantity() > 0)
        //   Splitting them into two separate lines is often cleaner and easier to read, like a checklist.
        //
        // HOW LAZY EVALUATION WORKS HERE:
        //   Java does NOT run the first filter on all 16 items, save a temporary list, and then run
        //   the second filter. Instead, nothing happens until .toList() turns on the belt. Then Java
        //   takes BedFrame #1 through BOTH filters, then BedFrame #2 through BOTH filters, and so on!
        //   If an item fails the first filter (price >= 300), Java skips the second filter for that item.
        //
        // DATA FLOW:
        //   List<BedFrame> (16 items)
        //     -> .stream()   : Stream<BedFrame>
        //     -> .filter(..) : Stream<BedFrame> (only items < €300 pass through)
        //     -> .filter(..) : Stream<BedFrame> (only items with stock > 0 pass through)
        //     -> .toList()   : List<BedFrame>   (Terminal: packs surviving items into a brand-new List)
        List<BedFrame> affordableStreamResult = bedFrames.stream()
                .filter(frame -> frame.price() < 300.0)       // Intermediate: yes/no test #1
                .filter(frame -> frame.stockQuantity() > 0)   // Intermediate: yes/no test #2
                .toList();                                    // Terminal (Java 16+): collect into a new List

        System.out.println("[Stream API Output] Found " + affordableStreamResult.size() + " matching frames:");
        affordableStreamResult.forEach(frame -> System.out.println("  " + frame.toDisplayString()));
        System.out.println("  (Notice that #03 'Cozy Cabin Frame' costs €249.00, but was excluded because stock is 0.)");

        // PROOF OF IMMUTABILITY: Our original 'bedFrames' list still has all 16 items!
        System.out.println("  (Original dataset still has " + bedFrames.size() + " bed frames — unchanged!)");

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 3: map() — Learning Transformations & Method References
    // =========================================================================
    private static void example03Map(List<BedFrame> bedFrames) {
        printExampleHeader(
                3,
                "map() - Extract Product Names",
                "Transform the list of BedFrame objects into a simple list of product name Strings.",
                "stream(), map() [intermediate], toList() [terminal]"
        );

        // --- PART A: TRADITIONAL (IMPERATIVE) APPROACH ---
        List<String> namesLoopResult = new ArrayList<>();
        for (BedFrame frame : bedFrames) {
            namesLoopResult.add(frame.name());
        }
        System.out.println("[Traditional Loop Output]");
        System.out.println("  " + namesLoopResult);

        System.out.println();

        // --- PART B: STREAM (DECLARATIVE) APPROACH ---
        // WHAT IS map()?
        //   Don't confuse the method .map() with the Map<K, V> data structure!
        //   In Streams, map() means "TRANSFORM each item into something else" (1 item in -> 1 item out).
        //   Here, a whole BedFrame object enters the station, and ONLY its String name comes out.
        //   Notice how the type on the conveyor belt changes:
        //     Stream<BedFrame>  --->  map()  --->  Stream<String>  --->  toList()  --->  List<String>
        //
        // WHAT IS A METHOD REFERENCE (BedFrame::name)?
        //   With a lambda, we would write:
        //       .map(frame -> frame.name())
        //   Look closely: the lambda does NOTHING except take 'frame' and immediately call .name() on it.
        //   Whenever a lambda just calls a single existing method, Java lets you shorten it using '::':
        //       ClassName::methodName  --->  BedFrame::name
        //   Both versions do the exact same thing! You can use whichever feels clearer to you.
        //   (Tip: If you want to do extra work, like making it uppercase, you can chain a second
        //    .map(String::toUpperCase) or write a lambda like .map(frame -> frame.name().toUpperCase()).)
        List<String> namesStreamResult = bedFrames.stream()
                .map(BedFrame::name)   // Intermediate: BedFrame -> String (same as: frame -> frame.name())
                .toList();             // Terminal: pack all 16 Strings into a List<String>

        System.out.println("[Stream API Output]");
        System.out.println("  " + namesStreamResult);

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 4: sorted() — Learning Comparators
    // =========================================================================
    private static void example04Sorted(List<BedFrame> bedFrames) {
        printExampleHeader(
                4,
                "sorted() - Sort Bed Frames by Price (Lowest to Highest)",
                "Display the catalog sorted from the most budget-friendly frame to the most expensive.",
                "stream(), sorted() [intermediate], toList() [terminal]"
        );

        // WHAT IS sorted()?
        //   sorted() is an INTERMEDIATE operation that puts items in order.
        //   If you have a Stream<String> or Stream<Integer>, Java already knows how to sort them
        //   (A-Z or 1-10), so you can just call .sorted() with empty parentheses.
        //
        //   HOWEVER, Java does NOT automatically know how to sort a custom BedFrame!
        //   Should it sort by name? By rating? By price?
        //   To tell Java the sorting rule, we pass in a COMPARATOR (a "judge").
        //
        // DECODING Comparator.comparingDouble(BedFrame::price):
        //   - Comparator.comparingDouble(...) builds a judge specifically for 'double' decimal numbers.
        //     (There is also comparingInt(...) for ints, and comparing(...) for Strings/objects.)
        //   - BedFrame::price tells the judge: "To compare two BedFrames, look at their price()!"
        //   - By default, it sorts ASCENDING (smallest to largest).
        //   - Want DESCENDING (largest to smallest)? Just add .reversed() at the end!
        //     (You will see .reversed() in action in Example 10.)
        //
        // NOTE: sorted() is a "stateful" intermediate operation—unlike filter(), it has to see
        // all the items before it can know which one is truly the cheapest.
        List<BedFrame> sortedByPrice = bedFrames.stream()
                .sorted(Comparator.comparingDouble(BedFrame::price)) // Intermediate: sort low -> high by price
                .toList();                                           // Terminal: collect into a new sorted List

        System.out.println("[Results - Sorted by Price Ascending]");
        sortedByPrice.forEach(frame -> System.out.println("  " + frame.toDisplayString()));

        // The original list is still in ID order (#01 first), NOT sorted by price.
        System.out.println("  (Proof of non-modification: First item in original list is still '"
                + bedFrames.get(0).name() + "' at €" + bedFrames.get(0).price() + ")");
        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 5: distinct() — Removing Duplicates & Chaining Multiple Steps
    // =========================================================================
    private static void example05Distinct(List<BedFrame> bedFrames) {
        printExampleHeader(
                5,
                "distinct() - Retrieve All Unique Materials",
                "Build a filter sidebar for the webshop showing every unique material without duplicates.",
                "stream(), map() [intermediate], distinct() [intermediate], sorted() [intermediate], toList() [terminal]"
        );

        // WHAT IS distinct()?
        //   distinct() is an INTERMEDIATE operation that acts like a bouncer with a checklist:
        //   if an item has already passed through, any identical duplicates are dropped.
        //   Under the hood, Java uses each object's .equals() method to check if two items match.
        //
        // WHY DO WE CALL map() BEFORE distinct()?
        //   All 16 BedFrames are unique objects (they have different IDs and names), so calling
        //   distinct() on BedFrames wouldn't remove anything!
        //   Instead, we FIRST use map() to extract just the material String ("Pine Wood", "Metal",
        //   "Pine Wood", "Metal"...), and THEN call distinct() to remove duplicate material Strings.
        //
        // DATA FLOW:
        //   Stream<BedFrame> (16 frames)
        //     -> .map(BedFrame::material) : Stream<String> (16 material names, with duplicates)
        //     -> .distinct()              : Stream<String> (only unique material names survive)
        //     -> .sorted()                : Stream<String> (sorted A-Z; no Comparator needed for Strings!)
        //     -> .toList()                : List<String>   (Terminal: final list of unique materials)
        List<String> uniqueMaterials = bedFrames.stream()
                .map(BedFrame::material) // Intermediate: BedFrame -> String (material)
                .distinct()              // Intermediate: drop duplicate Strings
                .sorted()                // Intermediate: sort Strings alphabetically (A -> Z)
                .toList();               // Terminal: pack into List<String>

        System.out.println("[Results - " + uniqueMaterials.size() + " Unique Materials]");
        uniqueMaterials.forEach(material -> System.out.println("  - " + material));

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 6: count() — Counting Without Creating a List
    // =========================================================================
    private static void example06Count(List<BedFrame> bedFrames) {
        printExampleHeader(
                6,
                "count() - Count In-Stock Bed Frames",
                "Determine how many distinct bed frame models are currently available to order (stock > 0).",
                "stream(), filter() [intermediate], count() [terminal]"
        );

        // WHAT IS count()?
        //   count() is a TERMINAL operation that simply counts how many items reach the end
        //   of the conveyor belt, returning a 'long' (a big whole number).
        //
        // WHY USE count() INSTEAD OF .toList().size()?
        //   If you called .toList().size(), Java would allocate memory to build a whole new List
        //   just to check its length and immediately throw the List away.
        //   With .count(), Java just increments a counter as each matching item passes by!
        //
        // SIDE NOTE FOR EXERCISES:
        //   count() is one of several "quick-answer" terminal operations. Other useful ones are:
        //     - anyMatch(predicate)  -> returns boolean: is at least ONE item matching?
        //     - allMatch(predicate)  -> returns boolean: do ALL items match?
        //     - noneMatch(predicate) -> returns boolean: do ZERO items match?
        long inStockCount = bedFrames.stream()
                .filter(frame -> frame.stockQuantity() > 0) // Intermediate: keep only in-stock frames
                .count();                                   // Terminal: return total number of survivors

        System.out.println("[Results]");
        System.out.println("  Total bed frame models : " + bedFrames.size());
        System.out.println("  Models in stock        : " + inStockCount);
        System.out.println("  Models out of stock    : " + (bedFrames.size() - inStockCount));

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 7: min() and max() — Understanding Optional<T>
    // =========================================================================
    private static void example07MinAndMax(List<BedFrame> bedFrames) {
        printExampleHeader(
                7,
                "min() and max() - Cheapest and Most Expensive Bed Frames",
                "Highlight the entry-level (cheapest) and luxury (most expensive) bed frames in the store.",
                "stream(), min() [terminal], max() [terminal], Optional"
        );

        // WHAT ARE min() AND max()?
        //   Both are TERMINAL operations. Just like sorted(), they need a Comparator ("judge")
        //   so they know WHAT property to compare (here, price).
        //
        // WHAT IS Optional<BedFrame> AND WHY DOES IT EXIST?
        //   Imagine our webshop had 0 bed frames, or we filtered for frames under €10 and found NONE.
        //   What should min() return if there is no minimum?
        //   In older Java, methods returned 'null' (nothing). If you forgot to check for null and
        //   called frame.name(), your program would immediately crash with a NullPointerException!
        //
        //   Optional<BedFrame> solves this by acting like a SEALED GIFT BOX:
        //     - Either there is a BedFrame inside the box (present),
        //     - Or the box is empty (empty).
        //   Java forces you to open the box safely before you can touch the BedFrame inside.
        //
        //   (Note: When working with primitive numbers like 'double' via mapToDouble() and average(),
        //    Java uses a specialized box called OptionalDouble—same exact concept!)
        Optional<BedFrame> cheapestFrame = bedFrames.stream()
                .min(Comparator.comparingDouble(BedFrame::price)); // Terminal: returns Optional<BedFrame>

        Optional<BedFrame> mostExpensiveFrame = bedFrames.stream()
                .max(Comparator.comparingDouble(BedFrame::price)); // Terminal: returns Optional<BedFrame>

        System.out.println("[Results]");

        // HOW TO SAFELY OPEN AN Optional BOX:
        //   There are several ways to open an Optional:
        //     1. ifPresentOrElse(doIfFound, doIfEmpty)  <-- used below!
        //     2. ifPresent(value -> ...)                <-- only run code if something is inside
        //     3. orElse(defaultValue)                   <-- get the value, or a fallback value if empty
        //
        //   Below, ifPresentOrElse takes TWO lambdas separated by a comma:
        //     - 1st lambda: frame -> ...   (runs if the box has a BedFrame)
        //     - 2nd lambda: () -> ...      (runs if the box is empty; '()' means 0 inputs)
        cheapestFrame.ifPresentOrElse(
                frame -> System.out.println("  Cheapest       : " + frame.toDisplayString()),
                () -> System.out.println("  Cheapest       : No bed frames available.")
        );

        mostExpensiveFrame.ifPresentOrElse(
                frame -> System.out.println("  Most Expensive : " + frame.toDisplayString()),
                () -> System.out.println("  Most Expensive : No bed frames available.")
        );

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 8: reduce() — Combining Many Values Into One Single Value
    // =========================================================================
    private static void example08Reduce(List<BedFrame> bedFrames) {
        printExampleHeader(
                8,
                "reduce() - Calculate Total Inventory Value",
                "Compute the total monetary value of all bed frames currently in the warehouse (price * stock).",
                "stream(), map() [intermediate], reduce() [terminal]"
        );

        // WHAT IS reduce()?
        //   "Reduce" means taking a stream of MANY items and boiling them down into ONE single result
        //   (like summing numbers, multiplying numbers, or joining strings together).
        //   reduce() is a TERMINAL operation.
        //
        // HOW reduce(identity, accumulator) WORKS STEP-BY-STEP:
        //   It takes two arguments:
        //     1. identity (0.0):
        //          Your starting value — think of pressing "Clear / 0" on a calculator before adding.
        //          If the stream is empty, reduce() safely returns this starting value (0.0).
        //     2. accumulator ((runningTotal, itemValue) -> runningTotal + itemValue):
        //          A 2-parameter lambda showing how to combine your total so far with the next item.
        //
        //   LET'S TRACE THE FIRST 3 ITEMS ON THE CONVEYOR BELT:
        //     Start : runningTotal = 0.0 (the identity)
        //     Item 1: €189.99 * 12 = 2279.88  ->  0.0 + 2279.88     = 2279.88  (new runningTotal)
        //     Item 2: €149.50 *  8 = 1196.00  ->  2279.88 + 1196.00 = 3475.88  (new runningTotal)
        //     Item 3: €249.00 *  0 =    0.00  ->  3475.88 + 0.00    = 3475.88  (new runningTotal)
        //     ...continues until all 16 items are folded into one final double!
        //
        //   (Tip: '(a, b) -> a + b' can also be written as the method reference Double::sum.
        //    Also, for pure number math like sum() or average(), Java offers specialized primitive
        //    streams via .mapToDouble(...), which give you .sum() and .average() directly!)
        double totalInventoryValue = bedFrames.stream()
                .map(frame -> frame.price() * frame.stockQuantity())                 // Intermediate: BedFrame -> Double (stock value)
                .reduce(0.0, (runningTotal, itemValue) -> runningTotal + itemValue); // Terminal: fold all values into one total

        System.out.println("[Results]");
        System.out.printf("  Total Warehouse Inventory Value: €%,.2f%n", totalInventoryValue);

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 9: collect() and groupingBy() — Organizing Data Into a Map
    // =========================================================================
    private static void example09CollectAndGroupingBy(List<BedFrame> bedFrames) {
        printExampleHeader(
                9,
                "collect() and groupingBy() - Group Bed Frames by Material",
                "Organize the webshop catalog into categories grouped by each bed frame's material.",
                "stream(), collect() [terminal], Collectors.groupingBy()"
        );

        // WHAT IS A Map<String, List<BedFrame>>?
        //   Think of a Map like a FILING CABINET with labeled drawers:
        //     - Each drawer has a unique label (the KEY)   -> here, a String material like "Oak Wood".
        //     - Inside each drawer is a folder (the VALUE) -> here, a List<BedFrame> of all Oak Wood beds.
        //
        // WHAT ARE collect() AND Collectors?
        //   - collect() is a powerful TERMINAL operation that packs stream items into a container
        //     (a List, a Set, a Map, or even a joined String).
        //   - Collectors is a utility class full of ready-made "packing recipes" you pass into collect().
        //
        // HOW Collectors.groupingBy(BedFrame::material) WORKS:
        //   As each BedFrame arrives at the end of the belt, Java checks its material:
        //     - "Pine Wood"? Put it in the "Pine Wood" drawer (creating the drawer if it's the first one).
        //     - "Metal"?     Put it in the "Metal" drawer.
        //   When finished, you get the entire filing cabinet: Map<String, List<BedFrame>>.
        //
        // ADVANCED TIP (Helpful for Exercise 4!):
        //   groupingBy() also has a 2-argument version:
        //       Collectors.groupingBy(classifierFunction, downstreamCollector)
        //   The 1st argument decides WHICH drawer to put an item in.
        //   The 2nd argument ("downstream collector") decides WHAT TO DO inside each drawer!
        //   By default, it collects items into a List. But you can swap that out to instead count
        //   how many items went into each drawer, sum their prices, etc.
        Map<String, List<BedFrame>> framesByMaterial = bedFrames.stream()
                .collect(Collectors.groupingBy(BedFrame::material)); // Terminal: build Map<String, List<BedFrame>>

        System.out.println("[Results - Grouped by Material]");

        // Map also has its own .forEach() method! Because each entry in a Map has TWO parts
        // (a key and a value), the lambda takes TWO parameters: (material, frames) -> { ... }
        framesByMaterial.forEach((material, frames) -> {
            System.out.println("  " + material + " (" + frames.size() + " models):");
            frames.forEach(frame -> System.out.println("    - " + frame.name() + " (€" + String.format("%.2f", frame.price()) + ")"));
        });

        System.out.println();
    }

    // =========================================================================
    // EXAMPLE 10: Combining Stream Operations — Real-World Pipelines
    // =========================================================================
    private static void example10CombinedOperations(List<BedFrame> bedFrames) {
        printExampleHeader(
                10,
                "Combining Operations - Top 3 Highest-Rated In-Stock Frames Under €500",
                "Recommend the 3 best-reviewed bed frames that customers can buy right now for under €500.",
                "stream(), filter() [intermediate], sorted() [intermediate], limit() [intermediate], toList() [terminal]"
        );

        // THE REAL POWER OF STREAMS: CHAINING WORKSTATIONS TOGETHER
        // Look at how this pipeline reads almost like plain English from top to bottom.
        // Imagine writing this with traditional for-loops, temporary lists, manual sorting,
        // and index checks—it would take 20+ lines of error-prone code!
        //
        // NEW OPERATIONS INTRODUCED HERE:
        //   1. .reversed():
        //        Comparator.comparingDouble(BedFrame::customerRating) sorts from LOWEST rating
        //        to HIGHEST (3.9 -> 5.0). Adding .reversed() flips it to HIGHEST first (5.0 -> 3.9).
        //   2. .limit(3):
        //        An INTERMEDIATE operation that only lets the first 3 items pass, then stops!
        //        This is called a "short-circuiting" operation because once it gets 3 items,
        //        it doesn't waste time passing the remaining items downstream.
        //
        // WHY DOES ORDER MATTER?
        //   Always put filter() BEFORE sorted()!
        //   Filtering first shrinks the data so sorted() has fewer items to sort.
        //   And put limit(3) AFTER sorted(), otherwise you'd just take the first 3 unsorted items!
        List<BedFrame> topThreeRecommendations = bedFrames.stream()
                .filter(frame -> frame.stockQuantity() > 0)                              // 1. Keep only in-stock frames
                .filter(frame -> frame.price() < 500.0)                                  // 2. Keep only frames under €500
                .sorted(Comparator.comparingDouble(BedFrame::customerRating).reversed()) // 3. Sort highest rating -> lowest
                .limit(3)                                                                // 4. Keep only the top 3
                .toList();                                                               // 5. Terminal: pack into a List

        System.out.println("[Results - Top 3 Recommended Bed Frames]");
        int rank = 1;
        for (BedFrame frame : topThreeRecommendations) {
            System.out.println("  #" + rank + " -> " + frame.toDisplayString());
            rank++;
        }

        System.out.println();
    }

    // =========================================================================
    // STUDENT EXERCISES (Practice on your own!)
    // =========================================================================
    //
    // HOW TO APPROACH THESE EXERCISES:
    //   1. Create a new static method in this class (e.g., private static void exercise01(List<BedFrame> bedFrames))
    //      and call it from main() or add a new option to the menu to test your work!
    //   2. Before coding, trace the conveyor belt in your head:
    //        - What type starts on the belt? (Stream<BedFrame>)
    //        - Which items need to be removed? (filter)
    //        - Does the type need to change? (map / mapToDouble)
    //        - Does the order matter? (sorted / limit)
    //        - What final answer do I want at the end? (toList, count, boolean, Optional, Map, print)
    //
    // TODO Exercise 1 (Beginner - filter & map):
    //   Find all bed frames of size "Queen" and create a List<String> containing
    //   their names formatted in UPPERCASE (e.g., "COPENHAGEN OAK").
    //   Hint: Chain filter(), map(), and toList(). (Remember to compare Strings with .equals(), not ==!)
    //
    // TODO Exercise 2 (Beginner - anyMatch / allMatch):
    //   Check whether the webshop sells at least one bed frame with a perfect 5.0
    //   customer rating, and check whether all "Metal" bed frames are currently in stock.
    //   Hint: Look up the terminal operations anyMatch() and allMatch() mentioned in Example 6.
    //
    // TODO Exercise 3 (Intermediate - mapToDouble & average):
    //   Calculate the average price of all "Oak Wood" bed frames.
    //   Handle the OptionalDouble result safely in case no Oak Wood frames exist.
    //   Hint: Use filter(), mapToDouble(BedFrame::price), and average().
    //         Review Example 7 on how to safely open an Optional box!
    //
    // TODO Exercise 4 (Intermediate - groupingBy with downstream collector):
    //   Count how many bed frames exist for each size ("Single", "Double", "Queen", etc.)
    //   and return a Map<String, Long>.
    //   Hint: Combine Collectors.groupingBy() with Collectors.counting() (see the tip in Example 9).
    //
    // TODO Exercise 5 (Intermediate - Multi-step pipeline):
    //   Find the 2 cheapest "Metal" or "Pine Wood" bed frames that have a customer
    //   rating of at least 4.2 and are currently in stock. Print their names and prices.
    //   Hint: Combine filter(), sorted(), limit(), and forEach().
}