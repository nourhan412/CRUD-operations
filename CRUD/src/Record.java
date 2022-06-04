public class Record {
    public int id;
    public String fName;
    public String lName;
    public int age;
    public int salary;
    public String phone;

    public Record()
    {
      System.out.println("Record was created successfully\n");
    }

    public Record(int id,String fName,String lName,int age,int salary,String phone)
    {
        setID(id);
        setFName(fName);
        setLName(lName);
        setAge(age);
        setSalary(salary);
       setPhone(phone);
    }
    public void setID(int id)
    {
        this.id=id;
    }
    public void setFName(String fName)
    {
            this.fName = fName;
    }
    public void setLName(String lName)
    {
        this.lName=lName;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setSalary(int salary)
    {
        this.salary=salary;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public int getID()
    {
        return id;
    }
    public String getFName()
    {
        return fName;
    }
    public String getLName()
    {
        return lName;
    }
    public int getAge()
    {
        return age;
    }
    public int getSalary(){
        return salary;
    }
    public String getPhone(){
        return phone;
    }
   public String DisplayRecord()
   {
       return id+","+fName+","+lName+","+age+","+salary+","+phone;
   }
}
