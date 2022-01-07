package com.example.retrofit;

public class MarvelMovieInfo {



    private String name;
    private String realName;
    private String team;
    private String firstAppearance;
    private String createdBy;
    private String publisher;
    private String bio;
    private String imageurl;

  /*  public MarvelMovieInfo(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String bio, String imageUrl) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }*/

    public MarvelMovieInfo(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String bio,String imageurl) {

        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.bio = bio;
        this.imageurl = imageurl;
    }

    public MarvelMovieInfo(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String bio) {
    }

    public String getName() {
            return name;
        }

        public String getRealName() {
            return realName;
        }

        public String getTeam() {
            return team;
        }

        public String getFirstAppearance() {
            return firstAppearance;
        }

        public String getCreatedBy() { return createdBy; }

        public String getPublisher() {
            return publisher;
        }

        public String getBio() {
            return bio;
        }

    public String getImageUrl() {
        return imageurl;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", realname='" + realName + '\'' +
                ", team='" + team + '\'' +
                ", firstappearance='" + firstAppearance + '\'' +
                ", createdby='" + createdBy + '\'' +
                ", publisher='" + publisher + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
    }


