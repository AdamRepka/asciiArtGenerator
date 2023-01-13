package asciiart.asciiartGenerator.mapper;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class GreyScaleToCharMapper {
    private final RangeMap<Double, Character> map;

    public GreyScaleToCharMapper() {
        map = TreeRangeMap.create();
        map.put(Range.open(252.0,256.0), ' ');
        map.put(Range.closed(248.0,252.0),'.');
        map.put(Range.closedOpen(244.0,248.0),'\'');
        map.put(Range.closedOpen(240.0,244.0),'`');
        map.put(Range.closedOpen(236.0,240.0), '^');
        map.put(Range.closedOpen(232.0,236.0),'\"');
        map.put(Range.closedOpen(228.0,232.0),',');
        map.put(Range.closedOpen(224.0,228.0),':');
        map.put(Range.closedOpen(220.0,224.0),';');
        map.put(Range.closedOpen(216.0,220.0),'>');
        map.put(Range.closedOpen(212.0,216.0),'<');
        map.put(Range.closedOpen(208.0,212.0),'~');
        map.put(Range.closedOpen(204.0,208.0),'+');
        map.put(Range.closedOpen(200.0,204.0),'_');
        map.put(Range.closedOpen(196.0,200.0),'-');
        map.put(Range.closedOpen(192.0,196.0),'?');
        map.put(Range.closedOpen(188.0,192.0),'[');
        map.put(Range.closedOpen(184.0,188.0),'{');
        map.put(Range.closedOpen(180.0,184.0),'(');
        map.put(Range.closedOpen(176.0,180.0),'l');
        map.put(Range.closedOpen(172.0,176.0),'|');
        map.put(Range.closedOpen(168.0,172.0),'\\');
        map.put(Range.closedOpen(164.0,168.0),'/');
        map.put(Range.closedOpen(160.0,164.0),'t');
        map.put(Range.closedOpen(156.0,160.0),'f');
        map.put(Range.closedOpen(152.0,156.0),'j');
        map.put(Range.closedOpen(148.0,152.0),'r');
        map.put(Range.closedOpen(144.0,148.0),'x');
        map.put(Range.closedOpen(140.0,144.0),'n');
        map.put(Range.closedOpen(136.0,140.0),'u');
        map.put(Range.closedOpen(132.0,136.0),'v');
        map.put(Range.closedOpen(128.0,132.0),'c');
        map.put(Range.closedOpen(124.0,128.0),'z');
        map.put(Range.closedOpen(120.0,124.0),'X');
        map.put(Range.closedOpen(116.0,120.0),'Y');
        map.put(Range.closedOpen(112.0,116.0),'U');
        map.put(Range.closedOpen(108.0,112.0),'J');
        map.put(Range.closedOpen(104.0,108.0),'C');
        map.put(Range.closedOpen(100.0,104.0),'L');
        map.put(Range.closedOpen(96.0,100.0),'Q');
        map.put(Range.closedOpen(92.0,96.0),'0');
        map.put(Range.closedOpen(88.0,92.0),'O');
        map.put(Range.closedOpen(84.0,88.0),'Z');
        map.put(Range.closedOpen(80.0,84.0),'m');
        map.put(Range.closedOpen(76.0,80.0),'w');
        map.put(Range.closedOpen(72.0,76.0),'q');
        map.put(Range.closedOpen(68.0,72.0),'p');
        map.put(Range.closedOpen(64.0,68.0),'d');
        map.put(Range.closedOpen(60.0,64.0),'b');
        map.put(Range.closedOpen(56.0,60.0),'k');
        map.put(Range.closedOpen(52.0,56.0),'h');
        map.put(Range.closedOpen(48.0,52.0),'a');
        map.put(Range.closedOpen(44.0,48.0),'o');
        map.put(Range.closedOpen(40.0,44.0),'*');
        map.put(Range.closedOpen(36.0,40.0),'#');
        map.put(Range.closedOpen(32.0,36.0),'M');
        map.put(Range.closedOpen(28.0,32.0),'W');
        map.put(Range.closedOpen(24.0,28.0),'&');
        map.put(Range.closedOpen(20.0,24.0),'8');
        map.put(Range.closedOpen(16.0,20.0),'%');
        map.put(Range.closedOpen(12.0,16.0),'B');
        map.put(Range.closedOpen(8.0,12.0),'@');
        map.put(Range.closedOpen(0.0,8.0),'$');
    }

    public Character getCharacter(double key) {
        return map.get(key);
    }
}
