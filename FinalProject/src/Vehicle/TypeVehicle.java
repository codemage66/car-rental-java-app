package Vehicle;

public enum TypeVehicle {
    Car("Car"), Bus("Bus"), Truck("Truck"), Motorcycle("Motorcycle");
    private String name ;
    TypeVehicle(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
