package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Packer
{
    public static String pack(String filePath) throws APIException, IOException
    {
        String result = "";
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line = in.readLine()) != null){
            if(line.length() == 0)
                continue;
            String[] lineArray = line.split(":");
            double weightLimit = Integer.parseInt(lineArray[0].trim());
            String[] stringThings = lineArray[1].trim().split(" ");
            List<Thing> inputs = new ArrayList<Thing>();
            for(String stringThing : stringThings){
                String[] itemDetails = stringThing.split(",");
                int id = Integer.parseInt(itemDetails[0].substring(1));
                double weight = Double.parseDouble(itemDetails[1]);
                double price = Double.parseDouble(itemDetails[2].substring(1, itemDetails[2].length()-1));
                Thing thing = new Thing(id, weight, price);
                inputs.add(thing);
            }

            Package aPackage = new Package(weightLimit, inputs);
            System.out.println(aPackage.toString());
            List<Thing> bestCombo = aPackage.determineCostAndWeightWisePackage();
            if(bestCombo.size() == 0){
                result+="-\n";
            }else{
                result+=bestCombo.stream().map(t->t.getIndexNumber()).collect(Collectors.toList()).toString()+"\n";
            }

        }

        return result;
    }



    public static void main(String[] args) throws APIException, IOException
    {
        System.out.println(pack("G:\\work\\adclear\\collector\\packer\\src\\main\\resources\\packertest.txt"));

    }
}
