# Viento: Pure Domain-Driven Software Development

## Overview

Viento is a development environment that fundamentally shifts how software is created: **developers program only the domain logic**, while UI, persistence, APIs, workflows, and distributed execution emerge automatically from introspection of the core business processes.

Rather than writing code that tangles business logic with technology-specific concerns (databases, HTTP calls, user input handling), Viento enables developers to express applications as if all information were instantly available and all operations were local. Interruptions caused by user input, remote calls, persistence, or human decisions are automatically detected, paused, and resolved in dedicated layers without contaminating the domain core.

This approach creates:
- **Durable software**: Logic survives technology changes, migrations, and administrative transitions
- **Single source of truth**: No duplicated concepts, no DTO boilerplate, no mapping layers
- **Auditability and transparency**: Pure domain logic is readable, reviewable, and understandable decades later
- **Safe AI integration**: AI operates only within well-defined, encapsulated layers with minimal context, reducing hallucinations and unpredictability
- **Institutional continuity**: New developers understand existing systems by reading domain logic, not by learning legacy technology stacks

Viento is especially valuable for open-source projects, public sector institutions, and organizations with limited resources where maintainability, auditability, and vendor independence are critical.

---

## The Core Innovation: Automated Decision-Making Through Introspection

Viento leverages advanced metaprogramming—continuations, reflection, dynamic proxies, bytecode generation—to achieve complete introspection of execution flows. This enables **automation of decisions developers normally make mentally**:

- **DTOs and serialization**: Generated automatically from domain entity structure
- **Persistence mappings**: Default JPA/database strategies derived from introspection, customizable when needed
- **REST APIs**: Contracts inferred from business process signatures
- **UI components**: Visual bindings created from data type and execution context
- **Workflows and task management**: Derived from detected pauses in execution
- **Distributed execution**: Process serialization and transport handled transparently

Rather than eliminating choice, Viento makes conventional choices algorithmic, then allows customization where business value demands it. This reduces boilerplate while maintaining full control.

---

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

