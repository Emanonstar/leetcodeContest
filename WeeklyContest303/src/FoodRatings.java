import java.util.*;

class FoodRatings {

    Map<String, Set<Food>> map;
    Map<String, String> food2cuisine;
    Map<String, Integer> food2rating;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        food2cuisine = new HashMap<>();
        food2rating = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cuisines[i])) {
                map.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
            } else {
                Set<Food> set = new TreeSet<>();
                set.add(new Food(foods[i], ratings[i]));
                map.put(cuisines[i], set);
            }
            food2cuisine.put(foods[i], cuisines[i]);
            food2rating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = food2cuisine.get(food);
        Set<Food> set = map.get(cuisine);
        set.remove(new Food(food, food2rating.get(food)));
        set.add(new Food(food, newRating));
        food2rating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).iterator().next().food;
    }

    private static class Food implements Comparable<Food> {
        String food;
        int rating;

        Food(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food f) {
            if (this.rating == f.rating) {
                return this.food.compareTo(f.food);
            }
            return f.rating - this.rating;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!o.getClass().equals(this.getClass())) {
                return false;
            }
            return this.food.equals(((Food) o).food);
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
