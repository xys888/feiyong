package lambda;

/**
 * @date 2021年07月22日15:26
 */
public interface Test19 {
    @FunctionalInterface
    public interface NoReturnMultiParam {
        void method(int a, int b);
    }

    /**无参无返回值*/
    @FunctionalInterface
    public interface NoReturnNoParam {
        void method();
    }

    /**一个参数无返回*/
    @FunctionalInterface
    public interface NoReturnOneParam {
        void method(int a);
    }

    /**多个参数有返回值*/
    @FunctionalInterface
    public interface ReturnMultiParam {
        int method(int a, int b);
    }

    /*** 无参有返回*/
    @FunctionalInterface
    public interface ReturnNoParam {
        int method();
    }

    /**一个参数有返回值*/
    @FunctionalInterface
    public interface ReturnOneParam {
        int method(int a);
    }

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
        //....
    }
}
