package com.example.JobSchedular;


import java.sql.Timestamp;

//why no autowiring is used here?
public class EmailingJob implements Job{
    private final EmailSender emailSender;
    private final EmailDetails emailDetails;

    public EmailingJob(EmailSender emailSender, EmailDetails emailDetails) {
        this.emailSender = emailSender;
        this.emailDetails = emailDetails;
    }

    @Override
    public void execute() {
        this.emailSender.send(emailDetails.getDestination(), emailDetails.getSubject(), emailDetails.getText());
        System.out.println("Execute Email Job");
    }

    @Override
    public Timestamp getTriggerTime() {
        return this.emailDetails.getTriggerTime();
    }

    public EmailDetails getEmailDetails() {
        return emailDetails;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }


}
