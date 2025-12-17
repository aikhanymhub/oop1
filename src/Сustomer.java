public class Сustomer {
    private String name;
    private Vehicle rentedVehicle;

    public Сustomer(String name){
        this.name = name;
        this.rentedVehicle = null;
    }

    public String getName(){return name;}
    public Vehicle getRentedVehicle(){return rentedVehicle;}

    public void rentVehicle( Vehicle vehicle){
        rentedVehicle = vehicle;
    }
    public void returnVehicle(){
        rentedVehicle = null;
    }
}
