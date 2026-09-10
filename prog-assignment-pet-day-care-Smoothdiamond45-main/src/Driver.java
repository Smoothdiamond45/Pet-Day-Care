package main;
import controllers.PetsDayCareAPI;
import controllers.OwnerAPI;
import models.*;
import utils.ScannerInput;
import java.io.File;

public class Driver {
    PetsDayCareAPI petsDayCareAPI;
    OwnerAPI ownerAPI;
    public static void main(String[] args) {

        new Driver();

    }
    //private void clearScreen(){
      //  System.out.print("\033[H\033[2J");
        //System.out.flush();
    //} //Didnt work

    public Driver() {
        ownerAPI = new OwnerAPI(new File(System.getProperty("user.dir")));
        petsDayCareAPI = new PetsDayCareAPI("Krazy Kennel", 50, new File(""));
       runMenu();
    }
    private int mainMenu(){
        return ScannerInput.readNextInt("""
                Pet Day Care
                ---------------------------------------
                1) Pets CRUD Menu
                2) Reports Menu
                ---------------------------------------
                3) Search Pets
                4) Sort Pets 
                ---------------------------------------
                5) Search Pets by ID
                6) Search Pets by Owner
                ---------------------------------------
                7) Finding Dogs by Owner, Breed and Age
                8) Parrot Vocab Size
                ---------------------------------------
                9) Deleting a pet by Index
                10) Deleting a pet by ID
                ---------------------------------------
                11) Save All
                12) Load All
                ---------------------------------------
                0) Exit 
                ---------------------------------------
                """);
    }
    private void runMenu(){
        int option = mainMenu();
        while (option != 0){
            switch (option){
                case 1 -> petCrudMenu();
                case 2 -> runreportMenu();
                case 3 -> searchPets();
                case 4 -> sortPets();
                case 5 -> searchPetsByID();
                case 6 -> searchPetsByOwner();
                case 7 -> findDogByOwnerandBreedwithAge();
                case 8 -> numberOfWordsParrot();
                case 9 -> deletePetIndex();
                case 10 -> deletePetID();
                case 11 -> saveAll();
                case 12 -> loadAll();
                default -> System.out.println("Invalid option" + option);
            }
          //  clearScreen();
            option = mainMenu();
        }
    }
   // Private methods for CRUD on Dog
    //------------------------------------{
    private void petCrudMenu() {

        boolean isAdded = false;

        int option = 10;
        while (option != 0) {
            option = ScannerInput.readNextInt("""
                    ---------------------------
                    |  1) Add a Dog           |
                    |  2) Add a Cat           | 
                    |  3) Add an Parrot       |
                    |  4) Add an Human        |
                    |  5) Return to main menu |
                    ---------------------------
                    ==>> """);

            switch (option) {
                case 1 -> {
                    System.out.println(ownerAPI.listOwners()); // show available owners
                    int ownerId = ScannerInput.readNextInt("Enter owner ID: ");
                    Owner owner = ownerAPI.getOwnerByIndex(ownerId); // look up the Owner object
                    String name = ScannerInput.readNextLine("Enter the dogs name:   ");
                    int age = ScannerInput.readNextInt("Enter the dog's age:   ");
                    char sex = ScannerInput.readNextChar("Enter the Dogs sex: (F, M) : ");
                    int dangerousInput = ScannerInput.readNextInt("Is the dog dangerous? (1 = Yes, 0 = No): ");
                    boolean dangerousBreed = (dangerousInput == 1);
                    int neuteredInput = ScannerInput.readNextInt("Is the dog neutered? (1 = Yes, 0 = No): ");
                    boolean neuteredBreed = (neuteredInput == 1);
                    double weight = ScannerInput.readNextDouble("What is the dogs weight:  ");
                    int vaccinatedInput = ScannerInput.readNextInt("Is the dog vaccinated? (1 = Yes, 0 = No): ");
                    boolean vaccinatedBreed = (vaccinatedInput == 1);
                    String breed = ScannerInput.readNextLine("What breed is the dog: ");
                    Dog dog = new Dog(name, ownerId, owner, age, sex, neuteredBreed, weight, vaccinatedBreed, dangerousBreed, breed);
                    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

                    for (int i = 0; i < days.length; i++) {
                        int attending = ScannerInput.readNextInt("Attending " + days[i] + "? (1 = Yes, 0 = No): ");
                        if (attending == 1) dog.checkIn(i);
                    }
                    isAdded = petsDayCareAPI.addPet(dog);

                }
                case 2 -> {
                    System.out.println(ownerAPI.listOwners()); // show available owners
                    int ownerId = ScannerInput.readNextInt("Enter owner ID: ");
                    Owner owner = ownerAPI.getOwnerByIndex(ownerId); // look up the Owner object
                    String name = ScannerInput.readNextLine("Enter the cats name:   ");
                    int age = ScannerInput.readNextInt("Enter the cat's age:   ");
                    char sex = ScannerInput.readNextChar("Enter the cats sex: (F, M) : ");
                    int neuteredInput = ScannerInput.readNextInt("Is the cat neutered? (1 = Yes, 0 = No): ");
                    boolean neuteredBreed = (neuteredInput == 1);
                    double weight = ScannerInput.readNextDouble("What is the cats weight:  ");
                    int vaccinatedInput = ScannerInput.readNextInt("Is the cAT vaccinated? (1 = Yes, 0 = No): ");
                    boolean vaccinatedBreed = (vaccinatedInput == 1);
                    String favouriteToy = ScannerInput.readNextLine("What is the cats favourite toy:   ");
                    int indoorInput = ScannerInput.readNextInt("Is the cat indoor? (1 = Yes, 0 = No): ");
                    boolean indoorBreed = (indoorInput == 1);
                    Cat cat = new Cat(name, ownerId, owner, age, sex, neuteredBreed, weight, vaccinatedBreed, favouriteToy, indoorBreed);
                    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

                    for (int i = 0; i < days.length; i++) {
                        int attending = ScannerInput.readNextInt("Attending " + days[i] + "? (1 = Yes, 0 = No): ");
                        if (attending == 1) cat.checkIn(i);
                    }
                    isAdded = petsDayCareAPI.addPet(cat);

                }
                case 3 -> {
                    System.out.println(ownerAPI.listOwners()); // show available owners
                    int ownerId = ScannerInput.readNextInt("Enter owner ID: ");
                    Owner owner = ownerAPI.getOwnerByIndex(ownerId); // look up the Owner object
                    String name = ScannerInput.readNextLine("Enter the Parrots name:   ");
                    int age = ScannerInput.readNextInt("Enter the Parrots's age:   ");
                    double wingSpan = ScannerInput.readNextDouble("What is the Parrots wing span:  ");
                    int canFlyInput = ScannerInput.readNextInt("Can this Parrot fly? (1 = Yes, 0 = No): ");
                    boolean canFly = (canFlyInput == 1);
                    int vocabularySize = ScannerInput.readNextInt("Enter vocabulary size:   ");
                    Parrot parrot = new Parrot(name, ownerId, owner, age, wingSpan, canFly, vocabularySize);
                    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

                    for (int i = 0; i < days.length; i++) {
                        int attending = ScannerInput.readNextInt("Attending " + days[i] + "? (1 = Yes, 0 = No): ");
                        if (attending == 1) parrot.checkIn(i);
                    }
                    isAdded = petsDayCareAPI.addPet(parrot);
                }
                case 4 -> {
                    System.out.println("This was a joke, why did you come here......");
                }
                case 5 -> option = 0;
                default -> System.out.println("Invalid option entered: " + option);
            }
        }

            if (isAdded) {
                System.out.println("Pet Added Successfully");
            } else {
                System.out.println("Pet not Added, please try again");

            }


    }
    //-----------------------------------------------------------------
    //  Private methods for Search facility
    //-----------------------------------------------------------------
    private void deletePetIndex(){
        String deleteIndex = ScannerInput.readNextLine("What is the pet index:   ");
        System.out.println(petsDayCareAPI.deletePetByIndex(Integer.parseInt(deleteIndex)));
    }
    private void deletePetID(){
        int deleteID = ScannerInput.readNextInt("What is the pet ID:   ");
    System.out.println(petsDayCareAPI.deletePetById(deleteID));}
    private void searchPets() {
        String name = ScannerInput.readNextLine("Enter pet name to search: ");
        System.out.println(petsDayCareAPI.getPet(name));
    }
    private void searchPetsByID() {
        int id = ScannerInput.readNextInt("Enter pet id to search: ");
        System.out.println(petsDayCareAPI.getPetByID(id));
    }
    private void searchPetsByOwner() {
        String ownerId = ScannerInput.readNextLine("Enter owner ID to search: ");
        System.out.println(petsDayCareAPI.listAllPetsByOwner(ownerId));
    }
    private void findDogByOwnerandBreedwithAge(){
        String ownerId = ScannerInput.readNextLine("Enter owner ID to search: ");
        String breed = ScannerInput.readNextLine("What is the dog's breed:  ");
        int age = ScannerInput.readNextInt("What is the dog's age: ");
        System.out.println(petsDayCareAPI.findDogByOwnerAndBreedAndAge(ownerId,breed,age));
    }
    private void numberOfWordsParrot(){
        int words = ScannerInput.readNextInt("What is the Parrots words: ");
        System.out.println(petsDayCareAPI.numberOfParrotsByVocabularySize(words));
    }

