package designPattern.buildMode.abstractTest;

import designPattern.buildMode.face.Item;
import designPattern.buildMode.face.Packing;
import designPattern.buildMode.impl.paceImpl.Bottle;
import designPattern.buildMode.impl.paceImpl.Wrapper;

/**
 * 第三步
 * 实现Item接口
 * 创建包装和价格方法
 * 创建饮料分类
 *
 * @author xys
 * @date 2021年05月27日15:33
 */
public abstract class Street implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
