package Main;

public enum season {
    spring("spring") , summer("summer") , autumn("autumn") , winter("winter");
    private String name ;
    season(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
