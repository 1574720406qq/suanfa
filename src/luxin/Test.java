package luxin;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 7:46 下午 2020/7/13
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        //Eat eat = new Eat();
        //Human blackMan = new BlackMan();
        BlackMan human = BlackMan::Raop;
        human.tell();


    }
}

interface Human{
    void tell();
}

interface BlackMan {

    public void tell();

    public static void Raop(){
        System.out.println("i am a good rapper");
    }
}