    //-----------------------------
    //  Private methods for Reports
    // ----------------------------

private int reportMenu(){
        return ScannerInput.readNextInt("""
                Pet Day Care
                Please choose what animal you want to register
                ----------------
                1) List all Pets
                2) List all Dogs
                ----------------------------
                3) List all Cats
                4) List all Parrots
                ------------------------------
                5) List all Dangerous Dogs
                6) List all indoor cats
                --------------------------------
                7) List all dogs older than an age
                8) list all cats by favourite toy
                --------------------------------------
                9) List all animals that are neutered
                10) Produce Weekly Income Report
                ---------------------------------------
                0) Back to the Main menu
                """);
    }

private int runreportMenu() {
    int option2 = reportMenu();
    while (option2 != 0) {
        switch (option2) {
            case 1 -> listAllPets();
            case 2 -> listAllDogs();
            case 3 -> listAllCats();
            case 4 -> listALlParrots();
            case 5 -> listALlDDogs();
            case 6 -> listAllInCats();
            case 7 -> listOldDogs();
            case 8 -> listAllFavCat();
            case 9 -> listAllNeuAnimal();
            case 10 -> incomeReport();
            default -> System.out.println("Invalid Pet" + option2);
        }
        // clearScreen();
        option2 = reportMenu();
    }
    return option2;
}
    private void listAllPets() {
        System.out.println(petsDayCareAPI.listAllPets());
    }

