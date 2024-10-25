# Welcome Screens

Our app features an engaging onboarding experience for first-time users, introducing them to the core benefits and functionality of the app. Upon the initial installation and launch, users are greeted by three welcome screens, each designed to showcase key aspects and guide them smoothly into the app experience.

![ProfileImage](/images/Welcome1.png)
![ProfileImage](/images/Welcome2.png)
![ProfileImage](/images/Welcome3.png)

# Login and Registration Screens

Both screens are built with Jetpack Compose, ensuring a smooth and responsive UI, with form validation managed using **Kotlin**. User authentication is securely handled by [Backend Service - e.g., Firebase Auth, Custom Backend], ensuring that all user data is encrypted and privacy-protected.

![ProfileImage](/images/LoginScreen.png)
![ProfileImage](/images/SignupScreen.png)

# Home Screen
The **Home Screen** serves as the main entry point for users after logging in, providing easy navigation to key app sections and personalized information at a glance.

## Home Screen Layout

Upon successful login, users are directed to the Home Screen, which is designed for quick access and seamless navigation.

### Key Elements

- **Top Bar**:
  - **Location Display (Top Left)**: Shows the user’s current location to provide relevant local content and information.
  - **Log Out Button (Top Right)**: Allows users to log out of their account with a single tap, ensuring secure exit from the app.

- **Bottom Navigation Bar**:
  The bottom navigation bar enables users to move between the main sections of the app efficiently. It includes the following options:
  - **Explore**: Takes users to the Explore Screen, where they can discover new content, browse services or products, and find resources related to the app’s core functionality.
  - **Appointments**: Directs users to the Appointment Screen, where they can view, manage, or schedule new appointments as needed.
  - **Profile**: Navigates to the Profile Screen, where users can manage their personal information, view activity, or adjust settings.
  - **Search**: Navigates to the Home Screen, where users can choose a filter to search for shops.

### Additional Features
- **Responsive UI**: The Home Screen and navigation components are designed with Jetpack Compose to ensure a responsive, smooth experience across devices.
- **Location-Based Personalization**: The user’s location is dynamically updated on the top left, enabling localized content and tailored suggestions based on the user's region.
  
![ProfileImage](/images/HomeScreen.png)

# Profile Screens

The **Profile Screen** provides users with access to their personal information and an overview of the pets they have added to their profile. This screen allows users to manage both their own profile details and their pet information conveniently.

## Profile Screen Layout

The Profile Screen is designed for easy viewing and management of user and pet information, with intuitive options to add, edit, or delete pet details.

### Key Elements

- **User Information Section**: 
  - Displays basic information about the user, such as their name, profile picture, and contact details (if applicable).
  - Includes an **Edit Button** that lets users update their personal information. Tapping this button opens a form to change details like name, contact info, or profile picture.

- **Pets List**:
  - Shows a list of pets added by the user, each represented on a **Pet Card** that includes details like the pet’s name, age, and other relevant information.
  - Each Pet Card contains the following interactive icons:
    - **Edit Icon**: Allows the user to edit the selected pet’s details, including information like name, age, breed, and more.
    - **Delete Icon**: Enables the user to remove a pet from their profile. A confirmation prompt appears to prevent accidental deletions.

- **Add New Pet Button** (Top Right): 
  - A prominent button labeled **Add New Pet** at the top right allows users to easily add a new pet to their profile.
  - On tapping, users are directed to a form where they can enter details such as the pet’s name, breed, age, and any other relevant information.

### Additional Features
- **User-Friendly Interface**: The Profile Screen layout is optimized for ease of use, with clear, accessible icons for each action.
- **Real-Time Updates**: Changes made to both user and pet information are updated in real-time, providing an up-to-date view of the profile.

![ProfileImage](/images/ProfileView.png)
![ProfileImage](/images/EditProfile.png)
![ProfileImage](/images/PetInfo.png)

# Appointment Screen

The **Appointment Screen** allows users to view and manage their pet-related appointments. Appointments are organized into three categories: **Past**, **Upcoming**, and **Cancelled**, each with a clear and consistent layout to enhance user experience.
## Appointment Screen Layout

Each appointment is displayed in a **Card View** format, which includes key details and actions based on the appointment status.

### Key Elements

