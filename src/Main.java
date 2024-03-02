import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        separateOddEvenNumbers();
        removeDuplicateElementsInList();
        System.out.println("-----------------------------------");
        frequencyOfEachCharacter();
        System.out.println("-----------------------------------");
        sumOfAllDigit();
        System.out.println("-----------------------------------");
        frequencyOfEachLetter();
        System.out.println("-----------------------------------");
        sortDecimalReverseOrder();
        System.out.println("-----------------------------------");
        joinStringWithPrefixSuffix();
        System.out.println("-----------------------------------");
        threeMaximumMinimumNumbers();
        System.out.println("-----------------------------------");
        anagram();
        System.out.println("-----------------------------------");
        increasingOrderOfTheirLength();
        System.out.println("-----------------------------------");
        nonrepeatingcharacter();
        System.out.println("-----------------------------------");
        reverseEachWord();
        System.out.println("-----------------------------------");
        reverseIntegerArray();
    }

    public static void reverseIntegerArray(){
        int[] array = new int[] {5, 1, 7, 3, 9, 6};
        int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
        System.out.println(Arrays.toString(reversedArray));
    }

    public static void reverseEachWord(){
            String str = "Java Concept Of The Day";
            System.out.println(Stream.of(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));
        /*String reversedStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(reversedStr);*/
    }

    public static void nonrepeatingcharacter(){
        String s1 = "google";
        Character c = s1.chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map( e-> e.getKey())
                .findFirst().get();
        System.out.println(s1.indexOf(c));
    }

    public static void increasingOrderOfTheirLength(){
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    public static void anagram(){
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 =Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("strings are angram");
        } else {
            System.out.println("not anagram");
        }
    }

    public static void threeMaximumMinimumNumbers(){
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().sorted().limit(3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------------------------------");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void joinStringWithPrefixSuffix(){
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joiner = listOfStrings.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joiner);
    }

    public static void sortDecimalReverseOrder(){
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<Double> list = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void frequencyOfEachLetter(){
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> map = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map.entrySet().iterator().forEachRemaining(System.out::println);
    }

    public static void sumOfAllDigit(){
        int i = 15623;
        Integer a = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(a);
    }

    public static void frequencyOfEachCharacter(){
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> a = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(a);
    }

    public static void removeDuplicateElementsInList(){
        List<String> list = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> strings = list.stream().distinct().collect(Collectors.toList());
        System.out.println(strings);
    }

    private static void separateOddEvenNumbers() {
        List<Integer> listOfIntegers = Arrays.asList(10,11,12,13,14,15,16,17,18,19);
        Map<Boolean, List<Integer>> map = listOfIntegers.stream().collect(Collectors.partitioningBy(integer -> integer%2==0));
        Set<Map.Entry<Boolean, List<Integer>>> entrySet = map.entrySet();
        for(Map.Entry<Boolean,List<Integer>> a :entrySet ){
            if(a.getKey()){
                System.out.println("Even Numbers" + " = " + a.getValue());
            }else{
                System.out.println("Odd Numbers" + " = " + a.getValue());
            }
        }
    }

}
