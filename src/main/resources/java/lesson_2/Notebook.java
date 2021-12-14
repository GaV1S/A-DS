 package lesson_2

public class Notebook {
     private String brandName;
     private int brandIndex;
     private int price;
     private int ram;

     public Notebook() {
         this.brandName = chooseBrand();
         this.ram = chooseRam();
         this.price = choosePrice();
     }

     public int getBrandIndex() {
         return brandIndex;
     }

     public String getBrandName() {
         return brandName;
     }

     public int getPrice() {
         return price;
     }

     public int getRam() {
         return ram;
     }

     private String chooseBrand() {
         int index = (int) (1 + Math.random() * 5);
         switch (index) {
             case 1:
                 this.brandIndex = index;
                 return "Asos";
             case 2:
                 this.brandIndex = index;
                 return "Eser";
             case 3:
                 this.brandIndex = index;
                 return "Lenuvo";
             case 4:
                 this.brandIndex = index;
                 return "MacNote";
             case 5:
                 this.brandIndex = index;
                 return "Xamiou";
             default:
                 return null;
         }
     }

     private int chooseRam() {
         int ram;
         do {
             ram = (int) (4 + Math.random() * 24);
         } while (ram % 4 != 0);
         return ram;
     }

     private int choosePrice() {
         int price;
         do {
             price = (int) (500 + Math.random() * 3050);
         } while (price % 50 != 0);
         return price;
     }
 }