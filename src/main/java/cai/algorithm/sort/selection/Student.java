package cai.algorithm.sort.selection;

public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    @Override
    public int compareTo(Student o) {
        if(age.equals(o.getAge())){
            return this.getName().compareTo(o.getName());
        }else{
            return age.compareTo(o.getAge());
        }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "["+this.name+","+this.age+"]";
    }
    
    

}
