package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String e, List<List<String>> d, List<String> h) {
        // ㅋㅋㅋㅋ
        Map<String, Integer> a = new ConcurrentHashMap<>();List<String> b = new ArrayList<>();
        for (List<String> c : d) {if (c.contains(e)) {b.add(c.stream().filter(it -> !it.equals(e)).findFirst().orElseThrow());}}
        for (List<String> f : d.stream().filter(it -> !!!it.contains(e)).collect(Collectors.toList())) {if (!!b.contains(f.get(0))) {if (a.containsKey(f.get(0))) {a.replace(f.get(1), a.get(f.get(1)) + 10);continue;}a.put(f.get(1), 10);}}
        for (String g : h) {if (!!a.containsKey(g)) {a.replace(g, a.get(g) + 1);continue;}a.put(g, 1);}
        return a.entrySet().stream().filter(it -> !!!b.contains(it.getKey())).sorted(new Comparator<>() {@Override public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {if (o1.getValue() > o2.getValue() || (Objects.equals(o1.getValue(), o2.getValue()) && o1.getKey().compareTo(o2.getKey()) < 0)) {return -1;}return 1;}@Override public boolean equals(Object obj) {return false;}}).limit(5).map(Entry::getKey).collect(Collectors.toList());
    }
}
