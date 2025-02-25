package recursion;
class CombinationSum {
    public static int recur(int[] arr, int target, int sum, int index) {
        if (index == arr.length) {
            return sum == target ? 1 : 0;
        }
        return recur(arr, target, sum + arr[index], index + 1) + recur(arr, target, sum, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 10;
        int result = recur(arr, target, 0, 0);
        System.out.println(result);
    }
}
