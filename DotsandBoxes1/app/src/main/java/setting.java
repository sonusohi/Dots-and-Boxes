/**
 * Created by navpreet on 2/1/2016.
 */
public class setting {
    private String name;
    private int icon;

    public setting(int icon, String name){
        super();
        this.icon = icon;
        this.name = name;
    }

    public  String getName(){
        return name;
    }

    public int getIcon(){
        return  icon;
    }
}