- **Past Appointments**:
  - Displayed with a **Status: Completed** label, indicating that the appointment has already taken place.
  - Each card includes:
    - **Pet's Name**
    - **Doctor's Name**
    - **Clinic Name**
    - **Appointment Day** and **Address**

- **Upcoming Appointments**:
  - Displayed with a **Cancel** button in place of a status, allowing users to cancel the appointment if needed.
  - Tapping **Cancel** removes the appointment from upcoming appointments and updates it under the **Cancelled** section.
  - Each card includes:
    - **Pet's Name**
    - **Doctor's Name**
    - **Clinic Name**
    - **Time** and **Address**

- **Cancelled Appointments**:
  - Displayed with a **Status: Cancelled** label, indicating that the appointment was canceled.
  - Each card includes:
    - **Pet's Name**
    - **Doctor's Name**
    - **Clinic Name**
    - **Time** and **Address**

### Additional Features

- **Easy Navigation**: Users can navigate between **Past**, **Upcoming**, and **Cancelled** sections to view the appointment status in real-time.
- **Real-Time Updates**: Canceling an appointment updates the status immediately, moving it from **Upcoming** to **Cancelled**.

![ProfileImage](/images/AppointmentScreen.png)

# Explore Screens
The **Explore Screen** helps users discover veterinary clinics nearby or based on specific filters, offering flexibility in browsing. This screen adapts based on the navigation path, providing localized suggestions and personalized results.

## Explore Screen Layout

The Explore Screen displays clinics in a **Card View** format, each card containing essential clinic details for quick evaluation and decision-making.

### Key Elements

- **Nearby Clinics**:
  - When accessed through the **Bottom Navigation Bar**, the Explore Screen shows nearby clinics based on the user's current location.
  - Clinics are displayed in cards that include:
    - **Clinic Name**
    - **Address**
    - **Distance from User’s Location**
    - **Tagline** or short description of the clinic’s services

- **Filtered Clinics**:
  - When accessed via one of the **9 Tiles** on the Home Screen, clinics are displayed based on selected filters, such as specialty, services offered, or other relevant criteria.
  - Each clinic card provides:
    - **Clinic Name**
    - **Address**
    - **Distance from User’s Location**
    - **Tagline** describing the clinic’s specific expertise or unique offerings

### Additional Features

- **Dynamic Content**: The clinics displayed are updated in real-time, either showing local clinics based on location or filtered results based on the selected criteria.
- **User-Friendly Design**: The card-based layout and clear information make it easy for users to compare clinics and select one that meets their needs.

![ProfileImage](/images/ExploreScreen.png)

# Explore Detail Screen

The **Explore Detail Screen** provides users with comprehensive information about a selected clinic, including available doctors and an option to book appointments. This screen helps users make informed decisions by displaying all relevant details about the clinic and its staff.

## Explore Detail Screen Layout

Upon selecting a clinic, users are directed to the Explore Detail Screen, which is organized to provide clear and detailed information.

### Key Elements

- **Clinic Information**: 
  - Displays essential details such as:
    - **Clinic Name**
    - **Address**
    - **Contact Information** (phone, email, etc.)
    - **Operating Hours**
    - **Services Offered**: A list or brief description of services provided by the clinic.
    - **Tagline**: Highlighting the clinic's unique offerings or specialties.

- **Doctors List**:
  - At the bottom of the screen, a list of available doctors at the clinic is displayed.
  - Each doctor entry may include:
    - **Doctor's Name**
    - **Specialization** (e.g., general veterinarian, surgeon)
    - **Years of Experience**
    - **Availability**: Shows available times for booking appointments.

- **Book Appointment Button**:
  - Once a doctor is selected, the **Book Appointment** button becomes active.
  - Tapping this button navigates the user to the **Book Appointment Screen**, where they can:
    - Select a **Pet** from their profile.
    - Choose a **Day** for the appointment based on doctor availability.

### Additional Features

- **Detailed Descriptions**: Each section is designed to provide clarity, ensuring that users can review the clinic’s services and doctor details effectively.
- **Responsive Navigation**: Selecting a doctor and booking an appointment are streamlined to minimize the number of steps required.

![ProfileImage](/images/ExploreDetailScreen.png)
![ProfileImage](/images/BookAppointment.png)
