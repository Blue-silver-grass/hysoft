package cn.hysoft.cpp;

public class AI {
    public static void main(String[] args) {
        int b=0;
        int a[] = {1,2,3,4,5,6,7,3};
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                if (i==j) continue;
                if (a[i] == a[j]){
                    b=i;break;
                }
            }
        }
        System.out.println(a[b]);
    }
}
