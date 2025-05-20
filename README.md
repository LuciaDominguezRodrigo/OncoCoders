# <p align="center"> OncoCoders </p>   

The goal of this project is to develop **algorithms and predictive models for variables associated with breast cancer**. Additionally, the project aims to create an innovative platform that empowers healthcare professionals to make informed therapeutic decisions from the moment of diagnosis. This approach eliminates the need to wait for follow-ups to evaluate patient progress, enabling more timely and effective interventions.

## 💡 Project Idea

**OncoCoders is a web-based platform accessible from any device**, designed to support **healthcare professionals, patients, and researchers** in the diagnosis, treatment, and follow-up of breast cancer.

At its core, the platform uses **advanced algorithms and predictive models** to assist clinical decisions from the very first diagnosis. This enables faster and more effective interventions without having to wait for follow-up visits to assess patient progress.

Key features of OncoCoders include:

- **Diagnosis support through machine learning models**, making the treatment journey faster and more efficient.
- **Follow-up and communication tools**, such as forms that help train models and track clinical progression in real time.
- **Clear and intuitive data visualization**, accessible to both doctors and patients.
- **Information and guidance on nutrition, self-care, and emotional well-being**, tailored not only to patients but also to families and caregivers.
- **Emotion-based filtering**, allowing recommendations and content to adapt to the patient’s current emotional state.
- **Researcher tools**, including secure upload of anonymized datasets and the ability to download data for model training and AI development.
- **Support from a multidisciplinary team**, including psychologists and nutritionists, with plans to expand to additional healthcare professionals.
- **Ongoing development**, with future updates including:
  - Multilingual support
  - Enhanced usability and accessibility
  - A **group chat for patients**
  - A **community forum** for sharing experiences and treatment feedback

The platform currently runs in any web browser, and a **mobile app version for iOS and Android** is planned for future releases.

---
## 👷 Team members

