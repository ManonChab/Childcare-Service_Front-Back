
# Childcare Service EB

This is an app created to serve as a booking and communication tool between the Childcare professional and her customers.
The clients can directly book slots of childcare in an interactive calendar that the childcare professional can review, approve or reject.
The clients can also leave reviews to be displayed on the landing page, which the admin can also review and manage.

## Repositories

**Front**
https://github.com/ManonChab/Childcare-Service_Front-End.git

**Back**
https://github.com/ManonChab/Childcare-Service_Front-Back.git

## Features

**User**
- Interactive calendar to book slots
- Leave review
- Send messages ( In progress )
- Mobile first/responsive

**Admin**
- slots review, approval or rejection
- recommendation review, display or hidding from landing page
- Messages, reception and sending ( In progress )
- Users management ( In progress )


## 🛠️ Technologias utilizadas 

**Management tools:**
- Jira
- Confluence

**Design tool:**
- Figma aplicando atomic design
- Mermaid for flowChart

**Client:** 
- React
- Vite
- VisualStudioCode

**Server:** 
- Java
- SpringBoot
- Node
- Express

## Folder architecture ⚙️

**Front**

```bash
 ┣ 📂src
 ┃ ┣ 📂calendar
 ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┗ 📜slots.js
 ┃ ┃ ┣ 📜Calendar.css
 ┃ ┃ ┣ 📜Calendar.jsx
 ┃ ┃ ┗ 📜UpdateSlot.jsx
 ┃ ┣ 📂Components
 ┃ ┃ ┣ 📂Atoms
 ┃ ┃ ┃ ┣ 📂AlertModal
 ┃ ┃ ┃ ┃ ┣ 📜AlertModal.jsx
 ┃ ┃ ┃ ┃ ┗ 📜AlertModal.module.css
 ┃ ┃ ┃ ┣ 📂Button
 ┃ ┃ ┃ ┃ ┣ 📜Button.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Button.module.css
 ┃ ┃ ┃ ┣ 📂closeButton
 ┃ ┃ ┃ ┃ ┣ 📜close-button.module.css
 ┃ ┃ ┃ ┃ ┗ 📜CloseButton.jsx
 ┃ ┃ ┃ ┣ 📂ColorSelector
 ┃ ┃ ┃ ┃ ┗ 📜ColorSelector.jsx
 ┃ ┃ ┃ ┣ 📂CreateSlot
 ┃ ┃ ┃ ┃ ┣ 📜CreateSlot.jsx
 ┃ ┃ ┃ ┃ ┗ 📜CreateSlot.module.css
 ┃ ┃ ┃ ┣ 📂Line
 ┃ ┃ ┃ ┃ ┣ 📜Line.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Line.module.css
 ┃ ┃ ┃ ┣ 📂Logo
 ┃ ┃ ┃ ┃ ┗ 📜Logo.jsx
 ┃ ┃ ┃ ┣ 📂Menu
 ┃ ┃ ┃ ┃ ┣ 📜Menu.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Menu.module.css
 ┃ ┃ ┃ ┣ 📂SliderButton
 ┃ ┃ ┃ ┃ ┗ 📜SliderButton.jsx
 ┃ ┃ ┃ ┗ 📂Title
 ┃ ┃ ┃ ┃ ┣ 📜Title.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Title.module.css
 ┃ ┃ ┣ 📂Form
 ┃ ┃ ┃ ┣ 📜LogInForm.jsx
 ┃ ┃ ┃ ┗ 📜SignUpForm.jsx
 ┃ ┃ ┣ 📂molecules
 ┃ ┃ ┃ ┗ 📂ReviewFormPopUp
 ┃ ┃ ┃ ┃ ┣ 📜ReviewPopUp.jsx
 ┃ ┃ ┃ ┃ ┗ 📜ReviewPopUp.module.css
 ┃ ┃ ┣ 📂Organisms
 ┃ ┃ ┃ ┣ 📂AboutMe
 ┃ ┃ ┃ ┃ ┣ 📜AboutMe.jsx
 ┃ ┃ ┃ ┃ ┗ 📜AboutMe.module.css
 ┃ ┃ ┃ ┣ 📂AdminEvents
 ┃ ┃ ┃ ┃ ┣ 📜AdminEvents.jsx
 ┃ ┃ ┃ ┃ ┗ 📜AdminEvents.module.css
 ┃ ┃ ┃ ┣ 📂AdminReviews
 ┃ ┃ ┃ ┃ ┣ 📜AdminReviews.jsx
 ┃ ┃ ┃ ┃ ┗ 📜AdminReviews.module.css
 ┃ ┃ ┃ ┣ 📂Clients
 ┃ ┃ ┃ ┃ ┗ 📜Clients.jsx
 ┃ ┃ ┃ ┣ 📂Contacts
 ┃ ┃ ┃ ┃ ┣ 📜Contacts.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Contacts.module.css
 ┃ ┃ ┃ ┣ 📂Messages
 ┃ ┃ ┃ ┃ ┗ 📜Messages.jsx
 ┃ ┃ ┃ ┣ 📂ReviewForm
 ┃ ┃ ┃ ┃ ┣ 📜ReviewForm.jsx
 ┃ ┃ ┃ ┃ ┗ 📜ReviewForm.module.css
 ┃ ┃ ┃ ┣ 📂Reviews
 ┃ ┃ ┃ ┃ ┣ 📜Reviews.jsx
 ┃ ┃ ┃ ┃ ┗ 📜Reviews.module.css
 ┃ ┃ ┃ ┗ 📂Settings
 ┃ ┃ ┃ ┃ ┗ 📜Settings.jsx
 ┃ ┃ ┗ 📂Pages
 ┃ ┃ ┃ ┣ 📂Admin
 ┃ ┃ ┃ ┃ ┣ 📜AdminPage.jsx
 ┃ ┃ ┃ ┃ ┗ 📜AdminPage.module.css
 ┃ ┃ ┃ ┣ 📂Landing
 ┃ ┃ ┃ ┃ ┣ 📜LandingPage.jsx
 ┃ ┃ ┃ ┃ ┗ 📜LandingPage.module.css
 ┃ ┃ ┃ ┣ 📂LogIn
 ┃ ┃ ┃ ┗ 📂SignUp
 ┃ ┃ ┃ ┃ ┗ 📜SignUp.jsx
 ┃ ┣ 📂Context
 ┃ ┃ ┣ 📂Theme
 ┃ ┃ ┃ ┣ 📜ThemeContext.jsx
 ┃ ┃ ┃ ┗ 📜ThemeOptions.jsx
 ┃ ┃ ┣ 📜UserContext.jsx
 ┃ ┃ ┗ 📜UserProvider.jsx
 ┃ ┣ 📂Layout
 ┃ ┃ ┣ 📜Layout.jsx
 ┃ ┃ ┗ 📜Layout.module.css
 ┃ ┣ 📂Router
 ┃ ┃ ┗ 📜index.jsx
 ┃ ┣ 📂Service
 ┃ ┃ ┣ 📜api.js
 ┃ ┃ ┗ 📜UserPath.jsx
 ┃ ┣ 📂tests
 ┃ ┣ 📜App.css
 ┃ ┣ 📜App.jsx
 ┃ ┗ 📜main.jsx
 ┣ 📜.gitignore
 ┣ 📜eslint.config.js
 ┣ 📜index.html
 ┣ 📜LICENSE
 ┣ 📜NOTICE
 ┣ 📜package-lock.json
 ┣ 📜package.json
 ┣ 📜README.md
 ┗ 📜vite.config.js
```

