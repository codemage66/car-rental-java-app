package Vehicle;

public enum TimeSpan {
     monthly("monthly") , yearly("yearly");
    private String name ;
      TimeSpan(String name){
       this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
