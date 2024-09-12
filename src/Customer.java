public class Customer {
String name;
String surname;
String email;
int id;

public Customer(String name,String surname,String email,int id){
    this.name=name;
    this.surname=surname;
    this.email=email;
    this.id=id;
}

public void customerInfo(){
    System.out.println("Ad:"+name+"Soyad:"+surname+"Email"+email+"id:"+id);
}
}