**Back**

```bash
 ┣ 📂src
 ┃ ┗ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┃ ┗ 📂daypilot
 ┃ ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂html5eventcalendarspring
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CorsConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CalendarController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂RequestDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventRequestDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginRequestDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRequestDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂ResponseDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventResponseDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserBasicDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserResponseDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ErrorInfo.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Child.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Event.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventStatus.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Review.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Role.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BadIdException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UnauthorizedException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mappper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChildRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChildService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChildServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Application.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📜application.properties
 ┣ 📂target
 ┃ ┣ 📂classes
 ┃ ┃ ┣ 📂org
 ┃ ┃ ┃ ┗ 📂daypilot
 ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┗ 📂html5eventcalendarspring
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CorsConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CalendarController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂RequestDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventRequestDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginRequestDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRequestDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂ResponseDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventResponseDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserBasicDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserResponseDTO.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ErrorInfo.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Event.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventStatus.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Review.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Role.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BadIdException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GlobalExceptionHandler.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UnauthorizedException.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mappper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventMapper.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventMapperImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserMapper.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserMapperImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Application.class
 ┃ ┃ ┗ 📜application.properties
 ┃ ┣ 📂generated-sources
 ┃ ┃ ┗ 📂annotations
 ┃ ┃ ┃ ┗ 📂org
 ┃ ┃ ┃ ┃ ┗ 📂daypilot
 ┃ ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂html5eventcalendarspring
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂mappper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventMapperImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserMapperImpl.java
 ┃ ┣ 📂generated-test-sources
 ┃ ┃ ┗ 📂test-annotations
 ┃ ┗ 📂test-classes
 ┣ 📜.env
 ┣ 📜.gitignore
 ┣ 📜LICENSE
 ┣ 📜NOTICE
 ┣ 📜pom.xml
 ┗ 📜README.md
```

## Instalación y Configuración ⚙️


Para ejecutar este proyecto en local, sigue estos pasos:

**Front**

Clonar el repositorio:
git clone https://github.com/ManonChab/Childcare-Service_Front-End.git

Instalar dependencias::
npm install
npm react-router

Iniciar el servidor de desarrollo::
npm run dev

**Back**

Clonar el repositorio:
git clone https://github.com/ManonChab/Childcare-Service_Front-Back.git

Instalar dependencias::
npm install
npm react-router

Iniciar el servidor de desarrollo::
npm run dev


## Libraries

**DayPilot Lite for JavaScript** open-source calendar/scheduling components for JavaScript/Angular/React/Vue (Apache License 2.0).

This project was generated using the DayPilot UI Builder, an online tool for configuring DayPilot components and generating starter projects.

**Material UI**
MUI offers a comprehensive suite of free UI tools to help build components.


## Licences

Licensed under Apache License 2.0.
May include third-party libraries available under their respective licenses.
