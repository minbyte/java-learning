package com.mindasoft._12_design_pattern._04_abstract_factory;

/**
 * 装机工程师类跟前面的实现相比，主要的变化是：从客户端不再传入选择CPU和主板的参数，而是直接传入客户已经选择好的产品对象。
 * 这样就避免了单独去选择CPU和主板所带来的兼容性问题，客户要选就是一套，就是一个系列。
 * @author: min
 * @date: 2019/4/2 14:35
 * @version: 1.0.0
 */
public class ComputerEngineer {
    /**
     * 定义组装机需要的CPU
     */
    private Cpu cpu = null;
    /**
     * 定义组装机需要的主板
     */
    private Mainboard mainboard = null;
    public void makeComputer(ComputeFactory af){
        /**
         * 组装机器的基本步骤
         */
        //1:首先准备好装机所需要的配件
        prepareHardwares(af);
        //2:组装机器
        //3:测试机器
        //4：交付客户
    }
    private void prepareHardwares(ComputeFactory af){
        //这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //直接找相应的工厂获取
        this.cpu = af.createCpu();
        this.mainboard = af.createMainboard();

        //测试配件是否好用
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}