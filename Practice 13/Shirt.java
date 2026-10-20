public class Shirt {
    private String id;
    private String name;
    private String color;
    private String size;

    public Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public String getSize() { return size; }

    @Override
    public String toString() {
        return "--- Информация о рубашке ---\n" +
               "Артикул (ID) : " + id + "\n" +
               "Наименование: " + name + "\n" +
               "Цвет        : " + color + "\n" +
               "Размер      : " + size + "\n";
    }
}