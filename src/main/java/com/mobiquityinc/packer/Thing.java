package com.mobiquityinc.packer;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Thing
{
    int indexNumber;
    double weight;
    double cost;


    public Thing()
    {
    }


    public Thing(int indexNumber, double weight, double cost)
    {
        this.indexNumber = indexNumber;
        this.weight = weight;
        this.cost = cost;
    }


    public int getIndexNumber()
    {
        return indexNumber;
    }


    public void setIndexNumber(int indexNumber)
    {
        this.indexNumber = indexNumber;
    }


    public double getWeight()
    {
        return weight;
    }


    public void setWeight(double weight)
    {
        this.weight = weight;
    }


    public double getCost()
    {
        return cost;
    }


    public void setCost(double cost)
    {
        this.cost = cost;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("indexNumber", indexNumber)
            .append("weight", weight)
            .append("cost", cost)
            .toString();
    }
}
