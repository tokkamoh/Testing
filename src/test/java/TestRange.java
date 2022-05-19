
import org.jfree.data.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRange {

    @Test
    public void Test1()
    {
        Range r1=new Range(0.8,1.9);
        Assertions.assertEquals(0.8,r1.getLowerBound());

    }
    @Test
    public void Test2()
    {
        Range r1=new Range(0.8,1.9);
        Assertions.assertEquals(1.9,r1.getUpperBound());

    }
    @Test
    public void Test3()
    {
        Range r2=new Range(2.1,4.0);
        Assertions.assertNotEquals(0.7,r2.getLowerBound());

    }
    @Test
    public void Test4()
    {
        Range r2=new Range(2.1,4.0);
        Assertions.assertNotEquals(4.3,r2.getUpperBound());
    }


    @Test
    public void TestCase1()
    {
        Range r1=new Range(0.8,1.9);
        Range r2=new Range(2.1,4.0);
        Range combine=Range.combine(r1,r2);
        Range test=new Range(0.8,4.0);
        Assertions.assertEquals(test,combine);

    }
    @Test
    public void TestCase2()
    {
        Range r1=new Range(0.8,1.9);
        Range r2=new Range(2.1,4.0);
        Range combine=Range.combine(r1,r2);
        Range test=new Range(0.8,1.9);

        Assertions.assertNotEquals(1.9,combine.getUpperBound());

    }

    @Test
    public void TestCase3()
    {
        Range r1=new Range(0.8,1.9);
        Range r2=new Range(2.1,4.0);
        Range combine=Range.combine(r1,r2);
        System.out.print(combine+"\n");
        Assertions.assertEquals(0.8,combine.getLowerBound());

    }
    @Test
    public void TestCase4()
    {
        Range r1=new Range(0.5,1.9);
        Range r2=new Range(1.6,2.0);
        Range combine=Range.combineIgnoringNaN(r1,r2);

        Assertions.assertNotEquals(0.8,combine.getUpperBound());

    }
    @Test
    public void TestCase5()
    {
        Range r1=new Range(0.5,1.9);
        Range r2=new Range(1.6,2.0);
        Range combine=Range.combineIgnoringNaN(r1,r2);
        Assertions.assertEquals(0.5,combine.getLowerBound());

    }
    @Test
    public void TestCase6()
    {
        Range r1=new Range(0.5,1.9);
        Range combine=Range.combineIgnoringNaN(r1,null);
        Assertions.assertEquals(0.5,combine.getLowerBound());

    }
    @Test
    public void TestCase7()
    {
        Range r1=new Range(0.5,1.9);
        Assertions.assertNotEquals(1.7,r1.constrain(1.8));

    }
    @Test
    public void TestCase8()
    {
        Range r2=new Range(1.6,2.0);
        Assertions.assertEquals(2.0,r2.constrain(2.5));

    }
    @Test
    public void TestCase9()
    {
        Range r1=new Range(0.5,1.9);
        Assertions.assertEquals(0.5,r1.constrain(0.3));

    }
    @Test
    public void TestCase10()
    {
        Range r1=new Range(2.25,4.1);
        Assertions.assertTrue(r1.contains(2.25));

    }
    @Test
    public void TestCase11()
    {
        Range r1=new Range(2.25,4.1);
        Assertions.assertNotEquals(true,r1.contains(0.3));

    }
    @Test
    public void TestCase12()
    {
        Range r1=new Range(2.25,4.1);
        Assertions.assertTrue(r1.contains(4.1));

    }
    @Test
    public void TestCase13()
    {

        Range r1=new Range(2.1,4.1);
        Range test=new Range(2.1,4.1);
        Assertions.assertEquals(true,r1.equals(test));


    }
    @Test
    public void TestCase14()
    {

        Range r1=new Range(2.1,4.1);
        int test=5;
        Assertions.assertFalse(r1.equals(test));
    }
    @Test
    public void TestCase15()
    {

    Range r1=new Range(2.1,4.1);
    Range test=new Range(2.1,4.9);
    Assertions.assertNotEquals(true,r1.equals(test));


    }


    @Test
    public void TestCase16()
    {

        Range r1=new Range(2.1,4.1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.expand(null,0.5,0.5));

    }

    @Test
    public void TestCase17()
    {

        Range r1=new Range(2.1,4.1);
        Range expanded=Range.expand(r1,0.7,4.8);
        Assertions.assertEquals(0.7,expanded.getLowerBound());
    }

    @Test
    public void TestCase18()
    {
        Range r1=new Range(2.1,4.1);
        Range expanded=Range.expand(r1,0.5,4.8);
        Assertions.assertEquals(1.1,expanded.getLowerBound());

    }
    @Test
    public void TestCase19()
    {
        Range r1=new Range(2.1,4.1);
        Range expanded=Range.expandToInclude(r1,6.1);
        Assertions.assertNotEquals(4.1,expanded.getUpperBound());
    }
    @Test
    public void TestCase20()
    {
        Range r1=new Range(2.1,4.1);
        Range expanded=Range.expandToInclude(r1,6.1);
        Assertions.assertEquals(6.1,expanded.getUpperBound());
    }
    @Test
    public void TestCase21()
    {
        Range r1=new Range(2.1,4.1);
        Range expanded=Range.expandToInclude(r1,0.9);
        Assertions.assertEquals(0.9,expanded.getLowerBound());
    }

    @Test
    public void TestCase22()
    {
        Range r1=new Range(2.0,4.0);
        Assertions.assertEquals(3.0,r1.getCentralValue());
    }


    @Test
    public void TestCase23()
    {
        Range r1=new Range(2.0,4.0);
        Assertions.assertNotEquals(2.25,r1.getCentralValue());
    }

    @Test
    public void TestCase24()
    {
        Range r1=new Range(2.0,4.0);
        Assertions.assertEquals(3.0,r1.getCentralValue());
    }

    @Test
    public void TestCase25()
    {
        Range r1=new Range(1.8,5.7);
        Assertions.assertEquals(3.9,r1.getLength());
    }
    @Test
    public void TestCase26()
    {
        Range r1=new Range(2.0,8.0);
        Assertions.assertEquals(6.0,r1.getLength());
    }
    @Test
    public void TestCase27()
    {
        Range r1=new Range(2.0,8.0);
        System.out.print(r1.hashCode()+"\n");
        Assertions.assertNotEquals(3,r1.hashCode());
    }
    @Test
    public void TestCase28()
    {
        Range r1=new Range(2.5,8.0);
        Assertions.assertEquals(-2137784320,r1.hashCode());
    }
    @Test
    public void TestCase29()
    {
        Range r1=new Range(2.0,4.0);
        Assertions.assertNotEquals(3.0,r1.hashCode());
    }
    @Test
    public void TestCase30()
    {
        Range r1=new Range(2.0,4.0);
        Range test=new Range(0.5,1.9);
        Assertions.assertFalse(r1.intersects(test));
    }
    @Test
    public void TestCase31()
    {
        Range r1=new Range(2.0,4.0);
        Range test=new Range(1.6,3.5);
        Assertions.assertTrue(r1.intersects(test));
    }
    @Test
    public void TestCase32()
    {
        Range r1=new Range(2.0,4.0);
        Range test=new Range(3.5,5.9);
        Assertions.assertTrue(r1.intersects(test));
    }
/*
    @Test
    public void TestCase37()
    {
        Range r1=new Range(2.0,4.0);

        Assertions.assertFalse(r1.isNaNRange());
    }
    @Test
    public void TestCase38()
    {
        Range r1=new Range(0.0/0.0,0.0/0.0);
        Assertions.assertTrue(r1.isNaNRange());
    }
    @Test
    public void TestCase39()
    {
        Range r1=new Range(0.0,0.0);
        Assertions.assertFalse(r1.isNaNRange());
    }
  */
    /*
@Test
    public void TestCase37()
    {
        Range r1=new Range(2.0,5.1);
        Range s=Range.scale(r1,4);
        Range excp=new Range(4.0,20.4);
        Assertions.assertNotEquals(excp,s);
    }
    @Test
    public void TestCase38()
    {
        Range r1=new Range(3.0,9.5);
        Range s=Range.scale(r1,3);
        Range excp=new Range(9.0,28.5);
        Assertions.assertEquals(excp,s);
    }
    @Test
    public void TestCase39()
    {
        Range r1=new Range(0.0,0.0);
        Range s=Range.scale(r1,3);
        Range excp=new Range(0.0,0.0);
        Assertions.assertEquals(excp,s);
    }*/
    @Test
    public void TestCase33()
    {
        Range r1=new Range(0.0,0.0);
        Range s=Range.shift(r1,3.1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.shift(null,0.5));

    }
    @Test
    public void TestCase34()
    {
        Range r1=new Range(1.0,2.0);
        Range s=Range.shift(r1,-3.1);
        System.out.print(s+"\n");
        Range excp=new Range(-2.1,-1.1);
        Assertions.assertNotEquals(excp,s);
    }
    @Test
    public void TestCase35()
    {
        Range r1=new Range(-5.0,6.3);
        Range s=Range.shift(r1,6);

        Range excp=new Range(0.0,12.3);
        Assertions.assertEquals(excp,s);
    }
    @Test
    public void TestCase36()
    {
        Range r1=new Range(1.0,2.0);
        Range s=Range.shift(r1,-3.1,true);
        Range excp=new Range(-2.1,-1.1);
        Assertions.assertEquals(excp,s);
    }
    @Test
    public void TestCase37()
    {
        Range r1=new Range(1.0,2.0);
        Range s=Range.shift(r1,-3.1,false);
        Range excp=new Range(-2.1,-1.1);
        Assertions.assertNotEquals(excp,s);
    }
    @Test
    public void TestCase38()
    {
        Range r1=new Range(1.0,5.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.shift(null,-3.1,true));

    }
    @Test
    public void TestCase39()
    {
        Range r1=new Range(1.0,5.0);
        String excp="Range[1.0,5.0]";
        Assertions.assertEquals(excp,r1.toString());
    }
    @Test
    public void TestCase40()
    {
        Range r1=new Range(1.0,5.0);
        String excp="Range[ 1.0, 5.0] ";
        Assertions.assertNotEquals(excp,r1.toString());
    }
    @Test
    public void TestCase41()
    {
        Range r1=new Range(0.0,3.4);
        String excp="Range[3.4,5.0] ";
        Assertions.assertNotEquals(excp,r1.toString());
    }
}