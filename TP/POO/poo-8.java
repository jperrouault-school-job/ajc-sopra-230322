

int a = 6;


void demoVariable(int a) {
    a = 7;
    System.out.println(a); // 7
}

System.out.println(a); // 6




class Demo {
    int a = 6;

    void demoVariable(int a) {
        System.out.println(this.a); // 6
        System.out.println(a); // 5
        a = 7;
        System.out.println(a); // 7
    }

    void demoVariable2() {
        System.out.println(a); // 6
    }
}


int a = 5;
Demo demo = new Demo();
demo.demoVariable(a);

System.out.println(a); // 5

demo.demoVariable2();




