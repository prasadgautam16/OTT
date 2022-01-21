package com.company;

import com.company.show.Show;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static void main(String[] args) {
        String path = "C:\\Users\\hp\\IdeaProjects\\OTT\\src\\com\\company\\data\\netflix_titles.csv";
        System.out.println("Enter a Number to show number of record : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter a Number is : " + n);
        List<Show> showList = getShowDetails(n, path);
        for(Show show:showList){
            System.out.println(show.toString());
        }
    }

    private static List<Show> getShowDetails(int n, String file) {
        List<Show> showList =new ArrayList<>();
        String line;
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            // time start
            BufferedReader br = new BufferedReader(new FileReader(file));

            while( n > i && (line = br.readLine()) != null) {
//                System.out.println("Line by Line : " + line);
                String [] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (i > 0) {
                    Show show = getOneShow(attributes);
                    showList.add(show);
                }
                i++;
            }
            // time end
            long end = System.currentTimeMillis();

            System.out.println("Function took : " + (end - start) + "ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return showList;
    }

    private static Show getOneShow(String[] attributes) {
        String showId , type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description = null;

        try{
            showId = attributes[0].equalsIgnoreCase("") ? null : attributes[0];
        }
        catch(Exception e){showId = null;}
        try{
            type = attributes[1].equalsIgnoreCase("") ? null : attributes[1];
        }
        catch(Exception e){type = null;}
        try{
            title = attributes[2].equalsIgnoreCase("") ? null : attributes[2];
        }
        catch(Exception e){title = null;}
        try{
            director = attributes[3].equalsIgnoreCase("") ? null : attributes[3];
        }
        catch(Exception e){director = null;}
        try{
            cast = attributes[4].equalsIgnoreCase("") ? null : attributes[4];
        }
        catch(Exception e){cast = null;}
        try{
            country = attributes[5].equalsIgnoreCase("") ? null : attributes[5];
        }
        catch(Exception e){country = null;}
        try{
            date_added = attributes[6].equalsIgnoreCase("") ? null : attributes[6];
        }
        catch(Exception e){date_added = null;}
        try{
            release_year = attributes[7].equalsIgnoreCase("") ? null : attributes[7];
        }
        catch(Exception e){release_year = null;}
        try{
            rating = attributes[8].equalsIgnoreCase("") ? null : attributes[8];
        }
        catch(Exception e){rating = null;}
        try{
            duration = attributes[9].equalsIgnoreCase("") ? null : attributes[9];
        }
        catch(Exception e){duration = null;}
        try{
            listed_in = attributes[10].equalsIgnoreCase("") ? null : attributes[10];
        }
        catch(Exception e){listed_in = null;}
        try{
            description = attributes[11].equalsIgnoreCase("") ? null : attributes[11];
        }
        catch(Exception e){description = null;}
//        try {
//            showId = attributes[0];
//            type = attributes[1];
//            title = attributes[2];
//            director = attributes[3];
//            cast = attributes[4];
//            country = attributes[5];
//            date_added = attributes[6];
//            release_year = attributes[7];
//            rating = attributes[8];
//            duration = attributes[9];
//            listed_in = attributes[10];
//            description = attributes[11];
//
//        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
        Show show = new Show(showId, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);
        return show;

    }
}


//    public static void main(String[] args) {
//        // write your code here
//        String path = "C:\\Users\\hp\\IdeaProjects\\OTT\\src\\com\\company\\data\\netflix_titles.csv";
//        String line;
//        int i = 0;
//        try {
//            System.out.println("Enter a Number to show number of record : ");
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
////            int n = 2;
//            System.out.println("Enter a Number is : " + n);
//            long start = System.currentTimeMillis();
//            // time start
//            BufferedReader br = new BufferedReader(new FileReader(path));
//
//            while( n > i && (line = br.readLine()) != null) {
//                System.out.println("Line by Line : " + line);
//
//                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                if (i > 0) {
//                    for (int j = 0; j < values.length; j++) {
//
//                        System.out.println("Each Data " + values[j]);
//                    }
//                }
//                i++;
//            }
//            // time end
//            long end = System.currentTimeMillis();
//
//            System.out.println("Function took : " + (end - start) + "ms");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
