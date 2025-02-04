# <p align="center"> OncoCoders </p>
***   

The goal of this project is to develop **algorithms and predictive models for variables associated with breast cancer**. Additionally, the project aims to create an innovative platform that empowers healthcare professionals to make informed therapeutic decisions from the moment of diagnosis. This approach eliminates the need to wait for follow-ups to evaluate patient progress, enabling more timely and effective interventions.

### 👷 Team members
*************

| Name | URJC mail | Github user |
| ------------- | ------------- | ----------- |
| Lucía Domínguez Rodrigo | lucia.dominguez.rodrigo@mail.com | [@LuciaDominguezRodrigo](https://github.com/LuciaDominguezRodrigo) |
| Gemma Millán Zamora  | gemmamillan123@gmail.com | [@gemmamillan](https://github.com/gemmamillan) |
| Ainhoa López Carrasco  | ainhoa.lop.car@gmail.com | [@Alopeeez04](https://github.com/Alopeeez04) |
| Ikár Martínez de Liz Kosto | iv.mardeliz.software@gmail.com | [@KandV008](https://github.com/KandV008) |
|   |  |  |

## :scroll:Table of Contents

1. [Usage](#hammer-usage)
    1. [Steps](#paw_prints-steps)
    1. [Requirements](#wrench-requirements)
1. [Requirement Analysis](#black_nib-requirement-analysis)
    1. [Entities](#black_joker-entities)
    1. [Type of Users](#busts_in_silhouette-type-of-users)
    1. [Functional Requirements](#wrench-functional-requirements)
    1. [Non Functional Requirements](#electric_plug-non-functional-requirements)
1. [Design](#straight_ruler-design)
    1. [Prototype](#church-prototype)
    1. [Navigation](#airplane-navigation)
    1. [Branding](#performing_arts-branding)
    1. [Architecture](#church-architecture)
    1. [DataBase](#dvd-database)
1. [License](#libra-license)


## :hammer: Usage

The steps to follow to use the application locally will be described.

### :paw_prints: Steps
*************

1. Clone the repository.

```
git clone https://github.com/LuciaDominguezRodrigo/OncoCoders.git
cd OncoCoders
```
2. [...]
3. Install dependencies.
```
npm install
```
4. [...]
5. Start application.

```
ng serve --open
```

7. Have fun!

### :wrench: Requirements
*************

| Software Requirements |
| :-: |
| [Node.js](https://nodejs.org/en)|
| [...]|

### :black_nib: Requirement Analysis
*************

#### :black_joker: Entities

Currently, there are X entities.

| Entities |
| :-: |
| [User]() |
| [Diagnosis]() |
| [Analisis]() |


#### :busts_in_silhouette: Type of Users

In the application there are 2 different type of user:

| Type of User | Description |
| :-: | :-- |
| Public User | Access only see general data |
| Patient User | Access to the form and its personalized diagnostics |
| Specialist User | Access to patient data provided in the form, along with access to the use of the AI | 
| Admin User | Access to page configuration and AI configuration |

#### :wrench: Functional Requirements

Here are the diferent actions that can do the different type of users:

| User Histories | Public | Patient | Specialist | Admin |
| :-- | :-: | :-: | :-: | :-: |
| UH-01 Sign Up | :heavy_check_mark: | | |
| UH-02 Log In | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-03 Log Out (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-04 Delete your Account (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-05 Recover password | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-06 Access to Main Page | :heavy_check_mark: | 
| UH-07 See General Metrics | :heavy_check_mark: | |
| UH-08 See Project's Presentation |:heavy_check_mark: |  |
| UH-XX Access to User Dashboard | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark:|
| UH-09 Show Pacient user Dashboard Page | | :heavy_check_mark: |
| UH-10 Access to Formulary Page | | :heavy_check_mark: | 
| UH-11 Access to Diagnosis Page | | :heavy_check_mark: | 
| UH-12 Access to Monitoring Page | | :heavy_check_mark: | 
| UH-13 Access to Recommendations Page | | :heavy_check_mark: |
| UH-14 Access to Forum Page | | :heavy_check_mark: | 
| UH-15 Access to Profile Page | | :heavy_check_mark: | |
| UH-16 Show Specialist User Dashboard Page | | | :heavy_check_mark: | |
| UH-17 Access to pending Patient List | | | :heavy_check_mark: | |
| UH-18 See more information related a pending Pacient User | | | :heavy_check_mark: | |
| UH-19 Access to processed Patient List Page | | | :heavy_check_mark: |
| UH-20 See more information related a processed Patient User | | | :heavy_check_mark: |
| UH-21 Access to record of all Patients | | | :heavy_check_mark: |
| UH-22 See more information about a Patient User | | | :heavy_check_mark: |
| UH-23 Access to recommendations using theri Diagnosis | | | :heavy_check_mark: |
| UH-24 Access to Specialist User Metrics | | | :heavy_check_mark: |
| UH-25 Show Admin User Dashboard Page | | | | :heavy_check_mark: |
| UH-26 Access to all not banned Users Page | | | | :heavy_check_mark: |
| UH-27 Ban an User | | | | :heavy_check_mark: |
| UH-28 Access to all banned Users Page | | | | :heavy_check_mark: |
| UH-29 Unban an User | | | | :heavy_check_mark: |
| UH-30 Access to IA Model Configuration Page | | | | :heavy_check_mark: |
| UH-31 See application general metrics | | | | :heavy_check_mark: |
| UH-32 Determine Profile pic (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-33 Change Profile Pic (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-34 Determine nickname (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-35 Change nickname (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-36 Determine email (!) | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-37 Access to Config Page | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-38 Access to Language Page | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-39 Access to Help Page | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |

#### :electric_plug: Non Functional Requirements

| Non Functional Requirements |
| :-: |
| Oriented to Web |
| Responsive Design |
| The software must be implemented with Angular |
| The applicaction need to connect with SQL Database |
| The applicaction need to connect with IA models |
| GUI must be minimalist and user-friendly |
| Protection & Security for Registered User Data |
| Usability & Accesibility |
| Main language must be Spanish |

#### Use Case Diagrams

<p align="center">
  <img src="/docs/use_case_diagrams/Public_User.svg" alt="Public_User_Diagram">
  <br>
  <small>Use Case Diagram 1. Public User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Pacient_User.svg" alt="Patient_User_Diagram">
  <br>
  <small>Use Case Diagram 2. Patient User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Specialist_User.svg" alt="Specialist_User_Diagram">
  <br>
  <small>Use Case Diagram 3. Specialist User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/Admin_User.svg" alt="Admin_User_Diagram">
  <br>
  <small>Use Case Diagram 4. Admin User</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/All_Users.svg" alt="All_Users_Diagram">
  <br>
  <small>Use Case Diagram 5. All Users</small>
</p>

<p align="center">
  <img src="/docs/use_case_diagrams/User_Managment.svg" alt="User_Managment_Diagram">
  <br>
  <small>Use Case Diagram 6. User Managment</small>
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


#### :airplane: Navigation

#### :performing_arts: Branding

#### :church: Architecture

#### :dvd: DataBase

## :libra: License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.
