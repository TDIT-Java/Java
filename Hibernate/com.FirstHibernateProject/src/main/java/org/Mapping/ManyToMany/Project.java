package org.Mapping.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    public List<Emp> emp;

    public Project() {
    }

    public Project(int id, String projectName, List<Emp> emp) {
        this.id = id;
        this.projectName = projectName;
        this.emp = emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", emp=" + emp +
                '}';
    }
}
