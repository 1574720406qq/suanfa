package com.atguigu;

/**
 * @Author: WangGuo
 * @Description:
 * @Date: Created in 10:58 上午 2020/7/25
 * @Modified By:
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
    }
}

class GraphicEditor{
    public void drawShape(Shap shap){
        shap.drawShap();
    }
}

abstract class Shap{
    public abstract void drawShap();
}

class Rectangle extends Shap{

    @Override
    public void drawShap() {
        System.out.println(" 画三角形 ");
    }
}

class Circle extends Shap{

    @Override
    public void drawShap() {
        System.out.println(" 画圆形 ");
    }
}
