package designPattern.abstractFactoryMode.factory;

import designPattern.abstractFactoryMode.face.Color;
import designPattern.abstractFactoryMode.face.Shape;

/**
 * 抽象工厂
 *
 * @author xys
 * @date 2021年05月26日14:26
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
