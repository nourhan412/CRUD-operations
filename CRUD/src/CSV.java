import java.io.*;
import java.util.*;
public class CSV {
public static void main(String []args) throws Exception {
           System.out.println("Enter the number of the service you want:");
           System.out.println("1 -> Insert new record\n2 -> Delete record\n3 -> update record\n" +
                   "4 -> search for a specific record\n5 -> Display a specific record");
           Scanner input=new Scanner(System.in);
           int order=input.nextInt();
          switch (order){
              case 1:
                insert();
                break;
              case 2:
                 delete();
                  break;
              case 3:
                  update();
                  break;
              case 4:
                  search();
                  break;
              case 5:
                  display();
                  break;
              default:
                  System.out.println("There is a problem, try again!");
          }
   }
   //Insert new record:-
   public static void insert(){
       Scanner input=new Scanner(System.in);
       System.out.print("Enter the ID: ");
       int id = input.nextInt();
       System.out.println("Enter the First Name");
       String fName = input.next();
       if(fName.matches(".*\\d.*")) {
       System.out.println("An error occur!(First name can not contains any numbers)");
       return;
       }
       System.out.println("Enter the Last Name ");
       String lName = input.next();
       if(lName.matches(".*\\d.*")) {
           System.out.println("An error occur!(Last name can not contains any numbers)");
           return;
       }
       System.out.println("Enter the Age");
       int age = input.nextInt();
       System.out.println("Enter the Salary");
       int salary = input.nextInt();
       System.out.println("Enter the Phone Number");
       String phone = input.next();

       Record record = new Record(id , fName , lName , age , salary , phone );
       try {
           PrintWriter writer = new PrintWriter(new FileWriter(
                   "Records.csv",true));
           writer.append(record.DisplayRecord());
           writer.append("\n");
           writer.close();
           System.out.println("Record inserted successfully.");
       } catch (IOException e) {
           System.out.println(e);
       }
   }

   //Given the index, delete the record at this index:-
   public static void delete()
   {
       System.out.print("Please enter the index of that record : ");
       Scanner input=new Scanner(System.in);
       int n=input.nextInt();
       try {
           BufferedReader bufReader = new BufferedReader(new FileReader(
                   "Records.csv"));
           ArrayList<String> listOfLines = new ArrayList<>();

           String line = bufReader.readLine();
           while (line != null) {
               listOfLines.add(line);
               line = bufReader.readLine();
           }
           bufReader.close();
           listOfLines.remove(n);
           PrintWriter p = new PrintWriter(new FileWriter(
                   "Records.csv", false));
           for (String str : listOfLines) {
               p.write(str + System.lineSeparator());
           }
           p.close();
           System.out.println("Record deleted successfully");
       }catch(IOException e)
       {
           System.out.println(e);
       }
   }

   //Given the index, update the data of the record at this index by a new data:-
   public static void update(){
       Scanner input=new Scanner(System.in);
       System.out.print("Please enter the index of that record : ");
       int idx=input.nextInt();
       System.out.print("Enter the old data you want to update:");
       String old=input.next();
       System.out.print("Enter the new data :");
       String nw=input.next();
       try {
           BufferedReader bufReader = new BufferedReader(new FileReader(
                   "Records.csv"));
           ArrayList<String> listOfLines = new ArrayList<>();
           int count=0;
           String line = bufReader.readLine();
           while (line != null) {
               if(idx==count)
               {
                   line=line.replace(old,nw);
               }
               count++;
               listOfLines.add(line);
               line = bufReader.readLine();
           }
           bufReader.close();
           PrintWriter pp = new PrintWriter(new FileWriter(
                   "Records.csv", false));
           for (String str : listOfLines)
               pp.write(str + System.lineSeparator());

           pp.close();
           System.out.println("Data updated successfully");
       }catch(IOException e ) {
           System.out.println(e);
       }
   }

   //given the id of record, do search, and return its index
    public static void search()
   {
       Scanner input=new Scanner(System.in);
       System.out.print("Enter the ID of that record : ");
       int ID=input.nextInt();
       try {
           Scanner s = new Scanner(new File("Records.csv"));
           String delimiter = ",";
           String line = s.nextLine();
           int c = 0;
           while (line != null) {
               String[] rec = line.split(delimiter);
               if (Integer.parseInt(rec[0]) == ID) {
                   break;
               }
               line = s.nextLine();
               c++;
           }
           System.out.println("It is found at index : " + c);
       }catch(Exception e) {
           System.out.println(e);
       }
   }

   //Display the record at the given index:-
   public static void display(){
       Scanner input=new Scanner(System.in);
       System.out.print("Please enter the index of that record : ");
       int num=input.nextInt();
       try {
           Scanner in = new Scanner(new File("Records.csv"));
           int counter = 0;
           System.out.println("Data of index " + num + " : ");
           while (in.hasNext()) {
               if (counter == num) {
                   System.out.println(in.nextLine());
                   break;
               } else
                   in.nextLine();
               counter++;
           }
       }catch(IOException ex)
       {
           System.out.println(ex);
       }
   }
}

