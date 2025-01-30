# <p align="center"> OncoCoders </p>
***   

The goal of this project is to develop **algorithms and predictive models for variables associated with breast cancer**. Additionally, the project aims to create an innovative platform that empowers healthcare professionals to make informed therapeutic decisions from the moment of diagnosis. This approach eliminates the need to wait for follow-ups to evaluate patient progress, enabling more timely and effective interventions.

### 👷 Team members
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

1. Clone the repository.

```
git clone https://github.com/KandV008/Kala.git
cd Kala
```

2. Configure [Google Cloud API](#cloud-configure-google-cloud-api).
3. Create ``.env`` with the next enviromental variable ``EXPO_PUBLIC_GOOGLE_MAPS_KEY``. It have to store your Google Cloud API Key.
4. Open your Android Emulator (You can use the one that comes with [Android Studio](https://developer.android.com/studio)).
5. Install dependencies.
```
npm install
```
6. Start application.

```
npx expo start
```

7. Press ``a`` to open the application with Android.
8. Have fun!

### :wrench: Requirements

| Software Requirements |
| :-: |
| [Expo SDK 51](https://expo.dev/changelog/2024/05-07-sdk-51) |
| [Node.js](https://nodejs.org/en)|
| [Google Cloud Platform Account](https://cloud.google.com) |

### :black_nib: Requirement Analysis

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
| UH-03 Log Out | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-04 Delete your Account | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-05 Recover password | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-06 Access to general metrics | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-07 Access to Form | | :heavy_check_mark: | |
| UH-08 Access to their Diagnosis | | :heavy_check_mark: |  |
| UH-09 Access to recomendations | | :heavy_check_mark: | :heavy_check_mark: |
| UH-10 Determine Profile pic | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-11 Change Profile Pic | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-12 Determine email | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-13 Determine nickname | | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |
| UH-14 Change nickname | | :heavy_check_mark: |  :heavy_check_mark: |:heavy_check_mark: |
| UH-15 See Diagnosis from a Patient | |  | :heavy_check_mark: | |
| UH-16 See results from the IA | | | :heavy_check_mark: | |
| UH-17 Access to recomendation using their Diagnosis | | | :heavy_check_mark: | |
| UH-18 Access to specific metrics | | | :heavy_check_mark: | |
| UH-19 Ban User | | | | :heavy_check_mark: |
| UH-20 Unban User | | | | :heavy_check_mark: |
| UH-21 Access to the IA | | | | :heavy_check_mark: |

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

### :straight_ruler: Design

### :church: Prototype

#### :airplane: Navigation

#### :performing_arts: Branding

#### :church: Architecture

#### :dvd: DataBase

## :libra: License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.