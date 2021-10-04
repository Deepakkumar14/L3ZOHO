package MailSystem;

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String Content;
    private int serialNo;
    private String recalledStatus;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getRecalledStatus() {
        return recalledStatus;
    }

    public void setRecalledStatus(String recalledStatus) {
        this.recalledStatus = recalledStatus;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", Content='" + Content + '\'' +
                ", serialNo=" + serialNo +
                ", recalledStatus='" + recalledStatus + '\'' +
                '}';
    }
}
