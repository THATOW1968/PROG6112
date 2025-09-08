/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Series seriesManager = new Series();
        int option = 0;
        String validate;
        System.out.println("Enter (1) or any other key to exit");
            validate = input.nextLine();
            if(validate.equals("1")){
                do {
           
                System.out.println("\n===== TV Series Management =====");
                System.out.println("1. Add Series");
                System.out.println("2. Search Series");
                System.out.println("3. Update Series");
                System.out.println("4. Delete Series");
                System.out.println("5. Validate Age Restriction");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                option = input.nextInt();
                input.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        System.out.print("Enter series ID: ");
                        String id = input.nextLine();
                        System.out.print("Enter series name: ");
                        String name = input.nextLine();
                        System.out.print("Enter age restriction: ");
                        int age = input.nextInt();
                        System.out.print("Enter number of episodes: ");
                        int episodes = input.nextInt();
                        seriesManager.addSeries(id, name, age, episodes);
                        System.out.println("Series added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter series ID to search: ");
                        String searchId = input.nextLine();
                        Series.SeriesModel found = seriesManager.getSeriesById(searchId);
                        if (found != null) {
                            System.out.println("Series found: " + found.seriesName);
                        } else {
                            System.out.println("Series not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter series ID to update: ");
                        String updateId = input.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = input.nextLine();
                        System.out.print("Enter new age restriction: ");
                        int newAge = input.nextInt();
                        System.out.print("Enter new number of episodes: ");
                        int newEpisodes = input.nextInt();
                        if (seriesManager.updateSeries(updateId, newName, newAge, newEpisodes)) {
                            System.out.println("Series updated successfully.");
                        } else {
                            System.out.println("Series not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter series ID to delete: ");
                        String deleteId = input.nextLine();
                        if (seriesManager.deleteSeriesById(deleteId)) {
                            System.out.println("Series deleted successfully.");
                        } else {
                            System.out.println("Series not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter age restriction to validate: ");
                        int checkAge = input.nextInt();
                        if (seriesManager.isAgeRestrictionValid(checkAge)) {
                            System.out.println("Age restriction is valid.");
                        } else {
                            System.out.println("Age restriction is invalid (must be between 13 and 21).\n");
                        }
                        break;

                    case 0:
                        System.out.println("Exiting application. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            while (option != 0);
            }else{
                System.out.println("Exitting");
            }

        
        }
    }
