package main.java.impl;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private Integer id;
    private String name;
    private List<String> comments = new ArrayList<>();
    private String content;
    private int priority;

    private int developerEstimation;
    private int teamLeadEstimation;

    public Item() {
    }

    public Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.id;
        this.name = itemBuilder.name;
        this.priority = itemBuilder.priority;
        this.comments = itemBuilder.comments;
        this.content = itemBuilder.content;
        this.developerEstimation = itemBuilder.developerEstimation;
        this.teamLeadEstimation = itemBuilder.teamLeadEstimation;
    }

    public Item(Integer id, String name, List<String> comments, String content, int priority, int developerEstimation, int teamLeadEstimation) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.content = content;
        this.priority = priority;
        this.developerEstimation = developerEstimation;
        this.teamLeadEstimation = teamLeadEstimation;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDeveloperEstimation() {
        return developerEstimation;
    }

    public void setDeveloperEstimation(int developerEstimation) {
        this.developerEstimation = developerEstimation;
    }

    public int getTeamLeadEstimation() {
        return teamLeadEstimation;
    }

    public void setTeamLeadEstimation(int teamLeadEstimation) {
        this.teamLeadEstimation = teamLeadEstimation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", priority=" + priority +
                ", developerEstimation=" + developerEstimation +
                ", teamLeadEstimation=" + teamLeadEstimation +
                '}';
    }

    public static class ItemBuilder {
        private Integer id;
        private String name;
        private List<String> comments = new ArrayList<>();
        private String content;
        private int priority;

        private int developerEstimation;
        private int teamLeadEstimation;


        public ItemBuilder(Integer id) {
            this.id = id;
        }

        public ItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder comments(List<String> comments) {
            this.comments = comments;
            return this;
        }

        public ItemBuilder content(String content) {
            this.content = content;
            return this;
        }

        public ItemBuilder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public ItemBuilder developerEstimation(int developerEstimation) {
            this.developerEstimation = developerEstimation;
            return this;
        }

        public ItemBuilder teamLeadEstimation(int teamLeadEstimation) {
            this.teamLeadEstimation = teamLeadEstimation;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    protected Item clone() throws CloneNotSupportedException {
        super.clone();
        Item item = new Item();
        item.setId(this.id);
        item.setName(this.name);
        item.setContent(this.content);
        item.setComments(List.copyOf(this.comments));
        item.setDeveloperEstimation(this.developerEstimation);
        item.setPriority(this.priority);
        item.setTeamLeadEstimation(this.teamLeadEstimation);
        return item;
    }
}
