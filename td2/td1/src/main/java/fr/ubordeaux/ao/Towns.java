package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class Towns
{
    private Set<Town> towns;
    private TownFactory tf;

    public Towns()
    {
        towns = new HashSet<Town>();
    }

    public void addTown(Town newTown)
    {
        towns.add(newTown);
    }

    public void removeTown(Town oldTown)
    {
        towns.remove(oldTown);
    }

    public int size() {
        return towns.size();
    }

    public Set<Town> getTowns(int from, int to)
    {
        Set<Town> result = new HashSet<Town>();
        int i = 0;
        for (Town town : towns)
        {
            if (i >= from)
                result.add(town);

            if (i >= to)
                return result;
            i++;
        }
        return result;
    }
}