    private void listAllDogs() {
        System.out.println(petsDayCareAPI.listAllDogs());
    }

    private void listAllCats() {
        System.out.println(petsDayCareAPI.listAllCats());
    }
    private void listALlParrots() {
        System.out.println(petsDayCareAPI.listAllParrots());
    }

    private void listALlDDogs() {
        System.out.println(petsDayCareAPI.listAllDangerousDogs());
    }

    private void listAllInCats() {
        System.out.println("Indoor Cats: " + petsDayCareAPI.numberOfIndoorCats());
    }

    private void listOldDogs() {
        int age = ScannerInput.readNextInt("Enter minimum age: ");
        System.out.println(petsDayCareAPI.listAllPetsThatStayMoreDays(age));
    }

    private void listAllFavCat() {
        String toy = ScannerInput.readNextLine("Enter favourite toy: ");
        System.out.println(petsDayCareAPI.listAllFavCatToys(toy));
    }

    private void listAllNeuAnimal() {
        System.out.println(petsDayCareAPI.listAllNeuteredAnimals());
    }

    private void incomeReport() {
        System.out.println("Weekly Income: €" + petsDayCareAPI.getWeeklyIncome());
        System.out.println("Average Days Per Week: " + petsDayCareAPI.getAverageNumDaysPerWeek());
    }
//---------------------------------
    //  Private methods for Persistence
    // --------------------------------
private void sortPets() {
    int option = ScannerInput.readNextInt("""
            Sort by:
            1) Sort by ID
            2) Sort by Name
            ==>> """);
    switch (option) {
        case 1 -> petsDayCareAPI.sortPetsById();
        case 2 -> petsDayCareAPI.sortPetsByName();
        default -> System.out.println("Invalid option");
    }
    System.out.println("Pets sorted successfully");
}
    private void saveAll() {
        try {
            petsDayCareAPI.save();
            System.out.println("Pets saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadAll() {
        try {
            petsDayCareAPI.load();
            System.out.println("Pets loaded successfully");
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

}