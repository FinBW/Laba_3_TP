package org.example;


public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"8",  "2",    "12",      "123456" },
                {"4",  "23",    "621126",  "1"     },
              { "33", "1",     "6",      "12"    },
             //   {"33", "1",     "6",       "12"    },
                {"621135",  "24626", "12", "12"    }
        };
        try {
            if (check(array)) System.out.println("Результат: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }



    }



    static int s = 0;
    static int sum = 0;

   public static boolean check(String[][] array) throws MyArraySizeException, MyArrayDataException, MyNoHappyException {
        boolean tmp = true;
       /*for (String[] strings : array) {
           for (String[] value : array) {
               if (value.length != 4 || strings.length != 4)
                   throw new MyArraySizeException("Массив не 4x4. Одумайся!");

           }
       }*/
       if (array.length != 4)  throw new MyArraySizeException("Массив не 4x4. Одумайся!");

       for (int i = 0; i < array.length; i++) {
           if (array[i].length != 4)  throw new MyArraySizeException("Массив не 4x4. Одумайся!");
       }

       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
           try {
           if (!(array[i][j].matches("(?ui:[0-9]+)")))
               s = Integer.valueOf(array[i][j]);
           //if (array[i][j].length() > 6) throw new MyArrayDataException(i, j, array[i][j]);
       }
       catch (NumberFormatException e) {
           throw new MyArrayDataException(i, j, array[i][j]);
       }
           }
       }

        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.valueOf(array[i][j]);
                        if (array[i][j].length() == 6) {
                            for (int n = 0; n < 6; n++) {
                                if (n < 3) {
                                    sumLeft += Character.getNumericValue(array[i][j].charAt(n));
                                } else {
                                    sumRight += Character.getNumericValue(array[i][j].charAt(n));
                                }
                                if (sumLeft == sumRight) throw new MyNoHappyException(i, j, array[i][j]);
                            }
                        }
                    } catch (MyNoHappyException e) {
                        e.printStackTrace();
                    }
                }
            }

        return tmp;
    }
}
