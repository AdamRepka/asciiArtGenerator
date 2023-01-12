package asciiart.asciiartGenerator.mapper;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GreyScaleToCharMapper {
    private final RangeMap<Double, Character> map;

    public GreyScaleToCharMapper() {
        map = TreeRangeMap.create();
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);
        map.put(Range.closed(,),);

    }

    public String getImageName(char key) {
        return map.get(key);
    }
}
