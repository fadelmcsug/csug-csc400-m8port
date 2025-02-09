import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonQueueTest {

	public static void main(String[] args) {
		Queue<Person> personQueue = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        int numPeople = 5;

        System.out.println("Enter the details for " + numPeople + " people:");
        
        // Prompt user for input to create 5 Person objects
        for (int i = 0; i < numPeople; i++) {
            System.out.println("Person " + (i + 1) + ":");
            
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            
            int age;
            while (true) {
                System.out.print("Age: ");
                try {
                    age = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid integer for age.");
                    scanner.nextLine();
                }
            }
            personQueue.enqueue((new Person(firstName, lastName, age)));
        }
        
        scanner.close();        
        
        // Print queue
        System.out.println("\n\nQueue contents:");
        System.out.println(personQueue.toString());
        
        // Sort by last name descending and print it
        personQueue.quicksort(Comparator.comparing(Person::getLastName).reversed());
        System.out.println("\nSorted by last name descending:");
        System.out.println(personQueue);

        // Sort by age descending and print it
        personQueue.quicksort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println("\nSorted by age descending:");
        System.out.println(personQueue);

	}
}