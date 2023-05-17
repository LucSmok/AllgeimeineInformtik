import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Schleifen {

    private ArrayList<Integer> list = new ArrayList<>();

    public Schleifen(Integer[] liste){
        //Var1
        this.list = new ArrayList<>(Arrays.asList(liste));
        //Var2
        /*for (Integer item:liste) {
            this.list.add(item);
        }*/

    }

    public int summiereBis(int index){
        int sum = 0;
        if (index<list.size()){
            int i = 0;
            while (i < index){
                i++;
                sum += list.get(i);
            }
        }else{
         System.out.println("Index zu groß");
        }
        return sum;
    }

    public int summiereBisAlt(int index){
        int sum = 0;
        if (index<list.size()){
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()){
                sum += it.next();
            }
        }else{
            System.out.println("Index zu groß");
        }
        return sum;
    }

}
