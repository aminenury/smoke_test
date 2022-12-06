public class categorypojo {
    private int id;
    private String name;

    public categorypojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public categorypojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "categorypojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
