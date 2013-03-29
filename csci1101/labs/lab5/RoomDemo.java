/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/11
 */

public class RoomDemo {

    public static void main(String[] args) {
        //create 3 rooms of set dimensions
        RoomDimension room1, room2, room3;
        room1 = new RoomDimension(10, 10);
        room2 = new RoomDimension(20, 20);
        room3 = new RoomDimension(30, 30);
        // carpet each room with a carpet of some price
        RoomCarpet carpet1, carpet2, carpet3;
        carpet1 = new RoomCarpet(room1, 1.50);
        carpet2 = new RoomCarpet(room2, 1.75);
        carpet3 = new RoomCarpet(room3, 1.50);
        
        System.out.println("Carpet Rooms\n\nRoom 1:"+carpet1+"\n\nRoom 2: "+carpet2+"\n\nRoom 3: "+carpet3+"\n");
        
    }
}
/*
--------------------Configuration: <Default>--------------------
Carpet Rooms

Room 1:
Dimensions :
length :    10.0    width : 10.0    Area :  100.0   Carpet Cost: 1.5
Total carpet cost: :150.0$

Room 2: 
Dimensions :
length :    20.0    width : 20.0    Area :  400.0   Carpet Cost: 1.75
Total carpet cost: :700.0$

Room 3: 
Dimensions :
length :    30.0    width : 30.0    Area :  900.0   Carpet Cost: 1.5
Total carpet cost: :1350.0$


Process completed.
 */
