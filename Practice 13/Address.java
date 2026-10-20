import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public void setCountry(String country) { this.country = country; }
    public void setRegion(String region) { this.region = region; }
    public void setCity(String city) { this.city = city; }
    public void setStreet(String street) { this.street = street; }
    public void setHouse(String house) { this.house = house; }
    public void setBuilding(String building) { this.building = building; }
    public void setApartment(String apartment) { this.apartment = apartment; }

    @Override
    public String toString() {
        return String.format(
            "Страна: [%s]\nРегион: [%s]\nГород: [%s]\nУлица: [%s]\nДом: [%s]\nКорпус: [%s]\nКвартира: [%s]\n",
            country, region, city, street, house, building, apartment
        );
    }

    public static Address parseWithSplit(String addressStr) {
        Address addr = new Address();
        
        String[] parts = addressStr.split(",");

        if (parts.length > 0) addr.setCountry(parts[0].trim());
        if (parts.length > 1) addr.setRegion(parts[1].trim());
        if (parts.length > 2) addr.setCity(parts[2].trim());
        if (parts.length > 3) addr.setStreet(parts[3].trim());
        if (parts.length > 4) addr.setHouse(parts[4].trim());
        if (parts.length > 5) addr.setBuilding(parts[5].trim());
        if (parts.length > 6) addr.setApartment(parts[6].trim());

        return addr;
    }

    public static Address parseWithTokenizer(String addressStr) {
        Address addr = new Address();
        
        StringTokenizer tokenizer = new StringTokenizer(addressStr, ",;-");
        
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim(); 
            
            switch (index) {
                case 0: addr.setCountry(token); break;
                case 1: addr.setRegion(token); break;
                case 2: addr.setCity(token); break;
                case 3: addr.setStreet(token); break;
                case 4: addr.setHouse(token); break;
                case 5: addr.setBuilding(token); break;
                case 6: addr.setApartment(token); break;
                default: break; 
            }
            index++;
        }
        return addr;
    }
}