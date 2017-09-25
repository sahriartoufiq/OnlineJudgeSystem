package ojs.domain.db;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by sahriar on 12/10/16.
 */
@Entity
@Table(name = "t_submissions")
public class Submissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "problems_id")
    private Problems problems;
    @Column(name = "judge_result")
    private String judgeResult;
    @Column(name = "used_time")
    private double usedTime;
    @Column(name = "language")
    private String language;
    @Transient
    private MultipartFile codeFile;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Problems getProblems() {
        return problems;
    }

    public void setProblems(Problems problems) {
        this.problems = problems;
    }

    public String getJudgeResult() {
        return judgeResult;
    }

    public void setJudgeResult(String judgeResult) {
        this.judgeResult = judgeResult;
    }

    public double getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(double usedTime) {
        this.usedTime = usedTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MultipartFile getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(MultipartFile codeFile) {
        this.codeFile = codeFile;
    }
}
