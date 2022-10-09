import java.util.Arrays;

class Solution1 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people);
        for (int i = 0; i < n; i++) {
            names[i] = people[i].name;
        }
        return names;
  }

    static class Person implements Comparable<Person> {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person p) {
            return p.height - this.height;
        }
    }
}
