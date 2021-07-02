package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model;

public class Company {

    private String name;
    private String catchPhrase;
    private String bs;//": "harness real-time e-markets"

    public Company(String name, String catchPhrase, String bs) {

        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
