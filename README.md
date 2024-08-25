# VShopper

VShopper is a web-based e-commerce application that allows users to browse, search, and purchase various electronic products, including laptops, phones, iPads, and more. The application provides an easy-to-use interface for both customers and administrators to manage product inventories, process orders, and handle customer queries.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- **Java**: Backend logic implementation.
- **JSP/Servlet**: For server-side rendering and handling user requests.
- **JSTL**: JavaServer Pages Standard Tag Library for dynamic content.
- **HTML/CSS/JavaScript**: Frontend development.
- **Bootstrap**: Responsive design framework.
- **MySQL/SQL Server**: Database management system.
- **Tomcat 10.1**: Web server.
- **NetBeans 17**: Integrated Development Environment (IDE) for Java.
- **JDK 17**: Java Development Kit.

## Installation

To run the VShopper project locally, follow these steps:

1. **Setup Your Environment**:

   - Install **JDK 8+**.
   - Install **Apache Tomcat 9+**.
   - Install **MySQL** or **SQL Server**.
   - Install NetBeans 17 with JDK 17.
   - Add the following libraries required: `jakarta.servlet.jsp.jstl-2.00.jar`, `jaxb-api-2.1.jar`, `sqljdbc42.jar`, `lombok-1.18.24.jar`. These libraries are included in the `Project_PRJ301_VShopper_VuNA\VShopper\web\lib` directory.

2. **Configure the Database**:

   - Create a new database named `vshopper_db`.
   - Run the SQL scripts provided in the `/database` directory to create tables and insert initial data.

3. **Build the Project**:

   - Use an IDE like **NetBeans 17** or **Eclipse** to open the project.
   - Build the project and resolve any dependencies.

4. **Deploy to Tomcat**:

   - Copy the compiled WAR file to the `webapps` directory of your Tomcat server.
   - Start the Tomcat server.

5. **Access the Application**:
   - Open a web browser and go to `http://localhost:8080/vshopper`.

## Usage

1. **For Customers**:

   - Browse products by categories.
   - Add products to the cart and proceed to checkout.
   - View order history and manage personal information.

2. **For Admins**:
   - Access the admin dashboard to manage products, categories, users, and orders.
   - View sales reports and analyze customer behavior.

## Database Setup

1. **MySQL Setup**:

   - Create a new schema `vshopper_db`.
   - Run the `create_tables.sql` script in the `/database/mysql` directory.
   - Run the `insert_data.sql` script to add initial data.

2. **SQL Server Setup**:
   - Create a new database `vshopper_db`.
   - Run the `create_tables.sql` script in the `/database/sqlserver` directory.
   - Run the `insert_data.sql` script to add initial data.

Ensure the database connection settings in the `db.properties` file match your local database configuration.

## Contributing

We welcome contributions to VShopper! Please follow these steps to contribute:

1. **Fork the Repository**.
2. **Create a New Branch** (`git checkout -b feature-branch`).
3. **Make Your Changes and Commit Them** (`git commit -m 'Add new feature'`).
4. **Push to the Branch** (`git push origin feature-branch`).
5. **Open a Pull Request**.

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

Happy Shopping with VShopper! 🎉
