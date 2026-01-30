# Viento

Viento is an open-source development environment that proposes a paradigm shift from technology-driven software development to domain-preserving, technology-agnostic systems.
## Complete example source code

[Viento Demo](https://fpetrola.github.io/viento/viento-demo.html)

### EnrollmentOfficer.java

```java
package com.fpetrola.viento.model;

import java.io.File;

public class EnrollmentOfficer {
  private final AdministrativeStaff admin;
  private final SchoolDirector director;
  private final Persister<Student> studentPersister;

  public EnrollmentOfficer(AdministrativeStaff admin, SchoolDirector director, Persister<Student> studentPersister) {
    this.admin = admin;
    this.director = director;
    this.studentPersister = studentPersister;
  }

  public void enrollNewStudent() {
    CharSequence name = admin.askStudentName();
    CharSequence email = admin.askStudentEmail();
    File healthCertificate = admin.askHealthCertificate();

    Student student = new Student(name, email, healthCertificate);

    boolean isApproved = director.reviewAndApprove(student);

    if (isApproved) {
      student.markAsEnrolled();
      studentPersister.save(student);
      admin.notifyEnrollmentSuccess(student);
    } else {
      String reason = director.askRejectionReason();
      admin.notifyEnrollmentRejected(student, reason);
    }
  }
}
```

## Screenshots

### Demo del Sistema

![Screenshot 1](screenshots/Screenshot%20from%202026-01-29%2022-25-05.png)
![Screenshot 2](screenshots/Screenshot%20from%202026-01-29%2022-25-16.png)
![Screenshot 3](screenshots/Screenshot%20from%202026-01-29%2022-25-21.png)
![Screenshot 4](screenshots/Screenshot%20from%202026-01-29%2022-26-08.png)
![Screenshot 5](screenshots/Screenshot%20from%202026-01-29%2022-26-22.png)
![Screenshot 6](screenshots/Screenshot%20from%202026-01-29%2022-26-28.png)
![Screenshot 7](screenshots/Screenshot%20from%202026-01-29%2022-26-32.png)
![Screenshot 8](screenshots/Screenshot%20from%202026-01-29%2022-26-51.png)
![Screenshot 9](screenshots/Screenshot%20from%202026-01-29%2022-27-00.png)
![Screenshot 10](screenshots/Screenshot%20from%202026-01-29%2022-27-05.png)
![Screenshot 11](screenshots/Screenshot%20from%202026-01-29%2022-29-25.png)
![Screenshot 12](screenshots/Screenshot%20from%202026-01-29%2022-29-35.png)
![Screenshot 13](screenshots/Screenshot%20from%202026-01-29%2022-29-45.png)

## Características

- **Separación de responsabilidades**: Cada componente maneja su función específica
- **Interfaz limpia**: Gestión intuitiva de inscripciones
- **Validación de datos**: Control sobre la información del estudiante
- **Revisión y aprobación**: Proceso de validación por director

## Licencia

Consultar el archivo LICENSE para más detalles.
