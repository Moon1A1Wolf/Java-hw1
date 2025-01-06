import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while(true){ 
            try {
                Runnable[] tasks = new Runnable[] {
                    () -> task1(scanner),
                    () -> task2(scanner),
                    () -> task3(scanner),
                    () -> task4(scanner),
                    () -> task5(scanner),
                    () -> task6(scanner),
                    () -> task7(scanner),
                    () -> task8(scanner),
                    () -> task9(scanner),
                    () -> task10(scanner),
                    () -> task11(scanner),
                    () -> task12(scanner)
                };

                System.out.print("0 - exit. Input the task number (1-12): ");
                int taskNumber = scanner.nextInt();

                if (taskNumber==0) { break; }
                else if (taskNumber >= 1 && taskNumber <= 12) {
                    System.out.println("\nTask №"+taskNumber);
                    tasks[taskNumber - 1].run();
                    System.out.println();
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid number.");
                System.out.println();
            }
        }
        scanner.close();
    }

    private static void task1(Scanner scanner) {
        System.out.print("Input first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Input second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Input third number: ");
        int num3 = scanner.nextInt();

        String strNum = String.valueOf(num1) + num2 + num3;
        int number = Integer.parseInt(strNum);
        System.out.println("Your number: " + number);
    }

    private static void task2(Scanner scanner) {
        System.out.print("Input number: ");
        double num = scanner.nextInt();
        
        System.out.print("Input percent: ");
        double per = scanner.nextInt();

        double result = (num/100)*per;

        System.out.println(per+"% of "+num+". Result - " + result);
    }

    private static void task3(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Input a six-digit number: ");
        String num = scanner.nextLine().trim();

        if (num.length() != 6 || !num.matches("\\d{6}")) {
            System.out.println("Error: the entered number must be a six-digit number!");
        } else {
            char[] digits = num.toCharArray();

            char temp = digits[0];
            digits[0] = digits[5];
            digits[5] = temp;

            temp = digits[1];
            digits[1] = digits[4];
            digits[4] = temp;

            String swapNum = new String(digits);
            System.out.println("Result - " + swapNum);
        }
    }

    private static void task4(Scanner scanner) {
        System.out.print("Input a month number: ");
        int month = scanner.nextInt();

        String result="Autumn";
        if (month<=0 || month>12) { result = "There are only 12 months in a year!"; }
        else if (month<3 || month==12) { result = "Winter"; }
        else if (month<=5) { result = "Spring"; }
        else if (month<=8) { result = "Summer"; }
        
        System.out.println(result);
    }

    private static void task5(Scanner scanner) {
        System.out.print("Input array size: ");
        int size = scanner.nextInt();

        if (size <= 1) {
            System.out.println("Array size must be greater than 1.");
            return;
        }

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;;
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int min = 0, max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
            if (array[i] > array[max]) {
                max= i;
            }
        }
        System.out.println("Min: " + array[min] + " (" + min + ")");
        System.out.println("Max: " + array[max] + " (" + max + ")");

        for (int i = Math.min(min, max) + 1; i < Math.max(min, max); i++) {
            array[i] *= 2;
        }

        System.out.println("Result:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void task6(Scanner scanner) {
        System.out.print("Input first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Input second number: ");
        int num2 = scanner.nextInt();

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        
        System.out.print("Odd numbers: ");
        for (int i = min; i <= max; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void task7(Scanner scanner) {
        System.out.print("Input array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Array size must be greater than 0.");
            return;
        }

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }
        System.out.println("Negative: " + negativeCount);
        System.out.println("Positiv: " + positiveCount);
        System.out.println("Zero: " + zeroCount);
    }


    private static void task8(Scanner scanner) {

        List<Item> menu = Arrays.asList(
            new Item("Кава", 75.0),
            new Item("Чай", 20.0),
            new Item("Сік", 35.0),
            new Item("Круасан", 30.0),
            new Item("Торт", 105.0),
            new Item("Кекс", 45.0)
        );

        while (true) {
            System.out.print("Скільки людей замовляють? ");
            if (!scanner.hasNextInt()) {
                System.out.println("Введіть будь ласка число.");
                scanner.next();
                continue;
            }
            int numPeople = scanner.nextInt();
            if (numPeople<=0) {
                System.out.println("Кількість людей повинна бути більша 0.");
            }
            else {
                double total = 0.0;
                for (int i = 1; i <= numPeople; i++) {
                    System.out.println("\n--- Замовлення № " + i + " ---");
                    double person = 0.0;

                    System.out.println("\nМеню:");
                    for (int j = 0; j < menu.size(); j++) {
                        System.out.println((j + 1) + ". " + menu.get(j).name + " - " + menu.get(j).price + " грн");
                    }
                    while (true) {
                        System.out.print("0 - чек. Додати: ");
                        scanner.nextLine();
                        if (scanner.hasNextInt()) {
                            int choice = scanner.nextInt();
                            if (choice == 0) {
                                break;
                            }
                            if (choice >= 1 && choice <= menu.size()) {
                                person += menu.get(choice - 1).price;
                                System.out.println("Додано " + menu.get(choice - 1).name);
                            } else {
                                System.out.println("Такого пункту в меню немає.");
                            }
                        }
                        else System.out.println("Оберіть пункт меню.");
                    }
                    total += person;
                    System.out.println("Загальна сума для людини " + i + ": " + person + " грн");
                }  
                System.out.println("\nЗагальна сума замовлення для компанії: " + total + " грн"); 
                System.out.println("--------------------------------------");
                System.out.print("\nБажаєте зробити ще одне замовлення? (1-так; 2-ні): ");
                int repeat = scanner.nextInt();
                if (repeat==2) {
                    break;
                }    
            }
        }
    }

    private static void task9(Scanner scanner) {
        System.out.println("1 - random array");
        System.out.print("2 - input array \n : ");
        int choice = scanner.nextInt();

        System.out.print("Input number of rows in the array: ");
        int rows = scanner.nextInt();

        int[][] array;
        
        if (choice == 1) {
            System.out.print("Input number of columns in the array: ");
            int cols = scanner.nextInt();
            array = RandomArray(rows, cols);
        } else {
            scanner.nextLine(); 
            array = InputArray(scanner, rows);
        }

        System.out.println("\nYour array:");
        PrintArray(array);

        double[] ratios = ZeroRatios(array);

        System.out.println("\nZero element ratio:");
        System.out.println(Arrays.toString(ratios));
    }

    private static void task10(Scanner scanner) {
        System.out.print("Input the array size: ");
        int size = scanner.nextInt();
        int[] array = RandomArray(size, -50, 50);

        System.out.println("Your array:");
        System.out.println(Arrays.toString(array));

        int[][] resultArray = {
            filterArray(array, n -> n % 2 == 0),
            filterArray(array, n -> n % 2 != 0),
            filterArray(array, n -> n < 0),
            filterArray(array, n -> n > 0)
        };

        System.out.println("\nTwo-dimensional array:");
        System.out.println("Even numbers:     " + Arrays.toString(resultArray[0]));
        System.out.println("Odd numbers:      " + Arrays.toString(resultArray[1]));
        System.out.println("Negative numbers: " + Arrays.toString(resultArray[2]));
        System.out.println("Positive numbers: " + Arrays.toString(resultArray[3]));
    }

    private static void task11(Scanner scanner) {
        System.out.print("Start of the range: ");
        int start = scanner.nextInt();

        System.out.print("End of the range: ");
        int end = scanner.nextInt();

        int sum = sumRange(start, end);
        System.out.println("The sum of the numbers from " + start + " to " + end + " is: " + sum);
    }

    private static void task12(Scanner scanner) {
        String input = "1.2; 0.5; 7.0; 2.6; 5.0";
        System.out.println("Your string:\n"+input);

        String result = sortNums(input);
        System.out.println("Result:\n" + result);
    }


    public static String sortNums(String input) {
        String[] parts = input.split(";\\s*");
        double[] numbers = Arrays.stream(parts)
                                 .mapToDouble(Double::parseDouble)
                                 .toArray();
        double largest = Arrays.stream(numbers).max().orElse(Double.NaN);
        Arrays.sort(numbers);

        double[] reordered = new double[numbers.length];
        int index = 0;

        for (double num : numbers) {
            if (num <= largest) {
                reordered[index++] = num;
            }
        }
        for (String part : parts) {
            double num = Double.parseDouble(part);
            if (num > largest) {
                reordered[index++] = num;
            }
        }
        return Arrays.toString(reordered)
                     .replace("[", "")
                     .replace("]", "")
                     .replace(",", ";");
    }


    public static int sumRange(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }



    public static int[] filterArray(int[] array, Condition condition) {
        List<Integer> filtered = new ArrayList<>();
        for (int num : array) {
            if (condition.test(num)) {
                filtered.add(num);
            }
        }
        return filtered.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] RandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    interface Condition {
        boolean test(int number);
    }



    public static int[][] RandomArray(int rows, int cols) {
        Random rand = new Random();
        int[][] array = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = rand.nextInt(20) - 9;
            }
        }
        return array;
    }

    public static int[][] InputArray(Scanner scanner, int rows) {
        int[][] array = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            System.out.print("Input the elements " + (i + 1) + " line after comma: ");
            String input = scanner.nextLine();
            String[] parts = input.split(",");
            array[i] = new int[parts.length];
            
            for (int j = 0; j < parts.length; j++) {
                array[i][j] = Integer.parseInt(parts[j].trim());
            }
        }
        return array;
    }

    public static void PrintArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static double[] ZeroRatios(int[][] array) {
        double[] ratios = new double[array.length];
        
        for (int i = 0; i < array.length; i++) {
            int zeroCount = 0;
            int nonZeroCount = 0;
            
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    zeroCount++;
                } else {
                    nonZeroCount++;
                }
            }
            if (nonZeroCount == 0) {
                ratios[i] = zeroCount == 0 ? 0 : Double.POSITIVE_INFINITY;
            } else {
                ratios[i] = (double) zeroCount / nonZeroCount;
            }
        }
        return ratios;
    }
}
