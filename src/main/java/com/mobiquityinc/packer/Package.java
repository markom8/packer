package com.mobiquityinc.packer;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Package
{
    double maxWeight;
    double maxCost;
    int maxNumberOfItems;
    List<Thing> things;


    public Package(List<Thing> things)
    {
        maxWeight = 100;
        maxCost = 100;
        maxNumberOfItems = 15;
        this.things = things;
    }


    public Package(double maxWeight, double maxCost, int maxNumberOfItems, List<Thing> things)
    {
        this.maxWeight = maxWeight;
        this.maxCost = maxCost;
        this.maxNumberOfItems = maxNumberOfItems;
        this.things = things;
    }


    public Package(double maxWeight, List<Thing> things)
    {
        this.maxWeight = maxWeight;
        maxCost = 100;
        maxNumberOfItems = 15;
        this.things = things;
    }


    public double getMaxWeight()
    {
        return maxWeight;
    }


    public void setMaxWeight(double maxWeight)
    {
        this.maxWeight = maxWeight;
    }


    public double getMaxCost()
    {
        return maxCost;
    }


    public void setMaxCost(double maxCost)
    {
        this.maxCost = maxCost;
    }


    public int getMaxNumberOfItems()
    {
        return maxNumberOfItems;
    }


    public void setMaxNumberOfItems(int maxNumberOfItems)
    {
        this.maxNumberOfItems = maxNumberOfItems;
    }


    public List<Thing> getThings()
    {
        return things;
    }


    public void setThings(List<Thing> things)
    {
        this.things = things;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("maxWeight", maxWeight)
            .append("maxCost", maxCost)
            .append("maxNumberOfItems", maxNumberOfItems)
            .append("things", things)
            .toString();
    }


    public List<Thing> determineCostAndWeightWisePackage()
    {
        things.removeIf(t -> t.getWeight() > maxWeight);

        ArrayList<ArrayList<Thing>> packageCombinations = new ArrayList<ArrayList<Thing>>();
        for (int i = 0; i < things.size(); i++)
        {
            Thing currentItem = things.get(i);
            int combinationSize = packageCombinations.size();
            for (int j = 0; j < combinationSize; j++)
            {
                ArrayList<Thing> combination = packageCombinations.get(j);
                ArrayList<Thing> newCombination = new ArrayList<>(combination);
                newCombination.add(currentItem);
                packageCombinations.add(newCombination);
            }
            ArrayList<Thing> current = new ArrayList<Thing>();
            current.add(currentItem);
            packageCombinations.add(current);
        }

        ArrayList<Thing> bestCombination = new ArrayList<>();
        double bestCost = 0;
        double bestWeight = 100;
        for (ArrayList<Thing> combination : packageCombinations)
        {
            double combinationWeight = combination.stream().filter(thing -> thing != null).mapToDouble(Thing::getWeight).sum();
            if (combinationWeight > maxWeight)
            {
                continue;
            }
            else
            {
                double combinationPrice = combination.stream().filter(thing -> thing != null).mapToDouble(Thing::getCost).sum();
                if (combinationPrice > bestCost)
                {
                    bestCost = combinationPrice;
                    bestCombination = combination;
                    bestWeight = combinationWeight;
                }
                else if (combinationPrice == bestCost)
                {
                    if (combinationWeight < bestWeight)
                    {
                        bestCost = combinationPrice;
                        bestCombination = combination;
                        bestWeight = combinationWeight;
                    }
                }
            }
        }

        return bestCombination;
    }
}
