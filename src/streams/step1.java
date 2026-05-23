import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class step1{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();

        //creating from array
        int[] arr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(arr);

        //creating from values
        Stream<String> stringStream = Stream.of("a", "b", "c","cat");
        
        //filter
        List<String> filteredList = stringStream.filter(s->s.startsWith("c")).collect(Collectors.toList());
        System.out.println(filteredList);
        //map
        List<Integer> transformedList = intStream.map(val->val*2).boxed().collect(Collectors.toList());
        List<Integer> nums = Arrays.asList(5,5,1, 3, 1, 4, 2);
        //sorted
        List<Integer> sorted = nums.stream().sorted().collect(Collectors.toList());
        //sorted with custom comparator
        List<Integer> sorted1 = nums.stream().sorted((a,b)->b-a).collect(Collectors.toList());
        //distinct
        List<Integer> distinct = nums.stream().distinct().collect(Collectors.toList());
        //limit
        List<Integer> limited = nums.stream().map(x->x*2).sorted().limit(3).collect(Collectors.toList());
        //skip first n elements
        List<Integer> skipped = nums.stream().skip(2).collect(Collectors.toList());
        //peek
        List<Integer> peeked = nums.stream().peek(n->System.out.println("Before:"+n)).map(n->n*2).
        peek(n->System.out.println("After:"+n)).collect(Collectors.toList());


        List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "apricot", "cherry");

        
        List<String> ans =  words.stream().filter(s->s.startsWith("a")).sorted((a,b)->{
                                            if(a.length()==b.length())
                                                return a.compareTo(b);
                                            return b.length()-a.length();})
                                            .collect(Collectors.toList());
        System.out.println(ans);

        // System.out.println(transformedList);
        // System.out.println(sorted);
        // System.out.println(sorted1);
        // System.out.println(distinct);
        // System.out.println(limited);
        // System.out.println(skipped);
        // System.out.println(peeked);
    }
}