class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        if ( 0 < twoDimArray.length && 0 < twoDimArray[0].length) {
            int lastX = twoDimArray[0].length -1;
            int lastY = twoDimArray.length - 1;

            System.out.printf("%s %s%n%d %d",
                    twoDimArray[0][0],             // top-left
                    twoDimArray[0][lastX],         // top-right
                    twoDimArray[lastY][0],         // bottom-left
                    twoDimArray[lastY][lastX]);    // bottom-right
        }
    }
}