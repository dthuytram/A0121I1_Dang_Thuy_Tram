package _casestudy_.controllers;

import _casestudy_.model.House;
import _casestudy_.model.Room;
import _casestudy_.model.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO_Services {
    // Set link for each object
    public static final String HOUSE = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_casestudy_\\data\\house.csv";
    public static final String VILLA = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_casestudy_\\data\\villa.csv";
    public static final String ROOM = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_casestudy_\\data\\room.csv";
    public static final String COMMA = ",";

    // Write data from class to csv file
    public static void writeVilla(Villa villa) {
        File file = new File(VILLA);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(villa.getNameService() + COMMA +
                    villa.getUsedArea() + COMMA +
                    villa.getCostRent() + COMMA +
                    villa.getMaxMember() + COMMA +
                    villa.getRentType() + COMMA +
                    villa.getId() + COMMA +
                    villa.getPlusService() + COMMA +
                    villa.getRoomStandards() + COMMA +
                    villa.getOtherDescription() + COMMA +
                    villa.getFloorNumber() + COMMA +
                    villa.getPoolArea() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //
    public static void writeHouse(House house) {
        File file = new File(HOUSE);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(house.getId() + COMMA + house.getNameService() + COMMA + house.getUsedArea() + COMMA + house.getCostRent() + COMMA + house.getMaxMember() + COMMA + house.getRentType() + COMMA + house.getPlusService() + COMMA + house.getOtherDescription() + COMMA + house.getRoomStandards() + COMMA + house.getFloorNumber() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //
    public static void writeRoom(Room room) {
        File file = new File(ROOM);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(room.getId() + COMMA + room.getNameService() + COMMA + room.getUsedArea() + COMMA + room.getCostRent() + COMMA + room.getMaxMember() + COMMA + room.getRentType() + COMMA + room.getPlusService() + COMMA + room.getFreeServices() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read the data from the csv file
    public static List<House> readHouse() throws IOException {
        List<House> houseList = new ArrayList<>();
        File file = new File(HOUSE);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            House house;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                house = new House(temp[0],
                        Integer.parseInt(temp[1]),
                        Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]),
                        temp[4], temp[5], temp[6],
                        temp[7], temp[8],
                        Integer.parseInt(temp[9]));
                houseList.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return houseList;
    }

    //
    public static List<Villa> readVilla() throws IOException {
        List<Villa> villaList = new ArrayList<>();
        File file = new File(VILLA);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            Villa villa;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                villa = new Villa(temp[0],
                        Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], temp[5], temp[6], temp[7], temp[8],
                        Integer.parseInt(temp[9]), Integer.parseInt(temp[10]));
                villaList.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return villaList;
    }

    //
    public static List<Room> readRoom() throws IOException {
        List<Room> roomList = new ArrayList<>();
        File file = new File(ROOM);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            Room room;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                room = new Room(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], temp[6], temp[7]);
                roomList.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomList;
    }
}
