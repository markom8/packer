import com.mobiquityinc.packer.Packer;
import com.mobiquityinc.packer.Package;
import com.mobiquityinc.packer.Thing;
import com.mobiquityinc.packer.exception.APIException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class PackerPackTest
{
    @Test
    public void testFileLoader() throws APIException, IOException {
        System.out.println(Packer.pack("D:\\mare\\code\\dais\\packer\\src\\main\\resources\\packertest.txt"));
    }

    @Test
    public void testThemapGroupBy(){
        List<Thing> things = new ArrayList<Thing>();
        Thing thing1 = new Thing(1,1.1,1.1);
        things.add(thing1);
        Thing thing2 = new Thing(2,2.2,2.2);
        things.add(thing2);
        Thing thing3 = new Thing(3,3.3,3.3);
        things.add(thing3);
        Thing thing4 = new Thing(4,4.4,4.4);
        things.add(thing4);
        Thing thing5 = new Thing(5,5.5,5.5);
        things.add(thing5);
        Thing thing6 = new Thing(6,6.6,6.6);
        things.add(thing6);
        Thing thing7 = new Thing(7,7.7,7.7);
        things.add(thing7);
        Thing thing8 = new Thing(8,8.8,8.8);
        things.add(thing8);
        Thing thing9 = new Thing(9,9.9,9.9);
        things.add(thing9);
        Thing thing10 = new Thing(10,10.10,10.10);
        things.add(thing10);

       Package aPackage = new Package(40,things);
       List<Thing> bestCombo = aPackage.determineCostAndWeightWisePackage();


    }

}
