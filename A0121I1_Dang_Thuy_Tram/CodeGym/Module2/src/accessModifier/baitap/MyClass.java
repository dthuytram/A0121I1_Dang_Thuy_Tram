package access_modifier.baitap;


//    A.B o = new A.B();
//    A.C o1 = new A.C();  // C not static
//    A.C o2 = new A().new C();
//
//    void method(int[] x) {
//        x[0] = 5;
//        x[1] = 5;
//    }
//
//    public static void main(String[] args) {
//        MyClass o = new MyClass();
//        int[] x = {1, 1};
//        o.method(x);
//        System.out.printf("x=%d, y=%d", x[0], x[1]);
        // object tham chieu
        // nguyenthuy tham tri
    class ChuNhat{
        public int rong, dai;

        public ChuNhat(int rong, int dai) {
                this.rong = rong;
                this.dai = dai;
        }
    }

        class MyClass {
            void method(ChuNhat x) {
                x.rong = 5;
                x.dai = 5;
            }

            public static void main(String[] args) {
                MyClass o = new MyClass();
                ChuNhat cn = new ChuNhat(1, 1);
                o.method(cn);
                System.out.printf("x=%d, y=%d", cn.rong, cn.dai);
            }


}
