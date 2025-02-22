# <p align="center"> OncoCoders </p>
***   

The goal of this project is to develop **algorithms and predictive models for variables associated with breast cancer**. Additionally, the project aims to create an innovative platform that empowers healthcare professionals to make informed therapeutic decisions from the moment of diagnosis. This approach eliminates the need to wait for follow-ups to evaluate patient progress, enabling more timely and effective interventions.

### 👷 Team members
*************

| Name                       | Email                             | Github user                                                        |
| -------------------------- | --------------------------------- | ------------------------------------------------------------------ |
| Lucía Domínguez Rodrigo    | lucia.dominguez.rodrigo@gmail.com | [@LuciaDominguezRodrigo](https://github.com/LuciaDominguezRodrigo) |
| Gemma Millán Zamora        | gemmamillan123@gmail.com          | [@gemmamillan](https://github.com/gemmamillan)                     |
| Ainhoa López Carrasco      | ainhoa.lop.car@gmail.com          | [@Alopeeez04](https://github.com/Alopeeez04)                       |
| Ikár Martínez de Liz Kosto | iv.mardeliz.software@gmail.com    | [@KandV008](https://github.com/KandV008)                           |
| Laura Llorente Vilanova    | laura.llovi@gmail.com             | [@lauraloops](https://github.com/lauraloops)                       |

## :scroll:Table of Contents

- [ OncoCoders ](#-oncocoders-)
    - [👷 Team members](#-team-members)
  - [:scroll:Table of Contents](#scrolltable-of-contents)
  - [:hammer: Usage](#hammer-usage)
    - [:paw\_prints: Steps](#paw_prints-steps)
  - [🔣Execution instructions](#execution-instructions)
    - [👟Steps](#steps)
    - [📋Requirements](#requirements)
    - [💾DataBase Config](#database-config)
    - [🕹️IDE Config](#️ide-config)
    - [🛠️ Development Environment Setup](#️-development-environment-setup)
      - [Prerequisites](#prerequisites)
      - [Start Angular](#start-angular)
    - [:wrench: Requirements](#wrench-requirements)
    - [:black\_nib: Requirement Analysis](#black_nib-requirement-analysis)
      - [:black\_joker: Entities](#black_joker-entities)
      - [:busts\_in\_silhouette: Type of Users](#busts_in_silhouette-type-of-users)
      - [:wrench: Functional Requirements](#wrench-functional-requirements)
      - [:electric\_plug: Non Functional Requirements](#electric_plug-non-functional-requirements)
      - [Use Case Diagrams](#use-case-diagrams)
    - [:straight\_ruler: Design](#straight_ruler-design)
    - [:church: Prototype](#church-prototype)
      - [🛠️ V0 prototype](#️-v0-prototype)
  - [⚔️ Sample users](#️-sample-users)
    - [🔑 @patient](#-patient)
    - [🔑 @patient2](#-patient2)
    - [🔑 @patient3](#-patient3)
    - [🛡️ @doctor](#️-doctor)
    - [🛡️ @doctor2](#️-doctor2)
    - [🚀 @researcher](#-researcher)
    - [🚀 @researcher2](#-researcher2)
    - [⚖️ @admin](#️-admin)
  - [📓 Sample docs](#-sample-docs)
      - [:airplane: Navigation](#airplane-navigation)
      - [:performing\_arts: Branding](#performing_arts-branding)
      - [:church: Architecture](#church-architecture)
      - [:dvd: DataBase](#dvd-database)
  - [:libra: License](#libra-license)


## :hammer: Usage

The steps to follow to use the application locally will be described.

### :paw_prints: Steps

## 🔣Execution instructions

### 👟Steps 
1. Download this repository
2. Check Requirements 
3. Configure DataBase
4. Configure IDE
5. Run Application in the IDE
6. Go to https://localhost/8443/

### 📋Requirements
- Java: JDK 21 --> https://www.oracle.com/es/java/technologies/downloads/#java21
- MySQL: v.8.0.41.0 (Explained in DataBase Configuration)
- Maven: 3.9.9
- Spring Boot 3.4.1
- IDE (explained in IDE Configuration)

### 💾DataBase Config
- Download MySQL v.8.0.41.0
- Select default port (port 3306)
- Create a user with DB admin permissions
- Configure MySQL Server as Windows Service
- Grant full access to the user
- Create a new Schema named EventCrafters in the server using MySQL Workbench

### 🕹️IDE Config
- We have used IntelliJ IDEA, bt it can be possible to use other IDE´S (like Visual Studio Code)
- Install Maven and Spring for your IDE
*************
### 🛠️ Development Environment Setup
To set up the development environment for the SPA application using Angular, follow these steps:

#### Prerequisites
1. **Node.js**: Ensure that Node.js is installed on your system. You can download it from [Node.js official website](https://nodejs.org/en).
2. **Angular CLI**: Install Angular CLI globally using npm:
   ```bash
   npm install -g @angular/cli
   ```
#### Start Angular
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

5. **Run the SPA**
   ```bash
   npm start
   ```

The SPA will be ready at [http://localhost:4200/](http://localhost:4200/)



### :wrench: Requirements


| Software Requirements | Version |
| :-: | :-: |
| [Node.js](https://nodejs.org/en)| `22.13.1`<= |
| [JDK 21](https://www.oracle.com/es/java/technologies/downloads/#java21)| `Java 21`<= |
| [MySQL](https://dev.mysql.com/downloads/installer/)| `8.0.41.0`<= |
| [Apache Maven](https://maven.apache.org/download.cgi)|`3.9.9`<= |
|[Angular Cli](https://www.npmjs.com/package/@angular/cli)| `19.1.5`<= |

### :black_nib: Requirement Analysis
*************

#### :black_joker: Entities

Currently, there are 5 entities.

| Entities | 
| :-: | 
| [User]() |
| [UserDiagnosis]() |
| [UserFormResponse]() |
| [ClinicFormResponse]() |
| [ClinicFormResponse2]() |


#### :busts_in_silhouette: Type of Users

In the application there are 4 different type of user:

|  Type of User   | Description                                                                         |
| :-------------: | :---------------------------------------------------------------------------------- |
|   Public User   | Access only see general data                                                        |
|  Patient User   | Access to the form and its personalized diagnostics                                 |
| Specialist User | Access to patient data provided in the form, along with access to the use of the AI |
|   Admin User    | Access to page configuration and AI configuration                                   |

#### :wrench: Functional Requirements

Here are the diferent actions that can do the different type of users:

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

#### :electric_plug: Non Functional Requirements

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

### :straight_ruler: Design
*************

### :church: Prototype
*************
#### 🛠️ V0 prototype
This section showcases the Version 0 (V0) prototype of the application, featuring the initial set of screens that outline the app’s core functionality and user interface. The prototype serves as a foundational visual representation, helping to validate the design, navigation flow, and user interactions before further development.
The screens included in this version may undergo changes as feedback is gathered and improvements are made. 
You can view all the prototype screens in the following Google Drive folder:  
➡️ [Click here to access the images](https://drive.google.com/drive/folders/1r1pOR_zI03jgq-HQDjaMytkzh4zrftb1?usp=sharing)  

## ⚔️ Sample users
This section shows the credentials of the test users to demo the application
### 🔑 @patient
- user email: patient@gmail.com
- password: pass

### 🔑 @patient2
- user email: patient2@gmail.com
- password: pass

### 🔑 @patient3
- user email: patient3@gmail.com
- password: pass

### 🛡️ @doctor
- user email: doctorhospital@gmail.com
- password: medicpass

### 🛡️ @doctor2
- user email: doctor2hospital@gmail.com
- password: medicpass

### 🚀 @researcher
- user email: researcher@gmail.com
- password: researcherpass

### 🚀 @researcher2
- user email: researcher2@gmail.com
- password: researcherpass

### ⚖️ @admin
- user email: admin@gmail.com
- password: adminpass

## 📓 Sample docs
- [Download model 1](docs/SampleExcel/modelo_1.xlsx)
- [Download model 2](docs/SampleExcel/modelo_2.xlsx)
- [Download model 3](docs/SampleExcel/modelo_3.xlsx)
- [Download model 4](docs/SampleExcel/modelo_4.xlsx)


#### :airplane: Navigation

#### :performing_arts: Branding

#### :church: Architecture

#### :dvd: DataBase

## :libra: License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.
