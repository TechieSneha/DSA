class Solution {
    public int smallestNumber(int n, int t) {
         while (true) {
            int product = digitProduct(n);

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
     private int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 0) {
                return 0;
            }

            product *= digit;
            num /= 10;
        }

        return product;
     }

}