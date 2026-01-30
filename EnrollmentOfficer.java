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
