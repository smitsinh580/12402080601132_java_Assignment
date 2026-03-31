import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Collections
        ArrayList<Student> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        TreeMap<Integer, String> tmap = new TreeMap<>();

        int choice;

        do {
            System.out.println("\n--- CRUD MENU ---");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

              
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    Student s = new Student(id, name);
                    list.add(s);
                    map.put(id, name);
                    tmap.put(id, name);

                    System.out.println(" Record Added!");
                    break;

               
                case 2:
                    System.out.println("\n--- ArrayList ---");
                    for (Student st : list) {
                        System.out.println(st);
                    }

                    System.out.println("\n--- HashMap ---");
                    for (Map.Entry<Integer, String> e : map.entrySet()) {
                        System.out.println(e.getKey() + " -> " + e.getValue());
                    }

                    System.out.println("\n--- TreeMap (Sorted) ---");
                    for (Map.Entry<Integer, String> e : tmap.entrySet()) {
                        System.out.println(e.getKey() + " -> " + e.getValue());
                    }
                    break;

                
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    
                    for (Student st : list) {
                        if (st.id == uid) {
                            st.name = newName;
                        }
                    }

                   
                    if (map.containsKey(uid)) {
                        map.put(uid, newName);
                        tmap.put(uid, newName);
                        System.out.println(" Record Updated!");
                    } else {
                        System.out.println(" ID not found!");
                    }
                    break;

               
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    
                    list.removeIf(st -> st.id == did);

                    
                    map.remove(did);
                    tmap.remove(did);

                    System.out.println("🗑 Record Deleted!");
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
