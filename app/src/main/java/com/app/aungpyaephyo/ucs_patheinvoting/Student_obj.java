package com.app.aungpyaephyo.ucs_patheinvoting;

/**
 * Created by User on 13/01/2017.
 */

public class Student_obj {
    String name;
    String section;
    int profile_image;
    boolean vote;

    int photo1, photo2, photo3, photo4;

    public Student_obj(){

    }

    public Student_obj(boolean vote){
        this.vote = vote;
    }

    public Student_obj(String name, String section, int profile_image, boolean vote){
        this.name = name;
        this.section = section;
        this.profile_image = profile_image;
        this.vote = vote;
    }

    public Student_obj(String name, String section, int profile_image, int photo1, int photo2, int photo3, int photo4){
        this.name = name;
        this.section = section;
        this.profile_image = profile_image;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public boolean getVote(){
        return vote;
    }

    public void setPhoto1(int photo1) {
        this.photo1 = photo1;
    }

    public void setPhoto2(int photo2) {
        this.photo2 = photo2;
    }

    public void setPhoto3(int photo3) {
        this.photo3 = photo3;
    }

    public void setPhoto4(int photo4) {
        this.photo4 = photo4;
    }

    public int getPhoto1() {
        return photo1;
    }

    public int getPhoto2() {
        return photo2;
    }

    public int getPhoto3() {
        return photo3;
    }

    public int getPhoto4() {
        return photo4;
    }
}
