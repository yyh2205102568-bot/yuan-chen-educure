public class Student {
    int id;
    String name;

    public Student(int id,String name){
        this.id=id;
        this.name=name;
        
    }
    @Override
        public boolean equals(Object obj){
           
    if (this == obj) {
        return true;
    }

    if (obj instanceof Student) {

        Student other = (Student) obj;

        return this.id == other.id;
    }

    return false;
}
        }
