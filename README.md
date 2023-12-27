## Project's Title: Wholesale system

## Project's description:

- A web-based wholesale stock control system for food products.
- The system allows to do **CRUD** of food products (id, SKU, description, category, price) from SQLite DB.
- The system allows have to do **CRUD** of business customers (business name, address, telephone) from SQLite DB.
- The system allows to search food products by description
- Technology used:

    - Java: Spring boot
    - Html: Thymeleaf
    - CSS: Tailwind CSS/ daisyUI

## How to Install and Run the Project

Step 1: Install Maven

- On Windows:
    1. Download Maven Binary zip file
    2. Setting environmentally variable
    3. check maven version with `man -v` to check installation successful or not
    4. for more info can refer this step-by-step instruction: https://phoenixnap.com/kb/install-maven-windows
- On macOS
    1. Install Homwbrew(Package Manager for macOS)
       with `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
    2. Install Maven with `brew install maven`

Step 2: Run the Project

- `mvn spring-boot:run`

## How to Use the Project

#### For Console Menu

Enter number of option to choose which function you want to test

#### For Web Functionality

1. Please start with this URL: http://localhost:8080/login
2. login username and password is:
    - username: test001
    - password: test001
3. There's a sidebar to choose go to food product or customer system
4. Then you can start to create, edit, delete, read and search food products
5. Also, you can start to create, edit, delete, and read customers

## Folder Structure

- Project's Instruction: wholesale_system/README.md
- Food Products: wholesale_system/src/main/java/com/example/wholesale_system/food_product
- Customers: wholesale_system/src/main/java/com/example/wholesale_system/customer
- Html: wholesale_system/src/main/resources
- Tests of Classes: wholesale_system/src/test/java/com/example/wholesale_system

## Credits

Thanks so much for the documentations of Spring, Springboot, Thymeleaf and daisyUI to let me learn to do a basic
fullstack project.

- Spring/ Spring boot: https://spring.io/guides/gs/spring-boot/
- Thymeleaf: https://www.thymeleaf.org/documentation.html
- daisyUI: https://daisyui.com/