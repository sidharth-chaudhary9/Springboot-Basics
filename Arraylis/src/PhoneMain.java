public class PhoneMain {
    public static void main(String[] args) {
        Phone p1=new Phone.PhoneBuilder()
                .setName("Iphone")
                .build();
        System.out.println(p1);
//        Phone p1=new Phone();
//        Phone.PhoneBuilder pp=p1.new PhoneBuilder();
//        p1=pp.setName("Iphone").setCompany("Apple").build();
//        System.out.println(p1);
    }
}
