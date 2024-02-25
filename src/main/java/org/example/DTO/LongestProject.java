package org.example.DTO;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LongestProject {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private String name;
    private int duration;

    public LongestProject() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
