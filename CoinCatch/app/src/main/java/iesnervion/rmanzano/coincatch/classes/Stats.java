package iesnervion.rmanzano.coincatch.classes;

public class Stats {
    private String nickname;
    private Integer score;

    public Stats() {
        this.nickname = "None";
        this.score = 0;
    }

    public Stats(String nickname, Integer score) {
        this.nickname = nickname;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
