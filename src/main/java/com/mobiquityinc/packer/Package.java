package com.mobiquityinc.packer;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
}
