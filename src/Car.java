// Enum for fuel types
enum FuelType {
    GASOLINE, ELECTRICITY, DIESEL, HYBRID
}

public class Car {
    private String brand;
    private String model;
    private int currentSpeed;
    private int maxSpeed;
    private FuelType fuel;
    private int numberOfDoors;
    private boolean isConvertible;

    // Private constructor for use with the Builder
    private Car(String brand, String model, int maxSpeed, FuelType fuel, int numberOfDoors, boolean isConvertible) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuel = fuel;
        this.numberOfDoors = numberOfDoors;
        this.isConvertible = isConvertible;
        this.currentSpeed = 0; // Initial speed is 0
    }

    // Getter and Setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
    }

    // Getter and Setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && !model.isEmpty()) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Model cannot be empty.");
        }
    }

    // Getter and Setter for max speed
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            throw new IllegalArgumentException("Max speed must be greater than 0.");
        }
    }

    // Getter and Setter for fuel type
    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    // Getter and Setter for number of doors
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors >= 0) {
            this.numberOfDoors = numberOfDoors;
        } else {
            throw new IllegalArgumentException("Number of doors cannot be negative.");
        }
    }

    // Getter and Setter for convertible option
    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        this.isConvertible = convertible;
    }

    // Method to accelerate the car
    public void accelerate(int amount) {
        if (amount >= 0) {
            currentSpeed += amount;
            if (currentSpeed > maxSpeed) {
                currentSpeed = maxSpeed; // Ensure speed doesn't exceed the max speed
            }
        } else {
            throw new IllegalArgumentException("Acceleration cannot be negative.");
        }
    }

    // Method to brake the car
    public void brake(int amount) {
        if (amount >= 0) {
            currentSpeed -= amount;
            if (currentSpeed < 0) {
                currentSpeed = 0; // Ensure speed doesn't go below 0
            }
        } else {
            throw new IllegalArgumentException("Braking cannot be negative.");
        }
    }

    // Method to get information about the car
    public String getInfo() {
        String convertibleInfo = isConvertible ? "yes" : "no";
        return String.format("Brand: %s, Model: %s, Max Speed: %d km/h, Fuel: %s, Number of Doors: %d, Convertible: %s, Current Speed: %d km/h",
                brand, model, maxSpeed, fuel.toString(), numberOfDoors, convertibleInfo, currentSpeed);
    }

    // Builder for creating a Car object
    public static class Builder {
        private String brand;
        private String model;
        private int maxSpeed;
        private FuelType fuel;
        private int numberOfDoors;
        private boolean isConvertible;

        public Builder(String brand, String model, int maxSpeed) {
            this.brand = brand;
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        public Builder setFuel(FuelType fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        public Builder setConvertible(boolean convertible) {
            this.isConvertible = convertible;
            return this;
        }

        public Car build() {
            return new Car(brand, model, maxSpeed, fuel, numberOfDoors, isConvertible);
        }
    }

    public static void main(String[] args) {
        // Creating a Car object using the Builder pattern
        Car car = new Car.Builder("Toyota", "Camry", 180)
                .setFuel(FuelType.GASOLINE)
                .setNumberOfDoors(4)
                .setConvertible(false)
                .build();

        // Displaying information about the car
        System.out.println(car.getInfo());
    }
}
