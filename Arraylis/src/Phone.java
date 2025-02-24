public class Phone {
    private String name;
    private String company;
    private int ram;
    private boolean on;

    private Phone(PhoneBuilder Phone){
        this.name=Phone.name;
        this.company=Phone.company;
        this.ram=Phone.ram;
        this.on=Phone.on;
    }
//    Phone(){}

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getRam() {
        return ram;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", ram=" + ram +
                ", on=" + on +
                '}';
    }

     static class PhoneBuilder{
        private String name;
        private String company;
        private int ram;
        private boolean on;

        public PhoneBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public PhoneBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setOn(boolean on) {
            this.on = on;
            return this;
        }
        public Phone build(){
            return new Phone(this);
        }
    }
}
