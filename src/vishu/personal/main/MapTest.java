package vishu.personal.main;

public class MapTest{
    private int id;
    private String name;
    
    MapTest(){
    	
    }
    MapTest(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setid(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
