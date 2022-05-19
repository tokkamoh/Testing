package RangeClass;

import org.jfree.data.Range;
import java.io.*;

public class RangeClass {
    public void main(){
        Range r1=new Range(0.8,1.9);
        Range r2=new Range(2.1,4.0);
        Range combine=Range.combineIgnoringNaN(r1,r2);
        System.out.print(combine+"\n");
    }


}
