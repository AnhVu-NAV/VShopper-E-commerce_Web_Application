# VShopper - E-commerce Web Application

VShopper is a web-based e-commerce platform that allows users to browse, search, and purchase various electronic products such as laptops, phones, iPads, and more. It provides an intuitive interface for both customers and administrators to manage product inventories, process orders, and view sales reports.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used
- **Backend:** Java, JSP, Servlet
- **Frontend:** HTML, CSS, JavaScript, Bootstrap
- **Database:** SQL Server
- **Web Server:** Tomcat 10.1
- **IDE:** NetBeans 17
- **JDK:** Java 17

## Installation

To run the VShopper project locally, follow these steps:

### Setup Your Environment
1. Install **JDK 17+**.
2. Install **Apache Tomcat 10.1+**.
3. Install **SQL Server**.
4. Install **NetBeans 17** or any Java IDE that supports JSP and Servlet.

### Libraries Required
Make sure to include the following libraries in your project (located in the `web/lib` directory):
- `jakarta.servlet.jsp.jstl-2.00.jar`
- `jaxb-api-2.1.jar`
- `sqljdbc42.jar`
- `lombok-1.18.24.jar`

### Configure the Database

1. **Create Database:**
   - Create a new SQL Server database named `vshopper_db`.

2. **Run SQL Scripts:**
   - Navigate to the `/database/sqlserver` directory.
   - Run the `create_tables.sql` script to create necessary tables.
   - Run the `insert_data.sql` script to add initial data.

3. **Configure Database Connection:**
   - Edit the `db.properties` file to match your SQL Server connection settings.

### Build and Deploy the Project

1. Open the project in **NetBeans 17** or another compatible IDE.
2. Build the project and resolve any dependencies.
3. Deploy the application:
   - Copy the compiled WAR file to the `webapps` directory of your Tomcat server.
   - Start Tomcat.

### Access the Application
- Open a web browser and go to `http://localhost:8080/vshopper` to access the application.

## Usage

### For Customers:
- **Browse Products:** View products by categories.
- **Cart & Checkout:** Add products to the cart and proceed to checkout.
- **Order History:** View past orders and manage personal information.

### For Admins:
- **Admin Dashboard:** Manage products, categories, users, and orders.
- **Sales Reports:** View sales performance and analyze customer behavior.

## Database Setup

### SQL Server Setup:

1. **Create Database:**
   - Create the `vshopper_db` database in SQL Server.
   
2. **Run Scripts:**
   - Run the `create_tables.sql` to create the database schema.
   - Run the `insert_data.sql` script to insert initial data.

3. Ensure the **database connection settings** in the `db.properties` file are correctly configured to your local SQL Server instance.

## Contributing

We welcome contributions to VShopper! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Happy Shopping with VShopper! 🎉
