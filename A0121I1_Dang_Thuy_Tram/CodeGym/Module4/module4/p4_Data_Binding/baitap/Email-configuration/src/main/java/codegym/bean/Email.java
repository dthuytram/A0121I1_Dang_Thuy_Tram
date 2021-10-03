package codegym.bean;

public class Email {
    private int id;
    private String languages;
    private int pageSize;
    private boolean isSpam;
    private String signature;



    public Email(int id, String languages, int pageSize, boolean isSpam, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.isSpam = isSpam;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Email() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