| Name                       | Email                             | Github user                                                        |
| -------------------------- | --------------------------------- | ------------------------------------------------------------------ |
| Lucía Domínguez Rodrigo    | lucia.dominguez.rodrigo@gmail.com | [@LuciaDominguezRodrigo](https://github.com/LuciaDominguezRodrigo) |
| Gemma Millán Zamora        | gemmamillan123@gmail.com          | [@gemmamillan](https://github.com/gemmamillan)                     |
| Ainhoa López Carrasco      | ainhoa.lop.car@gmail.com          | [@Alopeeez04](https://github.com/Alopeeez04)                       |
| Marcos Jiménez Pulido      | marcosjp0901@gmail.com            | [@MarJ03](https://github.com/MarJ03)                           |


## :scroll:Table of Contents

- [:hammer: Usage](#hammer-usage)
  - [:paw_prints: Steps](#paw_prints-steps)
  - [💾DataBase Config](#database-config)
  - [:wrench: Software Requirements](#wrench-software-requirements)
  - [🕹️ IDE Config](#️-ide-config)
  - [:book: Sample Data](#book-sample-data)
- [:black_nib: Requirement Analysis](#black_nib-requirement-analysis)
  - [:black_joker: Entities](#black_joker-entities)
  - [:busts_in_silhouette: Type of Users](#busts_in_silhouette-type-of-users)
  - [:wrench: Functional Requirements](#wrench-functional-requirements)
  - [:electric_plug: Non Functional Requirements](#electric_plug-non-functional-requirements)
- [:straight_ruler: Design](#straight_ruler-design)
  - [:church: Architecture](#church-architecture)
  - [:performing_arts: Branding](#performing_arts-branding)
  - [:cd: Database](#cd-database)
- [🧭 Possible actions to perform in the application](#-possible-actions-to-perform-in-the-application)

## :hammer: Usage

This section will explain the procedure for using the application.

### :paw_prints: Initial configuration

1. Download this repository
2. Check Requirements 
3. Configure DataBase
4. Configure IDE
5. Open a terminal window from the project root source

After completing all configuration steps, the application can be started manually or using a Windows or Linux dedicated script for easier steps.
### :fast_forward: Quick start
6. Execute the command ```.\localrun.bat``` (Windows Powershell) or ```./localrun.sh``` (Linux, requires execution permissions). In both cases, two independent terminal windows will be created, and the application will start its services concurrently. 

### :arrow_forward: Manual start
5. Run translation API server from Docker. Go to TranslationAPIServer folder and execute the command ```docker compose up -d```.
6. Run backend from terminal Go to ProjectBackend folder and execute the command ```mvnw spring-boot:run```.
7. Run Angular from terminal Go to ProjectFrontend folder and execute the command ```npm start```.
8. Go to: https://localhost:4200/


### :no_entry: Stopping the application
- Execute the command ```docker compose down```
- Go to the different terminal windows opened previously and press Ctrl+C repeatedly in each one to stop all processes related to the application execution.

### 💾DataBase Config

- Download MySQL v.8.0.41.0
- Select default port (port 3306)
- Create a user with DB admin permissions
- Configure MySQL Server as Windows Service
- Grant full access to the user
- Create a new Schema named EventCrafters in the server using MySQL Workbench

### :wrench: Software Requirements

This section shows the applications and versions required to run the software properly.

|                          Software Requirements                          |       Version        |
| :---------------------------------------------------------------------: | :------------------: |
|                    [Node.js](https://nodejs.org/en)                     | `22.13.1` or higher  |
| [JDK 21](https://www.oracle.com/es/java/technologies/downloads/#java21) | `Java 21` or higher  |
|           [MySQL](https://dev.mysql.com/downloads/installer/)           | `8.0.41.0` or higher |
|          [Apache Maven](https://maven.apache.org/download.cgi)          |  `3.9.9` or higher   |
|        [Angular Cli](https://www.npmjs.com/package/@angular/cli)        |  `19.1.5` or higher  |

### 🕹️ IDE Config

- We have used IntelliJ IDEA, bt it can be possible to use other IDE´S (like Visual Studio Code)
- Install Maven and Spring for your IDE


#### 🛠️ Development Environment Setup

To set up the development environment for the SPA application using Angular, follow these steps:

##### Prerequisites
1. **Node.js**: Ensure that Node.js is installed on your system. You can download it from [Node.js official website](https://nodejs.org/en).
2. **Angular CLI**: Install Angular CLI globally using npm:
   ```bash
   npm install -g @angular/cli
   ```
##### Start Angular
1. **Clone the project**
   ```bashhttps://github.com/LuciaDominguezRodrigo/OncoCoders.git ```
2. **Make sure the backend is running**: Following the instructions `🔣Execution instructions` of the documentation
3. **Redirect to the ProjectFrontend directory**
   ```bash
   cd OncoCoders/ProjectFrontend
   ```
4. **Install all the necessary modules**
   ```bash
   npm install
   ```

The SPA will be ready at [http://localhost:4200/](http://localhost:4200/)

### :book: Sample Data

#### Users
This section shows the credentials of the test users to demo the application:

|       user       |             email             |      password      |
| :--------------: | :---------------------------: | :----------------: |
|   ``@patient``   |     ``patient@gmail.com``     |      ``pass``      |
|  ``@patient2``   |    ``patient2@gmail.com``     |      ``pass``      |
|  ``@patient3``   |    ``patient3@gmail.com``     |      ``pass``      |
|   ``@doctor``    | ``doctorhospital@gmail.com``  |   ``medicpass``    |
|   ``@doctor2``   | ``doctor2hospital@gmail.com`` |   ``medicpass``    |
| ``@researcher``  |   ``researcher@gmail.com``    | ``researcherpass`` |
| ``@researcher2`` |   ``researcher2@gmail.com``   | ``researcherpass`` |
|    ``@admin``    |      ``admin@gmail.com``      |   ``adminpass``    |

#### Docs

Sample excel documents for the Reseacher User to upload in the application.

- [Access to model 1](docs/SampleExcel/modelo_1.xlsx)
- [Access to model 2](docs/SampleExcel/modelo_2.xlsx)
- [Access to model 3](docs/SampleExcel/modelo_3.xlsx)
- [Access to model 4](docs/SampleExcel/modelo_4.xlsx)

## :black_nib: Requirement Analysis

This section will contain all the analysis of the application.

### :black_joker: Entities

Currently, there are 5 entities.

|      Entities       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                |
| :-----------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|        User         | Represents individuals who interact with the application. Each user has a specific role, which determines their permissions and access within the platform.                                                                                                                                                                                                                                                                                |
|    UserDiagnosis    | Represents the various results generated by the predictive models. It stores the diagnostic outcomes associated with a user, providing insights into their health status. This entity allows patients, doctors, and researchers to access and track diagnostic history, supporting better decision-making and medical interventions.                                                                                                       |
|  UserFormResponse   | Represents the user-provided data used to train statistics models and generate statistical percentage results. This data is essential for improving diagnosis accuracy, and contributing to better predictive analytics in cancer detection and research.                                                                                                                                                                                  |
| ClinicFormResponse  | Represents the medical data and biological markers collected when a user is diagnosed for the first time. This form contains critical clinical information essential for establishing an initial diagnosis. Only a doctor can complete and submit this form, ensuring accurate and professional medical assessment. The data recorded here contributes to treatment planning, patient monitoring, and statistics model training.           |
| ClinicFormResponse2 | Represents the medical data and biological markers collected when a patient experiences a relapse. This form is crucial for tracking disease progression and adjusting treatment plans accordingly. Only a doctor can complete and submit this form, ensuring accurate and professional medical evaluation. The data gathered helps in monitoring patient outcomes, refining statistics models, and improving relapse detection strategies |


### :busts_in_silhouette: Type of Users

In the application there are 4 different type of user:

|  Type of User   | Description                                                                         |
| :-------------: | :---------------------------------------------------------------------------------- |
|   Public User   | Access only see general data                                                        |
|  Patient User   | Access to the form and its personalized diagnostics                                 |
| Specialist User | Access to patient data provided in the form, along with access to the use of the AI |
|   Admin User    | Access to page configuration and AI configuration                                   |

### :wrench: Functional Requirements

Here are the diferent actions that can do the different type of users. [Click here](#-possible-actions-to-perform-in-the-application) to see an explanation of possible actions.

| User Histories                                  |       Public       |      Patient       |     Specialist     |       Admin        |     Researcher     |
| :---------------------------------------------- | :----------------: | :----------------: | :----------------: | :----------------: | :----------------: |
| UH-01 Sign Up                                   | :heavy_check_mark: |                    |                    |                    |                    |
| UH-02 Log In                                    |                    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |                    |
| UH-03 Log Out                                   |                    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-04 Access to Main Page                       | :heavy_check_mark: |                    |                    |                    |                    |
| UH-05 See Project's Presentation                | :heavy_check_mark: |                    |                    |                    |                    |
| UH-06 Access to User Home Page                  |                    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-07 Show Patient User Home Page               |                    | :heavy_check_mark: |                    |                    |                    |
| UH-08 Access to Formulary Page                  |                    | :heavy_check_mark: |                    |                    |                    |
| UH-09 Access to Diagnosis Page                  |                    | :heavy_check_mark: |                    |                    |                    |
| UH-10 Access to Recommendations Page            |                    | :heavy_check_mark: |                    |                    |                    |
| UH-11 Show to Psychological Help pop-up         |                    | :heavy_check_mark: |                    |                    |                    |
| UH-12 Access to Profile Page                    |                    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-13 Show Medic User Home Page                 |                    |                    | :heavy_check_mark: |                    |                    |
| UH-14 Access Medic User Dashboard Page          |                    |                    | :heavy_check_mark: |                    |                    |
| UH-15 Access to Medic User Metrics              |                    |                    | :heavy_check_mark: |                    |                    |
| UH-16 Access to record of all Patients          |                    |                    | :heavy_check_mark: |                    |                    |
| UH-17 See more information about a Patient User |                    |                    | :heavy_check_mark: |                    |                    |
| UH-18 Show Admin User Home Page                 |                    |                    |                    | :heavy_check_mark: |                    |
| UH-19 Show Admin User Dashboard Page            |                    |                    |                    | :heavy_check_mark: |                    |
| UH-20 Access to all not banned Users Page       |                    |                    |                    | :heavy_check_mark: |                    |
| UH-21 Ban an User                               |                    |                    |                    | :heavy_check_mark: |                    |
| UH-22 Access to all banned Users Page           |                    |                    |                    | :heavy_check_mark: |                    |
| UH-23 Unban an User                             |                    |                    |                    | :heavy_check_mark: |                    |
| UH-24 See application general metrics           |                    |                    |                    | :heavy_check_mark: |                    |
| UH-25 Show Researcher User Home Page            |                    |                    |                    |                    | :heavy_check_mark: |
| UH-26 Access to IA Model Configuration Page     |                    |                    |                    |                    | :heavy_check_mark: |
| UH-27 Access to About Us Page                   | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-28 Show sections explanation                 |                    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |

#### Use Case Diagrams

<p align="center">
  <img src="/docs/use_case_diagrams/Public_User.svg" alt="Public_User_Diagram">
  <br>
  <small>Use Case Diagram 1. Public User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Patient_User.svg" alt="Patient_User_Diagram">
  <br>
  <small>Use Case Diagram 2. Patient User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Medic_User.svg" alt="Medic_User_Diagram">
  <br>
  <small>Use Case Diagram 3. Specialist User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Admin_User.svg" alt="Admin_User_Diagram">
  <br>
  <small>Use Case Diagram 4. Admin User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Researchers_User.svg" alt="Researcher_User_Diagram">
  <br>
  <small>Use Case Diagram 5. Researcher User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/User_Managment.svg" alt="User_Managment_Diagram">
  <br>
  <small>Use Case Diagram 6. User Managment</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Navigation_Bar.svg" alt="Navigation_Bar_Diagram">
  <br>
  <small>Use Case Diagram 7. Navigation Bar</small>
</p>


### :electric_plug: Non Functional Requirements

|            Non Functional Requirements             |
| :------------------------------------------------: |
|                  Oriented to Web                   |
|                 Responsive Design                  |
|   The software must be implemented with Angular    |
| The applicaction need to connect with SQL Database |
|  The applicaction need to connect with IA models   |
|      GUI must be minimalist and user-friendly      |
|   Protection & Security for Registered User Data   |
|              Usability & Accesibility              |
|           Main language must be Spanish            |

## :straight_ruler: Design

### :church: Architecture

<p align="center">
  <img src="/docs/architecture/Architecture.svg" alt="Architecture_Diagram">
  <br>
  <small>Architecture Diagram 1. Web Architecture</small>
</p>

### :performing_arts: Branding

| ![Figure 1. Logo](/docs/logo/oncocoders-pink.png) | ![Figure 2. Black Logo](/docs/logo/oncocoders-black.png) | ![Figure 3. White Logo](/docs/logo/oncocoders-white.png) |
| :-----------------------------------------------: | :------------------------------------------------------: | :------------------------------------------------------: |
|                  Figure 1. Logo                   |                   Figure 2. Black Logo                   |                   Figure 3. White Logo                   |

To see the logos in more detail, [click here](/docs/logo/).

### :cd: Database

<p align="center">
  <img src="/docs/database/relational-db.svg" alt="Relational_DB_ER_diagram">
  <br>
  <small>Entity Relation Diagram 1. Relational DB</small>
</p>

<p align="center">
  <img src="/docs/database/user-relation.svg" alt="User_Relation_ER_Diagram">
  <br>
  <small>Architecture Diagram 1. User relation</small>
</p>

## 🧭 Possible actions to perform in the application

### Login
 To log in, access the screen that displays the corresponding form. Enter the username and password, and you will be redirected to the personalized home page (since the session has been added). For this action, having an account is required. 

### Register
Through the login screen (via the "Sign Up" link) or the registration button on the default home screen, access will be provided to a user creation form. Those users whose email contains the word "hospital" will be created with the role of doctor. Those whose email contains the word "researcher" will be created with the researcher role, and the rest, by default, with the user role. 
Page administrators will be created by default

### Update profile info
On the profile page, fields can be edited using the "Edit" button next to each one. When clicked, a form will appear, allowing the user to update their information. It is important to note that if the zone is changed, the reference hospital will automatically update to match the assigned doctor's hospital.

### Patient diagnosis
The patient user will be able to access their most recent complete diagnosis through their profile, as well as via the corresponding button in the sidebar. The doctor will be able to access the most recent diagnoses of their assigned patient by entering the patient's ID in a form, which can be accessed by clicking the "Go to Diagnosis Results" button. The doctor will also be able to view patient diagnoses through the "Consult Statistics" button on their profile.

### View patient list
The doctor will be able to view the list of their assigned patients by navigating through the "Patients" button in the sidebar.

### View general correlation data statistics
The doctor will be able to view various data correlation charts by navigating through the "Dashboard" button in the sidebar.

### Access to patient first and relapse form
The doctor will be able to access the initial diagnosis form for a first-time diagnosed patient through their profile, as well as the relapse form.

### Access to general recommenadations
Patients can view general recommendations as well as more detailed information about each recommendation group by navigating to Recommendations through their profile or the sidebar.

### User form
Patients will have access to the self-prediction form through their profile or the sidebar.

### Access to  psychological support
Patients can access 24/7 psychological support through the phone number displayed when they click on the Psychological Help option in the navbar.

### Consult information about OncoCoders
You can visit the About Us page to learn more about our team, our mission, and our vision. Discover who we are, what we stand for, and how we strive to make a difference.

### Access to Informed consent and Privacy Policy
They will be able to access our data privacy policy as well as the informed data consent through the designated section at the bottom of each user's profile.

### Download excels 
If the user has a Researcher role, they will be able to download the necessary Excel files related to model training through the designated buttons in their profile.

### Upload excels
If the user has a Researcher role, they will be able to upload Excel files with the results provided by the models through the Model Configuration button in the sidebar.

### Ban/Unban user
A user with the Admin role can ban and unban users. Banned users will not be able to access the application.

### Consult information about OncoCoders
You can visit the About Us page to learn more about our team, our mission, and our vision. Discover who we are, what we stand for, and how we strive to make a difference.

## 📜 License and Copyright
© [2025] [OncoCoders]. All rights reserved.

This code is the exclusive property of **Lucía Dominguez Rodrigo, Ainhoa López Carrasco, Gemma Millán Zamora and Marcos Jiménez Pulido**. Copying, modifying, distributing, using, or downloading any part of this code is strictly prohibited without the express written authorization of all the owners.

This project is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License (CC BY-NC-ND 4.0), with the following additional restrictions:

**No Commercial Use**: The use of this code for commercial purposes is not allowed without the explicit written permission of the owners.

**No Modifications**: The code may not be modified, adapted, or used to create derivative works without the express authorization of the owners.

**Restricted Distribution**: The code may not be distributed, sublicensed, or shared without the express consent of the owners.

Any violation of these restrictions may result in legal action in accordance with current intellectual property and copyright law.

You can find more details about the license on the official Creative Commons website:
🔗 https://creativecommons.org/licenses/by-nc-nd/4.0/deed.en
