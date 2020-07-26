package com.atguigu;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 11:06 上午 2020/7/25
 * @Modified By:
 */
public class InterfaceOCP {
    public static void main(String[] args) {
        GraphEditor graphicEditor = new GraphEditor();
        graphicEditor.drawShap(new Rectangle1());
    }
}

class GraphEditor{
    public void drawShap(drawShape shape){
        shape.drawShape();
    }
}

interface drawShape{
    void drawShape();
}

class Rectangle1 implements drawShape{

    @Override
    public void drawShape() {
        System.out.println(" 画三角形 ");
    }
}

class Circle1 implements drawShape{

    @Override
    public void drawShape() {
        System.out.println(" 画圆形 ");
    }
}
