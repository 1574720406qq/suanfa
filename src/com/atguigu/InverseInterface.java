package com.atguigu;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 11:48 下午 2020/7/21
 * @Modified By:
 */
public class InverseInterface {
    public static void main(String[] args) {
        Person person = new Person();
        person.reveice(new Email());
        person.reveice(new WeChat());
    }
}

interface IReceiver{
    String getInfo();
}


class Email implements IReceiver{
    public String getInfo(){
        return "电子邮件信息：hello,world";
    }
}

class WeChat implements IReceiver{

    @Override
    public String getInfo() {
        return "微信信息：hello world";
    }
}

class Person{
    public void reveice(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}




