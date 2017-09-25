package ojs.domain.db;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sahriar on 12/10/16.
 */
@Entity
@Table(name = "t_problems")
public class Problems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "pblm_loc")
    private  String pblmLoc;
    @Column(name = "input_loc")
    private String inputLoc;
    @Column(name = "output_loc")
    private  String outputLoc;
    @Column(name = "category")
    private String category;
    @ManyToOne
    @JoinColumn(name = "pblm_setter_id")
    private Users users;
    @Column(name = "time_limit")
    private double timeLimit;
    @Column(name = "memory_limit")
    private double memoryLimit;

    @Transient
    private MultipartFile problm;

    @Transient
    private MultipartFile input;

    @Transient
    private MultipartFile output;

    @OneToMany(mappedBy = "problems")
    private Set<Submissions> submissionsSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPblmLoc() {
        return pblmLoc;
    }

    public void setPblmLoc(String pblmLoc) {
        this.pblmLoc = pblmLoc;
    }

    public String getInputLoc() {
        return inputLoc;
    }

    public void setInputLoc(String inputLoc) {
        this.inputLoc = inputLoc;
    }

    public String getOutputLoc() {
        return outputLoc;
    }

    public void setOutputLoc(String outputLoc) {
        this.outputLoc = outputLoc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(double timeLimit) {
        this.timeLimit = timeLimit;
    }

    public double getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(double memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Set<Submissions> getSubmissionsSet() {
        return submissionsSet;
    }

    public void setSubmissionsSet(Set<Submissions> submissionsSet) {
        this.submissionsSet = submissionsSet;
    }

    public MultipartFile getProblm() {
        return problm;
    }

    public void setProblm(MultipartFile problm) {
        this.problm = problm;
    }

    public MultipartFile getInput() {
        return input;
    }

    public void setInput(MultipartFile input) {
        this.input = input;
    }

    public MultipartFile getOutput() {
        return output;
    }

    public void setOutput(MultipartFile output) {
        this.output = output;
    }
}
